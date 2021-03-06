import com.sun.xml.internal.ws.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Database {
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection;
    ConsoleColour cc = new ConsoleColour();

    Database() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marios_pizzabar",
                                                    "root", "h4bI1tAt10n");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void viewMenu(){
        try{
            PreparedStatement pstmt = null;
            String sql = "SELECT * FROM pizza";

            pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){ //a mess of formatting... TOO BAD!
                System.out.print("#"+rs.getInt("id"));
                if(rs.getInt("id") > 9){
                    System.out.print(" -- ");
                }else{
                    System.out.print(" --- ");
                }
                System.out.print(cc.green+"\""+rs.getString("name")+"\""+cc.reset);
                String ing[] = rs.getString("ingredients").split(",");
                System.out.print(" -- ");
                for (int i = 0; i < ing.length; i++) {
                    System.out.print(ing[i]);
                    if(i < ing.length-2){
                        System.out.print(", ");
                    }else if(i < ing.length-1){
                        System.out.print(", and ");
                    }
                }
                System.out.print(" -- "+cc.green+rs.getString("price")+" kr.\n"+cc.reset);
            }

            rs.close();
            pstmt.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    //not sure why it has to be static, but it throws errors if it isn't ... *shrug*
    public void populateArrayWithPizza(ArrayList<Pizza> pizzaArrayList){
        try{
            PreparedStatement pstmt = null;
            String sql = "SELECT * FROM pizza";

            pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            int pizIndex = 0;
            while(rs.next()){
                pizzaArrayList.add(pizIndex,
                        new MenuPizza(
                        rs.getString("name"),
                        rs.getInt("id"),
                        rs.getString("ingredients"),
                        Double.parseDouble(rs.getString("price"))
                        )
                );
                if(pizIndex < 37) {
                    pizIndex++;
                }else{
                    pizIndex = 0;
                }
            }

            rs.close();
            pstmt.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void populateOrderHistory(LinkedList<Order> history){
        try{
            PreparedStatement pstmt = null;
            String sql = "SELECT * FROM order_history";

            pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                LinkedList<Pizza> tempList = new LinkedList<>();
                tempList.add(new Pizza(
                        rs.getString("name"),
                        Integer.parseInt(rs.getString("pizza_id")),
                        rs.getString("ingredients"),
                        Double.parseDouble(rs.getString("price"))
                        ));
                Customer tempCustomer = new Customer(
                        rs.getString("customer"),
                        Long.parseLong(rs.getString("phone_number"))
                );
                Order tempOrder = new Order(
                        Integer.parseInt(rs.getString("unique_id")),
                        rs.getBoolean("remote"),
                        tempList,
                        tempCustomer
                );
                tempOrder.setCreated_at(rs.getTimestamp("created_at"));
                tempOrder.setDelivered(rs.getBoolean("delivered"));

                history.addFirst(tempOrder);
            }

            rs.close();
            pstmt.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
//Template for the insert function
    public void addToArchive(Order order) {
        try {
            PreparedStatement pstmt = null;
            String sql =
            "INSERT INTO order_history (unique_id, delivered, remote, pizza_id, `name`, ingredients, price, customer, phone_number)"+
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = connection.prepareStatement(sql);
            for (int i = 0; i < order.getItems().size(); i++) {
                pstmt.setInt(1, order.getId());
                pstmt.setBoolean(2, order.isDelivered());
                pstmt.setBoolean(3, order.isRemote());

                pstmt.setString(4, Integer.toString(order.getItems().get(i).getId()));
                pstmt.setString(5, StringUtils.capitalize(order.getItems().get(i).getName().toLowerCase()));

                String ingredientsList = "";
                for (int j = 0; j < order.getItems().get(i).getIngredients().length; j++) {
                    ingredientsList += StringUtils.capitalize(order.getItems().get(i).getIngredients()[j].toLowerCase());
                    if(j < order.getItems().get(i).getIngredients().length - 1){
                        ingredientsList += ",";
                    }
                }
                pstmt.setString(6, ingredientsList);

                pstmt.setString(7, Double.toString(order.getItems().get(i).getPrice()));

                pstmt.setString(8, StringUtils.capitalize(order.getCustomer().getName().toLowerCase()));
                pstmt.setString(9, Long.toString(order.getCustomer().getNumber()));

                pstmt.executeUpdate();
            }

            pstmt.close();

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void viewOrderHistory(LinkedList<Order> orderHistory){ //moved from Mario class, since it makes more sense to have it here -Kris-
        System.out.println(cc.blueB+"Archived Orders:\n----------------"+cc.reset);
        String view = "";
        double sum = 0;
        for (int i = 0; i < orderHistory.size(); i++) {
            if(i > 0) {
                if(orderHistory.get(i).getId() != orderHistory.get(i-1).getId()) { //checks if same unique id
                    view += cc.blue + "\n" + orderHistory.get(i).getCreated_at() + "\n" + cc.reset;
                    view += "#" + orderHistory.get(i).getId() + " '" +
                            StringUtils.capitalize(orderHistory.get(i).customer.name.toLowerCase()) +
                            "' (" + orderHistory.get(i).customer.number + ") - ";
                    if (orderHistory.get(i).remote) {
                        view += "Ordered by Phone\n";
                    } else {
                        view += "Ordered in Person\n";
                    }
                    if (orderHistory.get(i).isDelivered()) {
                        view += cc.green+"-Delivered-\n"+cc.reset;
                    } else {
                        view += cc.red+"-Abandoned-\n"+cc.reset;
                    }
                    view += "Order(s):\n";
                }
            }else{ //first time through
                view += cc.blue + "\n" + orderHistory.get(i).getCreated_at() + "\n" + cc.reset;
                view += "#" + orderHistory.get(i).getId() + " '" +
                        StringUtils.capitalize(orderHistory.get(i).customer.name.toLowerCase()) +
                        "' (" + orderHistory.get(i).customer.number + ") - ";
                if (orderHistory.get(i).remote) {
                    view += "Ordered by Phone\n";
                } else {
                    view += "Ordered in Person\n";
                }
                if (orderHistory.get(i).isDelivered()) {
                    view += "-Delivered-\n";
                } else {
                    view += "-Abandoned-\n";
                }
                view += "Order(s):\n";
            }
            //where it gets all the pizzas
            for (int j = 0; j < orderHistory.get(i).getItems().size(); j++) {
                view += orderHistory.get(i).getItems().get(j).getId();
                if (orderHistory.get(i).getItems().get(j).getId() < 10) {
                    view += " --- ";
                } else {
                    view += " -- ";
                }
                view += cc.green+"\"" + orderHistory.get(i).getItems().get(j).getName() + "\"" +cc.reset+ " --- ";
                for (int k = 0; k < orderHistory.get(i).getItems().get(j).getIngredients().length; k++) {
                    view += StringUtils.capitalize(orderHistory.get(i).getItems().get(j).getIngredients()[k].toLowerCase());
                    if (k < orderHistory.get(i).getItems().get(j).getIngredients().length - 2) {
                        view += ", ";
                    } else if (k < orderHistory.get(i).getItems().get(j).getIngredients().length - 1) {
                        view += ", and ";
                    }
                }
                view += " --- " + cc.green + orderHistory.get(i).getItems().get(j).getPrice() + "kr.\n" + cc.reset;
                sum += orderHistory.get(i).getItems().get(j).getPrice();
            }

            if(!orderHistory.get(i).isDelivered()){
                //if the order was abandoned, the sum is set to 0, because no money is made
                sum = 0;
            }
            if(i+1 < orderHistory.size()) {
                if (orderHistory.get(i).getId() != orderHistory.get(i + 1).getId()) {
                    if(sum == 0){
                        view += cc.red;
                    }else{
                        view += cc.green;
                    }
                    view += "Total: " + sum + "kr.\n"+cc.reset;
                    sum = 0;
                }
            }else{
                if(sum == 0){
                    view += cc.red;
                }else{
                    view += cc.green;
                }
                view += "Total: " + sum + "kr.\n"+cc.reset;
                sum = 0;
            }
        }

        if (view.equals("")) {
            view = "No archived orders";
        }
        System.out.println(view);

        double totalSum = 0;
        for (int i = 0; i < orderHistory.size(); i++) {
            if(orderHistory.get(i).isDelivered()){
                totalSum += orderHistory.get(i).getPrice();
            }
        }
        System.out.println(cc.green+"Total sum of all past orders: "+totalSum+"kr."+cc.reset);
        System.out.print(cc.blueB+"----------------\n"+cc.reset);
    }
}

//TODO
/*
- Maybe text colours using the ANSI code August made
*/
//FIXME
/*
- Found a strange bug where choosing 'NO' on "would you like to add another order" would trigger itself again and end up
  adding another identical pizza order under a different unique id...6
*/