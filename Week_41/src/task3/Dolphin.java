package task3;

public class Dolphin extends Animal{

    Dolphin(int numberOfLegs) {
        super(numberOfLegs);
    }

    @Override
    public String name() {
        return "Dolphin";
    }
}

/*
Create animals:

    You are to create 3 animals of your own choosing.
    Each animal must have their own class that extends the Animal class.
    The constructor of each of the animals must take in an int as a parameter (numberOfLegs) and call super(numberOfLegs) in its body.
    Two of the animals must @Override the makeSound method, printing a line with what the specific animal sound like. e.g. ("Tiger goes grrrr");
    The last animal must not override the makeSound method.
 */