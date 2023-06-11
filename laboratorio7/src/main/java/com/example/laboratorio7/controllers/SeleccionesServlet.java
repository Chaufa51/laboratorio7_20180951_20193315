package com.example.laboratorio7.controllers;

import com.example.laboratorio7.models.beans.Estadio;
import com.example.laboratorio7.models.beans.Jugador;
import com.example.laboratorio7.models.beans.Seleccion;
import com.example.laboratorio7.models.daos.EstadiosDaos;
import com.example.laboratorio7.models.daos.JugadoresDaos;
import com.example.laboratorio7.models.daos.SeleccionesDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

import java.io.IOException;
import java.util.regex.Pattern;

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
                request.getRequestDispatcher("Selecciones/seleccionNuevo.jsp").forward(request, response);
                break;
        }



    }


    @Override


// ...

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SeleccionesDaos seleccionesDaos = new SeleccionesDaos();

        Seleccion seleccion = parseSeleccion(request);

        boolean noContinuar = true;

        if (seleccion != null) {
            String seleccionNombre = seleccion.getNombre();
            String tecnicoNombre = seleccion.getTecnico();

            // Validación de caracteres alfabéticos
            Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

            if (!pattern.matcher(seleccionNombre).matches() || !pattern.matcher(tecnicoNombre).matches()) {
                noContinuar = false;
            } else {
                for (Seleccion nuevaSeleccion : seleccionesDaos.listaSeleccion()) {
                    if (seleccionNombre.equals(nuevaSeleccion.getNombre()) && tecnicoNombre.equals(nuevaSeleccion.getTecnico())) {
                        noContinuar = false;
                        break;
                    }
                }
            }

            if (noContinuar) {
                seleccionesDaos.nuevaSeleccion(seleccion);
                response.sendRedirect(request.getContextPath() + "/listarSelecciones");
            } else {
                response.sendRedirect(request.getContextPath() + "/listarSelecciones?a=agregarSeleccion");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/listarSelecciones?a=agregarSeleccion");
        }
    }

    public Seleccion parseSeleccion(HttpServletRequest request){
        Seleccion seleccion = new Seleccion();

        seleccion.setNombre(request.getParameter("seleccion"));
        seleccion.setTecnico(request.getParameter("tecnico"));
        Estadio estadio = new Estadio();
        estadio.setNombre(request.getParameter("estadios"));
        seleccion.setEstadio(estadio);


        return seleccion;
    }

}