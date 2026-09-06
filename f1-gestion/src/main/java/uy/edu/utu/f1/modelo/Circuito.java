// Paquete de las entidades del modelo de Fórmula 1.
package uy.edu.utu.f1.modelo;

// Permite inicializar la lista de grandes premios.
import java.util.ArrayList;
// Interfaz para almacenar los grandes premios del circuito.
import java.util.List;

// Representa un circuito de carreras.
public class Circuito {
    // Identificador del circuito.
    private int id;
    // Nombre del circuito.
    private String nombre;
    // País donde está ubicado.
    private String pais;
    // Longitud de la pista en kilómetros.
    private double longitudPista;
    // Cantidad de vueltas de una carrera.
    private int vueltas;

    // Grandes premios disputados en este circuito.
    private List<GranPremio> grandesPremios;

    // Constructor vacío que prepara la lista de grandes premios.
    public Circuito() {
        this.grandesPremios = new ArrayList<>();
    }

    // Constructor con los datos principales del circuito.
    public Circuito(int id, String nombre, String pais, double longitudPista, int vueltas) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.longitudPista = longitudPista;
        this.vueltas = vueltas;
    }

    // Devuelve el identificador.
    public int getId() { return id; }
    // Cambia el identificador.
    public void setId(int id) { this.id = id; }

    // Devuelve el nombre.
    public String getNombre() { return nombre; }
    // Cambia el nombre.
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Devuelve el país.
    public String getPais() { return pais; }
    // Cambia el país.
    public void setPais(String pais) { this.pais = pais; }

    // Devuelve la longitud de la pista.
    public double getLongitudPista() { return longitudPista; }
    // Cambia la longitud de la pista.
    public void setLongitudPista(double longitudPista) { this.longitudPista = longitudPista; }

    // Devuelve la cantidad de vueltas.
    public int getVueltas() { return vueltas; }
    // Cambia la cantidad de vueltas.
    public void setVueltas(int vueltas) { this.vueltas = vueltas; }

    // Devuelve los grandes premios realizados en el circuito.
    public List<GranPremio> getGrandesPremios() { return grandesPremios; }
}
