package com.abril.martes25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHelper {


    public static Connection getConexion(String tipoBaseDatos) throws SQLException {

        if (tipoBaseDatos.equals("mySQL")) {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/logixs", "root", "");

        } else {

            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        }

    }

    public void executarConsulta(String sql) {
        
    }


}