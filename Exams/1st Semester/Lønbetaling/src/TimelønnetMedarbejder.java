public class TimelønnetMedarbejder implements Betaling{
    private double timeAntal;
    private double timeLøn;

    public TimelønnetMedarbejder(double timeAntal, double timeLøn) {
        this.timeAntal = timeAntal;
        this.timeLøn = timeLøn;
    }

    public double getTimeAntal() {
        return timeAntal;
    }

    public double getTimeLøn() {
        return timeLøn;
    }

    @Override
    public double beregnLøn() {
        return timeAntal * timeLøn;
    }
}
