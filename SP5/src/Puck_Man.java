import processing.core.PApplet;
import processing.core.*;

public class Puck_Man extends PApplet {

//--variables
    boolean paused = false;
        //player
    float playerX = 265, playerY = 585, playerSize = 35;
    boolean aDown = false, sDown = false, dDown = false, wDown = false;
    float playerSpeed = 3;
        //arenas
    Arena01 pManArena01 = new Arena01(this,320,370,playerX,playerY,playerSize);
    //since this^ is defined prior to the Size() initialisation, width and height won't work
        //arena debug image
    PImage debugArena;
    boolean debug = false;

//--settings
    public void settings(){
        //for some reason, the sketch doesn't work if size() is in Setup() instead of Settings()
        size(640,740);
    }

//--setup
    public void setup(){ //draw is necessary, since some methods don't work in Settings()
        //noCursor();
        //arena debug image
        debugArena = loadImage("Pac-Man arena reference (with grid).jpg");
    }

//--draw
    public void draw(){
        //background
        background(0);
        dBug();
        collision();
        pacMan(playerX,playerY,playerSize);
        controls();

        pManArena01.render();
    }

//--necessary to run the PApplet
    public static void main(String[] args) {
        String[] processingArgs = {"Puck_Man"};
        Puck_Man mySketch = new Puck_Man();
        PApplet.runSketch(processingArgs, mySketch);
    }

//--player model
    public void pacMan(float x, float y, float diameter){
        fill(255,255,0);
        strokeWeight(2);
        stroke(0);
        ellipse(x,y,diameter,diameter);
        line(x-diameter/2,y,x,y);
    }

//--debug stuff
    public void dBug(){
        if(debug) {
            image(debugArena, 0, 100, width, width); //for debugging arena
        }
    }

//--collision
    void collision(){
        if(pManArena01.collision(playerX,playerY)) {
            playerSpeed *= -1;
        }
    }

//--controls
    void controls(){
        if(aDown){
            playerX -= playerSpeed;
        }
        if(dDown){
            playerX += playerSpeed;
        }
        if(wDown){
            playerY -= playerSpeed;
        }
        if(sDown){
            playerY += playerSpeed;
        }
    }

//--keybinds
    public void keyPressed(){
        //controls
        if (key == 'A' || key == 'a' || keyCode == LEFT){
            aDown = true; sDown = false; dDown = false; wDown = false;
        }
        else if(key == 'D' || key == 'd' || keyCode == RIGHT){
            aDown = false; sDown = false; dDown = true; wDown = false;
        }
        else if(key == 'W' || key == 'w' || keyCode == UP){
            aDown = false; sDown = false; dDown = false; wDown = true;
        }
        else if(key == 'S' || key == 's' || keyCode == DOWN){
            aDown = false; sDown = true; dDown = false; wDown = false;
        }
        //shutdown
        if(key == ESC) {
            stop();
        }
        //pause
        if(key == 'P' || key == 'p') {
            if (!paused) {
                fill(250,50,50);
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
            if(!debug){
                debug = true;
            }else{
                debug = false;
            }
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

//FIXME
/**
* It is possible to clip through obstacles, no doubt because of the way the controls are set up, so that needs a rework
*/