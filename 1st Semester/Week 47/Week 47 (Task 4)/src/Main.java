import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//------ a:
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        Class.forName(JDBC_DRIVER);
        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "h4bI1tAt10n");
//------//
//------ b:
        System.out.println("TASK B:");
        PreparedStatement pstmt = null;
        String sql = "SELECT count(*) FROM city";

        pstmt = connection.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        rs.next();
        System.out.println("Count: " + rs.getInt(1));
//------ c:
        System.out.println("\nTASK C:");
        pstmt = null;
        sql = "SELECT * FROM city WHERE population > 5000000";

        pstmt = connection.prepareStatement(sql);

        rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println("#" + rs.getInt("id") + " \"" + rs.getString("name") + "\"");
        }

        rs.close();
        pstmt.close();
//------ d:
        System.out.println("\nTASK D:");
        ArrayList<City> cities = new ArrayList<>();

        pstmt = null;
        sql = "SELECT * FROM city WHERE population > 5000000";

        pstmt = connection.prepareStatement(sql);

        rs = pstmt.executeQuery();

        while (rs.next()) {
            cities.add(new City(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("countrycode"),
                    rs.getString("district"),
                    rs.getInt("population")
            ));
        }

        rs.close();
        pstmt.close();
//------ e:
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i).toString());
        }
    }
}

//TODO
/*
a. Create a connection to your local instance world database.
    - The URL should look like this: "jdbc:mysql://localhost/world"
    - Create the connection like this:
    Connection connection = null;
    connection = DriverManager.getConnection(URL, username, password);
    - NOTE: the second line in the above step, must be in a try/catch. - ALSO NOTE: You have to define String username and String password with your MySQL login (root/<password>)
    - THIRD NOTE: If you're having trouble finding the correct driver for the JDBC, try the following and use the one, that doesn't have "bin" in the name:
    https://efif.sharepoint.com/:u:/s/cph/Lyngby/Ea3K8LZeFStJjX-XHiTc-RgBK2qD7pe4z5ND8MilZ0lVsw

    b. Create a prepared statement, that retrieves the count of all cities in the city table. Write the result to console.

    c. Create a prepared statement, that retrieves all cities with a population greater than 5.000.000 and prints each result to console.

    d. Create a class called City with relevant data fields, and populate an arraylist<City> with the results retrieved from the above task (c).

    e. Override toString for the City class and print the arrayList to console.

    f. Close connection
*/