package com.abril.martes25;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FacturaAR {
    private int numero;
    private String concepto;
    private double importe;

    public FacturaAR() {
    }

    public FacturaAR(int numero) {
        this.numero = numero;
    }

    public FacturaAR(int numero, String concepto, double importe) {
        this.numero = numero;
        this.concepto = concepto;
        this.importe = importe;
    }

    public static List<FacturaAR> buscarTodas() {

        List<FacturaAR> lista = new ArrayList<FacturaAR>();

        try (Connection conn = DataBaseHelper.getConexion("mySQL");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * " +
                     "from Factura")) {

            while (rs.next()) {

                lista.add(new FacturaAR(rs.getInt("numero"),
                        rs.getString("concepto"),
                        rs.getDouble("importe")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public int hashCode() {
        return getNumero();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FacturaAR facturaAR))
            return false;

        return getNumero() == facturaAR.getNumero();
    }

    public void insert() throws SQLException {
        String sql = "insert into Factura (numero,concepto,importe) values (" + getNumero() + ",'" + getConcepto() + "'," + getImporte() + ")";
        try (Connection connection =
                     DataBaseHelper.getConexion("mySQL");
             Statement sentencia =
                     connection.createStatement()) {
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        }
    }

    public void borrar() {

        String sql =
                "delete from  Factura where numero=" + getNumero();

        try (Connection conexion = DataBaseHelper.getConexion("mySQL");
             Statement sentencia = conexion.createStatement();) {
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        }
    }
}
