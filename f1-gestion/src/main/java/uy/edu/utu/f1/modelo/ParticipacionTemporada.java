// Paquete de las entidades del modelo de Fórmula 1.
package uy.edu.utu.f1.modelo;

// Permite inicializar la lista de resultados.
import java.util.ArrayList;
// Interfaz para almacenar varios resultados.
import java.util.List;

// Representa la participación de un piloto y un auto en una temporada.
public class ParticipacionTemporada {
    // Número con el que compite el piloto.
    private int numeroCompetidor;

    // Temporada en la que participa.
    private Temporada temporada;
    // Auto utilizado durante la temporada.
    private Auto auto;
    // Piloto que participa.
    private Piloto piloto;
    // Resultados obtenidos durante la temporada.
    private List<Resultado> resultados;

    // Constructor vacío que inicializa la lista de resultados.
    public ParticipacionTemporada() {
        this.resultados = new ArrayList<>();
    }

    // Constructor que asigna el número del competidor.
    public ParticipacionTemporada(int numeroCompetidor) {
        this();
        this.numeroCompetidor = numeroCompetidor;
    }

    // Devuelve el número del competidor.
    public int getNumeroCompetidor() { return numeroCompetidor; }
    // Cambia el número del competidor.
    public void setNumeroCompetidor(int numeroCompetidor) { this.numeroCompetidor = numeroCompetidor; }

    // Devuelve la temporada.
    public Temporada getTemporada() { return temporada; }
    // Asigna la temporada.
    public void setTemporada(Temporada temporada) { this.temporada = temporada; }

    // Devuelve el auto utilizado.
    public Auto getAuto() { return auto; }
    // Asigna el auto utilizado.
    public void setAuto(Auto auto) { this.auto = auto; }

    // Devuelve el piloto participante.
    public Piloto getPiloto() { return piloto; }
    // Asigna el piloto participante.
    public void setPiloto(Piloto piloto) { this.piloto = piloto; }

    // Devuelve los resultados de la participación.
    public List<Resultado> getResultados() { return resultados; }
}
