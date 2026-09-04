package uy.edu.utu.f1.modelo;
import java.util.ArrayList;
import java.util.List;

public class Escuderia {
    private int id;
    private String nombre;
    
    private Proveedor proveedor;
    private List<Auto> autos;

    public Escuderia() {
        this.autos = new ArrayList<>();
    }

    public Escuderia(int id, String nombre) {
        this();
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }

    public List<Auto> getAutos() { return autos; }
}