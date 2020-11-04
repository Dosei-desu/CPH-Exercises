import com.sun.xml.internal.ws.util.StringUtils;

import java.util.LinkedList;

//Timmy & Kris
public class Mario extends Restaurant{
    Menu menu;
    ActiveOrders activeOrders;

    Mario(Menu menu, ActiveOrders activeOrders){
        this.menu = menu;
        this.activeOrders = activeOrders; //initialising this within the class solves the problem of changes here not
                                          //not affecting stuff in Restaurant
    }

    public void viewMenu(){
        menu.viewMenu();
    }

    public void viewActiveOrders(){ //moved from Restaurant, to give Mario some kind of actual purpose
        System.out.println("Printing Active Orders:");
        String view = "";
        for (int i = 0; i < activeOrders.getActiveOrders().size(); i++) {
            view += "#" + activeOrders.getActiveOrders().get(i).getId() + " '" + activeOrders.getActiveOrders().get(i).customer.name +
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
            view += "Total: " + sum + "kr.\n\n";
        }
        if (view.equals("")) {
            view = "N/A\n";
        }
        System.out.println(view);
    }

    public void viewHistory(){

    }
}
