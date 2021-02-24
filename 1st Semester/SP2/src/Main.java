public class Main {

    public static void main(String[] args) {
        Garage carGarage = new Garage();

        carGarage.addGasolineCar(666,"Lada","2107-71",1982,2,666,9.5);
        carGarage.addGasolineCar(02,"Generic","MuscleCar",2012,3,9001,21.2);
        carGarage.addDieselCar(103513,"GM","Oldsmobile Cutlass Supreme",1969,3,false,10);
        carGarage.addDieselCar(1337,"Futuristic","Johnny the Sentient Diesel Car",3093,17,true,77);
        carGarage.addElectricCar(80085,"Tesla","Model S",2016,3,100,647,215);
        carGarage.addElectricCar(-1,"CR4P","TR4P",-150,0,6,3,20000);

        //print car info
        System.out.println(carGarage.toString());

        //print total tax cost of all cars combined
        System.out.println("Total Tax Cost of all cars in the garage:\n"+carGarage.calculateTotalClimateTax()+" kr.");
    }
}
