package com.abril.martes25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal3 {
    public static void main(String[] args) {

        try (Connection conexion = getConexion();
             Statement sentencia = conexion.createStatement();) {

            sentencia.executeUpdate("insert into Persona (nombre) values ('ana')");

        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        }

    }

    private static Connection getConexion() throws SQLException {

        if ("mySQL".equals("mySQL")) {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/logixs", "root", "");

        } else {

            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        }

    }
}