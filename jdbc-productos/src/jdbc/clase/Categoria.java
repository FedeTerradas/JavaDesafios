package jdbc.clase;

public class Categoria {

    private Integer id;
    private String nombre;

    public Categoria(Integer i, String n) {
        id = i;
        nombre = n;
    }

    public Categoria(String n) {
        this(null, n);
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
