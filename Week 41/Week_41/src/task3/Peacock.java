package task3;

public class Peacock extends Animal{
    Peacock(int numberOfLegs) {
        super(numberOfLegs);
    }

    @Override
    public void makeSound() {
        System.out.println(name()+": Eeee Eeee Eeee Eeee!");
    }

    @Override
    public String name() {
        return "Peacock";
    }
}

/*
Create animals:

    You are to create 3 animals of your own choosing.
    Each animal must have their own class that extends the Animal class.
    The constructor of each of the animals must take in an int as a parameter (numberOfLegs) and call super(numberOfLegs) in its body.
    Two of the animals must @Override the makeSound method, printing a line with what the specific animal sounds like. e.g. ("Tiger goes grrrr");
    The last animal must not override the makeSound method.
 */