//Timmy & Kris
import java.util.LinkedList;
import java.util.Scanner;

public class Alfonso extends Restaurant{
    Menu menu;
    LinkedList<Customer> currentCustomer = new LinkedList<>();
    LinkedList<Pizza> customerPizza = new LinkedList<>();
    ActiveOrders activeOrders; //not used for anything

    Alfonso(Menu menu, ActiveOrders activeOrders){
        this.menu = menu;
        this.activeOrders = activeOrders;
    }
//--Start Order (initialises Customer)
    public void startOrder(String name, long number){
        this.currentCustomer.add(new Customer(name, number));
    }
//--Add Pizza to Order (by Name)
    public void addPizzaToOrderByName(String pizzaName){
        menu.viewPizzaByName(pizzaName);
        for (int i = 0; i < menu.menuPizzas.size(); i++) {
            if(menu.menuPizzas.get(i).getName().toLowerCase().equals(pizzaName.toLowerCase())){
                customerPizza.add(menu.menuPizzas.get(i));
            }
        }
    }
//--Add Pizza to Order (by ID)
    public void addPizzaToOrderById(int pizzaId){
        menu.viewPizzaByID(pizzaId);
        customerPizza.add(menu.menuPizzas.get(pizzaId - 1)); //has to be -1 to match the index
    }
//--Add Pizza to Order (by Ingredients)
    public void addPizzaToOrderByIngredients(String ingredients){ //need to make function that handles CustomPizzas
        //added all the functionality for selection and such to the viewPizza and its embedded customPizza function
        menu.viewPizzaByIngredients(ingredients,input,customerPizza);
    }


//--Selection Helper (moved from Restaurant class)
    public void selectionHelper(Scanner input, boolean isRemote, String customerName, Long phoneNum, LinkedList<Pizza> currentPizzas){
        startOrder(customerName, phoneNum); //moved this here to avoid a problem with the newly-created customer LinkedList
        System.out.println("Choose pizza:\n1 -- By Name\n2 -- By Id\n3 -- By Ingredients\n0 -- Return");
        int selection = input.nextInt();
        switch(selection){
            case 1:
                System.out.println("Enter Pizza Name:");
                String theGreaterSwallower = input.nextLine(); //necessary to make nextLine() work
                String pizzaName = input.nextLine();
                addPizzaToOrderByName(pizzaName);
                break;

            case 2:
                System.out.println("Enter Pizza Id:");
                int pizzaId = input.nextInt();
                addPizzaToOrderById(pizzaId);
                break;

            case 3:
                System.out.println("Enter Pizza Ingredient(s):");
                theGreaterSwallower = input.nextLine();
                String pizzaIng = input.nextLine();
                addPizzaToOrderByIngredients(pizzaIng);
                break;

            default:
                restaurant();
        }
        //temporary list used to add to active orders since it takes a LinkedList as parameter
        currentPizzas.add(customerPizza.getLast());

        //add another (loops back through and keeps customer data)
        System.out.println("Would you like to add another pizza to this order?\n1-'YES' | 2-'NO'");
        int addMore = input.nextInt();
        if(addMore == 1){
            selectionHelper(input, isRemote, customerName, phoneNum, currentPizzas);
        }
        //moved the activeOrders.addOrder outside of this function, since it caused a duplication bug
    }
//--Deliver (i.e. remove an order)
    public void deliver(int id){
        for (int i = 0; i < activeOrders.getActiveOrders().size(); i++) {
            if (id == activeOrders.getActiveOrders().get(i).id){
                activeOrders.getActiveOrders().remove(i);
            }
        }
    }

//--Print Orders >|decommissioned|<
    //suddenly doesn't work... (no clue why, don't really care either since it has been replaced)
    /*
    public void printOrders(){
        String view = "";
        for (int n = 0; n < customerPizza.size(); n++) {
            view += "'"+ currentCustomer.get(n).name +"' (num: "+ currentCustomer.get(n).number +"): ";
            view += customerPizza.get(n).getId();
            if(customerPizza.get(n).getId() < 10){
                view += " --- \"";
            }else{
                view += " -- \"";
            }
            view += customerPizza.get(n).getName()+"\" --- "+" ";
            for (int i = 0; i < customerPizza.get(n).getIngredients().length; i++) {
                view += customerPizza.get(n).getIngredients()[i];
                if(i < customerPizza.get(n).getIngredients().length-1){
                    view += ", ";
                }
            }
            view += " --- "+customerPizza.get(n).getPrice()+"kr.\n";
        }
        if(view.equals("")){
            view = "No orders in list.\n";
        }
        System.out.println(view); //prints the long string of stuff created above
    }
    */
}
