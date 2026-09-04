package uy.edu.utu.f1.modelo;
import java.util.ArrayList;
import java.util.List;

public class Circuito {
    private int id;
    private String nombre;
    private String pais;
    private double longitudPista;
    private int vueltas;
    
    private List<GranPremio> grandesPremios;

    public Circuito() {
        this.grandesPremios = new ArrayList<>();
    }

    public Circuito(int id, String nombre, String pais, double longitudPista, int vueltas) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.longitudPista = longitudPista;
        this.vueltas = vueltas;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public double getLongitudPista() { return longitudPista; }
    public void setLongitudPista(double longitudPista) { this.longitudPista = longitudPista; }

    public int getVueltas() { return vueltas; }
    public void setVueltas(int vueltas) { this.vueltas = vueltas; }

    public List<GranPremio> getGrandesPremios() { return grandesPremios; }
}
