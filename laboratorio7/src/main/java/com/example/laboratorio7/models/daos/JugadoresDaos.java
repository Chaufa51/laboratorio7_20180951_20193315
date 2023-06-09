package com.example.laboratorio7.models.daos;

import com.example.laboratorio7.models.beans.Jugador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JugadoresDaos extends BaseDaos {

    public ArrayList<Jugador> listarJugadores() throws SQLException{

        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        String sql="select * from jugador j" +
                "left join seleccion s on j.sn_idSeleccion = s.idSeleccion";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);){

            while (rs.next()){

            }
        }


        return listaJugadores;
    }

}
