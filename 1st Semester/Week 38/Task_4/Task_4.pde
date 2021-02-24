//Task 4 - Week 38
/*
For all exercises in Task 4, you are allowed to complete them with arrays of a fixed size. But do consider 
how the functions you write in 4.b, 4.c, 4.d, 4.e would work, if the array received as a parameter would not have a fixed length. 

4.a create arrays of the following type and assign it at least 3 different values: 
    - Integer array
    - String array
    - boolean array
    
4.b Write a function that takes in an array of strings as parameter and prints each string.

4.c Write a function that receives an integer array as a parameter and returns the sum of all elements in the array.

4.d Write a function that receives an integer array as a parameter and returns the average value.  

4.e Consider how you could write a function that takes in an integer array as a parameter and returns the array sorted from 
    lowest to highest value.
*/

//a: arrays
int[] intArray = {1,3,6};
String[] stringArray = {"one","three","six"};
boolean[] booleanArray = {true,false,false};

//b: example String array
String[] exampleStringArray = {"hello","I","am","an","example","array"};

//c & d: example int array
int[] exampleIntArray = {1,3,5,7,9,11,13,15};

//e: scrambled example int array
int[] scrambledIntArray = {3,11,59,25,33,6,0,76,44,52,99};


void setup(){
  //a: arrays:
  println("a: ");
  println(intArray);
  println(stringArray); //not sure what the vararg parameter problem means but the problem is avoided by printing each part of the array individually
  println(booleanArray);
  
  println(""); //spacer for the print lines to separate the various tasks
  
  //b: String array function
  println("b: ");
  bFunction(exampleStringArray);
  
  println(""); //spacer for the print lines to separate the various tasks
  
  //c: int array sum function
  println("C: ");
  println("Sum = "+cFunction(exampleIntArray));
  
  println(""); //spacer for the print lines to separate the various tasks
  
  //d: int array average function
  println("D: ");
  println("Average = "+dFunction(exampleIntArray));
  
  println(""); //spacer for the print lines to separate the various tasks
  
  //d: int array average function
  println("E: ");
  println("Sorted Array:");
  eFunction(scrambledIntArray);
}

void bFunction(String[] stringArray){
  for(int n = 0; n < stringArray.length; n++){
    println(stringArray[n]);
  }
}

int cFunction(int[] intArray){
  int sum = 0;
  for(int n = 0; n < intArray.length; n++){
    sum += intArray[n];
  }
  return sum;
}

int dFunction(int[] intArray){
  int sum = 0;
  for(int n = 0; n < intArray.length; n++){
    sum += intArray[n];
  }
  sum /= intArray.length;
  return sum;
}

void eFunction(int[] intArray){
  int[] sortedArray = sort(intArray); //sort() is a very useful bit of code :O!
  println(sortedArray);
}
