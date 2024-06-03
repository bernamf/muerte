package modelo.bean;

public class Caballero {
    private int id;
    private String nombre;
    private int fuerza;
    private int experiencia;
    private Arma arma;
    private Escudo escudo;

    public Caballero() {
    }

    public Caballero(int id, String nombre, int fuerza, int experiencia, Arma arma, Escudo escudo) {
        this.id = id;
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.experiencia = experiencia;
        this.arma = arma;
        this.escudo = escudo;
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

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }
}
