package task2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Room room1 = new Room(5,2,3,1);
        Room room2 = new Room(3,0,1,8); //lolwut??
        Room room3 = new Room(4,1,4,2);

        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        Building building1 = new Building(rooms,1,2,false);
        System.out.println("Total number of lamps: "+(rooms.get(0).getNumberOfLamps()+rooms.get(1).getNumberOfLamps()+rooms.get(2).getNumberOfLamps()));

        if(building1.getNumberOfFloors() > rooms.size()){
            System.out.println("This is an odd building...");
        }else{
            System.out.println("This building is normal...-ish.");
        }
    }
}

//Week 41 - task 2
/*
Task 2: Composition

2.a Create a Room.java class with the following fields (use appropriate types):

    Walls.java (.java???)
    numberOfDoors
    numberOfLamps
    numberOfWindows

2.b Create a constructor that populates all the fields above.

2.c Create getters() for each of the fields above.

2.d Create a Building.java class with the following fields (use appropriate types):

    Rooms (make sure to use the 'final' keyword here .(Tess: - if you have ever heard about it. The code should work either way ;).
    numberOfBathrooms
    numberOfFloors
    isOfficeBuilding

2.e Create a constructor that populates all the fields above.

2.f Create getters() for each of the fields above.

2.g In your main method, instantiate at least three different rooms.

2.h Add the three rooms to a collection (preferably of the same data type used for the "Rooms" field in your Building.java class).

2.i In your main method, instantiate a new building.

2.j print the total number of lamps in the entire building.

2.k make an if statement that checks if numberOfFloors > number of Rooms. if true, then print "This is an odd building".
 */