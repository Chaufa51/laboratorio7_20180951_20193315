package com.example.laboratorio7.controllers;

import com.example.laboratorio7.models.beans.Jugador;
import com.example.laboratorio7.models.daos.EstadiosDaos;
import com.example.laboratorio7.models.daos.JugadoresDaos;
import com.example.laboratorio7.models.daos.SeleccionesDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SeleccionesServlet", value = "/listarSelecciones")
public class SeleccionesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        SeleccionesDaos seleccionesDaos = new SeleccionesDaos();

        String action = request.getParameter("a") == null ? "listarSelecciones" : request.getParameter("a");

        switch (action){
            case "listarSelecciones":
                request.setAttribute("lista",seleccionesDaos.listaSelecciones1());

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Selecciones/listaSelecciones.jsp");
                requestDispatcher.forward(request,response);
                break;

            case "agregarSeleccion":
                EstadiosDaos estadiosDaos = new EstadiosDaos();

                request.setAttribute("lista",estadiosDaos.listaEstadios());
                request.getRequestDispatcher("Seleccion/seleccionNuevo.jsp").forward(request, response);
                break;
        }



    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}