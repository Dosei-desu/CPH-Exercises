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
int enemies = 5;
int foodCount = 1;
int arenaWidth = 30, arenaHeight = 20;
boolean coop = true;
Game game = new Game(arenaWidth, arenaHeight, enemies, foodCount, coop); //last boolean is coop
PFont font;

public void settings() {
  size(1201, 801);
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
    if(game.gameOver()){
      game = new Game(arenaWidth, arenaHeight, enemies, foodCount, coop);
    }
    loop();
  }
}

void draw()
{
  game.update();
  background(0); //Black
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
        fill(0,0,0);
      }
      else if(board[x][y] == 1)
      {
        fill(0,0,255);
      }
      else if(board[x][y] == 2)
      {
        fill(255,0,0);
      }
      else if(board[x][y] == 3)
      {
        fill(0,255,0);
      }
      else if(board[x][y] == 4)
      {
        fill(0,255,255);
      }
      stroke(100,100,100);
      rectMode(CORNER);
      rect(x*40, y*40, 40, 40);
    }
  }
  scoreDisplay();
  lifeDisplay();
  failureState();
}

void scoreDisplay(){
  fill(255);
  textAlign(CENTER,BOTTOM);
  textSize(25);
  text("Score: "+game.getScore(), width-100, 30);
}

void lifeDisplay(){
  fill(255);
  textAlign(CENTER,BOTTOM);
  textSize(25);
  text("Life: "+game.getPlayerLife(), 100, 30);
}

void failureState(){
  if(game.gameOver()){
    textSize(50);
    fill(150,0,0);
    rectMode(CENTER);
    rect(width/2,height/2,width,height);
    fill(0);
    text("Press Enter to restart",width/2,height/2-50);
    textSize(35);
    text("Score: "+game.getScore(),width/2,height/2);
    noLoop();
  }
}
