/**
 * "Lønberegning"
 * Kristoffer Pauly
 * 05-01-2021
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Time-based-salary Employees:\n");

        TimelønnetMedarbejder john = new TimelønnetMedarbejder(80,135);

        System.out.println("John works "+john.getTimeAntal()+" hours a month at a wage of "+john.getTimeLøn()+" kr.");
        System.out.println("John's monthly salary is: "+john.beregnLøn()+" kr.\n");

        TimelønnetMedarbejder bobbenheimer = new TimelønnetMedarbejder(125.5,183.5);
        System.out.println("Bobbenheimer works "+bobbenheimer.getTimeAntal()+" hours a month at a wage of "+bobbenheimer.getTimeLøn()+" kr.");
        System.out.println("Bobbenheimer's monthly salary is: "+bobbenheimer.beregnLøn()+" kr.\n");


        System.out.println("\nProvision-based-salary Employees:\n");

        ProvisionsMedarbejder anders = new ProvisionsMedarbejder(15000,12500,22.3);
        System.out.println("Anders earns a monthly base salary of "+anders.getGrundløn()+" kr. and gets a "+anders.getProvision()+" % on sales.");
        System.out.println("This month Anders made sales that totalled "+anders.getSalg()+" kr.");
        System.out.println("Anders' monthly salary is: "+anders.beregnLøn()+" kr.\n");

        ProvisionsMedarbejder dennis = new ProvisionsMedarbejder(22350,22735,17.5);
        System.out.println("Dennis earns a monthly base salary of "+dennis.getGrundløn()+" kr. and gets a "+dennis.getProvision()+" % on sales.");
        System.out.println("This month Dennis made sales that totalled "+dennis.getSalg()+" kr.");
        System.out.println("Dennis' monthly salary is: "+dennis.beregnLøn()+" kr.");
    }
}
