package com.abril.miercoles26.test.integration;

import com.abril.miercoles26.config.CargadorConsultasSQL;
import com.abril.miercoles26.config.DataBaseHelper2;
import com.abril.miercoles26.config.LectorFichero;
import com.abril.miercoles26.patronRepository.domain.Ordenador;
import com.abril.miercoles26.patronRepository.repository.OrdenadorRepository;
import com.abril.miercoles26.patronRepository.repository.OrdenadorRepositoryMySQL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrdenadorRepositoryTest {

    // variable de tipo interface
    private static OrdenadorRepository repositorio;

    @BeforeAll
    public static void inicializarGlobal() {
        //instancio un solo objeto para todos
        repositorio = new OrdenadorRepositoryMySQL();
    }

    @BeforeEach
    public void inicializar() throws IOException {

        LectorFichero lector = new LectorFichero("./public/cargartelefonostesxt.sql");
        DataBaseHelper2 dataBaseHelper = new DataBaseHelper2();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper);
        cargador.cargarFichero();
    }

    @Test
    public void buscarTodosTest() {

        List<Ordenador> lista = repositorio.buscarTodos();

        assertTrue(lista.size() > 5);

    }

    private void assertTrue(boolean b) {
    }

    @Test
    public void buscarOrdenadoresBaratosTest() {

        List<Ordenador> lista = repositorio.buscarOrdenadoresBaratos();

        assertTrue(lista.size() >= 2);

    }

    @Test
    public void buscarUnoEncontradoTest() {

        Ordenador ordenador = repositorio.buscarUno(1);

        assertEquals(1, ordenador.getNumero());
        assertEquals("m1", ordenador.getModelo());
        assertEquals(500, ordenador.getPrecio(), 0);

    }

    @Test
    public void buscarUnoNoEncontradoTest() {

        Ordenador ordenador = repositorio.buscarUno(1000);
        assertNull(ordenador);
    }

    @Test
    public void borrarTest() {

        Ordenador ordenador = new Ordenador(1);
        repositorio.borrar(ordenador);
        Ordenador ordenadorBorrado = repositorio.buscarUno(1);
        assertNull(ordenadorBorrado);
        ;
    }

    @Test
    public void insertarTest() {

        Ordenador ordenador = new Ordenador(10, "tablet", 1000);
        Ordenador ordenadorInsertado = repositorio.insertar(ordenador);
        assertEquals(ordenador, ordenadorInsertado);
    }

    @Test
    public void actualizarTest() {

        Ordenador ordenador = new Ordenador(10, "tablet", 1000);
        ordenador.setModelo("otro");
        ordenador.setPrecio(100);
        Ordenador ordenadorActualizado = repositorio.actualizar(ordenador);

        assertEquals(ordenador, ordenadorActualizado);
    }


}
