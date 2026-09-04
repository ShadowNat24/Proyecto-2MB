package uy.edu.utu.f1.modelo;
import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private int año;
    
    private List<GranPremio> grandesPremios;
    private List<ParticipacionTemporada> participaciones;

    public Temporada() {
        this.grandesPremios = new ArrayList<>();
        this.participaciones = new ArrayList<>();
    }

    public Temporada(int año) {
        this();
        this.año = año;
    }

    public int getAño() { return año; }
    public void setAño(int año) { this.año = año; }

    public List<GranPremio> getGrandesPremios() { return grandesPremios; }
    public List<ParticipacionTemporada> getParticipaciones() { return participaciones; }
}