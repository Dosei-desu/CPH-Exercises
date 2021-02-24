import java.sql.*;

public class Main {

//    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //final string containing the driver name



    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Control control = new Control();
        control.run();

















        //don't need this right now, it's just a database search example
/*
        Class.forName(JDBC_DRIVER); //"inverted" url
        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzabar", "root", "h4bI1tAt10n")

    //for reference
//    CREATE TABLE Pizzas(
//        id int NOT NULL AUTO_INCREMENT,
//        `name` varchar(50) NOT NULL,
//        price varchar(8) NOT NULL,
//        size varchar(10) NOT NULL,
//        PRIMARY KEY (id)
//        );


        //prepared statements prevent certain cyber attacks
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM pizzas WHERE id=?"; //specific point in database

        pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, 1); //specific point that matches the WHERE condition above
        //parameterindex refers to which of the "?" to replace with the "x" value

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("price"));
            System.out.println(rs.getString("size"));
        }
        rs.close();
        pstmt.close();

//----------------------------------------------------------------------------------------------------------------------
        //sifting through the entire database (throws null pointer exception for some reason)

        System.out.println("\n----------\n");

        try {
            PreparedStatement pstmtEx = null;
            String sqlEx = "SELECT * FROM pizzas"; //the WHERE statement isn't included, which means it cycles through
                                                   //the entire database

            pstmt = connection.prepareStatement(sqlEx);
            //no specification here like above

            ResultSet rsEx = pstmt.executeQuery();
            while (rsEx.next()) {
                System.out.println(rsEx.getString("name"));
                System.out.println(rsEx.getString("price"));
            }
            rsEx.close();
            pstmtEx.close();
        }
        catch(NullPointerException ex){
            System.out.println("\n(O '.')=O <ERROR>");
        }
//----------------------------------------------------------------------------------------------------------------------
*/
    }
}
