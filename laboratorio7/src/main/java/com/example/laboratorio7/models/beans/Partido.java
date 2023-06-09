package com.example.laboratorio7.models.beans;

public class Partido {
    private int idPartido;
    private Seleccion local;
    private Seleccion visitante;
    private Arbitro arbitro;
    private String fecha;
    private int numeroJornada;

    //getters and setters

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Seleccion getLocal() {
        return local;
    }

    public void setLocal(Seleccion local) {
        this.local = local;
    }

    public Seleccion getVisitante() {
        return visitante;
    }

    public void setVisitante(Seleccion visitante) {
        this.visitante = visitante;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(int numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    //constructores

    public Partido(int idPartido, Seleccion local, Seleccion visitante, Arbitro arbitro, String fecha, int numeroJornada) {
        this.idPartido = idPartido;
        this.local = local;
        this.visitante = visitante;
        this.arbitro = arbitro;
        this.fecha = fecha;
        this.numeroJornada = numeroJornada;
    }
}
