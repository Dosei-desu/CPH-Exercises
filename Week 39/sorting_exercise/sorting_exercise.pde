//sorting exercise

int[] numbers = {5,3,8,4,6,53,88,0,12,75,3,8,-2,19,99,-6};
int temp;

void setup(){
  size(800,800);
  frameRate(30);
}

void draw(){
  translate(0,height/2-25);
  background(255);
  
  for(int n = 0; n < numbers.length; n++){
    fill(255-5*n,255-10*n,0);
    strokeWeight(2);
    stroke(0);
    rect(n*50,0,50,50); //remember default rectMode is CORNER i.e: rect(x,y,width,height); !!
    fill(0);
    textSize(25);
    textAlign(CENTER, BOTTOM);
    text(numbers[n],25+50*n,50);
  }
}

void mouseClicked(){
  if(mouseButton == LEFT){
    for(int n = 1; n < numbers.length; n++){
      if(numbers[n-1] > numbers[n]){
        temp = numbers[n-1];
        numbers[n-1] = numbers[n];
        numbers[n] = temp;
      }
    }
  }
  if(mouseButton == RIGHT){
    for(int n = 1; n < numbers.length; n++){
      if(numbers[n-1] < numbers[n]){
        temp = numbers[n-1];
        numbers[n-1] = numbers[n];
        numbers[n] = temp;
      }
    }
  }
}
