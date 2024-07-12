package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Prueba {

    public static void main(String[] args) {
        Connection con = null;
        try {
            // Paso 1: Cargar el driver JDBC
            Class.forName("com.mysql.jdbc.Driver");

            // Paso 2: Establecer la conexión
            String url = "jdbc:mysql://localhost:3306/libros";
            String user = "root";
            String password = ""; // Cambia por tu contraseña si está configurada
            con = DriverManager.getConnection(url, user, password);

            if (con != null) {
                System.out.println("Conexión establecida con éxito a la base de datos MySQL.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        } finally {
            // Paso 5: Cerrar la conexión
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
