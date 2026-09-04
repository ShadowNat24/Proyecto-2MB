package uy.edu.utu.f1.main;
import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private int id;
    private String nombre;
    private String emailContacto;
    
    private List<Escuderia> escuderias;
    private List<Piloto> pilotos;

    public Proveedor() {
        this.escuderias = new ArrayList<>();
        this.pilotos = new ArrayList<>();
    }

    public Proveedor(int id, String nombre, String emailContacto) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.emailContacto = emailContacto;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmailContacto() { return emailContacto; }
    public void setEmailContacto(String emailContacto) { this.emailContacto = emailContacto; }

    public List<Escuderia> getEscuderias() { return escuderias; }
    public List<Piloto> getPilotos() { return pilotos; }
}