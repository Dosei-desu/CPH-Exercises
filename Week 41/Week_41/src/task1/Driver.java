package task1;

public class Driver {
    private String name;
    private int age;

    Driver(String _name, int _age){
        this.name = _name;
        this.age = _age;
    }

    public String printName(){
        return ", is driven by "+this.name;
    }
}

/*
1.a Create a Driver.java class with the following private fields (use appropriate types):

    Name
    Age

1.b Create a constructor that populates all the fields above.

1.g override the toString method in the Driver class, returning: " is driven by "+name
 */