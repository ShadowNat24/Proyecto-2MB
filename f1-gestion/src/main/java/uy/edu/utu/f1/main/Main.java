// Paquete que contiene la clase de inicio de la aplicación.
package uy.edu.utu.f1.main;

// Importa las clases del modelo que se utilizan en la prueba.
import uy.edu.utu.f1.modelo.Auto;
import uy.edu.utu.f1.modelo.Escuderia;
import uy.edu.utu.f1.modelo.ParticipacionTemporada;
import uy.edu.utu.f1.modelo.Piloto;
import uy.edu.utu.f1.modelo.Temporada;
// Permite representar la fecha de nacimiento del piloto.
import java.time.LocalDate;

// Clase principal desde la que se ejecuta el programa.
public class Main {
    // Punto de entrada de la aplicación Java.
    public static void main(String[] args) {
        // Crea una temporada, un piloto, un auto y una escudería de prueba.
        Temporada temp2026 = new Temporada(2026);
        Piloto piloto1 = new Piloto(101, "Franco Colapinto", "Argentina", LocalDate.of(2003, 5, 27));
        Auto auto1 = new Auto(1, "FW46", 2026);
        Escuderia escuderia = new Escuderia(1, "Williams Racing");

        // Crea una participación y la relaciona con sus entidades.
        ParticipacionTemporada participacion = new ParticipacionTemporada(43);
        participacion.setTemporada(temp2026);
        participacion.setPiloto(piloto1);
        participacion.setAuto(auto1);

        // Muestra en consola los datos guardados en la participación.
        System.out.println("PRUEBA DEL MODELO F1");
        System.out.println("Temporada: " + participacion.getTemporada().getAño());
        System.out.println("Piloto: " + participacion.getPiloto().getNombre());
        System.out.println("Auto asignado: " + participacion.getAuto().getModelo());
        System.out.println("Número de Competidor: " + participacion.getNumeroCompetidor());
    }
}
