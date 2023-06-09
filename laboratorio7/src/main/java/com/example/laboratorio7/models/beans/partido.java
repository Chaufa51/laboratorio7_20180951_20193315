package com.example.laboratorio7.models.beans;

public class partido {
    private int idPartido;
    private seleccion local;
    private seleccion visitante;
    private arbitro arbitro;
    private String fecha;
    private int numeroJornada;

    //getters and setters

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public seleccion getLocal() {
        return local;
    }

    public void setLocal(seleccion local) {
        this.local = local;
    }

    public seleccion getVisitante() {
        return visitante;
    }

    public void setVisitante(seleccion visitante) {
        this.visitante = visitante;
    }

    public com.example.laboratorio7.models.beans.arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(com.example.laboratorio7.models.beans.arbitro arbitro) {
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

    public partido(int idPartido, seleccion local, seleccion visitante, com.example.laboratorio7.models.beans.arbitro arbitro, String fecha, int numeroJornada) {
        this.idPartido = idPartido;
        this.local = local;
        this.visitante = visitante;
        this.arbitro = arbitro;
        this.fecha = fecha;
        this.numeroJornada = numeroJornada;
    }
}
