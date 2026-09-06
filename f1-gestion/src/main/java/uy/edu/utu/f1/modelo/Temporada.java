// Paquete de las entidades del modelo de Fórmula 1.
package uy.edu.utu.f1.modelo;

// Permite inicializar las listas de la temporada.
import java.util.ArrayList;
// Interfaz para almacenar carreras y participaciones.
import java.util.List;

// Representa una temporada del campeonato.
public class Temporada {
    // Año de la temporada.
    private int año;

    // Grandes premios incluidos en la temporada.
    private List<GranPremio> grandesPremios;
    // Pilotos y autos que participan en la temporada.
    private List<ParticipacionTemporada> participaciones;

    // Constructor vacío que inicializa las listas de relaciones.
    public Temporada() {
        this.grandesPremios = new ArrayList<>();
        this.participaciones = new ArrayList<>();
    }

    // Constructor que crea una temporada para un año específico.
    public Temporada(int año) {
        this();
        this.año = año;
    }

    // Devuelve el año de la temporada.
    public int getAño() { return año; }
    // Cambia el año de la temporada.
    public void setAño(int año) { this.año = año; }

    // Devuelve los grandes premios de la temporada.
    public List<GranPremio> getGrandesPremios() { return grandesPremios; }
    // Devuelve las participaciones de la temporada.
    public List<ParticipacionTemporada> getParticipaciones() { return participaciones; }
}