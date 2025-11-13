package jdbc.clase;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class MainBiblioteca {

    private static Scanner scanner = new Scanner(System.in);
    private static LibroDAO libroDAO = new LibroDAO();

    public static void main(String[] args) {
        System.out.println("Biblioteca: Sistema de gestión de libros");

        while (true) {
            System.out.println("\n1. Crear libro");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Actualizar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    actualizarLibro();
                    break;
                case 4:
                    eliminarLibro();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void crearLibro() {
        System.out.println("\nCrear libro:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Año de publicación: ");
        Integer anioPublicacion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("¿Disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();

        Libro libro = new Libro(titulo, autor, anioPublicacion, isbn, disponible);
        try {
            int id = libroDAO.crear(libro);
            System.out.println("Libro creado con ID: " + id);
        } catch (SQLException e) {
            System.out.println("Error al crear el libro: " + e.getMessage());
        }
    }

    private static void listarLibros() {
        System.out.println("\nListando libros:");
        try {
            List<Libro> libros = libroDAO.listarTodos();
            if (libros.isEmpty()) {
                System.out.println("No hay libros en la base de datos.");
            } else {
                for (Libro libro : libros) {
                    System.out.println("ID: " + libro.getId() + ", Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los libros: " + e.getMessage());
        }
    }

    private static void actualizarLibro() {
        System.out.println("\nActualizar libro:");
        System.out.print("ID del libro a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Nuevo título: ");
        String titulo = scanner.nextLine();
        System.out.print("Nuevo autor: ");
        String autor = scanner.nextLine();
        System.out.print("Nuevo año de publicación: ");
        Integer anioPublicacion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Nuevo ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("¿Disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();

        Libro libro = new Libro(id, titulo, autor, anioPublicacion, isbn, disponible);
        try {
            int filasActualizadas = libroDAO.actualizar(libro);
            if (filasActualizadas > 0) {
                System.out.println("Libro actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un libro con ese ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el libro: " + e.getMessage());
        }
    }

    private static void eliminarLibro() {
        System.out.println("\nEliminar libro:");
        System.out.print("ID del libro a eliminar: ");
        int id = scanner.nextInt();
        try {
            int filasEliminadas = libroDAO.eliminar(id);
            if (filasEliminadas > 0) {
                System.out.println("Libro eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un libro con ese ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro: " + e.getMessage());
        }
    }
}
