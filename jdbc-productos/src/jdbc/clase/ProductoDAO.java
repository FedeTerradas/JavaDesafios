package jdbc.clase;

import java.sql.*;

public class ProductoDAO {

    public int crear(Producto p) throws SQLException {
        // Verificar si el producto ya existe (por nombre o por combinación de datos únicos)
        String checkSql = "SELECT id FROM productos WHERE nombre = ?";
        try (Connection cn = dbConexion.getConnection(); PreparedStatement ps = cn.prepareStatement(checkSql)) {
            ps.setString(1, p.getNombre());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Si el producto ya existe, devolver su id
                return rs.getInt("id");
            }
        }

        // Si no existe, insertar el producto
        String sql = "INSERT INTO productos(nombre, precio, stock, categoria_id) VALUES(?,?,?,?)";
        try (Connection cn = dbConexion.getConnection(); PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            if (p.getCategoriaId() == null) {
                ps.setNull(4, Types.INTEGER);
            } else {
                ps.setInt(4, p.getCategoriaId());
            }
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        }
    }

    // Método para eliminar un producto por ID
    public boolean eliminar(int productoId) throws SQLException {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection cn = dbConexion.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, productoId);  // Establecer el ID del producto que se va a eliminar
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;  // Retorna true si se eliminó un registro
        }
    }

    public java.util.List<String> listarConCategoria() throws SQLException {
        String sql = "SELECT p.id,p.nombre,p.precio,p.stock,COALESCE(c.nombre,'(sin categoría)') AS categoria FROM productos p LEFT JOIN categorias c ON c.id=p.categoria_id ORDER BY p.nombre";
        try (Connection cn = dbConexion.getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            java.util.List<String> out = new java.util.ArrayList<>();
            while (rs.next()) {
                out.add(String.format("%d | %s | $%.2f | stock %d | %s", rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("stock"), rs.getString("categoria")));
            }
            return out;
        }
    }
}
