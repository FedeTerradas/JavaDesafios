package jdbc.clase;

import java.sql.*;
import java.util.*;

public class calificacionDAO {

    // Registrar calificación
    public int registrar(calificacion c) throws SQLException {
        String sql = "INSERT INTO calificaciones(estudiante_id, materia, nota, fecha) VALUES(?, ?, ?, ?)";
        try (Connection cn = dbConexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, c.getEstudianteId());
            ps.setString(2, c.getMateria());
            ps.setDouble(3, c.getNota());
            ps.setDate(4, java.sql.Date.valueOf(c.getFecha()));
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }

    // Calcular el promedio de un estudiante
    public double promedioDe(int estudianteId) throws SQLException {
        String sql = "SELECT AVG(nota) AS promedio FROM calificaciones WHERE estudiante_id=?";
        try (Connection cn = dbConexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, estudianteId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getDouble("promedio") : 0.0;
            }
        }
    }

    // Listar todas las calificaciones de un estudiante
    public List<calificacion> historial(int estudianteId) throws SQLException {
        String sql = "SELECT * FROM calificaciones WHERE estudiante_id=? ORDER BY fecha DESC, materia";
        try (Connection cn = dbConexion.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, estudianteId);
            try (ResultSet rs = ps.executeQuery()) {
                List<calificacion> historial = new ArrayList<>();
                while (rs.next()) {
                    historial.add(new calificacion(
                            rs.getInt("id"),
                            rs.getInt("estudiante_id"),
                            rs.getString("materia"),
                            rs.getDouble("nota"),
                            rs.getDate("fecha").toLocalDate()));
                }
                return historial;
            }
        }
    }
}
