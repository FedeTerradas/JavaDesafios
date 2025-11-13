package jdbc.clase;

import java.time.LocalDate;

public class calificacion {

    private Integer id;
    private int estudianteId;
    private String materia;
    private double nota;
    private LocalDate fecha;

    public calificacion(Integer i, int e, String m, double n, LocalDate f) {
        id = i;
        estudianteId = e;
        materia = m;
        nota = n;
        fecha = f;
    }

    public calificacion(int e, String m, double n, LocalDate f) {
        this(null, e, m, n, f);
    }

    public Integer getId() {
        return id;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public String getMateria() {
        return materia;
    }

    public double getNota() {
        return nota;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
