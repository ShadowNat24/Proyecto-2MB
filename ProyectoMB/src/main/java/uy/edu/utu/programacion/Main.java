package uy.edu.utu.programacion;

import uy.edu.utu.programacion.model.Camara;
import uy.edu.utu.programacion.model.Equipo;
import uy.edu.utu.programacion.model.Notebook;
import uy.edu.utu.programacion.model.Persona;
import uy.edu.utu.programacion.model.Proyector;
import uy.edu.utu.programacion.service.SistemaPrestamos;

public class Main {
    public static void main(String[] args) {
        SistemaPrestamos sistema = new SistemaPrestamos();

        Equipo notebook = new Notebook("NB001", "Notebook HP ProBook 450", "Operativo", 16, "Windows 11");
        Equipo proyector = new Proyector("PR001", "Proyector Epson PowerLite", "Operativo", "1920x1080", 3600);
        Equipo camara = new Camara("CAM01", "Cámara Canon EOS Rebel", "Operativo", "24.1 MP", "SDHC 64GB");

        Persona p1 = new Persona("PER01", "María Rodríguez", "Docente de Informática", "mrodriguez@utu.edu.uy");
        Persona p2 = new Persona("PER02", "Juan Pérez", "Estudiante 3er Año", "jperez@estudiantes.utu.edu.uy");

        sistema.registrarEquipo(notebook);
        sistema.registrarEquipo(proyector);
        sistema.registrarEquipo(camara);

        sistema.registrarPersona(p1);
        sistema.registrarPersona(p2);

        sistema.listarEquiposDisponibles();
        sistema.realizarPrestamo("NB001", "PER01", 7);
        sistema.realizarPrestamo("NB001", "PER02", 3);
        sistema.registrarDevolucion("NB001", false, "Equipo entregado en excelentes condiciones.");
        sistema.realizarPrestamo("PR001", "PER02", 2);
        sistema.registrarDevolucion("PR001", true, "Lámpara con parpadeo; requiere revisión técnica.");
        sistema.realizarPrestamo("PR001", "PER01", 5);
        sistema.listarHistorial();
    }
}
