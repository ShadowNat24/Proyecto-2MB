package uy.edu.utu.f1.modelo;
import java.util.ArrayList;
import java.util.List;

public class Auto {
    private int id;
    private String modelo;
    private int añoFabricacion;
    
    private Escuderia escuderia;
    private List<ParticipacionTemporada> participaciones;

    public Auto() {
        this.participaciones = new ArrayList<>();
    }

    public Auto(int id, String modelo, int añoFabricacion) {
        this();
        this.id = id;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAñoFabricacion() { return añoFabricacion; }
    public void setAñoFabricacion(int añoFabricacion) { this.añoFabricacion = añoFabricacion; }

    public Escuderia getEscuderia() { return escuderia; }
    public void setEscuderia(Escuderia escuderia) { this.escuderia = escuderia; }

    public List<ParticipacionTemporada> getParticipaciones() { return participaciones; }
}
