package com.abril.miercoles26.patronRepository.repository;

import com.abril.miercoles26.patronRepository.domain.Telefono;

import java.util.List;

public interface TelefonoRepository {
    Telefono insertar(Telefono t);

    void borrar(Telefono t);

    Telefono actualizar(Telefono t, String marca, String modelo,
                        double precio);

    List<Telefono> buscarTodos();

    Telefono buscarUno(int numero);

    List<Telefono> buscarPorConcepto(String modelo);

    List<Telefono> buscarPorRangoPrecio(double minPrecio, double maxPrecio);

    List<Telefono> buscarTelefonosBaratos(double menorPrecio);

    List<Telefono> buscarTelefonosCaros(double mayorPrecio);

    double mediaPrecios();
}
