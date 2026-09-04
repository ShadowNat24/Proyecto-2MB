package uy.edu.utu.f1.main;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear entidades de prueba
        Temporada temp2026 = new Temporada(2026);
        Piloto piloto1 = new Piloto(101, "Franco Colapinto", "Argentina", LocalDate.of(2003, 5, 27));
        Auto auto1 = new Auto(1, "FW46", 2026);
        Escuderia escuderia = new Escuderia(1, "Williams Racing");

        // Vincular relaciones
        ParticipacionTemporada participacion = new ParticipacionTemporada(43);
        participacion.setTemporada(temp2026);
        participacion.setPiloto(piloto1);
        participacion.setAuto(auto1);

        // Verificación en consola
        System.out.println("PRUEBA DEL MODELO F1");
        System.out.println("Temporada: " + participacion.getTemporada().getAño());
        System.out.println("Piloto: " + participacion.getPiloto().getNombre());
        System.out.println("Auto asignado: " + participacion.getAuto().getModelo());
        System.out.println("Número de Competidor: " + participacion.getNumeroCompetidor());
    }
}
