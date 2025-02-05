package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://172.16.237.119:3306/erronka2";
    private static final String USER = "erabiltzaile";
    private static final String PASSWORD = "3Taldea3";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
