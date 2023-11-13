package helpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/library";
    private Connection connection;
    
    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Error al conectarse a la base de datos" + e.getMessage());
        }
    } 
    
    public Connection getConnection(){
        return connection;
    }
}

