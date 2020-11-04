//Timmy & Kris
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Scanner;

public class Restaurant {
    Menu menu = new Menu();
    Scanner input = new Scanner(System.in);
    Mario mario;
    Alfonso alfonso;
    OrderHistory orderHistory = new OrderHistory();
    ActiveOrders activeOrders = new ActiveOrders(orderHistory);

    public void restaurant(){
        mario = new Mario(menu,activeOrders);
        alfonso = new Alfonso(menu,activeOrders);

        //Welcome Screen
        welcomeScreen();
        int num = input.nextInt();

        switch (num) {

            case 1: //view menu
                mario.viewMenu();
                restaurant();
                break;

            case 2: //start order (all of this could probably be moved into alfonso too)
                boolean isRemote = false;
                System.out.println("Please enter customer name:");
                String theGreaterSwallower = input.nextLine(); //necessary to make nextLine() work
                String customerName = input.nextLine();
                System.out.println("Is it ordered by phone?\n1-'YES' | 2-'NO'");
                int byPhone = input.nextInt();
                if (byPhone == 1) {
                    isRemote = true;
                }
                System.out.println("Please enter customer phone number:");
                Long phoneNum = input.nextLong();
                LinkedList<Pizza> currentPizzas = new LinkedList<>(); //similar to the "clear order" function Johan made
                //moved selectionHelper to Alfonso class, since it tidies up the Restaurant code
                alfonso.selectionHelper(input, isRemote, customerName, phoneNum, currentPizzas);
                //moved addOrder here to avoid a customer duplication bug
                activeOrders.addOrder(isRemote, currentPizzas, alfonso.currentCustomer.getLast()); //similar to Johan's "push order"
                restaurant();
                break;

            //replaced with active order list
            /*
            case 3: //view order
                System.out.println("Current pizza orders:");
                alfonso.printOrders();
                restaurant();
                break;
            */

            case 3: //print current orders
                mario.viewActiveOrders();
                restaurant();
                break;

            case 4: //remove active orders
                System.out.println("Enter customer ID to deliver:");
                int clearID = input.nextInt();
                alfonso.deliver(clearID);
                restaurant();
                break;

            default:
                restaurant();
        }
    }

    public void welcomeScreen(){
        System.out.println("WELCOME TO MARIO'S PIZZABAR\n\n1 -- View Menu (As Mario)\n2 -- Start Order (As Alfonso)"+
        "\n3 -- View Active Orders (As Mario)\n4 -- Deliver (As Alfonso)\n0 -- Shutdown");
    }


}
