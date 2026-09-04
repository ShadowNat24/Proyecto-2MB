package uy.edu.utu.f1.modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Piloto {
    private int codigo;
    private String nombre;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    
    private Proveedor proveedor;
    private List<ParticipacionTemporada> participaciones;

    public Piloto() {
        this.participaciones = new ArrayList<>();
    }

    public Piloto(int codigo, String nombre, String nacionalidad, LocalDate fechaNacimiento) {
        this();
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }

    public List<ParticipacionTemporada> getParticipaciones() { return participaciones; }
}
