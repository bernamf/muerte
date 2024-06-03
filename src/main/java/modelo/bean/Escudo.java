package modelo.bean;

public class Escudo {
    private int id;
    private String nombre;
    private int capacidadDefensa;

    public Escudo() {
    }

    public Escudo(int id, String nombre, int capacidadDefensa) {
        this.id = id;
        this.nombre = nombre;
        this.capacidadDefensa = capacidadDefensa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadDefensa() {
        return capacidadDefensa;
    }

    public void setCapacidadDefensa(int capacidadDefensa) {
        this.capacidadDefensa = capacidadDefensa;
    }
}
