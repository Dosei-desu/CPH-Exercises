import java.sql.*;
import java.util.ArrayList;

public class Database {
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection;

    Database() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/puck_man_highscorers",
                    "root", "h4bI1tAt10n");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addToDatabase(String player, int score, int time) {
        try {
            PreparedStatement pstmt = null;
            String sql = "INSERT INTO highscorers (player, score, time) VALUES (?, ?, ?)";

            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, player);
            pstmt.setInt(2, score);
            pstmt.setInt(3, time);

            pstmt.executeUpdate();

            pstmt.close();

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void populateHighscorers(ArrayList<Highscorer> arrayList){
        try {
            PreparedStatement pstmt = null;
            String sql = "SELECT * FROM highscorers ORDER BY highscorers.score DESC LIMIT 3;";

            pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Highscorer player = new Highscorer(
                        rs.getString("player"),
                        rs.getInt("score"),
                        rs.getInt("time")
                );
                arrayList.add(player);
            }
            rs.close();
            pstmt.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}