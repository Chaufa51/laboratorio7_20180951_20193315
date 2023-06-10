package com.example.laboratorio7.models.daos;

import com.example.laboratorio7.models.beans.Jugador;
import com.example.laboratorio7.models.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class JugadoresDaos extends BaseDaos {

    public ArrayList<Jugador> listarJugadores(){

        ArrayList<Jugador> lista = new ArrayList<>();

        String sql="select * from jugador j\n" +
                "left join seleccion s on j.sn_idSeleccion = s.idSeleccion";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                Jugador jugador = new Jugador();
                jugador.setIdJugador(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                jugador.setEdad(rs.getInt(3));
                jugador.setPosicion(rs.getString(4));
                jugador.setClub(rs.getString(5));

                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt(7));
                seleccion.setNombre(rs.getString(8));
                jugador.setSeleccion(seleccion);
                lista.add(jugador);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return  lista;
    }

    ////// guardar un nuevo jugador

    public void nuevoJugador(Jugador jugador){
        String sql ="INSERT into jugador (nombre,edad,posicion,club,sn_idSeleccion)"+
                "values (?,?,?,?,?)";

        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,jugador.getNombre());
            pstmt.setInt(2,jugador.getEdad());
            pstmt.setString(3,jugador.getPosicion());
            pstmt.setString(4,jugador.getClub());
            // pstmt.setInt(5,jugador.getSeleccion());

        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

}
