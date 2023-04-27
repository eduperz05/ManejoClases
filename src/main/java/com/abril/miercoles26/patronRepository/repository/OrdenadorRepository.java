package com.abril.miercoles26.patronRepository.repository;

import com.abril.miercoles26.patronRepository.domain.Ordenador;

import java.util.List;

public interface OrdenadorRepository {
    Ordenador actualizar(Ordenador ordenador);

    // su propia persistencia
    Ordenador insertar(Ordenador ordenador);

    // su propia persistencia
    void borrar(Ordenador ordenador);

    List<Ordenador> buscarTodos();

    List<Ordenador> buscarOrdenadoresBaratos();

    Ordenador buscarUno(int numero);

    List<Ordenador> buscarPorRangoPrecios(double precioInicial, double precioFinal);
}
