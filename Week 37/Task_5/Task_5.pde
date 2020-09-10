//Week 37 - Task 5:

void setup() {
  MethodOne(10); 
  MethodOne(666); //checking to see if it calculates properly
  MethodOne(1001); //^-------------------^
  MethodTwo(0); //monday check
  MethodTwo(5); //saturday check
  MethodTwo(2);
}


/*
  The following method has an error in it. Fix the error and run it. 
*/

void MethodOne(int max) //moved Max up here so that it can be parsed in
{
  int i = 1000; // You are not allowed to change this line. 
  
  if (i > max)
  {
    String output = "i is greater than "+max+".";  
    println(output);
  }else{
    String output = "i is not greater than "+max+".";  
    println(output);
  }
  
  //the problem was that the "println(output);" outside the if(); couldn't
  //reach the output String
}

/* 
  Finish the following method so that we can change the number assigned 
  to the weekday and it prints the correct output.  
*/
void MethodTwo(int weekDay) 
{
  //int weekDay = 0; // 0 = Monday, 6 = Sunday. 
  boolean weekend = false;
  
  if (weekDay < 5)
  {
    weekend = false;
  }
  else 
  {
    weekend = true;
  }

  // Print the name of the weekday here: 
  if(weekDay == 0){ println("Today is: Monday"); }
  if(weekDay == 1){ println("Today is: Tuesday"); }
  if(weekDay == 2){ println("Today is: Wednesday"); }
  if(weekDay == 3){ println("Today is: Thursday"); }
  if(weekDay == 4){ println("Today is: Friday"); }
  if(weekDay == 5){ println("Today is: Saturday"); }
  if(weekDay == 6){ println("Today is:Sunday"); }

  // Print if it is weekend here:
  if(weekend){
    println("It is weekend!");
  }else{ 
    println("It is not weekend...");
  }
}
