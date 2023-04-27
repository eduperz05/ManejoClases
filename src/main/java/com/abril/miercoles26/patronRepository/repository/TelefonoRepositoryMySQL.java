package com.abril.miercoles26.patronRepository.repository;

import com.abril.miercoles26.config.DataBaseHelper2;
import com.abril.miercoles26.patronRepository.domain.Telefono;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefonoRepositoryMySQL implements TelefonoRepository {

    @Override
    public Telefono insertar(Telefono t) {

        String sql = "insert into Telefono (numero,marca,modelo,precio) values (?,?,?,?);";

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, t.getNumero());
            sentencia.setString(2, t.getMarca());
            sentencia.setString(3, t.getModelo());
            sentencia.setDouble(4, t.getPrecio());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return t;
    }

    @Override
    public void borrar(Telefono t) {

        String sql = "delete from  Telefono where numero=" + t.getNumero();

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sql);) {
            sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Telefono actualizar(Telefono t, String marca, String modelo, double precio) {
        t.setMarca(marca);
        t.setModelo(modelo);
        t.setPrecio(precio);
        String sql = "UPDATE Telefono SET marca=?, modelo=?, precio=? WHERE numero=?;";

        try (Connection conexion = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql);) {
            sentencia.setString(1, t.getMarca());
            sentencia.setString(2, t.getModelo());
            sentencia.setDouble(3, t.getPrecio());
            sentencia.setInt(4, t.getNumero());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return t;
    }

    @Override
    public List<Telefono> buscarTodos() {

        List<Telefono> lista = new ArrayList<Telefono>();
        String sql = "select * from Telefono;";
        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conn.prepareStatement(sql)) {
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {

                lista.add(new Telefono(rs.getInt("numero"), rs.getString("marca"), rs.getString("marca"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public Telefono buscarUno(int numero) {

        Telefono or = null;
        String sql = "select * from Telefono where numero=? LIMIT 1;";
        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setInt(1, numero);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                or = new Telefono(rs.getInt("numero"), rs.getString("marca"), rs.getString("marca"), rs.getDouble("precio"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return or;
    }

    @Override
    public List<Telefono> buscarPorConcepto(String modelo) {

        List<Telefono> lista = new ArrayList<Telefono>();
        String sql = "select * from Telefono where " +
                "modelo=?;";

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setString(1, modelo);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(new Telefono(rs.getInt("numero"), rs.getString("marca"), rs.getString("marca"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public List<Telefono> buscarPorRangoPrecio(double minPrecio, double maxPrecio) {

        List<Telefono> lista = new ArrayList<Telefono>();
        String sql = "select * from Telefono where precio between ? and ?;";

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia =
                     conn.prepareStatement(sql)) {
            sentencia.setDouble(1, minPrecio);
            sentencia.setDouble(2, maxPrecio);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(new Telefono(rs.getInt("numero"), rs.getString("marca"), rs.getString("marca"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public List<Telefono> buscarTelefonosBaratos(double menorPrecio) {

        List<Telefono> lista = new ArrayList<Telefono>();
        String sql = "select * from Telefono where precio<?";

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conn.prepareStatement(sql)) {
            sentencia.setDouble(1, menorPrecio);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(new Telefono(rs.getInt("numero"), rs.getString("marca"), rs.getString("marca"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public List<Telefono> buscarTelefonosCaros(double mayorPrecio) {
        List<Telefono> lista = new ArrayList<Telefono>();
        String sql = "select * from Telefono where precio>?";

        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conn.prepareStatement(sql)) {
            sentencia.setDouble(1, mayorPrecio);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                lista.add(new Telefono(rs.getInt("numero"), rs.getString("marca"), rs.getString("marca"), rs.getDouble("precio")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public double mediaPrecios() {
        double media = 0;
        String sql = "select AVG(all precio) as media from Telefono;";
        try (Connection conn = DataBaseHelper2.getConexion("mySQL");
             PreparedStatement sentencia = conn.prepareStatement(sql)) {
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                media = rs.getDouble("media");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return media;
    }

}
