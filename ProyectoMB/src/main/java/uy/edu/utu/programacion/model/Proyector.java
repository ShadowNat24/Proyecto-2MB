package uy.edu.utu.programacion.model;

public class Proyector extends Equipo {
    private String resolucion;
    private int luminosidad;

    public Proyector() {
        super("", "", "Operativo");
    }

    public Proyector(String codigoInventario, String descripcion, String estado, String resolucion, int luminosidad) {
        super(codigoInventario, descripcion, estado);
        this.resolucion = resolucion;
        this.luminosidad = luminosidad;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public int getLuminosidad() {
        return luminosidad;
    }

    public void setLuminosidad(int luminosidad) {
        this.luminosidad = luminosidad;
    }

    @Override
    public String toString() {
        return super.toString() + " | Proyector [Resolución: " + resolucion + ", Lúmenes: " + luminosidad + "]";
    }
}
