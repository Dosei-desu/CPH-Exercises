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
  
  x = -5; y = 40; z = -5;
  if(x+y+z == 30 && check(x) && check(y) && z % 10 != 0 ){
    println("6b - Success!");
  }else{
    println("6b - Failure!");
  }
}

boolean check(int n){ //makes it so you can test for negatives, which isn't
                      //possible with % modulus
  return n != 10 && n != 20 && n != 30;
}
