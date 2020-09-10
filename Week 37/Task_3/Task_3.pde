//Week 37 - Task 3:

//NF - Green Lights play in the background
//"~all i see are green lights~"
//https://www.youtube.com/watch?v=ocnuOcwHNaM

//Variables
  //colours
color bg = color(255);
color off = color(150);
color redLight = color(255,0,0);
color greenLight = color(0,255,0);

  //on-off-switch
boolean on = true;

void setup(){
 size(200,200); 
}

void draw(){
  //move 0,0 to center of screen
  translate(width/2,height/2);
  //background
  background(bg);
  //lights, /*camera, action*/! 
  strokeWeight(3);
  stroke(0);
  //if spacebar or a mouse button is pressed, then the light turns green
  if(keyPressed && key == ' ' || mousePressed){
    fill(off);
  }else{
    fill(redLight);
  }
  circle(0,-50,25);
  if(keyPressed && key == ' ' || mousePressed){
    fill(greenLight);
  }else{
    fill(off);
  }
  circle(0,50,25);
}
