package com.abril.martes25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal4 {
    public static void main(String[] args) {
        Ordenador o = new Ordenador(1, "modelo1", 500);
        insertarOrdenador(o);

    }

    public static void insertarOrdenador(Ordenador ordenador) {

        String consultaSQL = "insert into Ordenador (numero,modelo,precio) values (" + ordenador.getNumero() + ",'" + ordenador.getModelo() + "'," + ordenador.getPrecio() + ")";
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

        if ("mySQL".equals("mySQL")) {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/logixs", "root", "");

        } else {

            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        }

    }
}