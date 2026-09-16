// Paquete de las entidades del modelo de Fórmula 1.
package uy.edu.utu.f1.modelo;

// Permite crear la lista de participaciones del auto.
import java.util.ArrayList;
// Interfaz usada para almacenar varias participaciones.
import java.util.List;

// Representa un auto de competición.
public class Auto {
    // Identificador único del auto.
    private int id;
    // Modelo o nombre comercial del auto.
    private String modelo;
    // Año en que fue fabricado.
    private int añoFabricacion;

    // Escudería a la que pertenece el auto.
    private Escuderia escuderia;
    // Participaciones del auto en distintas temporadas.
    private List<ParticipacionTemporada> participaciones;

    // Constructor vacío que inicializa la lista de participaciones.
    public Auto() {
        this.participaciones = new ArrayList<>();
    }

    // Constructor que crea un auto con sus datos principales.
    public Auto(int id, String modelo, int añoFabricacion) {
        this();
        this.id = id;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
    }

    // Devuelve el identificador del auto.
    public int getId() { return id; }
    // Cambia el identificador del auto.
    public void setId(int id) { this.id = id; }

    // Devuelve el modelo del auto.
    public String getModelo() { return modelo; }
    // Cambia el modelo del auto.
    public void setModelo(String modelo) { this.modelo = modelo; }

    // Devuelve el año de fabricación.
    public int getAñoFabricacion() { return añoFabricacion; }
    // Cambia el año de fabricación.
    public void setAñoFabricacion(int añoFabricacion) { this.añoFabricacion = añoFabricacion; }

    // Devuelve la escudería relacionada.
    public Escuderia getEscuderia() { return escuderia; }
    // Asigna una escudería al auto.
    public void setEscuderia(Escuderia escuderia) { this.escuderia = escuderia; }

    // Devuelve la lista de participaciones del auto.
    public List<ParticipacionTemporada> getParticipaciones() { return participaciones; }
}
