package task2;

import java.util.ArrayList;

public class Building {
    private final ArrayList<Room> rooms = new ArrayList<Room>(3);
    private int numberOfBathrooms;
    private int numberOfFloors;
    private boolean isOfficeBuilding;

    public Building(ArrayList<Room> rooms, int numberOfBathrooms, int numberOfFloors, boolean isOfficeBuilding) {
        for (int n = 0; n < this.rooms.size(); n++) {
            this.rooms.add(rooms.get(n));
        }
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfFloors = numberOfFloors;
        this.isOfficeBuilding = isOfficeBuilding;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isOfficeBuilding() {
        return isOfficeBuilding;
    }
}

/*
2.d Create a Building.java class with the following fields (use appropriate types):

    Rooms (make sure to use the 'final' keyword here .(Tess: - if you have ever heard about it. The code should work either way ;).
    numberOfBathrooms
    numberOfFloors
    isOfficeBuilding

2.e Create a constructor that populates all the fields above.

2.f Create getters() for each of the fields above.
 */