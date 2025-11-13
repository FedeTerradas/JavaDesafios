package jdbc.clase;

public class estudiante {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private int edad;

    // Constructor para id y nombre (ajustado a lo que estás usando en listar)
    public estudiante(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Constructor completo (para otros casos donde necesites más datos)
    public estudiante(Integer id, String nombre, String apellido, String email, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
    }
       // Constructor con los 4 parámetros: nombre, apellido, email y edad
    public estudiante(String nombre, String apellido, String email, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
     public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
     
    public String getEmail() {
        return email;
    }
      
    public void setEmail(String email) {
        this.email = email;
    }
    
        public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
      
      
     

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

