package com.abril.miercoles26.patronRepository.repository;

import com.abril.miercoles26.config.DataBaseHelper2;
import com.abril.miercoles26.patronRepository.domain.Ordenador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdenadorRepositoryMySQL implements OrdenadorRepository {

    @Override
    public Ordenador actualizar(Ordenador ordenador) {

        String sql = "update  Ordenador set modelo=?, precio=? where numero=?";

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sql);) {

            sentencia.setInt(1, ordenador.getNumero());
            sentencia.setString(2, ordenador.getModelo());
            sentencia.setDouble(3, ordenador.getPrecio());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return ordenador;
    }

    // su propia persistencia
    @Override
    public Ordenador insertar(Ordenador ordenador) {

        String sql = "insert into Ordenador (numero,modelo,precio) values (?,?,?)";

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sql);) {
            sentencia.setInt(1, ordenador.getNumero());
            sentencia.setString(2, ordenador.getModelo());
            sentencia.setDouble(3, ordenador.getPrecio());
            sentencia.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return ordenador;
    }

    // su propia persistencia
    @Override
    public void borrar(Ordenador ordenador) {

        String sql = "delete from Ordenador where numero=?";

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sql);) {
            sentencia.setInt(1, ordenador.getNumero());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ordenador> buscarTodos() {

        List<Ordenador> lista = new ArrayList<Ordenador>();

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement("select * from Ordenador");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                lista.add(new Ordenador(rs.getInt("numero"), rs.getString("modelo"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public List<Ordenador> buscarOrdenadoresBaratos() {

        List<Ordenador> lista = new ArrayList<Ordenador>();

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement("select * from Ordenador where precio<200");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                lista.add(new Ordenador(rs.getInt("numero"), rs.getString("modelo"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public Ordenador buscarUno(int numero) {

        Ordenador ordenador = null;

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement("select * from Ordenador where numero=?");

        ) {
            stmt.setInt(1, numero);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    ordenador = new Ordenador(rs.getInt("numero"), rs.getString("modelo"), rs.getDouble("precio"));

            }

        } catch (

                SQLException e) {
            System.out.println("ha ocurrido un error");
            throw new RuntimeException(e);
        }
        return ordenador;
    }

    @Override
    public List<Ordenador> buscarPorRangoPrecios(double precioInicial, double precioFinal) {

        List<Ordenador> lista = new ArrayList<Ordenador>();

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement stmt = conn
                     .prepareStatement("select * from Ordenador where precio between ? and ?")) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    lista.add(new Ordenador(rs.getInt("numero"), rs.getString("modelo"), rs.getDouble("precio")));
                }
            }

        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            throw new RuntimeException(e);
        }
        return lista;

    }
}