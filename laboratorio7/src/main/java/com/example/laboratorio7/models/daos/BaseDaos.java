package com.example.laboratorio7.models.daos;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public abstract class BaseDaos {

    public Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }


        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab7?serverTimezone=America/Lima";

        return DriverManager.getConnection(url, user, pass);


    }
}

