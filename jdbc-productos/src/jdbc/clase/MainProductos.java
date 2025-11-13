package jdbc.clase;

import java.util.List;

public class MainProductos {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE PRODUCTOS Y CATEGORÍAS ===");

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ProductoDAO productoDAO = new ProductoDAO();

        
        /// Comentar y descomentar las acciones del crud
        
        try {
            
            
            /*
            
            // 1️⃣ Insertar Categorías
            System.out.println("\n--- Insertando categorías ---");
            int idCat1 = categoriaDAO.crear(new Categoria("Electrónica"));
            int idCat2 = categoriaDAO.crear(new Categoria("Ropa"));
            int idCat3 = categoriaDAO.crear(new Categoria("Alimentos"));
            System.out.println("Categorías creadas con IDs: " + idCat1 + ", " + idCat2 + ", " + idCat3);

            // 2️⃣ Insertar Productos
            System.out.println("\n--- Insertando productos ---");
            productoDAO.crear(new Producto("Notebook", 1500.00, 10, idCat1));
            productoDAO.crear(new Producto("Campera", 80.00, 5, idCat2));
            productoDAO.crear(new Producto("Yerba Mate", 3.50, 50, idCat3));
            
            */ 
            
            // 3️⃣ Listar Productos con Categoría (JOIN)
            System.out.println("\n--- Listado de productos con categoría ---");
            List<String> productos = productoDAO.listarConCategoria();
            for (String producto : productos) {
                System.out.println(producto);
            }
            
            /*
            
            // 4️⃣ Actualizar un producto
            System.out.println("\n--- Actualizando producto 'Campera' ---");
            Producto pActualizar = new Producto(2, "Campera de Cuero", 120.00, 7, idCat2);
            productoDAO.crear(pActualizar);
            System.out.println("Producto actualizado.");

            // 5️⃣ Eliminar un producto
            System.out.println("\n--- Eliminando producto con ID 3 ---");
            productoDAO.eliminar(3);
            System.out.println("Producto eliminado.");
            
            */

            // 6️⃣ Mostrar estado final
            System.out.println("\n--- Listado final de productos ---");
            productos = productoDAO.listarConCategoria();
            for (String producto : productos) {
                System.out.println(producto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


