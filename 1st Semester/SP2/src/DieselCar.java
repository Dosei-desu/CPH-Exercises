public class DieselCar extends Car {
    private boolean hasParticleFilter;
    private double kmPerLitre;

    protected DieselCar(int regNum, String brand, String model, int year, int numberOfDoors, boolean hasParticleFilter, double kmPerLitre) {
        super(regNum, brand, model, year, numberOfDoors);
        this.hasParticleFilter = hasParticleFilter;
        this.kmPerLitre = kmPerLitre;
    }

    public boolean isHasParticleFilter() {
        return hasParticleFilter;
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
               "\nParticle Filter: "+this.hasParticleFilter+
               "\nKm Per Litre: "+this.kmPerLitre;
    }

    @Override
    public double calculateClimateTax() {
        double tax = 0;
        if(!this.hasParticleFilter){
            tax += 1000;
        }
        if(this.kmPerLitre < 50 && this.kmPerLitre >= 20){
            tax += 330+130;
        }else if(this.kmPerLitre < 20 && this.kmPerLitre >= 15){
            tax += 1050+1390;
        }else if(this.kmPerLitre < 15 && this.kmPerLitre >= 10){
            tax += 2340+1850;
        }else if(this.kmPerLitre < 10 && this.kmPerLitre >= 5){
            tax += 5500+2770;
        }else if (this.kmPerLitre < 5){
            tax += 10470+15260;
        }
        return tax;
    }
    /*
    3.	For en Dieselbil er der samme afgift som for benzinbilen, plus en udligningsafgift, som også afhængig af kmPrL.
    Hvis den er mellem 20 og 50 er udligningsafgiften 130 kr, mellem 15 og 20 er den 1390 kr, mellem 10 og 15 er den
    1850 kr, mellem 5 og 10 er den 2770 kr,  og under 5 er den 15260 kr. Der er desuden en partikeludledningsafgift på
    1000 kr hvis bilen ikke har partikelfilter monteret.
     */
}
