package com.example.laboratorio7.models.beans;

public class Estadio {

    private int idEstadio;
    private String nombre;
    private String provincia;
    private String club;

    //getters and setters


    public int getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    //constructores


    public Estadio() {
        this.idEstadio = idEstadio;
        this.nombre = nombre;
        this.provincia = provincia;
        this.club = club;
    }
}
