//Task 4 - Week 39

/*
- 4.a Write a method that takes in an integer as a parameter and prints all values between 0 and 100 that are divisible 
by the parameter received.

- 4.b add the following array to your code: int[] arr = { 1, 1, 1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 6, 6, 7, 8, 8, 9, 9, 10 }

- 4.c Write a method that returns a random element from the above array.

- 4.d Write a function that takes an integer as a parameter and prints the number. After that, it subtracts one from the 
input and calls itself again (recursion). If the input is less than zero, it should no longer call itself.

- 4.e Write a function that takes two integers as parameters and prints both of them seperated by a tab ( \t ). Then have 
the function calculate and print the fibunacci sequence by calling itself. If the input is greater than 10000, then stop. 
Start the function by calling it from setup with the input (1, 1). 
(hint: fibunacci sequence: https://i.pinimg.com/236x/98/82/d5/9882d569f7e0b5665fe3b2edd5069b06.jpg )
*/

//b:
int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 6, 6, 7, 8, 8, 9, 9, 10};

void setup(){
  //E:
  println("Function A:");
  aFunction(4);
  
  println(""); //spacer
  
  //C:
  println("Function C:");
  println(cFunction(arr));
  
  println(""); //spacer
  
  //D:
  println("Function D:");
  dFunction(9);
  
  println(""); //spacer
  
  //E: (can't make it work, and the tutors left)
  println("Function E:");
  eFunction(1,1); //got help from Jens (@JPfroosh)
}

void aFunction(int _input){
  for(int n = 1; n < 100; n++){
    if(n % _input == 0){
      println(n);
    }
  }
}

int cFunction(int[] _array){
  return (int)random(_array[0],_array[_array.length-1]);
}

int dFunction(int _input){
  if(_input == 0) return 0;
  println(_input);
  return dFunction(_input-1);
}

int eFunction(int n1, int n2){ //got help from Jens (@JPfroosh)
  println(n1+"\t"+n2);
  if(n1 > 10000 || n2 > 10000) return 0;
  return eFunction(n2,n1+n2); 
}
