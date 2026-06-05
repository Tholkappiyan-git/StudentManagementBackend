package student;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb" ;
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {

            Connection con = DriverManager.getConnection( URL, USER, PASSWORD);
            System.out.println("Database connected!");
            return con;

        } catch (Exception e) {

            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}