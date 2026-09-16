// Paquete de las entidades del modelo de Fórmula 1.
package uy.edu.utu.f1.modelo;

// Permite inicializar las listas de escuderías y pilotos.
import java.util.ArrayList;
// Interfaz para almacenar escuderías y pilotos.
import java.util.List;

// Representa un proveedor o representante relacionado con el campeonato.
public class Proveedor {
    // Identificador del proveedor.
    private int id;
    // Nombre del proveedor.
    private String nombre;
    // Correo electrónico de contacto.
    private String emailContacto;

    // Escuderías relacionadas con el proveedor.
    private List<Escuderia> escuderias;
    // Pilotos relacionados con el proveedor.
    private List<Piloto> pilotos;

    // Constructor vacío que inicializa las listas de relaciones.
    public Proveedor() {
        this.escuderias = new ArrayList<>();
        this.pilotos = new ArrayList<>();
    }

    // Constructor con los datos principales del proveedor.
    public Proveedor(int id, String nombre, String emailContacto) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.emailContacto = emailContacto;
    }

    // Devuelve el identificador.
    public int getId() { return id; }
    // Cambia el identificador.
    public void setId(int id) { this.id = id; }

    // Devuelve el nombre.
    public String getNombre() { return nombre; }
    // Cambia el nombre.
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Devuelve el correo de contacto.
    public String getEmailContacto() { return emailContacto; }
    // Cambia el correo de contacto.
    public void setEmailContacto(String emailContacto) { this.emailContacto = emailContacto; }

    // Devuelve las escuderías relacionadas.
    public List<Escuderia> getEscuderias() { return escuderias; }
    // Devuelve los pilotos relacionados.
    public List<Piloto> getPilotos() { return pilotos; }
}