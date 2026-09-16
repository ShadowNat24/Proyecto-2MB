// Paquete de las entidades del modelo de Fórmula 1.
package uy.edu.utu.f1.modelo;

// Representa el resultado de un piloto en un gran premio.
public class Resultado {
    // Posición final obtenida.
    private int posicion;
    // Cantidad de vueltas completadas.
    private int vueltasCompletadas;
    // Tiempo promedio o registrado por vuelta.
    private double tiempoPorVuelta;
    // Puntos obtenidos en la carrera.
    private int puntos;

    // Gran premio al que pertenece el resultado.
    private GranPremio granPremio;
    // Participación que obtuvo este resultado.
    private ParticipacionTemporada participacionTemporada;

    // Constructor vacío.
    public Resultado() {
    }

    // Constructor con los datos deportivos del resultado.
    public Resultado(int posicion, int vueltasCompletadas, double tiempoPorVuelta, int puntos) {
        this.posicion = posicion;
        this.vueltasCompletadas = vueltasCompletadas;
        this.tiempoPorVuelta = tiempoPorVuelta;
        this.puntos = puntos;
    }

    // Devuelve la posición final.
    public int getPosicion() { return posicion; }
    // Cambia la posición final.
    public void setPosicion(int posicion) { this.posicion = posicion; }

    // Devuelve las vueltas completadas.
    public int getVueltasCompletadas() { return vueltasCompletadas; }
    // Cambia las vueltas completadas.
    public void setVueltasCompletadas(int vueltasCompletadas) { this.vueltasCompletadas = vueltasCompletadas; }

    // Devuelve el tiempo por vuelta.
    public double getTiempoPorVuelta() { return tiempoPorVuelta; }
    // Cambia el tiempo por vuelta.
    public void setTiempoPorVuelta(double tiempoPorVuelta) { this.tiempoPorVuelta = tiempoPorVuelta; }

    // Devuelve los puntos obtenidos.
    public int getPuntos() { return puntos; }
    // Cambia los puntos obtenidos.
    public void setPuntos(int puntos) { this.puntos = puntos; }

    // Devuelve el gran premio relacionado.
    public GranPremio getGranPremio() { return granPremio; }
    // Asigna el gran premio relacionado.
    public void setGranPremio(GranPremio granPremio) { this.granPremio = granPremio; }

    // Devuelve la participación relacionada.
    public ParticipacionTemporada getParticipacionTemporada() { return participacionTemporada; }
    // Asigna la participación relacionada.
    public void setParticipacionTemporada(ParticipacionTemporada participacionTemporada) { this.participacionTemporada = participacionTemporada; }
}