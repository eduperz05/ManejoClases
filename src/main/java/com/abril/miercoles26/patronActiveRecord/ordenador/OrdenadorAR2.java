package com.abril.miercoles26.patronActiveRecord.ordenador;

import com.abril.miercoles26.config.DataBaseHelper2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdenadorAR2 {

    private int numero;
    private String modelo;
    private double precio;

    public OrdenadorAR2() {
    }

    public OrdenadorAR2(int numero) {
        this.numero = numero;
    }

    public OrdenadorAR2(int numero, String modelo,
                        double precio) {
        this.numero = numero;
        this.modelo = modelo;
        this.precio = precio;
    }

    public static List<OrdenadorAR2> buscarTodos() {

        List<OrdenadorAR2> lista = new ArrayList<OrdenadorAR2>();
        String sql = "select * from Ordenador;";
        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conn.prepareStatement(sql)) {
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {

                lista.add(new OrdenadorAR2(rs.getInt("numero"), rs.getString("modelo"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<OrdenadorAR2> buscarPorConcepto(String modelo) {

        List<OrdenadorAR2> lista = new ArrayList<OrdenadorAR2>();
        String sql = "select * from ordenador where " +
                "modelo=?;";

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setString(1, modelo);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(new OrdenadorAR2(rs.getInt("numero"), rs.getString("modelo"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<OrdenadorAR2> buscarPorRangoPrecio(double minPrecio, double maxPrecio) {

        List<OrdenadorAR2> lista = new ArrayList<OrdenadorAR2>();
        String sql = "select * from ordenador where precio between ? and ?;";

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setDouble(1, minPrecio);
            sentencia.setDouble(2, maxPrecio);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(new OrdenadorAR2(rs.getInt("numero"),
                        rs.getString("modelo"),
                        rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<OrdenadorAR2> buscarOrdenadoresBaratos(double menorPrecio) {

        List<OrdenadorAR2> lista = new ArrayList<OrdenadorAR2>();
        String sql = "select * from Ordenador where precio<?";

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conn.prepareStatement(sql)) {
            sentencia.setDouble(1, menorPrecio);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {

                lista.add(new OrdenadorAR2(rs.getInt("numero"), rs.getString("modelo"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static OrdenadorAR2 buscarUno(int numero) {

        OrdenadorAR2 or = null;
        String sql = "select * from ordenador where numero=? LIMIT 1;";
        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setInt(1, numero);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                or = new OrdenadorAR2(rs.getInt("numero"),
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
        OrdenadorAR2 other = (OrdenadorAR2) obj;
        return numero == other.numero;
    }

    // su propia persistencia
    public OrdenadorAR2 insertar() throws SQLException {

        String sql = "insert into Ordenador (numero,modelo,precio) values (?,?,?);";

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, getNumero());
            sentencia.setString(2, getModelo());
            sentencia.setDouble(3, getPrecio());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return this;
    }

    // su propia persistencia
    public void borrar() {

        String sql = "delete from  Ordenador where numero=" + getNumero();

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sql);) {
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        }
    }

    public OrdenadorAR2 actualizar(int numero, String modelo,
                                   double precio) throws SQLException {
        this.numero = numero;
        this.modelo = modelo;
        this.precio = precio;
        String sql = "UPDATE Ordenador SET numero=?, modelo=?, precio=? WHERE numero=?;";

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql);) {
            sentencia.setInt(1, getNumero());
            sentencia.setString(2, getModelo());
            sentencia.setDouble(3, getPrecio());
            sentencia.setInt(4, getNumero());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return this;
    }
}