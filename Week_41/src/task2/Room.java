package task2;

public class Room {
    private int walls;
    private int numberOfDoors;
    private int numberOfLamps;
    private int numberOfWindows;

    public Room(int walls, int numberOfDoors, int numberOfLamps, int numberOfWindows) {
        this.walls = walls;
        this.numberOfDoors = numberOfDoors;
        this.numberOfLamps = numberOfLamps;
        this.numberOfWindows = numberOfWindows;
    }

    public int getWalls() {
        return walls;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public int getNumberOfLamps() {
        return numberOfLamps;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }
}

/*
2.a Create a Room.java class with the following fields (use appropriate types):

    Walls.java (.java???)
    numberOfDoors
    numberOfLamps
    numberOfWindows

2.b Create a constructor that populates all the fields above.

2.c Create getters() for each of the fields above.
 */