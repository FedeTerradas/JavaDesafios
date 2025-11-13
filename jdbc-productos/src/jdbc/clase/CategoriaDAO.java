package jdbc.clase;

import java.sql.*;
import java.util.*;

public class CategoriaDAO {

    public int crear(Categoria c) throws SQLException {
        // Verificar si la categoría ya existe
        String checkSql = "SELECT id FROM categorias WHERE nombre = ?";
        try (Connection cn = dbConexion.getConnection(); PreparedStatement ps = cn.prepareStatement(checkSql)) {
            ps.setString(1, c.getNombre());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Si la categoría existe, devolver su id
                return rs.getInt("id");
            }
        }

        // Si no existe, insertarla
        String insertSql = "INSERT INTO categorias(nombre) VALUES(?)";
        try (Connection cn = dbConexion.getConnection(); PreparedStatement ps = cn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getNombre());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }

    public java.util.List<Categoria> listar() throws SQLException {
        try (Connection cn = dbConexion.getConnection(); PreparedStatement ps = cn.prepareStatement("SELECT * FROM categorias ORDER BY nombre"); ResultSet rs = ps.executeQuery()) {
            java.util.List<Categoria> r = new java.util.ArrayList<>();
            while (rs.next()) {
                r.add(new Categoria(rs.getInt("id"), rs.getString("nombre")));
            }
            return r;
        }
    }
}
