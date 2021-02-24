//Week 37 - Task 7:

//variables
int input;


void setup(){
  input = -20;
  //using Math.abs to turn the number into a positive number so that it
  //works with -20 as well as 20
  for(int n = 0; n <= Math.abs(input); ++n){
    if(n == Math.abs(input/2)){
      println("HALF!");
    }else if(n == 6){
      println("six");
    }else if(Math.abs(input) != input){ //makes it able to handle negatives
      println(n*-1); //turns n into a negative without interfering with the loop
    }else{
      println(n);
    }
  }
  //using an int for "Input" instead of a float, means that all uneven numbers
  //don't really work properly with this.
}
