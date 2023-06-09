package com.example.laboratorio7.models.beans;

public class seleccion {

    private int idSeleccion;
    private String nombre;
    private String tecnico;
    private estadio estadio;

    //getters and setters


    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public com.example.laboratorio7.models.beans.estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(com.example.laboratorio7.models.beans.estadio estadio) {
        this.estadio = estadio;
    }

    //constructores


    public seleccion(int idSeleccion, String nombre, String tecnico, com.example.laboratorio7.models.beans.estadio estadio) {
        this.idSeleccion = idSeleccion;
        this.nombre = nombre;
        this.tecnico = tecnico;
        this.estadio = estadio;
    }
}
