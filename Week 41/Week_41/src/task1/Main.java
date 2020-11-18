package task1;

//deliberately used two of the worst cars in existence

public class Main {

    public static void main(String[] args) {
        Driver me = new Driver("Kris",26);
        Car car1 = new Car("GM","Pontiac Aztek",2001, "4-door SUV");
        car1.setCarDriver(me);
        System.out.println("Car One -- "+car1.printCar()+me.printName());

        Car car2 = new Car("Reliant","Reliant Robin",1973,"2½-door 3-wheel saloon with large opening rear window");
        car2.setCarDriver(me);
        System.out.println("\nCar Two -- "+car2.printCar()+me.printName());
    }
}

//Week 41 - Task 1
/*
Task 1: Aggregation

1.a Create a Driver.java class with the following private fields (use appropriate types):

    Name
    Age

1.b Create a constructor that populates all the fields above.

1.c Create a Car.java class with the following private fields (use appropriate types):

    Make
    Model
    Year
    BodyStyle
    Driver

1.d Create a constructor, that populates all the fields above, except the Driver.

1.e Create a Getter and a Setter for the Driver variable.

1.f override the toString method in the Car class, returning: "Make: "+make+". Model: "+model+ " ("+ year + "), BodyStyle: "+bodyStyle

1.g override the toString method in the Driver class, returning: " is driven by "+name

1.h In the main method, instantiate a new Driver, populating the fields with your own name and age.

1.i In the main method, instantiate a new car, populating the field with whatever values you see fit.

1.j In the main method, assign the driver to the car created, using the setter method created in step 1.e

1.k print the toString method of the car you've created followed by the toString method of the driver.

1.l In the main method, create yet another car and assign the same driver to this car.

1.m repeat the step 1.k for the new car created in 1.l.
*/