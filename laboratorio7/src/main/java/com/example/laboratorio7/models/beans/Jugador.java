package com.example.laboratorio7.models.beans;

public class Jugador {

    private int idJugador;
    private String nombre;
    private int edad;
    private String posicion;
    private String club;
    private Seleccion seleccion;

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

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    //constructores

    public Jugador(int idJugador, String nombre, int edad, String posicion, String club, Seleccion seleccion) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.club = club;
        this.seleccion = seleccion;
    }
}
