package task3;

import java.util.ArrayList;

public class Zoo {
    ArrayList<Animal> animals = new ArrayList<Animal>();
    
    public void makeAllSounds(){
        for (int n = 0; n < animals.size(); n++) {
            animals.get(n).makeSound();
        }
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void printNumberOfLegs(){
        int legs = 0;
        for (int n = 0; n < animals.size(); n++) {
            legs += animals.get(n).getNumberOfLegs();
        }
        System.out.println("Total number of legs in my zoo: "+legs);
    }
}

/*
Create Zoo.java:

    - add a Collection of the type Animal called "animals", e.g. an ArrayList (make sure to initialize it).
    - add a method called makeAllSounds(). This must loop through all elements in the above collection and call the
    makeSound() on the element.
    - add a method called addAnimal() that takes in a new Animal as a parameter and adds it to the animals collection.
    - add a method called printNumberOfLegs() that loops through all elements in the animals collection and sums
    up the number of legs before printing ("Total number of legs in my zoo: "+legs);
 */