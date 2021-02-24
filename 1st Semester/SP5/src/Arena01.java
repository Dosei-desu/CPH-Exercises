import processing.core.PApplet;

import java.util.Arrays;

public class Arena01 extends PApplet { //has to also extend the processing app
    private final PApplet sketch; //not currently in use, but required to access processing library
    private Puck puck;
    private Puck[] ghosts = new Puck[5];
    private final int w = 20, h = 23;
    private int[][] board;
    private int previousX, previousY;
    private final int[] ghostPreviousX = new int[ghosts.length],
                        ghostPreviousY = new int[ghosts.length],
                        previousBoardValue = new int[ghosts.length];
    private int[] moveCounter = {0,0,0,0,0};

    Arena01(PApplet sketch, Puck puck){
        this.sketch = sketch; //necessary to define what sketch is being used, without this, the class would require
                              //a draw, setup, settings, and so on
        this.puck = puck;
        board = new int[w][h];

        this.ghosts[0] = new Puck(9,12);
        this.ghosts[1] = new Puck(10,12);
        this.ghosts[2] = new Puck(9,13);
        this.ghosts[3] = new Puck(10,13);
        this.ghosts[4] = new Puck(8,11);
        Arrays.fill(previousBoardValue, 0);

        clearBoard();
        populateBoard();
    }

    public void update(){
        //System.out.println("current" + puck.getX() + " : " + puck.getY()); //debug player coordinates
        updateBoard();
        ghostAI();
    }

    public int[][] getBoard()
    {
        return board;
    }

    public int getWidth(){
        return w;
    }

    public int getHeight(){
        return h;
    }

    private void clearBoard(){
        for(int y = 0; y < h; ++y)
        {
            for(int x = 0; x < w; ++x)
            {
                if(y > 2)
                board[x][y] = -1;
            }
        }
    }

    public boolean hit(){
        for (int i = 0; i < ghosts.length; i++) {
            if(puck.getX() == ghosts[i].getX() && puck.getY() == ghosts[i].getY()) return true;
        }
        return false;
    }

    private void updateBoard(){
        //player coordinates
        board[previousX][previousY] = 2; //eats pellet by turning the value from "0" to "2"
        previousX = puck.getX();
        previousY = puck.getY();
        board[puck.getX()][puck.getY()] = 1;

        for (int i = 0; i < ghosts.length; i++) {
            //ensures that the ghosts don't alter the tiles they move across similar to what the player does
            board[ghostPreviousX[i]][ghostPreviousY[i]] = previousBoardValue[i];
            ghostPreviousX[i] = ghosts[i].getX();
            ghostPreviousY[i] = ghosts[i].getY();
            previousBoardValue[i] = board[ghosts[i].getX()][ghosts[i].getY()];
            board[ghosts[i].getX()][ghosts[i].getY()] = 3;
        }
    }

    public void ghostAI(){
        int ghostSpeed = 4; //less = more speed

        //decided to do it on-rails because the alternative was beyond my ability, and in a sense, it gives the game
        //a different kind of spin, more akin to games like SuperHot, where enemies only move when you do, which in a
        //way requires a different kind of finesse from the original pac-man game

        //the ghost move with a timer incremented by "ghostSpeed", therefore, the smaller the number of "ghostSpeed"
        //the shorter that timer is and the faster they move

        //without the timer they would move with the rate of the FPS, i.e. 30-60 moves per second, which would make it
        //impossible to avoid them... it's janky, but it works

        //ghost one (top left)
        if(sketch.keyPressed) {
            int num = 0;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed; //1st loop end
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed; //2nd loop end
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[0]){ ghosts[0].moveY(1); } //3rd loop end

            if(moveCounter[0] > 78 * ghostSpeed){
                moveCounter[0] = 4*ghostSpeed;
            }

            moveCounter[0]++;
        }
        //ghost two (top right)
        if(sketch.keyPressed) {
            int num = 0;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed; //1st loop end
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); } //2nd loop end

            if(moveCounter[1] > 70 * ghostSpeed){
                moveCounter[1] = 4*ghostSpeed;
            }

            moveCounter[1]++;
        }
        //ghost three (bottom left)
        if(sketch.keyPressed) {
            int num = 0;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed; //1st loop end
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } //2nd loop end

            if(moveCounter[2] > 81*ghostSpeed){
                moveCounter[2] = 13*ghostSpeed;
            }

            moveCounter[2]++;
        }
        //ghost four (bottom right)
        if(sketch.keyPressed) {
            int num = 0;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed; //1st loop end
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveX(-1); } //2nd loop end

            if(moveCounter[3] > 77*ghostSpeed){
                moveCounter[3] = 13*ghostSpeed;
            }

            moveCounter[3]++;
        }
        //ghost five (middle)
        if(sketch.keyPressed) {
            int num = 0;
            if (num == moveCounter[4]) { ghosts[4].moveY(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveY(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } num += ghostSpeed;
            if (num == moveCounter[4]) { ghosts[4].moveX(-1); } //1st loop end

            if(moveCounter[4] > 37*ghostSpeed){
                moveCounter[4] = -1*ghostSpeed;
            }

            moveCounter[4]++;
        }

        //note for further development:
        //consider making the "rails" for each ghost longer so that it covers a different pattern that minimises
        //dark-spots where you can easily avoid them and also reduces the predictability, but requiring you to memorise
        //their entire track pattern
    }

    //good ol' : https://print-graph-paper.com/virtual-graph-paper (used to design maze)
    private void populateBoard(){
        int row = 4;
        //y-index 0, 1, and 2 remain blank, as those are where score and stuff will go
        //the first row is already initialised through the "clearBoard()"
        //2nd row
        board[1][row] = 0; board[2][row] = 0; board[3][row] = 0; board[4][row] = 0; board[5][row] = 0; board[6][row] = 0;
        board[7][row] = 0; board[8][row] = 0; board[11][row] = 0; board[12][row] = 0; board[13][row] = 0; board[14][row] = 0;
        board[15][row] = 0; board[16][row] = 0; board[17][row] = 0; board[18][row] = 0;
        //3rd row
        row++;
        board[1][row] = 0; board[4][row] = 0; board[8][row] = 0; board[11][row] = 0; board[15][row] = 0; board[18][row] = 0;
        //4th row
        row++;
        board[1][row] = 0; board[4][row] = 0; board[8][row] = 0; board[11][row] = 0; board[15][row] = 0; board[18][row] = 0;
        //5th row
        row++;
        board[1][row] = 0; board[2][row] = 0; board[3][row] = 0; board[4][row] = 0; board[5][row] = 0; board[6][row] = 0;
        board[7][row] = 0; board[8][row] = 0; board[9][row] = 0; board[10][row] = 0; board[11][row] = 0; board[12][row] = 0;
        board[13][row] = 0; board[14][row] = 0; board[15][row] = 0; board[16][row] = 0; board[17][row] = 0; board[18][row] = 0;
        //6th row
        row++;
        board[1][row] = 0; board[7][row] = 0; board[12][row] = 0; board[18][row] = 0;
        //7th row
        row++;
        board[1][row] = 0; board[2][row] = 0; board[3][row] = 0; board[5][row] = 0; board[6][row] = 0; board[7][row] = 0;
        board[8][row] = 0; board[9][row] = 0; board[10][row] = 0; board[11][row] = 0; board[12][row] = 0; board[13][row] = 0;
        board[14][row] = 0; board[16][row] = 0; board[17][row] = 0; board[18][row] = 0;
        //8th row
        row++;
        board[3][row] = 0; board[5][row] = 0; board[9][row] = 2; board[10][row] = 2; board[14][row] = 0; board[16][row] = 0;
        //9th row
        row++;
        board[3][row] = 0; board[4][row] = 0; board[5][row] = 0; board[6][row] = 0; board[8][row] = 2; board[9][row] = 2;
        board[10][row] = 2; board[11][row] = 2; board[13][row] = 0; board[14][row] = 0; board[15][row] = 0; board[16][row] = 0;
        //10th row
        row++;
        board[0][row] = 2; board[1][row] = 2; board[2][row] = 2; board[3][row] = 0; board[6][row] = 0; board[8][row] = 2;
        board[9][row] = 2; board[10][row] = 2; board[11][row] = 2; board[13][row] = 0; board[16][row] = 0; board[17][row] = 2;
        board[18][row] = 2; board[19][row] = 2;
        //11th row
        row++;
        board[3][row] = 0; board[4][row] = 0; board[5][row] = 0; board[6][row] = 0; board[8][row] = 2; board[9][row] = 2;
        board[10][row] = 2; board[11][row] = 2; board[13][row] = 0; board[14][row] = 0; board[15][row] = 0; board[16][row] = 0;
        //12th row
        row++;
        board[3][row] = 0; board[5][row] = 0; board[8][row] = 2; board[9][row] = 2; board[10][row] = 4; board[11][row] = 2;
        board[14][row] = 0; board[16][row] = 0;
        //13th row
        row++;
        board[1][row] = 0; board[2][row] = 0; board[3][row] = 0; board[5][row] = 0; board[14][row] = 0; board[16][row] = 0;
        board[17][row] = 0; board[18][row] = 0;
        //14th row
        row++;
        board[1][row] = 0; board[3][row] = 0; board[5][row] = 0; board[6][row] = 0; board[7][row] = 0; board[8][row] = 0;
        board[9][row] = 0; board[10][row] = 0; board[11][row] = 0; board[12][row] = 0; board[13][row] = 0; board[14][row] = 0;
        board[16][row] = 0; board[18][row] = 0;
        //15th row
        row++;
        board[1][row] = 0; board[3][row] = 0; board[7][row] = 0; board[12][row] = 0; board[16][row] = 0; board[18][row] = 0;
        //16th row
        row++;
        board[1][row] = 0; board[2][row] = 0; board[3][row] = 0; board[4][row] = 0; board[5][row] = 0; board[6][row] = 0;
        board[7][row] = 0; board[8][row] = 0; board[9][row] = 0; board[10][row] = 0; board[12][row] = 0; board[13][row] = 0;
        board[14][row] = 0; board[15][row] = 0; board[16][row] = 0; board[17][row] = 0; board[18][row] = 0;
        //17th row
        row++;
        board[1][row] = 0; board[3][row] = 0; board[6][row] = 0; board[10][row] = 0; board[11][row] = 0; board[12][row] = 0;
        board[16][row] = 0;
        //18th row
        row++;
        board[1][row] = 0; board[3][row] = 0; board[5][row] = 0; board[6][row] = 0; board[7][row] = 0; board[8][row] = 0;
        board[10][row] = 0; board[12][row] = 0; board[14][row] = 0; board[15][row] = 0; board[16][row] = 0; board[17][row] = 0;
        board[18][row] = 0;
        //19th row
        row++;
        board[1][row] = 0; board[2][row] = 0; board[3][row] = 0; board[4][row] = 0; board[5][row] = 0; board[8][row] = 0;
        board[9][row] = 0; board[10][row] = 0; board[12][row] = 0; board[13][row] = 0; board[14][row] = 0; board[16][row] = 0;
        board[18][row] = 0;
    }
}
