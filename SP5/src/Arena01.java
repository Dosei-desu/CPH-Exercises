import processing.core.PApplet;

import java.util.Arrays;

public class Arena01 extends PApplet { //has to also extend the processing app
    private final PApplet sketch; //not currently in use, but required to access processing library
    private Puck puck;
    private Puck[] ghosts = new Puck[4];
    private final int w = 20, h = 23;
    private int[][] board;
    private int previousX, previousY;
    private final int[] ghostPreviousX = new int[ghosts.length],
                        ghostPreviousY = new int[ghosts.length],
                        previousBoardValue = new int[ghosts.length];
    private int[] moveCounter = {0,0,0,0};

    Arena01(PApplet sketch, Puck puck){
        this.sketch = sketch; //necessary to define what sketch is being used, without this, the class would require
                              //a draw, setup, settings, and so on
        this.puck = puck;
        board = new int[w][h];

        this.ghosts[0] = new Puck(9,12);
        this.ghosts[1] = new Puck(10,12);
        this.ghosts[2] = new Puck(9,13);
        this.ghosts[3] = new Puck(10,13);
        for (int i = 0; i < previousBoardValue.length; i++) {
            previousBoardValue[i] = 0;
        }
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

    private void updateBoard(){
        //player coordinates
        board[previousX][previousY] = 2; //eats pellet
        previousX = puck.getX();
        previousY = puck.getY();
        board[puck.getX()][puck.getY()] = 1;
        for (int i = 0; i < ghosts.length; i++) {
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
        //a different kind of spin, more akin to games like SuperHot, where enemies only move when you do
        //ghost one
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
            if(num == moveCounter[0]){ ghosts[0].moveY(1); }

            if(moveCounter[0] > 32 * ghostSpeed){
                moveCounter[0] = 4*ghostSpeed;
            }

            moveCounter[0]++;
        }
        //ghost two
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
            if(num == moveCounter[1]){ ghosts[1].moveX(-1); }

            if(moveCounter[1] > 32 * ghostSpeed){
                moveCounter[1] = 4*ghostSpeed;
            }

            moveCounter[1]++;
        }
        //ghost three
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
            if(num == moveCounter[2]){ ghosts[2].moveX(1); } num += ghostSpeed;

            if(moveCounter[2] > 41*ghostSpeed){
                moveCounter[2] = 13*ghostSpeed;
            }

            moveCounter[2]++;
        }
        //ghost four
        if(sketch.keyPressed) {
            int num = 0;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;
            if(num == moveCounter[3]){ ghosts[3].moveY(-1); } num += ghostSpeed;

            if(moveCounter[3] > 41*ghostSpeed){
                moveCounter[3] = 13*ghostSpeed;
            }

            moveCounter[3]++;
        }
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
        board[3][row] = 0; board[5][row] = 0; board[8][row] = 2; board[9][row] = 2; board[10][row] = 2; board[11][row] = 2;
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
