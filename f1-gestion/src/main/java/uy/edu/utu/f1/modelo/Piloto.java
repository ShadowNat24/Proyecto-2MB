// Paquete de las entidades del modelo de Fórmula 1.
package uy.edu.utu.f1.modelo;

// Representa la fecha de nacimiento del piloto.
import java.time.LocalDate;
// Permite inicializar la lista de participaciones.
import java.util.ArrayList;
// Interfaz para almacenar las participaciones.
import java.util.List;

// Representa a un piloto de Fórmula 1.
public class Piloto {
    // Código identificador del piloto.
    private int codigo;
    // Nombre completo del piloto.
    private String nombre;
    // País de origen del piloto.
    private String nacionalidad;
    // Fecha de nacimiento.
    private LocalDate fechaNacimiento;

    // Proveedor relacionado con el piloto.
    private Proveedor proveedor;
    // Temporadas en las que participó.
    private List<ParticipacionTemporada> participaciones;

    // Constructor vacío que inicializa la lista de participaciones.
    public Piloto() {
        this.participaciones = new ArrayList<>();
    }

    // Constructor con los datos principales del piloto.
    public Piloto(int codigo, String nombre, String nacionalidad, LocalDate fechaNacimiento) {
        this();
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Devuelve el código del piloto.
    public int getCodigo() { return codigo; }
    // Cambia el código del piloto.
    public void setCodigo(int codigo) { this.codigo = codigo; }

    // Devuelve el nombre.
    public String getNombre() { return nombre; }
    // Cambia el nombre.
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Devuelve la nacionalidad.
    public String getNacionalidad() { return nacionalidad; }
    // Cambia la nacionalidad.
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    // Devuelve la fecha de nacimiento.
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    // Cambia la fecha de nacimiento.
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    // Devuelve el proveedor del piloto.
    public Proveedor getProveedor() { return proveedor; }
    // Asigna un proveedor al piloto.
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }

    // Devuelve las participaciones del piloto.
    public List<ParticipacionTemporada> getParticipaciones() { return participaciones; }
}
