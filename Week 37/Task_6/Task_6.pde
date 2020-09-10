//Week 37 - Task 6:

//variables
  //6.a
int a, b;
  //6.b
int x, y, z;

void setup(){
  a = 10; b = 6;
  if(a == 10 || b == 10 || a+b == 10){
    println("6a - Success!");
  }else{
    println("6a - Failure!");
  }
  x = 5; y = 15; z = 10;
  if(x+y+z == 30 && x % 10 != 0 && y % 10 != 0 && z % 10 != 0 ){
    println("6b - Success!");
  }else{
    println("6b - Failure!");
  }
}
