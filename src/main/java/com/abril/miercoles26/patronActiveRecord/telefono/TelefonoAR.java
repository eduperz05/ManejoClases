package com.abril.miercoles26.patronActiveRecord.telefono;

import com.abril.miercoles26.config.DataBaseHelper2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefonoAR {

    private int numero;
    private String marca;
    private String modelo;
    private double precio;


    public TelefonoAR() {
    }

    public TelefonoAR(int numero) {
        this.numero = numero;
    }

    public TelefonoAR(int numero, String marca, String modelo, double precio) {
        this.numero = numero;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public static List<TelefonoAR> buscarTodos() {

        List<TelefonoAR> lista = new ArrayList<TelefonoAR>();
        String sql = "select * from Telefono;";
        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conn.prepareStatement(sql)) {
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {

                lista.add(new TelefonoAR(rs.getInt("numero"), rs.getString("marca"), rs.getString("marca"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<TelefonoAR> buscarPorConcepto(String modelo) {

        List<TelefonoAR> lista = new ArrayList<TelefonoAR>();
        String sql = "select * from Telefono where " +
                "modelo=?;";

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setString(1, modelo);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(new TelefonoAR(rs.getInt("numero"), rs.getString("marca"), rs.getString("marca"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<TelefonoAR> buscarPorRangoPrecio(double minPrecio, double maxPrecio) {

        List<TelefonoAR> lista = new ArrayList<TelefonoAR>();
        String sql = "select * from Telefono where precio between ? and ?;";

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setDouble(1, minPrecio);
            sentencia.setDouble(2, maxPrecio);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(new TelefonoAR(rs.getInt("numero"), rs.getString("marca"), rs.getString("marca"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<TelefonoAR> buscarTelefonoesBaratos(double menorPrecio) {

        List<TelefonoAR> lista = new ArrayList<TelefonoAR>();
        String sql = "select * from Telefono where precio<?";

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conn.prepareStatement(sql)) {
            sentencia.setDouble(1, menorPrecio);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(new TelefonoAR(rs.getInt("numero"), rs.getString("marca"), rs.getString("marca"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static TelefonoAR buscarUno(int numero) {

        TelefonoAR or = null;
        String sql = "select * from Telefono where numero=? LIMIT 1;";
        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setInt(1, numero);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                or = new TelefonoAR(rs.getInt("numero"), rs.getString("marca"), rs.getString("marca"), rs.getDouble("precio"));
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
        TelefonoAR other = (TelefonoAR) obj;
        return numero == other.numero;
    }

    // su propia persistencia
    public TelefonoAR insertar() throws SQLException {

        String sql = "insert into Telefono (numero,marca,modelo,precio) values (?,?,?,?);";

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, getNumero());
            sentencia.setString(2, getMarca());
            sentencia.setString(3, getModelo());
            sentencia.setDouble(4, getPrecio());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return this;
    }

    // su propia persistencia
    public void borrar() {

        String sql = "delete from  Telefono where numero=" + getNumero();

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sql);) {
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        }
    }

    public TelefonoAR actualizar(int numero, String modelo,
                                 double precio) throws SQLException {
        this.numero = numero;
        this.modelo = modelo;
        this.precio = precio;
        String sql = "UPDATE Telefono SET numero=?, marca=?, modelo=?, precio=? WHERE numero=?;";

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql);) {
            sentencia.setInt(1, getNumero());
            sentencia.setString(2, getMarca());
            sentencia.setString(3, getModelo());
            sentencia.setDouble(4, getPrecio());
            sentencia.setInt(5, getNumero());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return this;
    }
}