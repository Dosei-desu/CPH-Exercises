public class GasolineCar extends Car {
    private int octaneNum;
    private double kmPerLitre;

    protected GasolineCar(int regNum, String brand, String model, int year, int numberOfDoors, int octaneNum, double kmPerLitre) {
        super(regNum, brand, model, year, numberOfDoors);
        this.octaneNum = octaneNum;
        this.kmPerLitre = kmPerLitre;
    }

    public int getOctaneNum() {
        return octaneNum;
    }

    public double getKmPerLitre() {
        return kmPerLitre;
    }

    @Override
    public String toString(){
        return "Registration num: "+this.regNum+
               "\nBrand: "+this.brand+
               "\nModel: "+this.model+
               "\nYear: "+this.year+
               "\nNumber of Doors: "+this.numberOfDoors+
               "\nOctane Num: "+this.octaneNum+
               "\nKm Per Litre: "+this.kmPerLitre;
    }

    @Override
    public double calculateClimateTax() {
        double tax = 0;
        if(this.kmPerLitre < 50 && this.kmPerLitre >= 20){
            tax += 330;
        }else if(this.kmPerLitre < 20 && this.kmPerLitre >= 15){
            tax += 1050;
        }else if(this.kmPerLitre < 15 && this.kmPerLitre >= 10){
            tax += 2340;
        }else if(this.kmPerLitre < 10 && this.kmPerLitre >= 5){
            tax += 5500;
        }else if (this.kmPerLitre < 5){
            tax += 10470;
        }
        return tax;
    }
    /*
    For en Benzinbil er afgiften afhængig af kmPrL. Hvis den er mellem 20 og 50 er den 330 kr, mellem 15 og 20 er
    den 1050 kr, mellem 10 og 15 er den 2340 kr, mellem 5 og 10 er den 5500 kr,  og under 5 er den 10470 kr.
     */
}
