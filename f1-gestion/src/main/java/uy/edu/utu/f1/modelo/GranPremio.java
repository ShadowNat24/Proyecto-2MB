package uy.edu.utu.f1.modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GranPremio {
    private int id;
    private String nombre;
    private LocalDate fecha;
    
    private Temporada temporada;
    private Circuito circuito;
    private List<Resultado> resultados;

    public GranPremio() {
        this.resultados = new ArrayList<>();
    }

    public GranPremio(int id, String nombre, LocalDate fecha) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Temporada getTemporada() { return temporada; }
    public void setTemporada(Temporada temporada) { this.temporada = temporada; }

    public Circuito getCircuito() { return circuito; }
    public void setCircuito(Circuito circuito) { this.circuito = circuito; }

    public List<Resultado> getResultados() { return resultados; }
}