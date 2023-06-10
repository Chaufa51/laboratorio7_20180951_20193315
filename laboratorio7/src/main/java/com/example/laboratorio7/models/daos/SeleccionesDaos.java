package com.example.laboratorio7.models.daos;

import com.example.laboratorio7.models.beans.Seleccion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
