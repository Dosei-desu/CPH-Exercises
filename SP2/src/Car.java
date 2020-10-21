public abstract class Car {
    protected int regNum;
    protected String brand;
    protected String model;
    protected int year;
    protected int numberOfDoors;

    protected Car(int regNum, String brand, String model, int year, int numberOfDoors) {
        this.regNum = regNum;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.numberOfDoors = numberOfDoors;
    }


    protected int getRegNum() {
        return regNum;
    }

    protected String getBrand() {
        return brand;
    }

    protected String getModel() {
        return model;
    }

    protected int getYear() {
        return year;
    }

    protected int getNumberOfDoors() {
        return numberOfDoors;
    }

    protected abstract double calculateClimateTax();
}
