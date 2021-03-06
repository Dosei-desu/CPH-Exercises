import processing.core.PApplet;
import processing.core.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Puck_Man extends PApplet {

//--variables
        //startscreen
    PImage startscreen;
    boolean started = false;
        //system functions
    boolean paused = false;
        //states
    boolean win = false;
    boolean gameOver = false;
            //highscorers
    ArrayList<Highscorer> highscorers = new ArrayList<>();
        //player
    static String name = "";
    PImage puck_man;
    Puck puck = new Puck(11,19);
            //"animation"
    int animationCounter = 0;
    boolean moveU = false, moveD = false, moveR = true, moveL = false;
            //health
    PImage heart;
    int hearts = 2;
            //score
    int highScore = 0;
    int time = 0;
    PImage fruit;
        //ghost
    PImage ghost;
        //arenas
    Arena01 arena_01 = new Arena01(this, puck);
    //since this^ is defined prior to the Size() initialisation, width and height won't work
        //arena debug image (not in use)
    boolean debug = false;

//--Database
    Database database = new Database();

//--settings
    public void settings(){
        //for some reason, the sketch doesn't work if size() is in Setup() instead of Settings()
        size(640,736);
    }

//--setup
    public void setup(){ //draw is necessary, since some methods don't work in Settings()
        //noCursor();
        startscreen = loadImage("Puck-Man startscreen.png");
        puck_man = loadImage("puck-man.png"); //find better image and make a version for left,right,up,down
        heart = loadImage("heart.png");
        ghost = loadImage("ghost.png");
        fruit = loadImage("fruit.png");
    }

//--draw
    public void draw(){
        if(mousePressed && mouseX > 0 && mouseX < width && mouseY > 0 && mouseY < height){
            started = true;
        }
        if(started) {
            //background
            background(0);

            arena_01.update();
            gameBoard();
            gameOverState();
        }else{
            image(startscreen,0,0,width,height);
        }
    }

//--reset
    public void reset(){
        loop();
        started = false;
        time = 0;
        highScore = 0;
        hearts = 2;
        animationCounter = 0;
        puck = new Puck(11,19);
        arena_01 = new Arena01(this, puck);
    }

//--necessary to run the PApplet
    public static void main(String[] args) {
        //Entering name before beginning
        System.out.println("Please enter your 5-digit name:");
        Scanner input = new Scanner(System.in);
        name = input.next();
        System.out.println("Starting Puck-Man...");

        String[] processingArgs = {"Puck_Man"};
        Puck_Man mySketch = new Puck_Man();
        PApplet.runSketch(processingArgs, mySketch);
    }

//--scoreboard
    public void scoreboard(int orbCounter, int fruitCounter){
        if(orbCounter != 0) {
            time++;
            highScore = (171 - orbCounter) * 50;
            highScore += (1 - fruitCounter) * 1000;
            textAlign(CORNER, CENTER);
            textSize(28);
            fill(150, 50, 50);
            text("Highscore: " + highScore, 20, 45);
            text("Time: " + time / 60 + "s", width - 225, 45);
        }
    }

//--game board for spawning visuals
    public void gameBoard() {
        int orbCounter = 0;
        int fruitCounter = 0;
        int[][] board = arena_01.getBoard();
        for (int y = 0; y < arena_01.getHeight(); y++) {
            for (int x = 0; x < arena_01.getWidth(); x++) {
                if (board[x][y] == -1) {
                    fill(150,50,50);
                } else if (board[x][y] >= 0) {
                    fill(0);
                }
                //stroke(255, 50); //shows grid
                noStroke();
                rectMode(CORNER);
                rect(x * 32, y * 32, 32, 32);

                //spawns the little pebbles or whatever they are
                if(y > 2 && board[x][y] == 0){
                    orbCounter++; //counts the pellets
                    ellipseMode(CORNER);
                    fill(225, 198, 153); //beige
                    ellipse((x * 32) + 12, (y * 32) + 12, 8, 8);
                }
                //spawns player visuals
                if(board[x][y] == 1 && !arena_01.hit()){
                    ellipseMode(CORNER);
                    if(animationCounter < 4) {
                        fill(200, 200, 50); //yellow ish
                        ellipse((x * 32) + 2,(y * 32 ) + 2, 28, 28);
                    }else if(animationCounter < 8){
                        fill(200, 200, 50); //yellow ish
                        ellipse((x * 32) + 2,(y * 32 ) + 2, 28, 28);
                        fill(0);
                        //animation
                            //up
                        if(moveU) {
                            beginShape();
                            vertex((x * 32) + 17, (y * 32) + 15);
                            vertex((x * 32) + 10, (y * 32));
                            vertex((x * 32) + 20, (y * 32));
                            endShape();
                        }
                            //down
                        if(moveD) {
                            beginShape();
                            vertex((x * 32) + 17, (y * 32) + 15);
                            vertex((x * 32) + 10, (y * 32) + 30);
                            vertex((x * 32) + 20, (y * 32) + 30);
                            endShape();
                        }
                            //right
                        if(moveR) {
                            beginShape();
                            vertex((x * 32) + 15, (y * 32) + 15);
                            vertex((x * 32) + 35, (y * 32) + 10);
                            vertex((x * 32) + 35, (y * 32) + 20);
                            endShape();
                        }
                            //left
                        if(moveL) {
                            beginShape();
                            vertex((x * 32) + 20, (y * 32) + 15);
                            vertex((x * 32), (y * 32) + 10);
                            vertex((x * 32), (y * 32) + 20);
                            endShape();
                        }
                    }else{
                        fill(200, 200, 50); //yellow ish
                        ellipse((x * 32) + 2,(y * 32 ) + 2, 28, 28);
                        fill(0);
                        //animation
                            //up
                        if(moveU) {
                            beginShape();
                            vertex((x * 32) + 17, (y * 32) + 15);
                            vertex((x * 32), (y * 32));
                            vertex((x * 32) + 30, (y * 32));
                            endShape();
                        }
                            //down
                        if(moveD) {
                            beginShape();
                            vertex((x * 32) + 17, (y * 32) + 15);
                            vertex((x * 32), (y * 32) + 30);
                            vertex((x * 32) + 30, (y * 32) + 30);
                            endShape();
                        }
                            //right
                        if(moveR) {
                            beginShape();
                            vertex((x * 32) + 15, (y * 32) + 15);
                            vertex((x * 32) + 35, (y * 32));
                            vertex((x * 32) + 35, (y * 32) + 30);
                            endShape();
                        }
                            //left
                        if(moveL) {
                            beginShape();
                            vertex((x * 32) + 20, (y * 32) + 15);
                            vertex((x * 32), (y * 32));
                            vertex((x * 32), (y * 32) + 30);
                            endShape();
                        }
                    }
                    if(animationCounter > 12){
                        animationCounter = 0;
                    }
                    animationCounter++;
                }
                //ghosts
                if(board[x][y] == 3){
                    fill(0);
                    image(ghost,(x * 32 ) + 2,(y * 32 ) + 2,28,28);
                }
                //fruit
                if(board[x][y] == 4){
                    fruitCounter++; //counts number of fruits
                    fill(50,250,50);
                    image(fruit,(x * 32 ) + 8,(y * 32 ) + 8,20,20);
                }
            }
        }
        //who knew it could be so fucking simple to make a win state... jesus christ...
        if(orbCounter == 0){
            //if the number of pellets == 0 you have eaten them all, aka, there are no tiles with the value "0"
            rectMode(CORNER);
            fill(0,200);
            noStroke();
            rect(0,0,width,height); //blacks out background with transparent screen

            textAlign(CENTER,CENTER);
            textSize(100);
            fill(250,250,50);
            text("YOU WIN",width/2,130);

            highScore += hearts * 250;
            highScore += (25 * (180 - time/60));

            //adds newest score to database
            if(name == ""){
                name = "NONAM";
            }
            if(name.length() > 5){
                name = name.substring(0,5);
            }
            database.addToDatabase(name.toUpperCase(),highScore,time/60);

            //display your score
            textSize(30);
            fill(250,250,50);
            text("\""+name.toUpperCase()+"\"",width/2,250);
            text("Score: "+highScore,width/2,300);
            text("Time: "+time/60+"s",width/2,350);

            //display highscorers
                //populates arraylist with top 3 scorers, yours included if you get a high enough score
            database.populateHighscorers(highscorers);
            text("------Highscorers------",width/2,450);
            text("\""+highscorers.get(0).getPlayer()+"\" --- "+highscorers.get(0).getScore()+" --- "+
                    highscorers.get(0).getTime()+"s",width/2,500);
            text("\""+highscorers.get(1).getPlayer()+"\" --- "+highscorers.get(1).getScore()+" --- "+
                    highscorers.get(1).getTime()+"s",width/2,550);
            text("\""+highscorers.get(2).getPlayer()+"\" --- "+highscorers.get(2).getScore()+" --- "+
                    highscorers.get(2).getTime()+"s",width/2,600);

            win = true;

            noLoop();
        }
        rectMode(CORNER);
        fill(0);
        noStroke();
        rect(0,0,width,95); //blacks out score, hearts, timer

        scoreboard(orbCounter, fruitCounter);
        displayHearts(orbCounter);
    }

//--Game Over State
    public void gameOverState(){
        if(arena_01.hit() && hearts != 0){
            hearts -= 1;
            puck.setX(11);
            puck.setY(19);
        }
        if(arena_01.hit() && hearts == 0){
            noStroke();
            rectMode(CORNER);
            fill(0);
            rect(0,0,width,95); //blacks out score, hearts, timer

            fill(0,200);
            rect(0,0,width,height); //blacks out background with transparent screen

            textAlign(CENTER,CENTER);
            textSize(100);
            fill(250,50,50);
            text("GAME OVER",width/2,height/2);

            gameOver = true;

            noLoop();
        }
    }

//--displays
    public void displayHearts(int orbCounter){
        if(orbCounter != 0) {
            if (hearts == 2) {
                image(heart, width / 2 - 60, 30, 40, 40);
                image(heart, width / 2 - 20, 30, 40, 40);
                image(heart, width / 2 + 20, 30, 40, 40);
            } else if (hearts == 1) {
                image(heart, width / 2 - 20, 30, 40, 40);
                image(heart, width / 2 + 20, 30, 40, 40);
            } else if (hearts == 0) {
                image(heart, width / 2 + 20, 30, 40, 40);
            }
        }
    }

//--keybinds
    public void keyPressed(){
        boolean moveOnce = true;
        //controls
        int[][] board = arena_01.getBoard();
        for (int y = 0; y < arena_01.getHeight(); y++) {
            for (int x = 0; x < arena_01.getWidth(); x++) {
                if (!paused) {
                    if (key == 'A' || key == 'a' || keyCode == LEFT) {
                        moveL = true; moveR = false; moveU = false; moveD = false;
                        //left exit teleporter
                        if (puck.getX() == 0 && puck.getY() == 12) {
                            puck.setX(18);
                        }
                        if (board[puck.getX() - 1][puck.getY()] != -1) { //checks if the block you are moving to isn't a wall
                            if (moveOnce) {
                                puck.moveX(-1);
                                moveOnce = false;
                            }
                        }
                    }
                    if (key == 'D' || key == 'd' || keyCode == RIGHT) {
                        moveR = true; moveL = false; moveU = false; moveD = false;
                        //left exit teleporter
                        if (puck.getX() == 19 && puck.getY() == 12) {
                            puck.setX(1);
                        }
                        if (board[puck.getX() + 1][puck.getY()] != -1) {
                            if (moveOnce) {
                                puck.moveX(1);
                                moveOnce = false;
                            }
                        }
                    }
                    if (key == 'W' || key == 'w' || keyCode == UP) {
                        moveU = true; moveR = false; moveL = false;  moveD = false;
                        if (board[puck.getX()][puck.getY() - 1] != -1) {
                            if (moveOnce) {
                                puck.moveY(-1);
                                moveOnce = false;
                            }
                        }
                    }
                    if (key == 'S' || key == 's' || keyCode == DOWN) {
                        moveD = true; moveU = false; moveR = false; moveL = false;
                        if (board[puck.getX()][puck.getY() + 1] != -1) {
                            if (moveOnce) {
                                puck.moveY(1);
                                moveOnce = false;
                            }
                        }
                    }
                }
            }
        }
        //shutdown
        if(key == ESC) {
            stop();
        }
        //pause
        if(key == 'P' || key == 'p') {
            if (!paused) {
                rectMode(CORNER);
                fill(50,200);
                rect(0,0,width,height); //greys out background with transparent screen

                fill(150);
                textSize(100);
                textAlign(CENTER,CENTER);
                text("PAUSED",width/2,height/2);
                paused = true;
                noLoop();
            } else {
                paused = false;
                loop();
            }
        }
        //reset
        if(key == 'R' || key == 'r'){
            reset();
        }
        //debug
        if(key == 'M' || key == 'm'){
            debug = !debug;
        }
    }

//--mouse button functionality
    public void mousePressed(){
        if(paused){
            paused = false;
            loop();
        }
        //debug
        if(debug) {
            if (mouseX >= 0 && mouseX <= width && mouseY >= 0 && mouseY <= height) {
                System.out.println("X: " + (mouseX) + "\nY: " + (mouseY));
            }
        }
        if(win || gameOver){
            win = false;
            gameOver = false;
            reset();
        }
    }
}

//TODO
/**
 *
 */

//FIXME
/**
 * Rare event of magically skipping around a corner when two keys are pressed simultaneously, have not been able to
   recreate...
 * Make up and down chomping look less derp
 */