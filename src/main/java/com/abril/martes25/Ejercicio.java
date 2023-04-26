package com.abril.martes25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio {
    public static void main(String[] args) {
        Mesa m = new Mesa(20.50, 40.40, "roble");
        insertarMesa(m);
    }

    private static void insertarMesa(Mesa m) {
        String consultaSQL = "insert into Mesa (precio,peso,tipoMadera) values (" + m.getPrice() + "," + m.getWeight() + ",'" + m.getTypeWood() + "')";
        System.out.println(consultaSQL);
        consultaModificacion(consultaSQL);
    }

    private static void consultaModificacion(String sql) {

        try (Connection conexion = getConexion();
             Statement sentencia = conexion.createStatement();) {
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        }

    }

    private static Connection getConexion() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/logixs", "root", "");
    }
}
