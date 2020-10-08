package task3;

public class Animal implements AnimalSound{
    private int numberOfLegs;

    Animal(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public void makeSound() {
        System.out.println(name()+": Undefined animal makes no sound.");
    }

    @Override
    public String name() {
        return "Unnamed";
    }
}

/*
Create Animal.java

    give it a private field called numberOfLegs using an appropriate data type.
    add a constructor, that sets the above field.
    add a getter for the numberOfLegs field.
    have it implement the interface AnimalSound
    the makeSound() method must print the following: "Undefined animal makes no sound."
 */