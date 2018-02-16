package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    public static Connection getConnection() {
        Connection connectionDB = null;
        try {
            String url = "jdbc:mysql://localhost:3306/companyDB";
            String user = "root";
            String password = "qwerty";
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);
            connectionDB = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connectionDB;
    }
}



