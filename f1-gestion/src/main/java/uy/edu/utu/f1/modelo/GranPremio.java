// Paquete de las entidades del modelo de Fórmula 1.
package uy.edu.utu.f1.modelo;

// Representa la fecha del gran premio.
import java.time.LocalDate;
// Permite inicializar la lista de resultados.
import java.util.ArrayList;
// Interfaz para almacenar los resultados.
import java.util.List;

// Representa una carrera o gran premio.
public class GranPremio {
    // Identificador de la carrera.
    private int id;
    // Nombre de la carrera.
    private String nombre;
    // Fecha en que se disputa.
    private LocalDate fecha;

    // Temporada a la que pertenece la carrera.
    private Temporada temporada;
    // Circuito donde se realiza.
    private Circuito circuito;
    // Resultados obtenidos por los participantes.
    private List<Resultado> resultados;

    // Constructor vacío que inicializa la lista de resultados.
    public GranPremio() {
        this.resultados = new ArrayList<>();
    }

    // Constructor con los datos principales de la carrera.
    public GranPremio(int id, String nombre, LocalDate fecha) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    // Devuelve el identificador.
    public int getId() { return id; }
    // Cambia el identificador.
    public void setId(int id) { this.id = id; }

    // Devuelve el nombre.
    public String getNombre() { return nombre; }
    // Cambia el nombre.
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Devuelve la fecha.
    public LocalDate getFecha() { return fecha; }
    // Cambia la fecha.
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    // Devuelve la temporada relacionada.
    public Temporada getTemporada() { return temporada; }
    // Asigna la temporada.
    public void setTemporada(Temporada temporada) { this.temporada = temporada; }

    // Devuelve el circuito relacionado.
    public Circuito getCircuito() { return circuito; }
    // Asigna el circuito.
    public void setCircuito(Circuito circuito) { this.circuito = circuito; }

    // Devuelve la lista de resultados.
    public List<Resultado> getResultados() { return resultados; }
}