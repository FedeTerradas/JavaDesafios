package jdbc.clase;

public class Producto {

    private Integer id;
    private String nombre;
    private double precio;
    private int stock;
    private Integer categoriaId;

    public Producto(Integer i, String n, double p, int s, Integer c) {
        id = i;
        nombre = n;
        precio = p;
        stock = s;
        categoriaId = c;
    }

    public Producto(String n, double p, int s, Integer c) {
        this(null, n, p, s, c);
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
}
