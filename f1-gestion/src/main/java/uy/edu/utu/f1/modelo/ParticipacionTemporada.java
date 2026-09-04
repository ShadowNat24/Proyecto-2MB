package uy.edu.utu.f1.modelo;
import java.util.ArrayList;
import java.util.List;

public class ParticipacionTemporada {
    private int numeroCompetidor;
    
    private Temporada temporada;
    private Auto auto;
    private Piloto piloto;
    private List<Resultado> resultados;

    public ParticipacionTemporada() {
        this.resultados = new ArrayList<>();
    }

    public ParticipacionTemporada(int numeroCompetidor) {
        this();
        this.numeroCompetidor = numeroCompetidor;
    }

    public int getNumeroCompetidor() { return numeroCompetidor; }
    public void setNumeroCompetidor(int numeroCompetidor) { this.numeroCompetidor = numeroCompetidor; }

    public Temporada getTemporada() { return temporada; }
    public void setTemporada(Temporada temporada) { this.temporada = temporada; }

    public Auto getAuto() { return auto; }
    public void setAuto(Auto auto) { this.auto = auto; }

    public Piloto getPiloto() { return piloto; }
    public void setPiloto(Piloto piloto) { this.piloto = piloto; }

    public List<Resultado> getResultados() { return resultados; }
}
