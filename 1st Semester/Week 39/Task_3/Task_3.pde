//Task 3 - Week 39

/*
3.a Sort the array:
int[] myArray = { 1, 6423, 64, 6, 3, 123, 61, 6, 36, 1236, 347, 3, 1326, 246, 4 }; by importing java.util.Arrays 
and use the Arrays.sort() method on it. Then use the printArray() method to print it.
*/

import java.util.Arrays;

int[] myArray = { 1, 6423, 64, 6, 3, 123, 61, 6, 36, 1236, 347, 3, 1326, 246, 4 };

void setup(){
  myArray = sort(myArray);
  println(myArray);
}
