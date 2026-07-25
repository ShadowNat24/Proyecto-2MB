package uy.edu.utu.programacion.model;

public class Notebook extends Equipo {
    private int memoriaRAM;
    private String sistemaOperativo;

    public Notebook() {
        super("", "", "Operativo");
    }

    public Notebook(String codigoInventario, String descripcion, String estado, int memoriaRAM, String sistemaOperativo) {
        super(codigoInventario, descripcion, estado);
        this.memoriaRAM = memoriaRAM;
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(int memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String toString() {
        return super.toString() + " | Notebook [RAM: " + memoriaRAM + "GB, SO: " + sistemaOperativo + "]";
    }
}
