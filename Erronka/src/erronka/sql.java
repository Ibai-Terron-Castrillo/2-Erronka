package erronka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sql {
    
    // Nombre de la base de datos
    private static final String DB_NAME = "erronka2";
    
    // Credenciales de la base de datos
    private static final String USER = "root";
    private static final String PASSWORD = "1MG2024";
    
    // URL de conexión (incluye el puerto correcto y opciones recomendadas)
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false&serverTimezone=UTC";
    
    // Variables de conexión y declaración SQL
    private Connection connection;
    private Statement statement;

    // Constructor para establecer la conexión
    public sql() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                statement = connection.createStatement();
                System.out.println("Conexión a la base de datos '" + DB_NAME + "' exitosa.");
            } else {
                System.out.println("Conexión fallida.");
            }

        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver de MySQL no encontrado.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para cerrar la conexión
    public void closeConnection() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
            System.out.println("Conexión cerrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // Método main para probar la conexión
    public static void main(String[] args) {
        sql conexion = new sql();
        conexion.closeConnection();
    }
}

