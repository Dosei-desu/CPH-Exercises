package task3;

public class Main {

    public static void main(String[] args) {
        Zoo myZoo = new Zoo();

        Peacock peacock = new Peacock(2);
        Elephant elephant = new Elephant(4);
        Dolphin dolphin = new Dolphin(0);

        myZoo.addAnimal(peacock);
        myZoo.addAnimal(elephant);
        myZoo.addAnimal(dolphin);

        myZoo.makeAllSounds();
        myZoo.printNumberOfLegs();
    }
}

//Week 41 - Task 3
/*
Task 3: Interfaces & Inheritance

Create an interface called AnimalSound.java - declare a method called "makeSound();" in it.

Create Animal.java

    give it a private field called numberOfLegs using an appropriate data type.
    add a constructor, that sets the above field.
    add a getter for the numberOfLegs field.
    have it implement the interface AnimalSound
    the makeSound() method must print the following: "Undefined animal makes no sound."

Create Zoo.java:

    - add a Collection of the type Animal called "animals", e.g. an ArrayList (make sure to initialize it).
    - add a method called makeAllSounds(). This must loop through all elements in the above collection and call the
    makeSound() on the element.
    - add a method called addAnimal() that takes in a new Animal as a parameter and adds it to the animals collection.
    - add a method called printNumberOfLegs() that loops through all elements in the animals collection and sums
    up the number of legs before printing ("Total number of legs in my zoo: "+legs);

Create animals:

    You are to create 3 animals of your own choosing.
    Each animal must have their own class that extends the Animal class.
    The constructor of each of the animals must take in an int as a parameter (numberOfLegs) and call super(numberOfLegs) in its body.
    Two of the animals must @Override the makeSound method, printing a line with what the specific animal sound like. e.g. ("Tiger goes grrrr");
    The last animal must not override the makeSound method.

In the Main.java:

    Create a new instance of Zoo
    Create instances of each of your 3 animals.
    Call the zoo.addAnimal() method with each of your 3 animal objects.
    Call the zoo.makeSounds() method.
    Call the zoo.printNumberOfLegs() method.

 */