import processing.core.PApplet;

public class Arena01 extends PApplet { //has to also extend the processing app
    private PApplet sketch;
    private float x, y;

    Arena01(PApplet sketch, float x, float y){
        this.sketch = sketch; //necessary to define what sketch is being used, without this, the class would require
                              //a draw, setup, settings, and so on
        this.x = x;
        this.y = y;
    }

    public void render(){ //8x8 cells each 80x80 pixels, with the player taking up 40x40 roughly
        //formatting
        sketch.noFill();
        sketch.stroke(250,50,50);
        sketch.strokeWeight(4);
        //perimeter
        sketch.line(x-320,y-270,x+320,y-270);
        sketch.beginShape();
        sketch.vertex(x-320,y+5);
        sketch.vertex(x-200,y+5);
        sketch.vertex(x-200,y-75);
        sketch.vertex(x-310,y-75);
        sketch.vertex(x-310,y-260);
        sketch.vertex(x-10,y-260);
        sketch.vertex(x-10,y-180);
        sketch.vertex(x+10,y-180);
        sketch.vertex(x+10,y-260);
        sketch.vertex(x+310,y-260);
        sketch.vertex(x+310,y-75);
        sketch.vertex(x+200,y-75);
        sketch.vertex(x+200,y+5);
        sketch.vertex(x+320,y+5);
        sketch.vertex(x+320,y+50);
        sketch.vertex(x+200,y+50);
        sketch.vertex(x+200,y+130);
        sketch.vertex(x+310,y+130);
        sketch.vertex(x+310,y+235);
        sketch.vertex(x+265,y+235);
        sketch.vertex(x+265,y+255);
        sketch.vertex(x+310,y+255);
        sketch.vertex(x+310,y+360);
        sketch.vertex(x-310,y+360);
        sketch.vertex(x-310,y+255);
        sketch.vertex(x-265,y+255);
        sketch.vertex(x-265,y+235);
        sketch.vertex(x-310,y+235);
        sketch.vertex(x-310,y+130);
        sketch.vertex(x-200,y+130);
        sketch.vertex(x-200,y+50);
        sketch.vertex(x-320,y+50);
        sketch.endShape(CLOSE);
        //top half
            //top row
                //box 1
        sketch.beginShape();
        sketch.vertex(x-260,y-220);
        sketch.vertex(x-200,y-220);
        sketch.vertex(x-200,y-180);
        sketch.vertex(x-260,y-180);
        sketch.endShape(CLOSE);
                //box 2
        sketch.beginShape();
        sketch.vertex(x-145,y-220);
        sketch.vertex(x-60,y-220);
        sketch.vertex(x-60,y-180);
        sketch.vertex(x-145,y-180);
        sketch.endShape(CLOSE);
                //box 3
        sketch.beginShape();
        sketch.vertex(x+145,y-220);
        sketch.vertex(x+60,y-220);
        sketch.vertex(x+60,y-180);
        sketch.vertex(x+145,y-180);
        sketch.endShape(CLOSE);
                //box 4
        sketch.beginShape();
        sketch.vertex(x+260,y-220);
        sketch.vertex(x+200,y-220);
        sketch.vertex(x+200,y-180);
        sketch.vertex(x+260,y-180);
        sketch.endShape(CLOSE);
            //second row
                //box 1
        sketch.beginShape();
        sketch.vertex(x-260,y-135);
        sketch.vertex(x-200,y-135);
        sketch.vertex(x-200,y-115);
        sketch.vertex(x-260,y-115);
        sketch.endShape(CLOSE);
                //t-shape 1
        sketch.beginShape();
        sketch.vertex(x-145,y-135);
        sketch.vertex(x-125,y-135);
        sketch.vertex(x-125,y-75);
        sketch.vertex(x-60,y-75);
        sketch.vertex(x-60,y-55);
        sketch.vertex(x-125,y-55);
        sketch.vertex(x-125,y+5);
        sketch.vertex(x-145,y+5);
        sketch.endShape(CLOSE);
                //t-shape 2
        sketch.beginShape();
        sketch.vertex(x-75,y-135);
        sketch.vertex(x+75,y-135);
        sketch.vertex(x+75,y-115);
        sketch.vertex(x+10,y-115);
        sketch.vertex(x+10,y-55);
        sketch.vertex(x-10,y-55);
        sketch.vertex(x-10,y-115);
        sketch.vertex(x-75,y-115);
        sketch.endShape(CLOSE);
                //t-shape 3
        sketch.beginShape();
        sketch.vertex(x+145,y-135);
        sketch.vertex(x+125,y-135);
        sketch.vertex(x+125,y-75);
        sketch.vertex(x+60,y-75);
        sketch.vertex(x+60,y-55);
        sketch.vertex(x+125,y-55);
        sketch.vertex(x+125,y+5);
        sketch.vertex(x+145,y+5);
        sketch.endShape(CLOSE);
                //box 1
        sketch.beginShape();
        sketch.vertex(x+260,y-135);
        sketch.vertex(x+200,y-135);
        sketch.vertex(x+200,y-115);
        sketch.vertex(x+260,y-115);
        sketch.endShape(CLOSE);
            //middle box
        sketch.beginShape();
        sketch.vertex(x-80,y-10);
        sketch.vertex(x+75,y-10);
        sketch.vertex(x+75,y+70);
        sketch.vertex(x-80,y+70);
        sketch.endShape(CLOSE);
        sketch.stroke(0);
        sketch.strokeWeight(6);
        sketch.line(x-20,y-10,x+20,y-10);
        sketch.strokeWeight(4);
        sketch.stroke(250,50,50);
            //third row
                //box 1
        sketch.beginShape();
        sketch.vertex(x-145,y+50);
        sketch.vertex(x-125,y+50);
        sketch.vertex(x-125,y+130);
        sketch.vertex(x-145,y+130);
        sketch.endShape(CLOSE);
                //t-shape 1
        sketch.beginShape();
        sketch.vertex(x-75,y+110);
        sketch.vertex(x+75,y+110);
        sketch.vertex(x+75,y+130);
        sketch.vertex(x+10,y+130);
        sketch.vertex(x+10,y+195);
        sketch.vertex(x-10,y+195);
        sketch.vertex(x-10,y+130);
        sketch.vertex(x-75,y+130);
        sketch.endShape(CLOSE);
                //box 2
        sketch.beginShape();
        sketch.vertex(x+145,y+50);
        sketch.vertex(x+125,y+50);
        sketch.vertex(x+125,y+130);
        sketch.vertex(x+145,y+130);
        sketch.endShape(CLOSE);
            //fourth row
                //l-shape 1
        sketch.beginShape();
        sketch.vertex(x-260,y+175);
        sketch.vertex(x-200,y+175);
        sketch.vertex(x-200,y+255);
        sketch.vertex(x-220,y+255);
        sketch.vertex(x-220,y+195);
        sketch.vertex(x-260,y+195);
        sketch.endShape(CLOSE);
                //box 1
        sketch.beginShape();
        sketch.vertex(x-145,y+175);
        sketch.vertex(x-60,y+175);
        sketch.vertex(x-60,y+195);
        sketch.vertex(x-145,y+195);
        sketch.endShape(CLOSE);
                //box 2
        sketch.beginShape();
        sketch.vertex(x+145,y+175);
        sketch.vertex(x+60,y+175);
        sketch.vertex(x+60,y+195);
        sketch.vertex(x+145,y+195);
        sketch.endShape(CLOSE);
                //l-shape 2
        sketch.beginShape();
        sketch.vertex(x+260,y+175);
        sketch.vertex(x+200,y+175);
        sketch.vertex(x+200,y+255);
        sketch.vertex(x+220,y+255);
        sketch.vertex(x+220,y+195);
        sketch.vertex(x+260,y+195);
        sketch.endShape(CLOSE);
            //bottom row
                //t-shape 1
        sketch.beginShape();
        sketch.vertex(x-260,y+300);
        sketch.vertex(x-145,y+300);
        sketch.vertex(x-145,y+235);
        sketch.vertex(x-125,y+235);
        sketch.vertex(x-125,y+300);
        sketch.vertex(x-60,y+300);
        sketch.vertex(x-60,y+320);
        sketch.vertex(x-260,y+320);
        sketch.endShape(CLOSE);
                //t-shape 2
        sketch.beginShape();
        sketch.vertex(x-75,y+235);
        sketch.vertex(x+75,y+235);
        sketch.vertex(x+75,y+255);
        sketch.vertex(x+10,y+255);
        sketch.vertex(x+10,y+320);
        sketch.vertex(x-10,y+320);
        sketch.vertex(x-10,y+255);
        sketch.vertex(x-75,y+255);
        sketch.endShape(CLOSE);
                //t-shape 3
        sketch.beginShape();
        sketch.vertex(x+260,y+300);
        sketch.vertex(x+145,y+300);
        sketch.vertex(x+145,y+235);
        sketch.vertex(x+125,y+235);
        sketch.vertex(x+125,y+300);
        sketch.vertex(x+60,y+300);
        sketch.vertex(x+60,y+320);
        sketch.vertex(x+260,y+320);
        sketch.endShape(CLOSE);
    }
}
