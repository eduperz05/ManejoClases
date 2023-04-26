package com.abril.martes25;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal2 {
    public static void main(String[] args) {

        Connection conexion = null;
        Statement sentencia = null;
        try {

            conexion = getConexion();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate("insert into Persona (nombre) values ('ana')");

        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        } finally {
            try {
                assert conexion != null;
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                assert sentencia != null;
                sentencia.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

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