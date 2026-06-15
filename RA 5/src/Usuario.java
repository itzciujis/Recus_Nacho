import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private int edad;
    private String correo;
    private String dni;
    private String telefono;

    public Usuario(String nombre, int edad, String correo,
                   String dni, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }
    public String toString() {
        return "Nombre: " + nombre +
                ", Edad: " + edad +
                ", Correo: " + correo +
                ", DNI: " + dni +
                ", Teléfono: " + telefono;
    }
}