//SP1
//Kristoffer Borg Pauly

/*
- Think of new stuff to add, since you still have 4 days left....
*/

//--------------------------------------------------------------------------------------------------------------------------------------------
//Variables:
import java.util.Random; //imports Random utility (legacy code from Tobias' original sketch that I haven't bothered to change
int enemies = 6;
int foodCount = 2;
int arenaWidth = 30, arenaHeight = 20;
boolean coop = false;
int winScore = 10;

//startscreen
boolean startScreen = true;

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
PImage bgPic;
PImage nmPic;
PImage uPic;
PImage ePic;
PImage homeSymbol;
PImage returnSymbol;

//skull reaper
int skullX = (int)random(width/2,width-1);
int skullY = (int)random(1,height-1);
int skullSpeedX = (int)random(1,10); 
int skullSpeedY = (int)random(1,10);
PImage skullPic;

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
  font = createFont("Gungsuh", 25, true); //didn't like Arial so I decided to go with Gungsuh (hopefully this is available on all word font libraries)
  textFont(font);
  bgPic = loadImage("vista.jpg");
  nmPic = loadImage("devil.jpg");
  uPic = loadImage("unicorn.jpg");
  ePic = loadImage("endless.jpg");
  homeSymbol = loadImage("home.png");
  returnSymbol = loadImage("return.png");
  skullPic = loadImage("skull.png");
}
//--------------------------------------------------------------------------------------------------------------------------------------------
//Draw:
void draw()
{
  background(0); //Black
  
  //start screen
  startScreen();
  
  if(!startScreen){ //only starts if the startScreen is not active (this is to prevent a bug where you can die in the background)
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
    buttonsDisplay();
    
    //modes
    nightMare();
    uniCorn();
    endLess();
    
    //varies failure/win states
    failureState();
    coopWinFailureState();
    winState();
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------
//Start Screen:
void startScreen(){
  if(startScreen){
    //start screen canvas
    rectMode(CENTER);
    fill(0);
    rect(width/2,height/2,width,height);
    
    //intro text + title?
    textAlign(CENTER,BOTTOM);
    textSize(50);
    fill(255);
    text("Pick a Gamemode", width/2, height/4);
    
    //selection boxes
    stroke(255);
      //left box
    if(!coop){
      fill(0,150,0);
    }else{
      noFill();
    }
    rect(300,385,300,60);
      //right box
    if(coop){
      fill(0,150,0);
    }else{
      noFill();
    }
    rect(900,385,150,60);
    fill(255);
    textSize(40);
    text("Singleplayer", width/4, height/2);
    text("Co-op", width-width/4, height/2);
    
    //selection imagery stuff
    noStroke();
    fill(0,0,255);
    rect(300,height-height/3,50,50);
    rect(850,height-height/3,50,50);
    fill(0,255,255);
    rect(950,height-height/3,50,50);
    fill(255);
    text("+",900,550);
    
    if(mousePressed && mouseX < 450 && mouseX > 150 && mouseY < 415 && mouseY > 355){
      coop = false;
      game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
      resetVar();
      startScreen = false;
    }else if(mousePressed && mouseX < 975 && mouseX > 825 && mouseY < 415 && mouseY > 355){
      coop = true;
      game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
      resetVar();
      startScreen = false;
    }
  }
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
//reset stuff
void resetModes(){
  //reset modes
  nightmareMode = false;
  unicornMode = false;
  endlessMode = false;
}

void resetVar(){
  //reset variables
  enemies = 6;
  foodCount = 2;
  arenaWidth = 30;
  arenaHeight = 20;
  winScore = 10;
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
  uDoOnce = true;
  eDoOnce = true;
  //reset misc enemies and stuff
  skullX = (int)random(width/2,width-1);
  skullY = (int)random(1,height-1);
  skullSpeedX = (int)random(1,10); 
  skullSpeedY = (int)random(1,10);
  //reset points and timer
  points = 0;
  timer = 1800;
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
    skullReaper();
  }
  if(nightmareMode && nmDoOnce){
    skullX = (int)random(width/2,width-1);
    skullY = (int)random(1,height-1);
    skullSpeedX = (int)random(1,10); 
    skullSpeedY = (int)random(1,10);
    nmDoOnce = false;
    game = new Game(arenaWidth, arenaHeight, enemies*4, foodCount/2, winScore, coop);
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
    winScore = 5;
    game = new Game(arenaWidth, arenaHeight, enemies*10, foodCount/2, winScore, coop);
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
    enemies = 6;
    winScore = 10000;
    game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------
//Skull Reaper:
void skullReaper(){
  //Nightmare Mode Skull Reaper
  imageMode(CENTER);
  image(skullPic, skullX, skullY, 100, 100);
  
  //if skull collides with walls
  if(skullX < 50){
    skullSpeedX *= (int)random(-1,-3);
    skullX = 50;
  }else if(skullX > width-50){
    skullSpeedX *= (int)random(-1,-3);
    skullX = width-50;
  }
  if(skullY < 50){
    skullSpeedY *= (int)random(-1,-3);
    skullY = 50;
  }else if(skullY > height-50){
    skullSpeedY *= (int)random(-1,-3);
    skullY = height-50;
  }
  
  //collision
  if(game.player.getX() > (skullX-50)/40 && game.player.getX() < (skullX+50)/40 && game.player.getY() > (skullY-50)/40 && game.player.getY() < (skullY+50)/40){
    println("collision!");
    game.setPlayerLife(0);
  }
  if(coop){
    if(game.player2.getX() > (skullX-50)/40 && game.player2.getX() < (skullX+50)/40 && game.player2.getY() > (skullY-50)/40 && game.player2.getY() < (skullY+50)/40){
      game.setPlayer2Life(0);
    }
  }
  
  //speed
  skullX += skullSpeedX;
  skullY += skullSpeedY;
}

//-----------------------------------------------------------------------
//Displays:
void scoreDisplay(){
  textAlign(CENTER,BOTTOM);
  textSize(25);
  if(coop){
    fill(P1TextCol);
    text("P1 Score: "+game.getScore()+"/"+winScore, width-120, 30);
    fill(P2TextCol);
    text("P2 Score: "+game.getP2Score()+"/"+winScore, width-120, 60);
  }else{
    fill(textCol);
    text("Score: "+game.getScore()+"/"+winScore, width-120, 30);
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

void buttonsDisplay(){
  image(homeSymbol,220,20,40,40);
  image(returnSymbol,260,20,40,40);
  image(nmPic,300,20,40,40);
  image(uPic,340,20,40,40);
  image(ePic,380,20,40,40);
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
    int winPoints = points;
    if(nightmareMode) winPoints *= 3;
    if(unicornMode) winPoints *= 2;
    text("Points: "+winPoints,width/2,height/2);
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
      int winPoints = points;
      if(game.win2()){
        if(nightmareMode) winPoints *= 3;
        if(unicornMode) winPoints *= 2;
      }
      text("P2 Points: "+winPoints,width/2,height/2);
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
      int winPoints = points;
      if(game.win()){
        if(nightmareMode) winPoints *= 3;
        if(unicornMode) winPoints *= 2;
      }
      text("P1 Points: "+winPoints,width/2,height/2);
      points = points/2 - 75*(winScore - game.getP2Score());
      if(points < 0) points = 0;
      text("P2 Points: "+points,width/2,height/2+45);
      noLoop();
    }
  }
}

//--------------------------------------------------------------------------------------------------------------------------------------------
//Buttons:
void mouseClicked(){
  //return (x260,y20,w40,h40)
  if(mouseX < 240 && mouseX > 200 && mouseY < 40 && mouseY > 0){
    loop();
    resetVar();
    startScreen = true;
  }
  if(mouseX < 280 && mouseX > 240 && mouseY < 40 && mouseY > 0){
    loop();
    resetVar();
    resetModes();
    game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
    loop();
  }
  if(mouseX < 320 && mouseX > 280 && mouseY < 40 && mouseY > 0){
    loop();
    resetVar();
    unicornMode = false;
    endlessMode = false;
    nightmareMode = true;
  }
  if(mouseX < 360 && mouseX > 320 && mouseY < 40 && mouseY > 0){
    loop();
    resetVar();
    endlessMode = false;
    nightmareMode = false;
    unicornMode = true;
  }
  if(mouseX < 400 && mouseX > 360 && mouseY < 40 && mouseY > 0){
    loop();
    resetVar();
    nightmareMode = false;
    unicornMode = false;
    endlessMode = true;
  }
  
  if(game.gameOver() || game.win() || game.win2() || game.coopGameOver() > 0){
    //reset
    resetVar();
    //reset game
    game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
  }
  //start sketch
  loop();
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
      //reset
      resetVar();
      //reset game
      game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
    }
    //start sketch
    loop();
  }
  if(key == 'r' || key == 'R'){
    //reset
    resetVar();
    //reset modes
    resetModes();
    //reset game
    game = new Game(arenaWidth, arenaHeight, enemies, foodCount, winScore, coop);
    //start sketch
    loop();
  }
  if(key == 'u'){
    loop();
    unicornMode = false;
    endlessMode = false;
    nightmareMode = true;
  }
  if(key == 'U'){
    loop();
    nightmareMode = false;
    endlessMode = false;
    unicornMode = true;
  }
  if(key == 'E'){
    loop();
    nightmareMode = false;
    unicornMode = false;
    endlessMode = true;
  }
  if(key == 'X'){
    loop();
    startScreen = true;
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
