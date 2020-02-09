package SQLiteDBActions;

import java.sql.*;
import java.sql.Connection;

public class SelectTabName {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Deepak\\Work\\DB\\SampleDB.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.print("Connection to db is successful.\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void selectTab(String tabName) {

        String sql = "Select * from " + tabName;

        try {

            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            System.out.print("Executing Query : \n\n" + sql + "\n");
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("UserId") + "\t" +
                        rs.getString("UserName") + "\t" +
                        rs.getString("Password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SelectTabName tabName = new SelectTabName();
        tabName.selectTab("Users");
    }
}