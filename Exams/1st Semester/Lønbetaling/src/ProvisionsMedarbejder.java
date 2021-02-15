public class ProvisionsMedarbejder implements Betaling{
    private double grundløn;
    private double salg;
    private double provision;

    public ProvisionsMedarbejder(double grundløn, double salg, double provision) {
        this.grundløn = grundløn;
        this.salg = salg;
        this.provision = provision;
    }

    public double getGrundløn() {
        return grundløn;
    }

    public double getSalg() {
        return salg;
    }

    public double getProvision() {
        return provision;
    }

    @Override
    public double beregnLøn() {
        return grundløn + (salg * (provision/100));
    }
}
