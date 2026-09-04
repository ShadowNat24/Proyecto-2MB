package uy.edu.utu.f1.modelo;
public class Resultado {
    private int posicion;
    private int vueltasCompletadas;
    private double tiempoPorVuelta;
    private int puntos;
    
    private GranPremio granPremio;
    private ParticipacionTemporada participacionTemporada;

    public Resultado() {
    }

    public Resultado(int posicion, int vueltasCompletadas, double tiempoPorVuelta, int puntos) {
        this.posicion = posicion;
        this.vueltasCompletadas = vueltasCompletadas;
        this.tiempoPorVuelta = tiempoPorVuelta;
        this.puntos = puntos;
    }

    public int getPosicion() { return posicion; }
    public void setPosicion(int posicion) { this.posicion = posicion; }

    public int getVueltasCompletadas() { return vueltasCompletadas; }
    public void setVueltasCompletadas(int vueltasCompletadas) { this.vueltasCompletadas = vueltasCompletadas; }

    public double getTiempoPorVuelta() { return tiempoPorVuelta; }
    public void setTiempoPorVuelta(double tiempoPorVuelta) { this.tiempoPorVuelta = tiempoPorVuelta; }

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    public GranPremio getGranPremio() { return granPremio; }
    public void setGranPremio(GranPremio granPremio) { this.granPremio = granPremio; }

    public ParticipacionTemporada getParticipacionTemporada() { return participacionTemporada; }
    public void setParticipacionTemporada(ParticipacionTemporada participacionTemporada) { this.participacionTemporada = participacionTemporada; }
}