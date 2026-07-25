package uy.edu.utu.programacion.service;

import java.time.LocalDate;

import uy.edu.utu.programacion.model.Equipo;
import uy.edu.utu.programacion.model.Persona;

public class Prestamo {
    private Equipo equipo;
    private Persona persona;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionPrevista;
    private LocalDate fechaDevolucionReal;
    private boolean activo;
    private String observaciones;

    public Prestamo(Equipo equipo, Persona persona, LocalDate fechaPrestamo, LocalDate fechaDevolucionPrevista) {
        this.equipo = equipo;
        this.persona = persona;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
        this.fechaDevolucionReal = null;
        this.activo = true;
        this.observaciones = "Préstamo activo en curso.";
    }

    public void finalizarDevolucion(boolean necesitaReparacion, String observaciones) {
        this.fechaDevolucionReal = LocalDate.now();
        this.activo = false;
        this.observaciones = observaciones;
        this.equipo.devolver(necesitaReparacion);
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }

    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    @Override
    public String toString() {
        String estadoPrestamo = activo ? "ACTIVO" : "FINALIZADO (Devuelto el " + fechaDevolucionReal + ")";
        return "Préstamo [" + estadoPrestamo + "]\n" +
               "  - Equipo: " + equipo.getCodigoInventario() + " (" + equipo.getDescripcion() + ")\n" +
               "  - Solicitante: " + persona.getNombre() + " (" + persona.getIdentificador() + ")\n" +
               "  - Fecha Inicio: " + fechaPrestamo + " | Prevista: " + fechaDevolucionPrevista + "\n" +
               "  - Obs: " + observaciones;
    }
}
