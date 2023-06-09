package com.abril.miercoles26.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHelper2 {

    public static Connection getConexion(String tipoBaseDatos) throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/logixs", "root", "");
    }

    public void executarConsulta(String sql) {

        try (Connection conexion = getConexion("mySQL");
             Statement sentencia = conexion.createStatement();) {
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        }
    }
}