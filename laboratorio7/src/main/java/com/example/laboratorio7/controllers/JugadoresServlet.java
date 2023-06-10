package com.example.laboratorio7.controllers;

import com.example.laboratorio7.models.beans.Jugador;
import com.example.laboratorio7.models.beans.Seleccion;
import com.example.laboratorio7.models.daos.JugadoresDaos;
import com.example.laboratorio7.models.daos.SeleccionesDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
