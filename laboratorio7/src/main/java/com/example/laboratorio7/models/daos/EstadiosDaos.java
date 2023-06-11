package com.example.laboratorio7.models.daos;

import com.example.laboratorio7.models.beans.Estadio;
import com.example.laboratorio7.models.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class EstadiosDaos extends BaseDaos {

    //la uso para el combobox
    public ArrayList<Estadio> listaEstadios(){

        ArrayList<Estadio> lista = new ArrayList<>();

        String sql ="select * from estadio";

        try(Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                Estadio estadio = new Estadio();
                estadio.setIdEstadio(rs.getInt(1));
                estadio.setNombre(rs.getString(2));
                lista.add(estadio);
            }

        } catch (SQLException ex){
            ex.printStackTrace();

        }

        return lista;
    }


}
