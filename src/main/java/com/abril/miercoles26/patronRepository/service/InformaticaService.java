package com.abril.miercoles26.patronRepository.service;


import com.abril.miercoles26.patronRepository.domain.Ordenador;
import com.abril.miercoles26.patronRepository.domain.Telefono;
import com.abril.miercoles26.patronRepository.repository.OrdenadorRepository;
import com.abril.miercoles26.patronRepository.repository.TelefonoRepository;

import java.util.List;

public class InformaticaService {

    private TelefonoRepository repositorioTelefono;
    private OrdenadorRepository repositorioOrdenador;

    public InformaticaService(TelefonoRepository repositorioTelefono, OrdenadorRepository repositorioOrdenador) {
        this.repositorioTelefono = repositorioTelefono;
        this.repositorioOrdenador = repositorioOrdenador;
    }

    public Telefono actualizarTelefono(Telefono telefono, String marca, String modelo, double precio) {
        return repositorioTelefono.actualizar(telefono, marca, modelo, precio);
    }

    public Telefono insertarTelefono(Telefono telefono) {
        return repositorioTelefono.insertar(telefono);
    }

    public void borrarTelefono(Telefono telefono) {
        repositorioTelefono.borrar(telefono);
    }

    public List<Telefono> buscarTodosTelefonos() {
        List<Telefono> lista = repositorioTelefono.buscarTodos();
        for (Telefono m : lista) {

            m.setMarca(m.getMarca().toUpperCase());
        }
        return lista;
    }

    public Telefono buscarUnoTelefono(int numero) {
        return repositorioTelefono.buscarUno(numero);
    }

    public Ordenador actualizarOrdenador(Ordenador ordenador) {
        return repositorioOrdenador.actualizar(ordenador);
    }

    public Ordenador insertarOrdenador(Ordenador ordenador) {
        return repositorioOrdenador.insertar(ordenador);
    }

    public void borrarOrdenador(Ordenador ordenador) {
        repositorioOrdenador.borrar(ordenador);
    }

    public List<Ordenador> buscarTodosOrdenadores() {
        return repositorioOrdenador.buscarTodos();
    }

    public List<Ordenador> buscarOrdenadoresBaratos() {
        return repositorioOrdenador.buscarOrdenadoresBaratos();
    }

    public Ordenador buscarUnoOrdenador(int numero) {
        return repositorioOrdenador.buscarUno(numero);
    }

    public List<Ordenador> buscarPorRangoPreciosOrdenadores(double precioInicial, double precioFinal) {
        return repositorioOrdenador.buscarPorRangoPrecios(precioInicial, precioFinal);
    }


}
