package com.example.laboratorio7.models.beans;

public class Arbitro {

    private int idArbitro;
    private String nombre;
    private String pais;

    //getters and setters


    public int getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(int idArbitro) {
        this.idArbitro = idArbitro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    //constructores


    public Arbitro(int idArbitro, String nombre, String pais) {
        this.idArbitro = idArbitro;
        this.nombre = nombre;
        this.pais = pais;
    }
}
