package task1;

public class Car {
    private String make;
    private String model;
    private int year;
    private String bodyStyle;
    private Driver carDriver;

    Car(String _make, String _model, int _year, String _bodyStyle){
        this.make = _make;
        this.model = _model;
        this.year = _year;
        this.bodyStyle = _bodyStyle;
    }

    public String getCarDriver(){
        return ""+carDriver;
    }

    public void setCarDriver(Driver _carDriver){
        this.carDriver = _carDriver;
    }

    public String printCar(){
        return "Make: "+this.make+", Model: "+this.model+" ("+this.year+"), BodyStyle: "+this.bodyStyle;
    }
}

/*
1.c Create a Car.java class with the following private fields (use appropriate types):

    Make
    Model
    Year
    BodyStyle
    Driver

1.d Create a constructor, that populates all the fields above, except the Driver.

1.e Create a Getter and a Setter for the Driver variable.

1.f override(create?) the toString method in the Car class, returning: "Make: "+make+". Model: "+model+ " ("+ year + "), BodyStyle: "+bodyStyle
 */