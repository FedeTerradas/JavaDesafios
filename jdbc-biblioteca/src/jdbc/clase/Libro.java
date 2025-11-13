package jdbc.clase;

public class Libro {

    private Integer id;
    private String titulo;
    private String autor;
    private Integer anioPublicacion;
    private String isbn;
    private boolean disponible;

    public Libro(Integer id, String t, String a, Integer anio, String i, boolean d) {
        this.id = id;
        this.titulo = t;
        this.autor = a;
        this.anioPublicacion = anio;
        this.isbn = i;
        this.disponible = d;
    }

    public Libro(String t, String a, Integer anio, String i, boolean d) {
        this(null, t, a, anio, i, d);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String v) {
        this.titulo = v;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String v) {
        this.autor = v;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer v) {
        this.anioPublicacion = v;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String v) {
        this.isbn = v;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean v) {
        this.disponible = v;
    }
}
