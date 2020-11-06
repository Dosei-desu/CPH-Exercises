//Timmy & Kris

import java.util.Scanner;

public class Restaurant {
    Menu menu = new Menu();
    Scanner input = new Scanner(System.in);
    Mario mario;
    Alfonso alfonso;
    OrderHistory orderHistory = new OrderHistory();
    ActiveOrders activeOrders = new ActiveOrders(orderHistory);

    public void restaurant(){
        mario = new Mario(menu, activeOrders, orderHistory);
        alfonso = new Alfonso(menu, activeOrders);

        //Welcome Screen
        welcomeScreen();
        int num = input.nextInt();

        switch (num) {

            case 1: //view menu
                mario.viewMenu();
                restaurant();
                break;

            case 2: //start order (all of this could probably be moved into alfonso too)
                alfonso.createOrder();
                alfonso.printLastPizza();
                restaurant();
                break;

            case 3: //print current orders
                mario.viewActiveOrders();
                restaurant();
                break;

            case 4: //make orders (set to ready)
                mario.makeOrders();
                restaurant();
                break;

            case 5: //edit order
                alfonso.processActiveOrder();
                restaurant();
                break;

            case 6: //view order history
                mario.viewHistory();
                restaurant();
                break;

            case 7: //statistics (not implemented)
                //stuff happens here
                restaurant();
                break;

            case 0: //shutdown
                break;

            default:
                restaurant();
        }
    }

    public void welcomeScreen(){
        System.out.println("WELCOME TO MARIO'S PIZZABAR\n\n1 -- View Menu (As Mario)\n2 -- Start Order (As Alfonso)"+
        "\n3 -- View Active Orders (As Mario)\n4 -- Make Orders (As Mario)\n5 -- Process Order (As Alfonso)" +
        "\n6 -- View History (as Mario)\n0 -- Shutdown");
    }
}
