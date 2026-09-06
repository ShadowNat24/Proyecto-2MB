// Paquete de las entidades del modelo de Fórmula 1.
package uy.edu.utu.f1.modelo;

// Permite crear la lista de autos.
import java.util.ArrayList;
// Interfaz para almacenar los autos de la escudería.
import java.util.List;

// Representa una escudería de Fórmula 1.
public class Escuderia {
    // Identificador de la escudería.
    private int id;
    // Nombre de la escudería.
    private String nombre;

    // Proveedor relacionado con la escudería.
    private Proveedor proveedor;
    // Autos que pertenecen a la escudería.
    private List<Auto> autos;

    // Constructor vacío que inicializa la lista de autos.
    public Escuderia() {
        this.autos = new ArrayList<>();
    }

    // Constructor con los datos principales de la escudería.
    public Escuderia(int id, String nombre) {
        this();
        this.id = id;
        this.nombre = nombre;
    }

    // Devuelve el identificador.
    public int getId() { return id; }
    // Cambia el identificador.
    public void setId(int id) { this.id = id; }

    // Devuelve el nombre.
    public String getNombre() { return nombre; }
    // Cambia el nombre.
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Devuelve el proveedor relacionado.
    public Proveedor getProveedor() { return proveedor; }
    // Asigna un proveedor a la escudería.
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }

    // Devuelve los autos de la escudería.
    public List<Auto> getAutos() { return autos; }
}