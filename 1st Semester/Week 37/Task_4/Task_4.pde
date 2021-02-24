//Week 37 - Task 4:

//loop(loop(loop(loop(loop(loop(loop...

void setup(){
  //task a
  for(int n1 = 0; n1 < 21; ++n1){
    println("a = "+n1);
  }
  //b
  for(int n2 = 0; n2 <= 20; ++n2){
    if(n2 % 2 == 0 && n2 != 0){
    println("b = "+n2);
    }
  }
  //c
  int n3 = 0;
  while (n3 <= 20){
    if(n3 % 2 == 0 && n3 != 0){
      println("c = "+n3);
    }
    ++n3;
  }
}
