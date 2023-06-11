package com.example.laboratorio7.models.daos;

import com.example.laboratorio7.models.beans.Estadio;
import com.example.laboratorio7.models.beans.Jugador;
import com.example.laboratorio7.models.beans.Partido;
import com.example.laboratorio7.models.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public void nuevaSeleccion(Seleccion seleccion){
        String sql ="INSERT into seleccion (nombre,tecnico,estadio_idEstadio)"+
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
    public void borrarSeleccion(int idSeleccion) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM seleccion WHERE idSeleccion = ?")) {
            pstmt.setInt(1, idSeleccion);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //se crea obtenerSeleccion para poder sacar una seleccion via su id
    public Seleccion obtenerSeleccion(int idSeleccion) {
        Seleccion seleccion = null;

        String sql = "DELETE FROM seleccion WHERE idSeleccion = ?;";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idSeleccion);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    seleccion = fetchSeleccionesData(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return seleccion;
    }
    private Seleccion fetchSeleccionesData(ResultSet rs) throws SQLException {
        Seleccion seleccion = new Seleccion();

        seleccion.setIdSeleccion(rs.getInt(1));
        seleccion.setNombre(rs.getString(2));
        seleccion.setTecnico(rs.getString(3));

        Estadio estadio = new Estadio();
        estadio.setIdEstadio(rs.getInt(4));
        estadio.setNombre(rs.getNString(5));
        seleccion.setEstadio(estadio);


        return seleccion;
    }
}
