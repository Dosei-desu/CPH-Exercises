/**
 * @author Johan (original), reworked to fit Database by Kris
 */

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.LinkedList;

public class OrderHistory {
    private LinkedList<Order> orderHistory;
    private Database database = new Database();

    public OrderHistory() {
        orderHistory = new LinkedList<>();
        database.populateOrderHistory(orderHistory);
    }

    public void addOrder(Order order) {
        orderHistory.addFirst(order);
        database.addToArchive(order);
    }

//--Database history stuff (the new shinier version)
    public void viewOrderHistory(){
        database.viewOrderHistory(this.orderHistory);
    }

//--View History (derelict)
    public void viewHistory(){ //moved from Mario class, since it makes more sense to have it here -Kris-
        System.out.println("Archived Orders:\n----------------");
        String view = "";
        for (int i = 0; i < orderHistory.size(); i++) {
            view += "\n"+orderHistory.get(i).getCreated_at()+"\n";
            view += "#" + orderHistory.get(i).getId() + " '" + orderHistory.get(i).customer.name +
                    "' (" + orderHistory.get(i).customer.number + ") - ";
            if (orderHistory.get(i).remote) {
                view += "Ordered by Phone\n";
            } else {
                view += "Ordered in Person\n";
            }
            if (orderHistory.get(i).isDelivered()){
                view += "-Delivered-\n";
            }else{
                view += "-Abandoned-\n";
            }
            view += "Order(s):\n";
            double sum = 0;
            for (int j = 0; j < orderHistory.get(i).getItems().size(); j++) {
                view += orderHistory.get(i).getItems().get(j).getId();
                if (orderHistory.get(i).getItems().get(j).getId() < 10) {
                    view += " --- ";
                } else {
                    view += " -- ";
                }
                view += "\"" + orderHistory.get(i).getItems().get(j).getName() + "\" --- ";
                for (int k = 0; k < orderHistory.get(i).getItems().get(j).getIngredients().length; k++) {
                    view += StringUtils.capitalize(orderHistory.get(i).getItems().get(j).getIngredients()[k].toLowerCase());
                    if (k < orderHistory.get(i).getItems().get(j).getIngredients().length - 2) {
                        view += ", ";
                    } else if (k < orderHistory.get(i).getItems().get(j).getIngredients().length - 1) {
                        view += ", and ";
                    }
                }
                view += " --- " + orderHistory.get(i).getItems().get(j).getPrice() + "kr.\n";
                sum += orderHistory.get(i).getItems().get(j).getPrice();
            }
            if(!orderHistory.get(i).isDelivered()){
                //if the order was abandoned, the sum is set to 0, because no money is made
                sum = 0;
            }
            view += "Total: " + sum + "kr.\n";
        }
        if (view.equals("")) {
            view = "No archived orders";
        }
        System.out.println(view);
        System.out.println("----------------");
    }

    public LinkedList<Order> getOrderHistory(){
        return orderHistory;
    }

}
