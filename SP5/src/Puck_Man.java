import processing.core.PApplet;
import processing.core.*;

import java.util.ArrayList;
import java.util.List;

public class Puck_Man extends PApplet {

//--variables
    boolean paused = false;
        //player
    Puck puck = new Puck(6,18);
        //ghost
    PImage ghost;
        //arenas
    Arena01 arena_01 = new Arena01(this, puck);
    //since this^ is defined prior to the Size() initialisation, width and height won't work
        //arena debug image
    boolean debug = false;

//--settings
    public void settings(){
        //for some reason, the sketch doesn't work if size() is in Setup() instead of Settings()
        size(640,736);
    }

//--setup
    public void setup(){ //draw is necessary, since some methods don't work in Settings()
        //noCursor();
        ghost = loadImage("ghost.png");
    }

//--draw
    public void draw(){
        //background
        background(0);
        arena_01.update();
        gameBoard();
    }

//--necessary to run the PApplet
    public static void main(String[] args) {
        String[] processingArgs = {"Puck_Man"};
        Puck_Man mySketch = new Puck_Man();
        PApplet.runSketch(processingArgs, mySketch);
    }

//--scoreboard
    public void scoreboard(int orbCounter){
        int score = (171-orbCounter)*50;
        textAlign(CORNER,CENTER);
        textSize(30);
        fill(150,50,50);
        text("Highscore: "+score,45,45);
    }

//--game board for spawning visuals
    public void gameBoard() {
        int orbCounter = 0;
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
                    orbCounter++;
                    ellipseMode(CORNER);
                    fill(225, 198, 153); //beige
                    ellipse((x * 32) + 12, (y * 32) + 12, 8, 8);
                }
                //spawns player visuals
                if(board[x][y] == 1){
                    ellipseMode(CORNER);
                    fill(200, 200, 50); //yellow ish
                    ellipse((x * 32) + 2,(y * 32 ) + 2, 30, 30);
                }
                //ghosts
                if(board[x][y] == 3){
                    fill(0);
                    image(ghost,(x * 32 ) + 2,(y * 32 ) + 2,28,28);
                }
            }
        }
        //who knew it could be so fucking simple to make a win state... jesus christ...
        if(orbCounter == 0){
            System.out.println("Win");
        }
        rectMode(CORNER);
        fill(0);
        noStroke();
        rect(0,0,width,95);
        scoreboard(orbCounter);
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
                        if (board[puck.getX()][puck.getY() - 1] != -1) {
                            if (moveOnce) {
                                puck.moveY(-1);
                                moveOnce = false;
                            }
                        }
                    }
                    if (key == 'S' || key == 's' || keyCode == DOWN) {
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
                fill(250,250,50);
                textSize(35);
                textAlign(CENTER,CENTER);
                text("PAUSED",width/2,height/2+85);
                paused = true;
                noLoop();
            } else {
                paused = false;
                loop();
            }
        }
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
    }
}

//TODO
/**
 * Add enenenmies that track player
 * Add "fruit" (maybe trapped inside ghost cage)
 */

//FIXME
/**
 *
 */