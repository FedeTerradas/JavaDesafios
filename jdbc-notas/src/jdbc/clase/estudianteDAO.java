package jdbc.clase;

import java.sql.*;
import java.util.*;

public class estudianteDAO {

    public int crear(estudiante e) throws SQLException {
        // Verificar si el email ya existe
        String checkSql = "SELECT id FROM estudiantes WHERE email = ?";
        try (Connection cn = dbConexion.getConnection(); PreparedStatement ps = cn.prepareStatement(checkSql)) {
            ps.setString(1, e.getEmail());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Si el email ya existe, devolver un ID (o mostrar un mensaje de error)
                System.out.println("El email ya está registrado: " + e.getEmail());
                return 0;  // O puedes devolver el ID del estudiante existente si lo prefieres
            }
        }

        // Si el email no existe, insertar el estudiante
        String insertSql = "INSERT INTO estudiantes(nombre, apellido, email, edad) VALUES(?,?,?,?)";
        try (Connection cn = dbConexion.getConnection(); PreparedStatement ps = cn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getEmail());
            ps.setInt(4, e.getEdad());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }

    public java.util.List<estudiante> listar() throws SQLException {
        try (Connection cn = dbConexion.getConnection(); PreparedStatement ps = cn.prepareStatement("SELECT * FROM estudiantes ORDER BY nombre"); ResultSet rs = ps.executeQuery()) {
            java.util.List<estudiante> r = new java.util.ArrayList<>();
            while (rs.next()) {
                // Asegúrate de que el constructor de estudiante acepta id y nombre
                r.add(new estudiante(rs.getInt("id"), rs.getString("nombre")));
            }
            return r;
        }
    }

}
