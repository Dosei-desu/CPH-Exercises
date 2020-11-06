//Timmy & Kris

import com.sun.xml.internal.ws.util.StringUtils;

public class Mario extends Restaurant{
    Menu menu;
    ActiveOrders activeOrders;
    OrderHistory orderHistory;

//--Constructor (unlike Alfonso's, this one includes OrderHistory, because Mario needs to access its functionality)
    Mario(Menu menu, ActiveOrders activeOrders, OrderHistory orderHistory){
        this.menu = menu;
        this.activeOrders = activeOrders; //initialising this within the class solves the problem of changes here not
                                          //not affecting stuff in Restaurant
        this.orderHistory = orderHistory;
    }

//--View Menu
    public void viewMenu(){
        menu.viewMenu();
    }

//--View Active Orders
    public void viewActiveOrders(){ //moved from Restaurant, to give Mario some kind of actual purpose
        System.out.println("Active Orders:\n--------------");
        String view = "";
        for (int i = 0; i < activeOrders.getActiveOrders().size(); i++) {
            view += "\n#" + activeOrders.getActiveOrders().get(i).getId() + " '" + activeOrders.getActiveOrders().get(i).customer.name +
                    "' (" + activeOrders.getActiveOrders().get(i).customer.number + ") - ";
            if (activeOrders.getActiveOrders().get(i).remote) {
                view += "Ordered by Phone";
            } else {
                view += "Ordered in Person";
            }
            view += "\nOrder(s):\n";
            double sum = 0;
            for (int j = 0; j < activeOrders.getActiveOrders().get(i).getItems().size(); j++) {
                view += activeOrders.getActiveOrders().get(i).getItems().get(j).getId();
                if (activeOrders.getActiveOrders().get(i).getItems().get(j).getId() < 10) {
                    view += " --- ";
                } else {
                    view += " -- ";
                }
                view += "\"" + activeOrders.getActiveOrders().get(i).getItems().get(j).getName() + "\" --- ";
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
            view += "Total: " + sum + "kr.\n";
        }
        if (view.equals("")) {
            view = "No active orders";
        }
        System.out.println(view);
        System.out.println("--------------");
    }

//--Make Orders (i.e. select an order to "make" (i.e.i.e. set as "ready"))
    public void makeOrders(){
        viewActiveOrders();
        System.out.println("Pick an order to make");
        int id = input.nextInt();
        for (int i = 0; i < activeOrders.getActiveOrders().size(); i++) {
            if(id == activeOrders.getActiveOrders().get(i).getId()) {
                activeOrders.getActiveOrders().get(i).setReady(true);
            }
        }
        System.out.println("Order #"+id+" has been made\n");
    }

//--View History (i.e. OrderHistory list)
    public void viewHistory(){
       orderHistory.viewHistory(); //moved the code for this to OrderHistory
    }
}
