import Models.Pizza;

import java.util.Scanner;

public class Control {
    Console console;
    Scanner input;

    Control(){
        console = new Console();
        input = new Scanner(System.in);
    }

    public void run(){
        boolean stop = false;

        System.out.println("Database Interface In Yo Face... Ace... Space... Maze... Haze.......\nPick an option below:");
        System.out.println("1 -- Select All\n2 -- Select Single\n3 -- Update Single\n4 -- Create Pizza");

        int num = input.nextInt();

        switch(num){
            case 1:
                for (int i = 0; i < console.selectAll().size(); i++) {
                    System.out.println(console.selectAll().get(i).toString()); //bug here
                }
                break;

            case 2: //throws error if id doesn't exist
                System.out.println("Enter pizza ID:");
                try {
                    int selection = input.nextInt();
                    console.selectSingle(selection).toString();
                }
                catch(NullPointerException ex){
                    System.out.println("That pizza id does not exist!");
                }
                break;

            case 3:
                System.out.println("Enter pizza ID:");
                int selection1 = input.nextInt();
                System.out.println("Enter new pizza name:");
                String trashCollector = input.nextLine();
                String selection2 = input.nextLine();
                System.out.println("Enter new pizza price:");
                String selection3 = input.nextLine();
                System.out.println("Enter new pizza size:");
                String selection4 = input.nextLine();

                Pizza tempPiz = new Pizza(selection1, selection2, selection3, selection4);
                console.updateSingle(selection1,tempPiz);

                System.out.println("New pizza:\n");
                console.selectSingle(selection1).toString();
                break;

            case 4:

                break;

            case 5:

                break;

            case 0:
                System.out.println("Shutting down...");
                stop = true;
                break;

            default:
                System.out.println();
                run();
                break;
        }
        if(!stop){
            System.out.println();
            run();
        }
    }
}
