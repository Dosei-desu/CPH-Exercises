//Task 1 - Week 38
/*
1.a Write a function that prints an empty line and call it from setup();

1.b Write a function that receives a string as a parameter and prints it. call this function from setup()

1.c Write a function that receives a string called "name" and an integer called "age" and call it from setup with your own name and age. 
    Have the function print the text "My name is \<name\>, I am <age> years old".
*/

String a = "";

void setup(){
  aFunction();
  bFunction("random text");
  cFunction("Kris",26);
}

void aFunction(){
  println("a - "+"");
}

void bFunction(String text){
  println("b - "+text);
}

void cFunction(String name, int age){
  println("c - "+"Hi, my name is "+name+", I am "+age+" years old.");
}
