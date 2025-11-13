package jdbc.clase;

import java.sql.*;
import java.util.*;

public class LibroDAO {

    public int crear(Libro l) throws SQLException {
        String sql = "INSERT INTO libros (titulo,autor,año_publicacion,isbn,disponible) VALUES (?,?,?,?,?)";
        try (Connection c = dbConexion.getConnection(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            if (l.getAnioPublicacion() == null) {
                ps.setNull(3, Types.INTEGER);
            } else {
                ps.setInt(3, l.getAnioPublicacion());
            }
            ps.setString(4, l.getIsbn());
            ps.setBoolean(5, l.isDisponible());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }

    public int actualizar(Libro l) throws SQLException {
        String sql = "UPDATE libros SET titulo=?,autor=?,año_publicacion=?,isbn=?,disponible=? WHERE id=?";
        try (Connection c = dbConexion.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            if (l.getAnioPublicacion() == null) {
                ps.setNull(3, Types.INTEGER);
            } else {
                ps.setInt(3, l.getAnioPublicacion());
            }
            ps.setString(4, l.getIsbn());
            ps.setBoolean(5, l.isDisponible());
            ps.setInt(6, l.getId());
            return ps.executeUpdate();
        }
    }

    public int eliminar(int id) throws SQLException {
        try (Connection c = dbConexion.getConnection(); PreparedStatement ps = c.prepareStatement("DELETE FROM libros WHERE id=?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }

    private Libro map(ResultSet rs) throws SQLException {
        return new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"),
                (Integer) (rs.getObject("año_publicacion") == null ? null : rs.getInt("año_publicacion")),
                rs.getString("isbn"), rs.getBoolean("disponible"));
    }

    public java.util.Optional<Libro> obtenerPorId(int id) throws SQLException {
        try (Connection c = dbConexion.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM libros WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? java.util.Optional.of(map(rs)) : java.util.Optional.empty();
            }
        }
    }

    public java.util.List<Libro> listarTodos() throws SQLException {
        try (Connection c = dbConexion.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM libros ORDER BY titulo"); ResultSet rs = ps.executeQuery()) {
            java.util.List<Libro> out = new java.util.ArrayList<>();
            while (rs.next()) {
                out.add(map(rs));
            }
            return out;
        }
    }

    public java.util.List<Libro> buscarPorAutor(String q) throws SQLException {
        String sql = "SELECT * FROM libros WHERE autor LIKE ? ORDER BY titulo";
        try (Connection c = dbConexion.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + q + "%");
            try (ResultSet rs = ps.executeQuery()) {
                java.util.List<Libro> out = new java.util.ArrayList<>();
                while (rs.next()) {
                    out.add(map(rs));
                }
                return out;
            }
        }
    }

    public java.util.List<Libro> listarDisponibles() throws SQLException {
        try (Connection c = dbConexion.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM libros WHERE disponible=1 ORDER BY titulo"); ResultSet rs = ps.executeQuery()) {
            java.util.List<Libro> out = new java.util.ArrayList<>();
            while (rs.next()) {
                out.add(map(rs));
            }
            return out;
        }
    }
}
