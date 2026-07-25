package uy.edu.utu.programacion.model;

public class Camara extends Equipo {
    private String resolucion;
    private String tipoAlmacenamiento;

    public Camara() {
        super("", "", "Operativo");
    }

    public Camara(String codigoInventario, String descripcion, String estado, String resolucion, String tipoAlmacenamiento) {
        super(codigoInventario, descripcion, estado);
        this.resolucion = resolucion;
        this.tipoAlmacenamiento = tipoAlmacenamiento;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getTipoAlmacenamiento() {
        return tipoAlmacenamiento;
    }

    public void setTipoAlmacenamiento(String tipoAlmacenamiento) {
        this.tipoAlmacenamiento = tipoAlmacenamiento;
    }

    @Override
    public String toString() {
        return super.toString() + " | Cámara [Resolución: " + resolucion + ", Memoria: " + tipoAlmacenamiento + "]";
    }
}
