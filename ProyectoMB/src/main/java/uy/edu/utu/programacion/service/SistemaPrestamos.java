package uy.edu.utu.programacion.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import uy.edu.utu.programacion.model.Equipo;
import uy.edu.utu.programacion.model.Persona;

public class SistemaPrestamos {
    private List<Equipo> equipos;
    private List<Persona> personas;
    private List<Prestamo> prestamos;

    public SistemaPrestamos() {
        this.equipos = new ArrayList<>();
        this.personas = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void registrarEquipo(Equipo equipo) {
        if (buscarEquipo(equipo.getCodigoInventario()) != null) {
            System.out.println(" ERROR: Ya existe un equipo con el código " + equipo.getCodigoInventario());
            return;
        }
        equipos.add(equipo);
        System.out.println("✔ Equipo registrado con éxito: " + equipo.getCodigoInventario());
    }

    public void registrarPersona(Persona persona) {
        if (buscarPersona(persona.getIdentificador()) != null) {
            System.out.println(" ERROR: Ya existe una persona con el ID " + persona.getIdentificador());
            return;
        }
        personas.add(persona);
        System.out.println("✔ Persona registrada con éxito: " + persona.getNombre());
    }

    public Equipo buscarEquipo(String codigoInventario) {
        for (Equipo e : equipos) {
            if (e.getCodigoInventario().equalsIgnoreCase(codigoInventario)) {
                return e;
            }
        }
        return null;
    }

    public Persona buscarPersona(String identificador) {
        for (Persona p : personas) {
            if (p.getIdentificador().equalsIgnoreCase(identificador)) {
                return p;
            }
        }
        return null;
    }

    public boolean realizarPrestamo(String codigoEquipo, String idPersona, int diasDuracion) {
        Equipo equipo = buscarEquipo(codigoEquipo);
        if (equipo == null) {
            System.out.println(" OPERACIÓN DENEGADA: El equipo " + codigoEquipo + " no existe.");
            return false;
        }

        Persona persona = buscarPersona(idPersona);
        if (persona == null) {
            System.out.println(" OPERACIÓN DENEGADA: La persona con ID " + idPersona + " no existe.");
            return false;
        }

        if (!equipo.esPrestable()) {
            System.out.println(" OPERACIÓN DENEGADA: El equipo " + codigoEquipo + " no se encuentra disponible (Ocupado o En Reparación).");
            return false;
        }

        equipo.prestar();

        LocalDate inicio = LocalDate.now();
        LocalDate prevista = inicio.plusDays(diasDuracion);

        Prestamo nuevoPrestamo = new Prestamo(equipo, persona, inicio, prevista);
        prestamos.add(nuevoPrestamo);

        System.out.println(" PRÉSTAMO CONCRETADO: Equipo " + codigoEquipo + " asignado a " + persona.getNombre() + " hasta el " + prevista);
        return true;
    }

    public boolean registrarDevolucion(String codigoEquipo, boolean necesitaReparacion, String observaciones) {
        Prestamo prestamoActivo = null;
        for (Prestamo p : prestamos) {
            if (p.isActivo() && p.getEquipo().getCodigoInventario().equalsIgnoreCase(codigoEquipo)) {
                prestamoActivo = p;
                break;
            }
        }

        if (prestamoActivo == null) {
            System.out.println(" OPERACIÓN DENEGADA: No hay un préstamo activo registrado para el equipo " + codigoEquipo);
            return false;
        }

        prestamoActivo.finalizarDevolucion(necesitaReparacion, observaciones);
        System.out.println(" DEVOLUCIÓN REGISTRADA: Equipo " + codigoEquipo + " procesado correctamente. Nuevo Estado: " + prestamoActivo.getEquipo().getEstado());
        return true;
    }

    public void listarEquiposDisponibles() {
        System.out.println("\n--- LISTADO DE EQUIPOS DISPONIBLES ---");
        boolean hayDisponibles = false;
        for (Equipo e : equipos) {
            if (e.esPrestable()) {
                System.out.println(e);
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("(No hay equipos disponibles en este momento)");
        }
    }

    public void listarHistorial() {
        System.out.println("\n--- HISTORIAL COMPLETO DE PRÉSTAMOS ---");
        if (prestamos.isEmpty()) {
            System.out.println("(El historial de préstamos se encuentra vacío)");
            return;
        }
        for (Prestamo p : prestamos) {
            System.out.println(p);
            System.out.println("------------------------------------------------");
        }
    }
}
