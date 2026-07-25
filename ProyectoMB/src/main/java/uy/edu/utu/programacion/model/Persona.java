package uy.edu.utu.programacion.model;

public class Persona {
    private String identificador;
    private String nombre;
    private String grupoOFuncion;
    private String contacto;

    public Persona(String identificador, String nombre, String grupoOFuncion, String contacto) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.grupoOFuncion = grupoOFuncion;
        this.contacto = contacto;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupoOFuncion() {
        return grupoOFuncion;
    }

    public void setGrupoOFuncion(String grupoOFuncion) {
        this.grupoOFuncion = grupoOFuncion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "ID: " + identificador + " | Nombre: " + nombre + " (" + grupoOFuncion + ") | Contacto: " + contacto;
    }
}
