package com.abril.martes25;

import java.sql.*;

public class Principal {

    public static void main(String[] args) {

        // Open a connection
        try (Connection conn =getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from PERSONA");) {
            while (rs.next()) {
                // Display values
                System.out.print(rs.getString("nombre"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static Connection getConexion() throws SQLException {
        return  DriverManager.getConnection("jdbc:mysql://localhost:3306/logixs", "root", "");
    }

}