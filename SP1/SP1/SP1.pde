//SP1
//Kristoffer Borg Pauly

/*
- Add start menu where you can select whether to play solo or coop.
*/

//--------------------------------------------------------------------------------------------------------------------------------------------
//Variables:
import java.util.Random; //imports Random utility (legacy code from Tobias' original sketch that I haven't bothered to change
int enemies = 6;
int foodCount = 2;
int arenaWidth = 30, arenaHeight = 20;
boolean coop = false;
int winScore = 10;

//initialising the game
Game game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop); //last boolean is coop

//mode on/off switches
boolean nightmareMode = false;
boolean nmDoOnce = true;
boolean unicornMode = false;
boolean uDoOnce = true;
boolean endlessMode = false;
boolean eDoOnce = true;

//default colours
color bgCol = color(0,150);
color P1Col = color(0,0,255);
color P2Col = color(0,255,255);
color enCol = color(255,0,0);
color foodCol = color(0,255,0);
//text colours
color P1TextCol = color(100,100,255);
color P2TextCol = color(100,255,255);
color textCol = color(255);

//point-score stuff
int points = 0;
int timer = 1800; //3min at a fps of 10

//image and font Objects
PFont font;
PImage nmPic;
PImage bgPic;
PImage uPic;
PImage ePic;

//--------------------------------------------------------------------------------------------------------------------------------------------
//Settings:
public void settings() {
  size(1201, 801);
}
//--------------------------------------------------------------------------------------------------------------------------------------------
//Setup:
void setup()
{
  frameRate(10);
  font = createFont("Arial", 25, true);
  textFont(font);
  nmPic = loadImage("devil.jpg");
  bgPic = loadImage("vista.jpg");
  uPic = loadImage("unicorn.jpg");
  ePic = loadImage("endless.jpg");
}
//--------------------------------------------------------------------------------------------------------------------------------------------
//Draw:
void draw()
{
  background(0); //Black
  game.update();
  
  //gamemode backgrounds (comes before gameBoard, because it decides colours and backgrounds that the gameBoard uses)
  gameModeBGs();
  
  //gameboard (how colours of enemies, allies, food, etc. is determined
  gameBoard();
  
  //point stuff
  pointScore();
  
  //displays
  scoreDisplay();
  lifeDisplay();
  
  //modes
  nightMare();
  uniCorn();
  endLess();
  
  //varies failure/win states
  failureState();
  coopWinFailureState();
  winState();
}

//--------------------------------------------------------------------------------------------------------------------------------------------
//Point stuff:
void pointScore(){  
  if(!endlessMode){
    points = timer;
    textAlign(CENTER,BOTTOM);
    textSize(25);
    fill(textCol);
    text("Points: "+points, width/2, 30);
    --timer;
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------
//Modes:
void gameModeBGs(){
  if(nightmareMode){ //Nightmare Mode background
    imageMode(CENTER);
    image(nmPic, width/2, height/2, width, height);
  }else if(unicornMode){ //Unicorn Mode background
    imageMode(CENTER);
    image(uPic, width/2, height/2, width, height);
  }else if(endlessMode){ //Endless Mode background
    imageMode(CENTER);
    image(ePic, width/2, height/2, width, height);
  }else{ //Default Mode background
    imageMode(CENTER);
    image(bgPic, width/2, height/2, width, height);
  }
}

void nightMare(){
  if(nightmareMode){
    enCol = color(random(33,66),random(14,28),random(41,82));
    foodCol = color(255);
    P1TextCol = color(200,0,0);
    P2TextCol = color(200,0,0);
    P1Col = color(255,255,0);
    P2Col = color(255,0,0);
    textCol = color(200,0,0);
  }
  if(nightmareMode && nmDoOnce){
    points *= 2;
    nmDoOnce = false;
    game = new Game(arenaWidth, arenaHeight, enemies*4, 1, winScore, coop);
  }
}

void uniCorn(){
  if(unicornMode){
    enCol = color(random(1,255),random(1,255),random(1,255));
    foodCol = color(0);
    P1TextCol = color(random(1,255),random(100,150));
    P2TextCol = color(random(1,255),random(100,150));
    textCol = color(random(1,255),random(1,255),random(1,255));
    P1Col = color(random(1,255),random(100,150));
    P2Col = color(random(1,255),random(100,150));
  }
  if(unicornMode && uDoOnce){
    points *= 3;
    uDoOnce = false;
    winScore = 5;
    game = new Game(arenaWidth, arenaHeight, enemies*10, 1, winScore, coop);
  }
}

void endLess(){
  if(endlessMode){
    enCol = color(random(1,255),random(1,255));
    foodCol = color(0,random(155,255),0);
    P1TextCol = color(0,0,random(155,255));
    P2TextCol = color(0,random(155,255),random(155,255));
    textCol = color(random(155,255),155);
    P1Col = color(0,0,random(155,255));
    P2Col = color(0,random(155,255),random(155,255));
  }
  if(endlessMode && eDoOnce){
    eDoOnce = false;
    winScore = 10000;
    game = new Game(arenaWidth, arenaHeight, enemies, 2, winScore, coop);
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------
//Displays:
void scoreDisplay(){
  textAlign(CENTER,BOTTOM);
  textSize(25);
  if(coop){
    fill(P1TextCol);
    text("P1 Score: "+game.getScore()+"/"+winScore, width-100, 30);
    fill(P2TextCol);
    text("P2 Score: "+game.getP2Score()+"/"+winScore, width-100, 60);
  }else{
    fill(textCol);
    text("Score: "+game.getScore()+"/"+winScore, width-100, 30);
  }
}

void lifeDisplay(){
  textAlign(CENTER,BOTTOM);
  textSize(25);
  if(coop){
    fill(P1TextCol);
    text("P1 Life: "+game.getPlayerLife(), 100, 30);
    fill(P2TextCol);
    text("P2 Life: "+game.getPlayer2Life(), 100, 60);
  }else{
    fill(textCol);
    text("Life: "+game.getPlayerLife(), 100, 30);
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------
//Various game states (win and defeat, as well as coop win/defeat):
void winState(){
  if(game.win() && !coop){
    textSize(50);
    fill(150,150);
    rectMode(CENTER);
    rect(width/2,height/2,width,height);
    fill(0);
    text("You won!",width/2,height/2-120);
    text("Press 'Enter' to restart or 'R' to reset",width/2,height/2-50);
    textSize(35);
    text("Points: "+points,width/2,height/2);
    noLoop();
  }
}

void failureState(){
  if(game.gameOver() || timer < 0){
    textSize(50);
    fill(150,0,0,150);
    rectMode(CENTER);
    rect(width/2,height/2,width,height);
    fill(0);
    text("Game Over!",width/2,height/2-120);
    text("Press 'Enter' to restart or 'R' to reset",width/2,height/2-50);
    textSize(35);
    points = points/2 - 75*(winScore - game.getScore());
    if(points < 0) points = 0;
    text("Points: "+points,width/2,height/2);
    noLoop();
  }
}
  
void coopWinFailureState(){
  if(coop){
    if(game.coopGameOver() == 1 || game.win2() || game.getP2Score() > game.getScore() && timer < 0){ //P1 loses
      textSize(50);
      fill(100,255,255,150);
      rectMode(CENTER);
      rect(width/2,height/2,width,height);
      fill(0);
      text("Player Two Wins!",width/2,height/2-120);
      text("Press 'Enter' to restart or 'R' to reset",width/2,height/2-50);
      textSize(35);
      text("P2 Points: "+points,width/2,height/2);
      points = points/2 - 75*(winScore - game.getScore());
      if(points < 0) points = 0;
      text("P1 Points: "+points,width/2,height/2+45);
      noLoop();
    }
    if(game.coopGameOver() == 2 || game.win() || game.getScore() > game.getP2Score() && timer < 0){ //P2 loses
      textSize(50);
      fill(100,100,255,150);
      rectMode(CENTER);
      rect(width/2,height/2,width,height);
      fill(0);
      text("Player One Wins!",width/2,height/2-120);
      text("Press 'Enter' to restart or 'R' to reset",width/2,height/2-50);
      textSize(35);
      text("P1 Points: "+points,width/2,height/2);
      points = points/2 - 75*(winScore - game.getP2Score());
      if(points < 0) points = 0;
      text("P2 Points: "+points,width/2,height/2+45);
      noLoop();
    }
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------
//Controls:
void keyReleased()
{
  game.onKeyReleased(key);
  game.onKeyReleased2(keyCode);
}

void keyPressed()
{
  game.onKeyPressed(key);
  game.onKeyPressed2(keyCode);
  
  //pause game
  if(keyCode == BACKSPACE){
    rectMode(CENTER);
    fill(150,150);
    rect(width/2-15,height/2,10,50);
    rect(width/2+15,height/2,10,50);
    textAlign(CENTER,BOTTOM);
    textSize(35);
    fill(200);
    text("Press Enter to resume",width/2,height/2-45);
    noLoop();
  }
  //resume game
  if(keyCode == ENTER){
    if(game.gameOver() || game.win() || game.win2() || game.coopGameOver() > 0){
      //reset colours
      enCol = color(255,0,0);
      foodCol = color(0,255,0);
      P1TextCol = color(100,100,255);
      P2TextCol = color(100,255,255);
      textCol = color(255);
      P1Col = color(0,0,255);
      P2Col = color(0,255,255);
      //reset booleans (but not modes)
      nmDoOnce = true;
      uDoOnce = true;
      eDoOnce = true;
      //reset points and timer
      points = 0;
      timer = 1800;
      //reset game
      game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
    }
    //start sketch
    loop();
  }
  if(key == 'r' || key == 'R'){
    //reset colours
    enCol = color(255,0,0);
    foodCol = color(0,255,0);
    P1TextCol = color(100,100,255);
    P2TextCol = color(100,255,255);
    textCol = color(255);
    P1Col = color(0,0,255);
    P2Col = color(0,255,255);
    //reset booleans
    nmDoOnce = true;
    nightmareMode = false;
    unicornMode = false;
    endlessMode = false;
    nmDoOnce = true;
    uDoOnce = true;
    eDoOnce = true;
    //reset points and timer
    points = 0;
    timer = 1800;
    //reset game
    game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
    //start sketch
    loop();
  }
  if(key == 'u'){
    unicornMode = false;
    endlessMode = false;
    nightmareMode = true;
  }
  if(key == 'U'){
    nightmareMode = false;
    endlessMode = false;
    unicornMode = true;
  }
  if(key == 'E'){
    nightmareMode = false;
    unicornMode = false;
    endlessMode = true;
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------
//Game board (determines color and size of the playable game field):
void gameBoard(){
  // This embedded loop skips over values in the arrays based on
  // the spacer variable, so there are more values in the array
  // than are drawn here. Change the value of the spacer variable
  // to change the density of the points
  int[][] board = game.getBoard();
  for (int y = 0; y < game.getHeight(); y++)
  {
    for (int x = 0; x < game.getWidth(); x++)
    {
      if(board[x][y] == 0)
      {
        fill(bgCol);
      }
      else if(board[x][y] == 1)
      {
        fill(P1Col);
      }
      else if(board[x][y] == 2)
      {
        fill(enCol);
      }
      else if(board[x][y] == 3)
      {
        fill(foodCol);
      }
      else if(board[x][y] == 4)
      {
        fill(P2Col);
      }
      stroke(255,50);
      rectMode(CORNER);
      rect(x*40, y*40, 40, 40);
    }
  }
}
