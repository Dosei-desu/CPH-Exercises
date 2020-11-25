/**
 * @author Timmy & Kris
 */

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

public class Alfonso extends Restaurant{
    Menu menu;
    LinkedList<Customer> currentCustomer = new LinkedList<>();
    LinkedList<Pizza> customerPizza = new LinkedList<>();
    ActiveOrders activeOrders; //not used for anything
    ConsoleColour cc = new ConsoleColour();

    Alfonso(Menu menu, ActiveOrders activeOrders){
        this.menu = menu;
        this.activeOrders = activeOrders;
    }

//--Start Order (initialises Customer)
    public void startOrder(String name, long number){
        this.currentCustomer.add(new Customer(name, number));
    }

//--Add Pizza to Order (by Name)
    public boolean addPizzaToOrderByName(String pizzaName, LinkedList<Pizza> currentPizzas){
        menu.viewPizzaByName(pizzaName);
        for (int i = 0; i < menu.menuPizzas.size(); i++) {
            if (menu.menuPizzas.get(i).getName().toLowerCase().equals(pizzaName.toLowerCase())) {
                customerPizza.add(menu.menuPizzas.get(i));
                return true;
            }
        }
        return false;
    }

//--Add Pizza to Order (by ID)
    public void addPizzaToOrderById(int pizzaId){
        menu.viewPizzaByID(pizzaId);
        customerPizza.add(menu.menuPizzas.get(pizzaId - 1)); //has to be -1 to match the index
    }

//--Add Pizza to Order (by Ingredients)
    public void addPizzaToOrderByIngredients(String ingredients) { //need to make function that handles CustomPizzas
        //added all the functionality for selection and such to the viewPizza and its embedded customPizza function
        menu.viewPizzaByIngredients(ingredients, input, customerPizza);
    }

//--Selection Helper (moved from Restaurant class)
    public void selectionHelper(Scanner input, boolean isRemote, String customerName, Long phoneNum, LinkedList<Pizza> currentPizzas){
        boolean check = false; //used to prevent "no such element" + addLast problem with Pizza Name order
        startOrder(customerName, phoneNum); //moved this here to avoid a problem with the newly-created customer LinkedList
        System.out.println("Choose pizza:\n1 -- By Name\n2 -- By ID\n3 -- By Ingredients\n0 -- Return (Cancels Order)");
        try {
            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("Enter pizza name:");
                    String theGreaterSwallower = input.nextLine(); //flushes the scanner input (could also just be "input.nextLine();")
                    String pizzaName = input.nextLine();
                    check = addPizzaToOrderByName(pizzaName, currentPizzas); //this is the only way it would cooperate... deal with it
                    break;

                case 2:
                    System.out.println("Enter pizza ID:");
                    int pizzaId = input.nextInt();
                    addPizzaToOrderById(pizzaId);
                    break;

                case 3:
                    System.out.println("Enter pizza ingredient(s):");
                    theGreaterSwallower = input.nextLine();
                    String pizzaIng = input.nextLine();
                    addPizzaToOrderByIngredients(pizzaIng);
                    break;

                case 0: //return
                    break;

                default:
                    break;
            }
            if (selection > 0 && selection < 4) { //only triggers if 1, 2, or 3 are entered
                //temporary list used to add to active orders since it takes a LinkedList as parameter
                //Is it a mess? yes. but too bad!
                if(selection != 1 || check) { //if the selection is based on name (i.e. == 1), it uses "check" instead
                    currentPizzas.add(customerPizza.getLast());
                }else{ //technically not an exception, but it should be ...!
                    System.out.println(cc.red+"No such element error!\n"+cc.reset);
                    selectionHelper(input, isRemote, customerName, phoneNum, currentPizzas);
                }

                //add another (loops back through and keeps customer data)
                System.out.println("Would you like to add another pizza to this order?\n1-"+cc.green+"'YES'"+cc.reset+" | 2-"+cc.red+"'NO'"+cc.reset);
                int addMore = input.nextInt();
                if (addMore == 1) {
                    selectionHelper(input, isRemote, customerName, phoneNum, currentPizzas);
                } else { //else statement necessary to avoid duplication bug
                    activeOrders.addOrder(isRemote, currentPizzas, currentCustomer.getLast()); //similar to Johan's "push order"
                    printLastPizza();
                }
            }
        }
        catch (InputMismatchException ex){
            System.out.println(cc.red+"Input mismatch error!\n"+cc.reset);
            input.nextLine();
            selectionHelper(input, isRemote, customerName, phoneNum, currentPizzas);
        }
        catch (NoSuchElementException ex){
            System.out.println(cc.red+"No such element error!\n"+cc.reset);
            selectionHelper(input, isRemote, customerName, phoneNum, currentPizzas);
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println(cc.red+"Out of bounds error!\n"+cc.reset);
            selectionHelper(input, isRemote, customerName, phoneNum, currentPizzas);
        }
    }

//--Print latest pizza
    public void printLastPizza(){
        if(activeOrders.getActiveOrders().size() > 0) {
            System.out.println("Receipt:");
            for (int i = 0; i < activeOrders.getActiveOrders().getLast().getItems().size(); i++) {
                System.out.println(activeOrders.getActiveOrders().getLast().getItems().get(i));
            }
            System.out.println(cc.green+"Total: "+activeOrders.getActiveOrders().getLast().getPrice()+"kr.\n"+cc.reset);
        }else{
            System.out.println(cc.red+"N/A\n"+cc.reset);
        }
    }

//--Create Order
    public void createOrder(){ //can probably be moved to Alfonso
        boolean isRemote = false;
        System.out.println("Please enter customer name:");

        String customerName = input.nextLine();
        System.out.println("Is it ordered by phone?\n1-"+cc.green+"'YES'"+cc.reset+" | 2-"+cc.red+"'NO'"+cc.reset);
        int byPhone = input.nextInt();
        if (byPhone == 1) {
            isRemote = true;
        }
        System.out.println("Please enter customer phone number:");
        Long phoneNum = input.nextLong();
        LinkedList<Pizza> currentPizzas = new LinkedList<>(); //similar to the "clear order" function Johan made
        //moved selectionHelper to Alfonso class, since it tidies up the Restaurant code
        selectionHelper(input, isRemote, customerName, phoneNum, currentPizzas);
    }

//--Process (edit) active orders
    public void processActiveOrder(){ //can probably be moved to Alfonso
        if(activeOrders.getActiveOrders().size() > 0) {
            System.out.println(cc.green+"There are "+activeOrders.getActiveOrders().size()+" active orders"+cc.reset);
            System.out.println("1 -- Deliver Order\n2 -- Abandon Order\n0 -- Return");
            int selection = input.nextInt();

            switch (selection) {

                case 1: //deliver (i.e, move to history and mark Delivered as True)
                    viewActiveOrders();
                    System.out.println("Enter order ID: ");
                    int id1 = input.nextInt();
                    deliver(id1);
                    break;

                case 2: //abandon (i.e, move to history and mark Delivered as False)
                    viewActiveOrders();
                    System.out.println("Enter order ID: ");
                    int id2 = input.nextInt();
                    abandon(id2);
                    break;

                case 0: //does nothing, just stops it from doing anything (used to have Restaurant() in here, but that
                        //causes a bug where the entire activeOrders list is wiped...)
                    break;

                default:
                    break;
            }
        }else{
            System.out.println(cc.red+"No active orders to process\n"+cc.reset);
        }
    }

//--Deliver (i.e. remove an order from active orders and process as delivered)
    public void deliver(int id){
        boolean check = false; //to avoid failure statement appearing on successful processing of an order
        for (int i = 0; i < activeOrders.getActiveOrders().size(); i++) {
            if (id == activeOrders.getActiveOrders().get(i).id && activeOrders.getActiveOrders().get(i).isReady()){
                activeOrders.getActiveOrders().get(i).setDelivered(true);
                activeOrders.archiveOrder(activeOrders.getActiveOrders().get(i).getId());
                check = true;
            }else if(id == activeOrders.getActiveOrders().get(i).id){
                //check to ensure order is ready, otherwise it won't let you deliver it
                System.out.println(cc.red+"Order is not ready to be delivered"+cc.reset);
                check = true;
            }
        }
        if(!check){
            System.out.println(cc.red+"Order ID: "+id+" does not exist\n"+cc.reset);
        }else{
            System.out.println(cc.green+"Finished processing Order ID: "+id+"\n"+cc.reset);
        }
    }

//--Abandon (i.e. remove an order from active orders and process as abandoned)
    public void abandon(int id){ //has no "is it ready?" check, since you can abandon whenever
        boolean check = false; //to avoid failure statement appearing on successful processing of an order
        for (int i = 0; i < activeOrders.getActiveOrders().size(); i++) {
            if (id == activeOrders.getActiveOrders().get(i).id){
                activeOrders.getActiveOrders().get(i).setDelivered(false);
                activeOrders.archiveOrder(activeOrders.getActiveOrders().get(i).getId());
                check = true;
            }
        }
        if(!check){
            System.out.println(cc.red+"Order ID: "+id+" does not exist\n"+cc.reset);
        }else{
            System.out.println(cc.green+"Finished processing Order ID: "+id+"\n"+cc.reset);
        }
    }

//--View active orders (copied from Mario)
    //this can be improved, but this is currently just to get around the fact alfonso can't access mario's functions
    public void viewActiveOrders(){
        System.out.println(cc.blueB+"Active Orders:\n--------------"+cc.reset);
        String view = "";
        for (int i = 0; i < activeOrders.getActiveOrders().size(); i++) {
            view += "\n#" + activeOrders.getActiveOrders().get(i).getId() + " '" + activeOrders.getActiveOrders().get(i).customer.name +
                    "' (" + activeOrders.getActiveOrders().get(i).customer.number + ") - ";
            if (activeOrders.getActiveOrders().get(i).remote) {
                view += "Ordered by Phone\n";
            } else {
                view += "Ordered in Person\n";
            }
            if(activeOrders.getActiveOrders().get(i).isReady()){
                view += cc.green+"-Ready-\n"+cc.reset;
            }else{
                view += cc.red+"-Not Ready-\n"+cc.reset;
            }
            view += "Order(s):\n";
            double sum = 0;
            for (int j = 0; j < activeOrders.getActiveOrders().get(i).getItems().size(); j++) {
                view += activeOrders.getActiveOrders().get(i).getItems().get(j).getId();
                if (activeOrders.getActiveOrders().get(i).getItems().get(j).getId() < 10) {
                    view += " --- ";
                } else {
                    view += " -- ";
                }
                view += cc.green+"\"" + activeOrders.getActiveOrders().get(i).getItems().get(j).getName() + "\""+cc.reset+" --- ";
                for (int k = 0; k < activeOrders.getActiveOrders().get(i).getItems().get(j).getIngredients().length; k++) {
                    view += StringUtils.capitalize(activeOrders.getActiveOrders().get(i).getItems().get(j).getIngredients()[k].toLowerCase());
                    if (k < activeOrders.getActiveOrders().get(i).getItems().get(j).getIngredients().length - 2) {
                        view += ", ";
                    } else if (k < activeOrders.getActiveOrders().get(i).getItems().get(j).getIngredients().length - 1) {
                        view += ", and ";
                    }
                }
                view += " --- " + activeOrders.getActiveOrders().get(i).getItems().get(j).getPrice() + "kr.\n";
                sum += activeOrders.getActiveOrders().get(i).getItems().get(j).getPrice();
            }
            view += cc.green+"Total: " + sum + "kr.\n"+cc.reset;
        }
        if (view.equals("")) {
            view = cc.red+"No active orders"+cc.reset;
        }
        System.out.println(view);
        System.out.println(cc.blueB+"--------------"+cc.reset);
    }
}
