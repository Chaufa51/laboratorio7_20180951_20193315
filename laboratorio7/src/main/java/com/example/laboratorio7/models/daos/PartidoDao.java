package com.example.laboratorio7.models.daos;
import com.example.laboratorio7.models.beans.Partido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartidoDao extends BaseDaos{

    public ArrayList<Partido> obtenerPartidosPorSeleccionLocal(int idSeleccion) {
        ArrayList<Partido> partidos = new ArrayList<>();
        String sql ="SELECT * FROM partido WHERE seleccionLocal = ?";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                Partido partido = new Partido();
                partido.setIdPartido(rs.getInt(1));
                // Establecer otros atributos del partido
                partidos.add(partido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidos;
    }

    public ArrayList<Partido> obtenerPartidosPorSeleccionVisitante(int idSeleccion) {
        ArrayList<Partido> partidos = new ArrayList<>();
        String sql ="SELECT * FROM partido WHERE seleccionVisitante = ?";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                Partido partido = new Partido();
                partido.setIdPartido(rs.getInt(1));
                // Establecer otros atributos del partido
                partidos.add(partido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidos;
    }

    public boolean verificarSeleccionEnPartidos(int seleccionId) {
        // Realiza la consulta en la base de datos
        String sql = "SELECT COUNT(*) FROM partido WHERE seleccionLocal = ? OR seleccionVisitante = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, seleccionId);
            pstmt.setInt(2, seleccionId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // true si hay al menos 1 partido
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false; // Si ocurre algún error, retorna false por precaución
    }

}
