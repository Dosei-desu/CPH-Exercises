//SP1
//Kristoffer Borg Pauly

/*
 * Array 2D. 
 * 
 * Demonstrates the syntax for creating a two-dimensional (2D) array.
 * Values in a 2D array are accessed through two index values.  
 * 2D arrays are useful for storing images. In this example, each dot 
 * is colored in relation to its distance from the center of the image. 
 */
 
import java.util.Random;
int enemies = 6;
int foodCount = 2;
int arenaWidth = 30, arenaHeight = 20;
boolean coop = true;
int winScore = 10;

Game game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop); //last boolean is coop

boolean nightmareMode = false;
boolean nmDoOnce = true;
boolean unicornMode = false;
boolean uDoOnce = true;

color bgCol = color(0,150);
color P1Col = color(0,0,255);
color P2Col = color(0,255,255);
color enCol = color(255,0,0);
color foodCol = color(0,255,0);

color P1TextCol = color(100,100,255);
color P2TextCol = color(100,255,255);
color textCol = color(255);

PFont font;
PImage nmPic;
PImage bgPic;
PImage uPic;

public void settings() {
  size(1201, 801);
  nmPic = loadImage("devil.jpg");
  bgPic = loadImage("vista.jpg");
  uPic = loadImage("unicorn.jpg");
}

void setup()
{
  frameRate(10);
  font = createFont("Arial", 25, true);
  textFont(font);
}

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
    nmDoOnce = true;
    uDoOnce = true;
    //reset game
    game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
    //start sketch
    loop();
  }
  if(key == 'u'){
    unicornMode = false;
    nightmareMode = true;
  }
  if(key == 'U'){
    nightmareMode = false;
    unicornMode = true;
  }
}

void draw()
{
  background(0); //Black
  game.update();
  
  //Nightmare Mode background
  if(nightmareMode){
    imageMode(CENTER);
    image(nmPic, width/2, height/2, width, height);
  }else if(unicornMode){
    imageMode(CENTER);
    image(uPic, width/2, height/2, width, height);
  }else{
    imageMode(CENTER);
    image(bgPic, width/2, height/2, width, height);
  }
  
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
      stroke(100,100,100);
      rectMode(CORNER);
      rect(x*40, y*40, 40, 40);
    }
  }
  
  //displays
  scoreDisplay();
  lifeDisplay();
  
  //modes
  nightMare();
  uniCorn();
  
  //varies failure/win states
  failureState();
  coopFailureState();
  winState();
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
    nmDoOnce = false;
    game = new Game(arenaWidth, arenaHeight, enemies*4, 1, winScore*2, coop);
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
    uDoOnce = false;
    game = new Game(arenaWidth, arenaHeight, enemies*8, 5, 3, coop);
  }
}

void scoreDisplay(){
  textAlign(CENTER,BOTTOM);
  textSize(25);
  if(coop){
    fill(P1TextCol);
    text("P1 Score: "+game.getScore(), width-100, 30);
    fill(P2TextCol);
    text("P2 Score: "+game.getP2Score(), width-100, 60);
  }else{
    fill(textCol);
    text("Score: "+game.getScore(), width-100, 30);
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

void winState(){
  if(game.win()){
    textSize(50);
    fill(150,150);
    rectMode(CENTER);
    rect(width/2,height/2,width,height);
    fill(0);
    text("You won!",width/2,height/2-120);
    text("Press 'Enter' to restart or 'R' to reset",width/2,height/2-50);
    textSize(35);
    text("Score: "+game.getScore(),width/2,height/2);
    noLoop();
  }
}

void failureState(){
  if(game.gameOver()){
    textSize(50);
    fill(150,0,0,150);
    rectMode(CENTER);
    rect(width/2,height/2,width,height);
    fill(0);
    text("Game Over!",width/2,height/2-120);
    text("Press 'Enter' to restart or 'R' to reset",width/2,height/2-50);
    textSize(35);
    text("Score: "+game.getScore(),width/2,height/2);
    noLoop();
  }
}
  
void coopFailureState(){
  if(coop){
    if(game.coopGameOver() == 1 || game.win2()){ //P1 loses
      textSize(50);
      fill(100,255,255);
      rectMode(CENTER);
      rect(width/2,height/2,width,height);
      fill(0);
      text("Player Two Wins!",width/2,height/2-100);
      text("Press 'Enter' to restart or 'R' to reset",width/2,height/2-50);
      textSize(35);
      text("P2 Score: "+game.getP2Score(),width/2,height/2);
      text("P1 Score: "+game.getScore(),width/2,height/2+35);
      noLoop();
    }
    if(game.coopGameOver() == 2 || game.win()){ //P2 loses
      textSize(50);
      fill(100,100,255);
      rectMode(CENTER);
      rect(width/2,height/2,width,height);
      fill(0);
      text("Player One Wins!",width/2,height/2-100);
      text("Press 'Enter' to restart or 'R' to reset",width/2,height/2-50);
      textSize(35);
      text("P1 Score: "+game.getScore(),width/2,height/2);
      text("P2 Score: "+game.getP2Score(),width/2,height/2+35);
      noLoop();
    }
  }
}
