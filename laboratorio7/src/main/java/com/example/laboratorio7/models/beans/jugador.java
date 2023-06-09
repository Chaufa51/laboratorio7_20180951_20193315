package com.example.laboratorio7.models.beans;

public class jugador {

    private int idJugador;
    private String nombre;
    private int edad;
    private String posicion;
    private String club;
    private seleccion seleccion;

    // getters and setters
    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public com.example.laboratorio7.models.beans.seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(com.example.laboratorio7.models.beans.seleccion seleccion) {
        this.seleccion = seleccion;
    }

    //constructores

    public jugador(int idJugador, String nombre, int edad, String posicion, String club, com.example.laboratorio7.models.beans.seleccion seleccion) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.club = club;
        this.seleccion = seleccion;
    }
}
