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
int foodCount = 1;
int arenaWidth = 30, arenaHeight = 20;
boolean coop = false;
int winScore = 10;

Game game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop); //last boolean is coop

boolean nightmareMode = false;
boolean doOnce = true;

color bgCol = color(0);
color P1Col = color(0,0,255);
color P2Col = color(0,255,255);
color enCol = color(255,0,0);
color foodCol = color(0,255,0);

PFont font;
PImage nmPic;

public void settings() {
  size(1201, 801);
  nmPic = loadImage("devil.jpg");
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
    if(game.gameOver() || game.win() || game.win2()){
      bgCol = color(0);
      enCol = color(255,0,0);
      foodCol = color(0,255,0);
      doOnce = true;
      game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
    }
    loop();
  }
  if(key == 'r' || key == 'R'){
    bgCol = color(0);
    enCol = color(255,0,0);
    foodCol = color(0,255,0);
    doOnce = true;
    game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
    nightmareMode = false;
    doOnce = true;
    loop();
  }
  if(key == 'u' || key == 'U'){
    nightmareMode = true;
  }
}

void draw()
{
  background(0); //Black
  if(nightmareMode){
    imageMode(CENTER);
    image(nmPic, width/2, height/2, width, height);
  }
  game.update();
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
  
  //varies failure/win states
  failureState();
  coopFailureState();
  winState();
}

void nightMare(){
  if(nightmareMode && doOnce){
    doOnce = false;
    bgCol = color(0,0);
    enCol = color(66,28,82);
    foodCol = color(255);
    game = new Game(arenaWidth, arenaHeight, enemies*4, foodCount, winScore*2, coop);
  }
}

void scoreDisplay(){
  textAlign(CENTER,BOTTOM);
  textSize(25);
  if(coop){
    fill(100,100,255);
    text("P1 Score: "+game.getScore(), width-100, 30);
    fill(100,255,255);
    text("P2 Score: "+game.getP2Score(), width-100, 60);
  }else{
    fill(255);
    text("Score: "+game.getScore(), width-100, 30);
  }
}

void lifeDisplay(){
  textAlign(CENTER,BOTTOM);
  textSize(25);
  if(coop){
    fill(100,100,255);
    text("P1 Life: "+game.getPlayerLife(), 100, 30);
    fill(100,255,255);
    text("P2 Life: "+game.getPlayer2Life(), 100, 60);
  }else{
    fill(255);
    text("Life: "+game.getPlayerLife(), 100, 30);
  }
}

void winState(){
  if(game.win()){
    textSize(50);
    fill(100,100,255);
    rectMode(CENTER);
    rect(width/2,height/2,width,height);
    fill(0);
    text("You won!",width/2,height/2-120);
    text("Press Enter to restart",width/2,height/2-50);
    textSize(35);
    text("Score: "+game.getScore(),width/2,height/2);
    noLoop();
  }
}

void failureState(){
  if(game.gameOver()){
    textSize(50);
    fill(150,0,0);
    rectMode(CENTER);
    rect(width/2,height/2,width,height);
    fill(0);
    text("Game Over!",width/2,height/2-120);
    text("Press Enter to restart",width/2,height/2-50);
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
      text("Press Enter to restart",width/2,height/2-50);
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
      text("Press Enter to restart",width/2,height/2-50);
      textSize(35);
      text("P1 Score: "+game.getScore(),width/2,height/2);
      text("P2 Score: "+game.getP2Score(),width/2,height/2+35);
      noLoop();
    }
  }
}
