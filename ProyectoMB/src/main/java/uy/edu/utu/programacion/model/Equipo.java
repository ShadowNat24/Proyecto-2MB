package uy.edu.utu.programacion.model;

public abstract class Equipo {
    private String codigoInventario;
    private String descripcion;
    private String estado;
    private boolean disponible;

    public Equipo(String codigoInventario, String descripcion, String estado) {
        this.codigoInventario = codigoInventario;
        this.descripcion = descripcion;
        this.estado = estado;
        this.disponible = true;
    }

    public boolean esPrestable() {
        return this.disponible && !this.estado.equalsIgnoreCase("En Reparación");
    }

    public void prestar() {
        if (!esPrestable()) {
            throw new IllegalStateException("El equipo no se encuentra disponible para préstamo.");
        }
        this.disponible = false;
    }

    public void devolver(boolean necesitaReparacion) {
        if (necesitaReparacion) {
            this.estado = "En Reparación";
            this.disponible = false;
        } else {
            this.estado = "Operativo";
            this.disponible = true;
        }
    }

    public String getCodigoInventario() {
        return codigoInventario;
    }

    public void setCodigoInventario(String codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "[" + codigoInventario + "] " + descripcion + " | Estado: " + estado + " | Disponible: " + (disponible ? "SÍ" : "NO");
    }
}
