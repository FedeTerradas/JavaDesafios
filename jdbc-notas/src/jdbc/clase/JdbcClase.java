package jdbc.clase;

import java.time.LocalDate;

public class JdbcClase {

    public static void main(String[] args) {
        try {
            estudianteDAO eDao = new estudianteDAO();
            calificacionDAO cDao = new calificacionDAO();

            // Crear estudiante
            estudiante est1 = new estudiante("Ana Gómez", "Perez", "ana.gomez@mail.com", 22);
            int estId = eDao.crear(est1);  // Asegúrate de que este valor no sea 0
            if (estId == 0) {
                System.out.println("No se pudo crear el estudiante");
                return;  // Salir si no se puede crear el estudiante
            }

            System.out.println("Estudiante creado con ID: " + estId);

            // Registrar calificaciones
            cDao.registrar(new calificacion(estId, "Matemáticas", 9.5, LocalDate.now().minusDays(1)));
            cDao.registrar(new calificacion(estId, "Historia", 8.0, LocalDate.now()));

            // Calcular promedio
            double promedio = cDao.promedioDe(estId);
            System.out.println("Promedio de calificaciones: " + promedio);

            // Mostrar historial de calificaciones
            System.out.println("--- Historial de calificaciones ---");
            for (calificacion c : cDao.historial(estId)) {
                System.out.println(c.getMateria() + ": " + c.getNota() + " - " + c.getFecha());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
