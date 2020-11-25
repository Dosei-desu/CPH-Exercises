/**
 * @author Timmy & Kris
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Restaurant {
    Menu menu = new Menu();
    Scanner input = new Scanner(System.in);
    Mario mario;
    Alfonso alfonso;
    OrderHistory orderHistory = new OrderHistory();
    ActiveOrders activeOrders = new ActiveOrders(orderHistory);
    ConsoleColour cc = new ConsoleColour();

    public void restaurant(){
        mario = new Mario(menu, activeOrders, orderHistory);
        alfonso = new Alfonso(menu, activeOrders);

        //Welcome Screen
        welcomeScreen();

        try {
            int num = input.nextInt();

            switch (num) {

                case 1: //view menu
                    mario.viewMenu();
                    restaurant();
                    break;

                case 2: //start order
                    alfonso.createOrder();
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

                case 5: //edit orders
                    alfonso.processActiveOrder();
                    restaurant();
                    break;

                case 6: //view order history
                    mario.viewHistory();
                    restaurant();
                    break;

                case 7: //statistics
                    mario.printStats();
                    restaurant();
                    break;

                case 0: //shutdown
                    break;

                default: //if the value isn't accounted for, it simply returns
                    restaurant();
            }
        }

        catch (InputMismatchException ex){ //if the input isn't an int, this is triggered
            System.out.println(cc.redB+"Input mismatch error!\n"+cc.reset);
            input.nextLine(); //flushes the scanner so that it doesn't create an infinite loop
            restaurant();
        }
    }

    public void welcomeScreen(){
        System.out.println(cc.blueU+"WELCOME TO MARIO'S PIZZABAR\n"+cc.reset+cc.blueB+"\n1 -- View Menu (As Mario)\n2 -- Start Order (As Alfonso)"+
        "\n3 -- View Active Orders (As Mario)\n4 -- Make Orders (As Mario)\n5 -- Process Order (As Alfonso)" +
        "\n6 -- View History (As Mario)\n7 -- Order Statistics (As Mario)\n0 -- Shutdown"+cc.reset);
    }
}
