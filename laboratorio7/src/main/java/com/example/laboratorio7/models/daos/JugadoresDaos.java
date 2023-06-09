package com.example.laboratorio7.models.daos;

import com.example.laboratorio7.models.beans.Jugador;
import com.example.laboratorio7.models.beans.Seleccion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JugadoresDaos extends BaseDaos {

    public ArrayList<Jugador> listarJugadores(){

        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        String sql="select * from jugador j" +
                "left join seleccion s on j.sn_idSeleccion = s.idSeleccion";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);){

            while (rs.next()){
                Jugador jugador = new Jugador();
                jugador.setIdJugador(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                jugador.setEdad(rs.getInt(3));
                jugador.setPosicion(rs.getString(4));
                jugador.setClub(rs.getString(5));

                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt("s.idSeleccion"));
                seleccion.setNombre(rs.getString("nombre"));
                jugador.setSeleccion(seleccion);
                listaJugadores.add(jugador);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listaJugadores;
    }

}
