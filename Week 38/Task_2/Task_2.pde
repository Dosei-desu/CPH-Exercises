//Task 2 - Week 38
/*
2.a Look at the file TaskTwoA and fill out the missing line, using the happy boolean. 

2.b Write a function that receives to integers as parameters and returns the sum of them.

2.c Write a function that receives a string and returns it as uppercase. (Hint: ".toUpperCase()". 
    Further hint: https://www.w3schools.com/jsref/jsref_toUpperCase.asp )

2.d Write a function that receives a string and returns true if the first letter of the string is uppercase. 
    (Hints: ".charAt(0)" and "Character.isUpperCase('a');" )
*/

boolean happy = true;

void setup() {
   if (iAmHappy())
   {
     println("a - "+"I clap my hands");
   }
   else
   {
     println("a - "+"I don't clap my hands"); 
   }
   
   println("b - "+bFunction(1,2));
   
   println("c - "+cFunction("all lower case"));
   
   println("d - "+dFunction("Capitalisation"));
}


boolean iAmHappy()
{
  // fill out what is missing here: 
  return happy;
}

int bFunction(int a, int b){
  int sum = a + b;
  return sum;
}

String cFunction(String text){
  return text.toUpperCase();
}

boolean dFunction(String text){
  char firstLetter = text.charAt(0);
  if(Character.isUpperCase(firstLetter)){
    return true;
  }
  return false;
}
