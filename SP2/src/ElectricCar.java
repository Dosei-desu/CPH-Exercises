public class ElectricCar extends Car{
    private int batteryCapacityKWh;
    private int maxKm;
    private double whPerKm;

    protected ElectricCar(int regNum, String brand, String model, int year, int numberOfDoors, int batteryCapacityKWh, int maxKm, double whPerKm) {
        super(regNum, brand, model, year, numberOfDoors);
        this.batteryCapacityKWh = batteryCapacityKWh;
        this.maxKm = maxKm;
        this.whPerKm = whPerKm;
    }

    public int getBatteryCapacityKWh() {
        return batteryCapacityKWh;
    }

    public int getMaxKm() {
        return maxKm;
    }

    public double getWhPerKm() {
        return whPerKm;
    }

    @Override
    public String toString(){
        return "Registration num: "+this.regNum+
               "\nBrand: "+this.brand+
               "\nModel: "+this.model+
               "\nYear: "+this.year+
               "\nNumber of Doors: "+this.numberOfDoors+
               "\nBattery Capacity in KWh: "+this.batteryCapacityKWh+
               "\nMaximum Km Distance: "+this.maxKm+
               "\nWh Per Km: "+this.whPerKm;
    }

    @Override
    public double calculateClimateTax() {
        double tax = 0;
        double convertedKwhToKm = 100/(this.whPerKm / 91.25);

        if(convertedKwhToKm < 50 && convertedKwhToKm >= 20){
            tax += 330;
        }else if(convertedKwhToKm < 20 && convertedKwhToKm >= 15){
            tax += 1050;
        }else if(convertedKwhToKm < 15 && convertedKwhToKm >= 10){
            tax += 2340;
        }else if(convertedKwhToKm < 10 && convertedKwhToKm >= 5){
            tax += 5500;
        }else if (convertedKwhToKm < 5){
            tax += 10470;
        }
        return tax;
    }
    /*
    For en Elbil gælder de samme regler som for benzinbilen, blot skal man først omregne whPrKm til kmPrL.
    Det gøres ved at dividere whPrKm med 91,25 og dernæst dividere 100 med dette tal. Se evt. formlen her:
    https://fdm.dk/alt-om-biler/dine-rettigheder/boder-afgifter/ejerafgift-elbil.
     */
}
