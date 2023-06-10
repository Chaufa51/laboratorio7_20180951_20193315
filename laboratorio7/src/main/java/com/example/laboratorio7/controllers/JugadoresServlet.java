package com.example.laboratorio7.controllers;

import com.example.laboratorio7.models.beans.Jugador;
import com.example.laboratorio7.models.beans.Seleccion;
import com.example.laboratorio7.models.daos.JugadoresDaos;
import com.example.laboratorio7.models.daos.SeleccionesDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "JugadoresServlet", value = "/listarJugadores")
public class JugadoresServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        JugadoresDaos jugadoresDaos = new JugadoresDaos();

        String action = request.getParameter("a") == null ? "listarJugadores" : request.getParameter("a");

        switch (action){
            case "listarJugadores":
                request.setAttribute("lista",jugadoresDaos.listarJugadores());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Jugador/listaJugadores.jsp");
                requestDispatcher.forward(request,response);
                break;

            case "agregarJugador":
                SeleccionesDaos seleccionesDaos = new SeleccionesDaos();

                request.setAttribute("lista",seleccionesDaos.listaSeleccion());
                request.getRequestDispatcher("Jugador/jugadorNuevo.jsp").forward(request, response);
        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JugadoresDaos jugadoresDaos = new JugadoresDaos();

        Jugador jugador = parseJugador(request);
        boolean noContinuar = true;
        /*
        jugadoresDaos.nuevoJugador(jugador);
        response.sendRedirect(request.getContextPath() + "/listarJugadores");*/

        if(jugador != null){
            for(Jugador nuevoJugador : jugadoresDaos.listarJugadores()){
                if((jugador.getNombre().equals(nuevoJugador.getNombre()))){
                    noContinuar=false;
                }
            }
            if(noContinuar){
                jugadoresDaos.nuevoJugador(jugador);
                response.sendRedirect(request.getContextPath() + "/listarJugadores");
            }else{
                response.sendRedirect(request.getContextPath() + "/listarJugadores?a=agregarJugador");
            }
        }else{
            response.sendRedirect(request.getContextPath() + "/listarJugadores?a=agregarJugador");
        }

        }


    public Jugador parseJugador(HttpServletRequest request){
        Jugador jugador = new Jugador();
        String nombre = request.getParameter("nombre");
        String edadString = request.getParameter("edad");
        String posicion = request.getParameter("posicion");
        String club = request.getParameter("club");
        String seleccionString = request.getParameter("selecciones");

        try{
            int edad = Integer.parseInt(edadString);
            int seleccion =Integer.parseInt(seleccionString);

            jugador.setNombre(nombre);
            jugador.setEdad(edad);
            jugador.setPosicion(posicion);
            jugador.setClub(club);
            jugador.setIdSeleccion(seleccion);

            return jugador;

        }catch (NumberFormatException ex){
            return null; // validamos que la edad sea un numero
        }

    }
}