import java.util.ArrayList;

public class Garage {
    public ArrayList<Car> carsInGarage = new ArrayList<Car>();

    public void addGasolineCar(int regNum, String brand, String model, int year, int numberOfDoors, int octaneNum, double kmPerLitre){
        carsInGarage.add(new GasolineCar(regNum, brand, model, year, numberOfDoors, octaneNum, kmPerLitre));
    }

    public void addDieselCar(int regNum, String brand, String model, int year, int numberOfDoors, boolean hasParticleFilter, double kmPerLitre){
        carsInGarage.add(new DieselCar(regNum, brand, model, year, numberOfDoors, hasParticleFilter, kmPerLitre));
    }

    public void addElectricCar(int regNum, String brand, String model, int year, int numberOfDoors, int batteryCapacityKWh, int maxKm, double whPerKm){
        carsInGarage.add(new ElectricCar(regNum, brand, model, year, numberOfDoors, batteryCapacityKWh, maxKm, whPerKm));
    }

    @Override
    public String toString(){
        String printInfo = "";
        for (int n = 0; n < carsInGarage.size(); n++) {
            printInfo += "\nCar num: "+(n+1)+"\n"+carsInGarage.get(n).toString()+"\nTax: "+carsInGarage.get(n).calculateClimateTax()+" kr.\n";

        }
        return printInfo;
    }

    public double calculateTotalClimateTax(){
        double taxTotal = 0;
        for (int n = 0; n < carsInGarage.size(); n++) {
            taxTotal += carsInGarage.get(n).calculateClimateTax();
        }
        return taxTotal;
    }
}
/*
Der skal være en klasse der hedder Garage, som har en ArrayList der kan indeholde biler.
Garageklassen skal have et navn, samt en metode til at tilføje biler til bilparken.
Den skal override toString, sådan at den skriver alle de biler ud der holder i garagen.
Den skal også have en metode der hedder beregnGrønAfgiftForBilpark() der beregner den
samlede grønne afgift for alle bilerne i garagen.
 */