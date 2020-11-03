//Timmy & Kris
import java.util.LinkedList;

public class Alfonso extends Restaurant{
    Menu menu;
    Customer currentCustomer;
    LinkedList<Pizza> customerPizza = new LinkedList<>();

    Alfonso(Menu menu){
        this.menu = menu;
    }

    public void startOrder(String name, long number){
        this.currentCustomer = new Customer(name, number);
    }

    public void addPizzaToOrderByName(String pizzaName, boolean remote){
        menu.viewPizzaByName(pizzaName);
        for (int i = 0; i < menu.menuPizzas.size(); i++) {
            if(menu.menuPizzas.get(i).getName().toLowerCase().equals(pizzaName.toLowerCase())){
                customerPizza.add(menu.menuPizzas.get(i));
                addOrder(remote,customerPizza.get(customerPizza.size()-1));
            }
        }
    }

    public void addPizzaToOrderById(int pizzaId, boolean remote){
        menu.viewPizzaByID(pizzaId);
        customerPizza.add(menu.menuPizzas.get(pizzaId-1)); //has to be -1 to match the index
        addOrder(remote,customerPizza.get(customerPizza.size()-1));
    }

    public void addPizzaToOrderByIngredients(String ingredients, boolean remote){ //need to make function that handles CustomPizzas
        menu.viewPizzaByIngredients(ingredients,input,customerPizza);
        //added all the functionality for selection and such to the viewPizza and its embedded customPizza function
        addOrder(remote,customerPizza.get(customerPizza.size()-1));
    }

    public void addOrder(boolean remote, Pizza items){
        Customer customer = this.currentCustomer;
        LinkedList<Pizza> orderList = new LinkedList<>();
        orderList.add(items);
        activeOrders.addOrder(remote, orderList, customer); //"is it by phone?" | pizza order | customer
        System.out.println(activeOrders.id); //test print
        //this whole function doesn't seem to work with the activeOrder functionality in Restaurant...
    }

    public void printOrders(){
        String view = "";
        for (int n = 0; n < customerPizza.size(); n++) {
            view += "'"+currentCustomer.name + "' (num: "+currentCustomer.number+"): ";
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
}
