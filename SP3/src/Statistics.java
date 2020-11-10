/**
 * @author Kris
 */

import java.util.*;

//messing around with an attempt at statistics -kris-
//can easily be retrofitted to suit a FileReader/FilePrinter functionality, but works 100% without it as well
//currently this only shows stats based on names, but it can be changed to show ingredients or something else instead,
//however, I felt it was most poignant to simply refer to names, even if it could potentially show a lot of "custom
//pizzas" as the same entry, despite them having unique ingredients

public class Statistics {
    OrderHistory orderHistory;
    List<String> orderHistoryList = new ArrayList<>();

    Statistics(OrderHistory orderHistory){
        this.orderHistory = orderHistory;
        populate();
    }

    public void populate(){
        for (int i = 0; i < orderHistory.getOrderHistory().size(); i++) {
            for (int j = 0; j < orderHistory.getOrderHistory().get(i).getItems().size(); j++) {
                //only adds to the list if it was delivered
                if(orderHistory.getOrderHistory().get(i).isDelivered()) {
                    orderHistoryList.add(orderHistory.getOrderHistory().get(i).getItems().get(j).getName());
                }
            }
        }
        orderHistoryList.sort(Comparator.naturalOrder()); //sorts the list alphabetically
    }

    public void printOrderList(){ //not used, just for debugging purposes
        System.out.println("Printing list of order history pizza names");
        for (int i = 0; i < orderHistoryList.size(); i++) {
            System.out.println(orderHistoryList.get(i));
        }
    }

    public void stats(){ //find names and count them, then calculate % occurrence based on that
        if(orderHistoryList.size() > 0) {
            System.out.println("Occurrence statistics of delivered orders\n-----------------------------------------");
            for (int i = 0; i < orderHistoryList.size(); i++) {
                if (i > 0) {
                    //ensures no duplicates (easy because of the sorting done above)
                    if (!orderHistoryList.get(i).equals(orderHistoryList.get(i - 1))) {
                        //counts frequency of a certain object through a collection and adds it to a 'double' variable
                        //if it's an 'int' the calculation below doesn't work ('float' also works)
                        double count = Collections.frequency(orderHistoryList, orderHistoryList.get(i));
                        //the 'String.format("%.1f",number)' limits the number of decimal places
                        System.out.println("\"" + orderHistoryList.get(i) + "\" makes up " + (String.format("%.1f", (count /
                                orderHistoryList.size()) * 100)) + "% of all orders");
                    }
                } else {
                    //same as above, but without the "if()" statement (handles the cases when there is only 1 item on the list)
                    double count = Collections.frequency(orderHistoryList, orderHistoryList.get(i));
                    System.out.println("\"" + orderHistoryList.get(i) + "\" makes up " + (String.format("%.1f", (count /
                            orderHistoryList.size()) * 100)) + "% of all orders");
                }
            }
            System.out.println("-----------------------------------------\n");
        }else{
            System.out.println("No statistics available\n");
        }
    }
}
