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

                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                int edad = rs.getInt(3);
                String posicion = rs.getString(4);
                String club = rs.getString(5);

                int idSeleccion =rs.getInt("s.idSeleccion");
                String nombreSeleccion = rs.getString("nombre");
                Seleccion seleccion = new Seleccion(idSeleccion,nombreSeleccion);
                Jugador jugador = new Jugador(id,nombre,edad,posicion,club,seleccion);

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
