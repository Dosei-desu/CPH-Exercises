import Models.Pizza;

import java.util.ArrayList;
import java.sql.*;

public class Console implements DBBasicMethods{
    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection connection;
    ArrayList<Pizza> pizzas = new ArrayList<>();

    public Console()  {
        //doing try catch here, means I don't have to also implement throws Control where Console is created
        try {
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzabar", "root", "h4bI1tAt10n");

            PreparedStatement pstmt = null;
            String sql = "SELECT * FROM pizzas";

            pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Pizza pizza = new Pizza(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("price"),
                    rs.getString("size")
                );
                pizzas.add(pizza);
            }
            rs.close();
            pstmt.close();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int deleteSingle(int id) {
        try {
            PreparedStatement pstmt = null;
            String sql = "DELETE FROM pizzas WHERE id=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows + " row(s) affected!");

            pstmt.close();

            return affectedRows;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Pizza selectSingle(int id) {
        try {
            PreparedStatement pstmt = null;
            String sql = "SELECT * FROM pizzas WHERE id=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            System.out.println("Id: "+rs.getString("id"));
            System.out.println("Name: "+rs.getString("name"));
            System.out.println("Price: "+rs.getString("price"));
            System.out.println("Size: "+rs.getString("size"));

            Pizza tempPiz = new Pizza(id,rs.getString("name"),rs.getString("price"),rs.getString("size"));

            rs.close();
            pstmt.close();


            return tempPiz;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateSingle(int id, Pizza pizza) {
        try {
            PreparedStatement pstmt = null;
            String sql = "UPDATE pizzas SET name=?, price=?, size=? WHERE id=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, pizza.getName());
            pstmt.setString(2, pizza.getPrice());
            pstmt.setString(3, pizza.getSize());
            pstmt.setInt(4,id);

            int affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows + " row(s) affected!");

            pstmt.executeUpdate();
            pstmt.close();

            update(); //necessary to update the array with new pizza objects

            return affectedRows;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertSingle(Pizza pizza) {
        try {
            PreparedStatement pstmt = null;
            String sql = "INSERT INTO pizzas (name, price, size) VALUES (?, ?, ?)";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, pizza.getName());
            pstmt.setString(2, pizza.getPrice());
            pstmt.setString(3, pizza.getSize());

            int affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows + " row(s) affected!");

            pstmt.close();

            return affectedRows;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Pizza> selectAll() {
        return pizzas;
    }

    public void update(){
        pizzas.clear(); //pretty stupid code here, but TOO BAD, it works, so idgaf
        try {
            PreparedStatement pstmt = null;
            String sql = "SELECT * FROM pizzas";

            pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Pizza pizza = new Pizza(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("price"),
                        rs.getString("size")
                );
                pizzas.add(pizza);
            }
            rs.close();
            pstmt.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}