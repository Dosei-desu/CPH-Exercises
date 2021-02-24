//Task 5 - Week 38
/*
For this task you should reuse the Student class from Task 3. 
    Methods of reusing the class could be: 
    - copy the Students.pde file and open it in this sketch
    - copy the content of the students tab from Task 3 and create it once more in this sketch
    - Open the task 3 and continue working in this.
    Either method is fine - it is up to you. 
    
5.a Create an array of Students (the class created in Task 3) with 10 elements in it. Each student must have a unique name.

5.b Create a function that takes in the array from 5.a as a parameter as well as an integer. The function should return the 
    field "name" (the name of the student) and print it. Call this method with different parameters (only the integer - not the array) 
    from the setup() of Datamatik.

5.c Create a similar function to that of 5.b, but instead of receiving the array and an integer, it receives the array and a string. 
    Loop through all elements in the array until you find the element with the name received as a parameter. Then return the index of 
    that student. Call this method with different names from the setup() of Datamatik
*/

//a: array of students
Student[] students = new Student[10];

void setup(){
  //a: 10 uniquely-named array indexes (added the other stuff too so i didnt have to do it later)
  //it seems like you don't need anything but the names, but I kept the rest just because reasons...
  students[0] = new Student("Kris", 26, false, 'C');
  students[1] = new Student("Student A", 24, false, 'C');
  students[2] = new Student("Student B", 27, false, 'A');
  students[3] = new Student("Student C", 27, true, 'C');
  students[4] = new Student("Student D", 29, true, 'B');
  students[5] = new Student("Student E", 35, false, 'B');
  students[6] = new Student("Student F", 25, true, 'C');
  students[7] = new Student("Student G", 26, false, 'A');
  students[8] = new Student("Student H", 32, false, 'A');
  students[9] = new Student("Student I", 28, false, 'B');
  
  //b: 
  println("Student number 5:");
  bFunction(students,5); //not sure if I understand the problem properly, but ive made a function that takes in the Student array
                         //and student number on the list
  //different int parameter:
  println("Student number 1:");
  bFunction(students,1);
  
  //spacer
  println("");
  
  //c:
  //correct prints
  println("Student name: Kris");
  println("Student number: "+cFunction(students,"Kris"));
  println("Student name: Student F");
  println("Student number: "+cFunction(students,"Student F"));
  
  //incorrect name:
  println("Student name: Timmy");
  println("Student number: "+cFunction(students,"Timmy")); //when it returns -1, it means the student doesn't exist
}

void bFunction(Student[] studentArray, int studentNum){
    println("Student name: "+studentArray[studentNum-1].name);
}

int cFunction(Student[] studentArray, String studentName){
  for(int n = 0; n < studentArray.length; n++){
    if(studentArray[n].name == studentName){
      return n+1;
    }
  }
  return -1;
}
