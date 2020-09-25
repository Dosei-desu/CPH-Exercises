import java.util.Random;

class Game
{
  private Random rnd;
  private final int width;
  private final int height;
  private int[][] board;
  private Keys keys;
  private Keys2 keys2;
  private int playerLife;
  private int player2Life;
  private Dot player;
  private Dot player2;
  private Dot[] enemies;
  private Dot[] food;
  private int score = 0;
  private int score2 = 0;
  private boolean coop;
  private int winScore;
  
   
  Game(int width, int height, int numberOfEnemies, int foodCounter, int _winScore, boolean _coop)
  {
    if(width < 10 || height < 10)
    {
      throw new IllegalArgumentException("Width and height must be at least 10");
    }
    if(numberOfEnemies < 0)
    {
      throw new IllegalArgumentException("Number of enemies must be positive");
    } 
    this.rnd = new Random();
    this.board = new int[width][height];
    this.width = width;
    this.height = height;
    this.winScore = _winScore;
    this.keys = new Keys();
    this.keys2 = new Keys2();
    this.player = new Dot(0,0,width-1, height-1);
    this.coop = _coop;
    if(this.coop){
      this.player2 = new Dot(0,height-1,width-1, height-1);
    }
    
    this.enemies = new Dot[numberOfEnemies];
    for(int i = 0; i < numberOfEnemies; ++i)
    {
      this.enemies[i] = new Dot(width-1, height-1, width-1, height-1);
    }
    if(this.coop){
      foodCounter *= 2;
    }
    this.food = new Dot[foodCounter];
    for(int i = 0; i < foodCounter; ++i)
    {
      this.food[i] = new Dot((int)random(1,width-1), (int)random(1,height-1), width-1, height-1);
    }
    
    this.playerLife = 100;
    this.player2Life = 100;
  }
  
  public int getWidth()
  {
    return width;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public int getPlayerLife()
  {
    return playerLife;
  }
  
  public int getPlayer2Life()
  {
    return player2Life;
  }
  
  public void onKeyPressed(char ch)
  {
    keys.onKeyPressed(ch);
  }
  
  public void onKeyReleased(char ch)
  {
    keys.onKeyReleased(ch);
  }
  
  public void onKeyPressed2(int ch)
  {
    keys2.onKeyPressed(ch);
  }
  
  public void onKeyReleased2(int ch)
  {
    keys2.onKeyReleased(ch);
  }
  
  public void update()
  {
    updatePlayer();
    updatePlayer2();
    updateEnemies();
    updateFood();
    checkForCollisions();
    clearBoard();
    populateBoard();
  }
  
  
  
  public int[][] getBoard()
  {
    //ToDo: Defensive copy?
    return board;
  }
  
  private void clearBoard()
  {
    for(int y = 0; y < height; ++y)
    {
      for(int x = 0; x < width; ++x)
      {
        board[x][y]=0;
      }
    }
  }
  
  private void updatePlayer()
  {
    //Update player
    if(keys.wDown() && !keys.sDown())
    {
      player.moveUp();
    }
    if(keys.aDown() && !keys.dDown())
    {
      player.moveLeft();
    }
    if(keys.sDown() && !keys.wDown())
    {
      player.moveDown();
    }
    if(keys.dDown() && !keys.aDown())
    {
      player.moveRight();
    }  
  }
  
  private void updatePlayer2(){
    if(coop){
      //Update player
      if(keys2.wDown() && !keys2.sDown())
      {
        player2.moveUp();
      }
      if(keys2.aDown() && !keys2.dDown())
      {
        player2.moveLeft();
      }
      if(keys2.sDown() && !keys2.wDown())
      {
        player2.moveDown();
      }
      if(keys2.dDown() && !keys2.aDown())
      {
        player2.moveRight();
      }  
    }
  }
  
  private void updateEnemies()
  {
    for(int i = 0; i < enemies.length; ++i)
    {
      //Should we follow or move randomly?
      //2 out of 3 we will follow..
      if(rnd.nextInt(3) < 2)
      {
        //We follow
        int dx = 0, dy = 0, dx2 = 0, dy2 = 0;
        if(coop && i < enemies.length/2){
          dx2 = player2.getX() - enemies[i].getX();
          dy2 = player2.getY() - enemies[i].getY();
        }else{
          dx = player.getX() - enemies[i].getX();
          dy = player.getY() - enemies[i].getY();
        }
        
        if(abs(dx) > abs(dy) || abs(dx2) > abs(dy2))
        {
          if(dx > 0 || dx2 > 0)
          {
            //Player is to the right
            enemies[i].moveRight();
          }
          else
          {
            //Player is to the left
            enemies[i].moveLeft();
          }
        }
        else if(dy > 0 || dy2 > 0)
        {
          //Player is down;
          enemies[i].moveDown();
        }
        else
        {//Player is up;
          enemies[i].moveUp();
        }
      }
      else
      {
        //We move randomly
        int move = rnd.nextInt(4);
        if(move == 0)
        {
          //Move right
          enemies[i].moveRight();
        }
        else if(move == 1)
        {
          //Move left
          enemies[i].moveLeft();
        }
        else if(move == 2)
        {
          //Move up
          enemies[i].moveUp();
        }
        else if(move == 3)
        {
          //Move down
          enemies[i].moveDown();
        }
      }
    }
  }
  
  private void updateFood()
  {
    for(int i = 0; i < food.length; ++i)
    {
      //Should we follow or move randomly?
      //2 out of 3 we will follow..
      if(rnd.nextInt(3) < 2)
      {
        //We avoid
        int fx = 0, fy = 0, fx2 = 0, fy2 = 0;
        if(coop && i < enemies.length/2){
          fx2 = player2.getX() - food[i].getX();
          fy2 = player2.getY() - food[i].getY();
        }else{
          fx = player.getX() - food[i].getX();
          fy = player.getY() - food[i].getY();
        }
        if(abs(fx) < abs(fy) || abs(fx2) < abs(fy2))
        {
          if(fx > 0)
          {
            //Player is to the right
            food[i].moveLeft();
          }
          else
          {
            //Player is to the left
            food[i].moveRight();
          }
        }
        else if(fy > 0)
        {
          //Player is down;
          food[i].moveUp();
        }
        else
        {//Player is up;
          food[i].moveDown();
        }
      }
      else
      {
        //We move randomly
        int move = rnd.nextInt(4);
        if(move == 0)
        {
          //Move right
          food[i].moveRight();
        }
        else if(move == 1)
        {
          //Move left
          food[i].moveLeft();
        }
        else if(move == 2)
        {
          //Move up
          food[i].moveUp();
        }
        else if(move == 3)
        {
          //Move down
          food[i].moveDown();
        }
      }
    }
  }
  
  private void populateBoard()
  {
    //Insert player
    board[player.getX()][player.getY()] = 1;
    if(coop){
      board[player2.getX()][player2.getY()] = 4;
    }
    //Insert enemies
    for(int i = 0; i < enemies.length; ++i)
    {
      board[enemies[i].getX()][enemies[i].getY()] = 2;
    }
    for(int i = 0; i < food.length; ++i)
    {
      board[food[i].getX()][food[i].getY()] = 3;
    }
  }
   
  private void checkForCollisions()
  {
    //Check enemy collisions
    for(int i = 0; i < enemies.length; ++i)
    {
      if(enemies[i].getX() == player.getX() && enemies[i].getY() == player.getY())
      {
        //We have a collision
        playerLife -= 3;
      }
      if(coop){
        if(enemies[i].getX() == player2.getX() && enemies[i].getY() == player2.getY())
        {
          //We have a collision
          player2Life -= 3;
        }
      }
    }
    for(int i = 0; i < food.length; ++i)
    {
      if(food[i].getX() == player.getX() && food[i].getY() == player.getY())
      {
        //We have a collision
        ++score;
        if(playerLife > 100){
        playerLife += 5;
        }
        for(int n = 0; n < food.length; ++n)
        {
        food[i] = new Dot((int)random(1,width-1), (int)random(1,height-1), width-1, height-1);
        }
      }
      if(coop){
        if(food[i].getX() == player2.getX() && food[i].getY() == player2.getY())
        {
          //We have a collision
          ++score2;
          if(player2Life > 100){
          playerLife += 5;
          }
          for(int n = 0; n < food.length; ++n)
          {
          food[i] = new Dot((int)random(1,width-1), (int)random(1,height-1), width-1, height-1);
          }
        }
      }
    }
  }
  
  private int getScore(){
    return this.score;
  }
  
  private int getP2Score(){
    return this.score2;
  }
  
  private boolean win(){
    if(this.score >= this.winScore) return true;
    return false;
  }
  
  private boolean win2(){
    if(this.score2 >= this.winScore) return true;
    return false;
  }
  
  private boolean gameOver(){
    if(!this.coop){
      if(this.playerLife < 1) return true;
    }
    return false;
  }
  
  private int coopGameOver(){
    if(this.coop){
      if(this.playerLife < 1) return 1;
      if(this.player2Life < 1) return 2;
    }
    return 0;
  }
}
