//Timmy & Kris
import java.util.LinkedList;
import java.util.Scanner;

public class Restaurant {
    Menu menu = new Menu();
    Scanner input = new Scanner(System.in);
    boolean doOnce = true;
    Mario mario;
    Alfonso alfonso;
    OrderHistory orderHistory = new OrderHistory();
    ActiveOrders activeOrders = new ActiveOrders(orderHistory);

    public void restaurant(){
        if(doOnce) {
            menu.pizzaMenu(); //necessary to "spawn" the menu list
            mario = new Mario(menu);
            alfonso = new Alfonso(menu);
            doOnce = false;
        }

        //Welcome Screen
        welcomeScreen();
        int num = input.nextInt();
        if(num == 1) {
            mario.viewMenu();
            restaurant();
        }
        if(num == 2){
            boolean isRemote = false;
            System.out.println("Please enter customer name:");
            String theGreaterSwallower = input.nextLine(); //necessary to make nextLine() work
            String customerName = input.nextLine();
            System.out.println("Is it ordered by Phone?\n1-'YES' | 2-'NO'");
            int byPhone = input.nextInt();
            if (byPhone == 1){
                isRemote = true;
            }
            System.out.println("Please enter customer phone nr.:");
            Long phoneNum = input.nextLong();
            alfonso.startOrder(customerName, phoneNum);
            selectionHelper(input, isRemote);
        }
        if(num == 3){
            System.out.println("Current pizza orders:");
            alfonso.printOrders();
            restaurant();
        }
        if(num == 4){ //hidden functionality
            System.out.println("Printing order list");
            String view = "";
            /*
            LinkedList<Pizza> johnsPizza = new LinkedList<>();
            johnsPizza.add(menu.menuPizzas.get(1));
            Customer john = new Customer("john",911);
            activeOrders.addOrder(true,johnsPizza,john);
             */
            for(Order order : this.activeOrders.getActiveOrders()){
                view += order.getId()+" "+order.customer.name;
            }
            System.out.println(view);

            restaurant();
        }
    }

    public void welcomeScreen(){
        System.out.println("WELCOME TO MARIO'S PIZZABAR\n\n1 -- View Menu (As Mario)\n2 -- Start Order (As Alfonso)"+
        "\n3 -- View Orders (As Alfonso)\n0 -- Shutdown");
    }

    public void selectionHelper(Scanner input, boolean isRemote){
        System.out.println("Choose customers pizza:\n1 -- By Name\n2 -- By Id\n3 -- By Ingredients\n0 -- Return");
        int selection = input.nextInt();
        switch(selection){
            case 1:
                System.out.println("Enter pizza name:");
                String theGreaterSwallower = input.nextLine();
                String pizzaName = input.nextLine();
                alfonso.addPizzaToOrderByName(pizzaName,isRemote);
                break;

            case 2:
                System.out.println("Enter pizza Id:");
                int pizzaId = input.nextInt();
                alfonso.addPizzaToOrderById(pizzaId,isRemote);
                break;

            case 3:
                System.out.println("Enter pizza ingredient(s):");
                theGreaterSwallower = input.nextLine();
                String pizzaIng = input.nextLine();
                alfonso.addPizzaToOrderByIngredients(pizzaIng,isRemote);
                break;

            default:
                restaurant();
        }
        System.out.println("Would you like to add another pizza to this order?\n1-'YES' | 2-'NO'");
        int addMore = input.nextInt();
        if(addMore == 1){
            selectionHelper(input, isRemote);
        }
        restaurant();
    }
}
