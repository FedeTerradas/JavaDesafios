package jdbc.clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConexion {

    private static final String URL = "jdbc:mysql://localhost:3306/escuela?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "123321fede_12"; // <-- Cambiar aquí tu contraseña

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
