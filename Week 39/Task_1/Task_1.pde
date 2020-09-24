//Week 39 - Task One

/*
- 1.a Create an integer array with the values { 8, 9, 1, 5, 11, 13, 7, 4, 6, 3, 12, 10, 2 } 

- 1.b implement your own sorting algorithm for the int[] array, by creating a method that takes in the int[] array and 
loops through it with a for loop. for every step in the for loop, you must compare the values of array[i] and array[i + 1] 
and swap them if [i] is greater than [i + 1]. 

- 1.c call the method created in 1.b in a while loop from setup(), until the list is sorted. 

- 1.d Add a boolean to keep track of when the list is sorted to avoid creating an infinite loop.
*/

int[] intArray = {8, 9, 1, 5, 11, 13, 7, 4, 6, 3, 12, 10, 2};

void setup(){
  int n = 0;
  while(n < intArray.length){
    sortingMachine(intArray);
    n++;
  }
  println(intArray);
}

void sortingMachine(int[] _array){
  boolean isSorted = false;
  if(!isSorted){
    for(int i = 1; i < _array.length; i++){
      if(_array[i-1] > _array[i]){
        int temp = _array[i-1];
        _array[i-1] = _array[i];
        _array[i] = temp;
      }else{
        isSorted = true;
      }
    }
  }
}
