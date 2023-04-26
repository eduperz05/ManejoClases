package com.abril.martes25;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdenadorAR {

    private int numero;
    private String modelo;
    private double precio;

    public OrdenadorAR() {
    }

    public OrdenadorAR(int numero) {
        this.numero = numero;
    }

    public OrdenadorAR(int numero, String modelo,
                       double precio) {
        this.numero = numero;
        this.modelo = modelo;
        this.precio = precio;
    }

    public static List<OrdenadorAR> buscarTodos() {

        List<OrdenadorAR> lista = new ArrayList<OrdenadorAR>();

        try (Connection conn = DataBaseHelper.getConexion("mySQL");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from Ordenador")) {

            while (rs.next()) {

                lista.add(new OrdenadorAR(rs.getInt("numero"), rs.getString("modelo"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<OrdenadorAR> buscarPorConcepto(String modelo) {

        List<OrdenadorAR> lista = new ArrayList<OrdenadorAR>();
        String sql = "select * from ordenador where " +
                "modelo=?;";

        try (Connection conn = DataBaseHelper.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setString(1, modelo);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(new OrdenadorAR(rs.getInt("numero"), rs.getString("modelo"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<OrdenadorAR> buscarPorRangoPrecio(double minPrecio, double maxPrecio) {

        List<OrdenadorAR> lista = new ArrayList<OrdenadorAR>();
        String sql = "select * from ordenador where precio between ? and ?;";

        try (Connection conn = DataBaseHelper.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setDouble(1, minPrecio);
            sentencia.setDouble(2, maxPrecio);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(new OrdenadorAR(rs.getInt("numero"),
                        rs.getString("modelo"),
                        rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static OrdenadorAR buscarUno(int numero) {

        OrdenadorAR or = new OrdenadorAR();
        String sql = "select * from ordenador where " +
                "numero=? LIMIT 1;";
        try (Connection conn = DataBaseHelper.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setInt(1, numero);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                or = new OrdenadorAR(rs.getInt("numero"),
                        rs.getString("modelo"), rs.getDouble(
                        "precio"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return or;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrdenadorAR other = (OrdenadorAR) obj;
        return numero == other.numero;
    }

    // su propia persistencia
    public void insertar() {

        String sql = "insert into Ordenador (numero,modelo,precio) values (" + getNumero() + ",'" + getModelo() + "',"
                + getPrecio() + ")";

        try (Connection conexion = DataBaseHelper.getConexion("mySQL");
             Statement sentencia = conexion.createStatement()) {
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        }
    }

    // su propia persistencia
    public void borrar() {

        String sql = "delete from  Ordenador where numero=" + getNumero();

        try (Connection conexion = DataBaseHelper.getConexion("mySQL");
             Statement sentencia = conexion.createStatement();) {
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        }
    }

    public void actualizar(int numero, String modelo,
                           double precio) {
        this.numero = numero;
        this.modelo = modelo;
        this.precio = precio;
        String sql = "UPDATE Ordenador SET numero=?, modelo=?, precio=? WHERE numero=?;";

        try (Connection conexion = DataBaseHelper.getConexion("mySQL");
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql);) {
            sentencia.setInt(1, getNumero());
            sentencia.setString(2, getModelo());
            sentencia.setDouble(3, getPrecio());
            sentencia.setInt(4, getNumero());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error");
            System.out.println(e.getMessage());
        }
    }
}