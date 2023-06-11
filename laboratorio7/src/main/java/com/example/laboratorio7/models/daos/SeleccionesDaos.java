package com.example.laboratorio7.models.daos;

import com.example.laboratorio7.models.beans.Estadio;
import com.example.laboratorio7.models.beans.Jugador;
import com.example.laboratorio7.models.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionesDaos extends BaseDaos {

    //la uso para el combobox
    public ArrayList<Seleccion> listaSeleccion(){

        ArrayList<Seleccion> lista = new ArrayList<>();

        String sql ="select * from seleccion";

        try(Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                lista.add(seleccion);
            }

        } catch (SQLException ex){
            ex.printStackTrace();

        }

        return lista;
    }

    public ArrayList<Seleccion> listaSelecciones1(){

        ArrayList<Seleccion> lista = new ArrayList<>();

//        String sql = "SELECT\n" +
//                "  s.idSeleccion AS ID,\n" +
//                "  s.nombre AS Nombre,\n" +
//                "  s.tecnico AS Tecnico,\n" +
//                "  e.nombre AS Estadio,\n" +
//                "  CONCAT(sLocal.nombre, ' vs ', sVisitante.nombre) AS PrimerPartido\n" +
//                "FROM\n" +
//                "  seleccion s\n" +
//                "  INNER JOIN estadio e ON s.estadio_idEstadio = e.idEstadio\n" +
//                "  INNER JOIN partido p ON (s.idSeleccion = p.seleccionLocal OR s.idSeleccion = p.seleccionVisitante)\n" +
//                "  INNER JOIN seleccion sLocal ON p.seleccionLocal = sLocal.idSeleccion\n" +
//                "  INNER JOIN seleccion sVisitante ON p.seleccionVisitante = sVisitante.idSeleccion\n" +
//                "WHERE\n" +
//                "  p.fecha = (\n" +
//                "    SELECT MIN(fecha)\n" +
//                "    FROM partido\n" +
//                "    WHERE seleccionLocal = s.idSeleccion OR seleccionVisitante = s.idSeleccion\n" +
//                "  )\n";
        String sql = "SELECT\n" +
                "  s.idSeleccion AS ID,\n" +
                "  s.nombre AS Nombre,\n" +
                "  s.tecnico AS Tecnico,\n" +
                "  e.nombre AS Estadio\n" +
                "FROM\n" +
                "  seleccion s\n" +
                "  INNER JOIN estadio e ON s.estadio_idEstadio = e.idEstadio;";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));
                Estadio estadio = new Estadio();
                estadio.setNombre(rs.getString(4));
                seleccion.setEstadio(estadio);

                lista.add(seleccion);

            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return  lista;
    }

    //sin validar aun
    public void nuevaSeleccion(Seleccion seleccion){
        String sql ="INSERT into seleccion (nombre,tecnico,estadio)"+
                "values (?,?,?)";

        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,seleccion.getNombre());
            pstmt.setString(2,seleccion.getTecnico());
            pstmt.setString(3,seleccion.getEstadio().getNombre());

            pstmt.executeUpdate();

        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

}
