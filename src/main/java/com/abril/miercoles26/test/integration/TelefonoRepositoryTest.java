package com.abril.miercoles26.test.integration;

import com.abril.miercoles26.config.CargadorConsultasSQL;
import com.abril.miercoles26.config.DataBaseHelper2;
import com.abril.miercoles26.config.LectorFichero;
import com.abril.miercoles26.patronRepository.domain.Telefono;
import com.abril.miercoles26.patronRepository.repository.TelefonoRepository;
import com.abril.miercoles26.patronRepository.repository.TelefonoRepositoryMySQL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TelefonoRepositoryTest {

    // variable de tipo interface
    private static TelefonoRepository repositorio;

    @BeforeAll
    public static void inicializarGlobal() {

        repositorio = new TelefonoRepositoryMySQL();
    }

    @BeforeEach
    public void inicializar() throws IOException {

        LectorFichero lector = new LectorFichero("public/cargartelefonostest.sql");
        DataBaseHelper2 dataBaseHelper = new DataBaseHelper2();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper);
        cargador.cargarFichero();
    }

    @Test
    public void buscarTodosTest() {

        List<Telefono> lista = repositorio.buscarTodos();
        assertTrue(lista.size() >= 5);

    }

    @Test
    public void buscarTelefonoesBaratosTest() {

        List<Telefono> lista = repositorio.buscarTelefonosBaratos(300);
        assertTrue(lista.size() >= 2);

    }

    @Test
    public void buscarTelefonoescAROSTest() {

        List<Telefono> lista = repositorio.buscarTelefonosCaros(700);
        assertTrue(lista.size() >= 2L);

    }

    @Test
    public void buscarUnoEncontradoTest() {

        Telefono telefono = repositorio.buscarUno(1);

        assertEquals(1, telefono.getNumero());
        assertEquals("apple", telefono.getModelo());
        assertEquals(1200, telefono.getPrecio(), 0);

    }

    @Test
    public void buscarUnoNoEncontradoTest() {

        Telefono telefono = repositorio.buscarUno(1000);
        assertNull(telefono);
    }


    @Test
    public void borrarTest() {

        Telefono telefono = new Telefono(1);
        repositorio.borrar(telefono);
        Telefono telefonoBorrado = repositorio.buscarUno(1);
        assertNull(telefonoBorrado);
        ;
    }

    @Test
    public void insertarTest() {

        Telefono telefono = new Telefono(7, "xiaomi", "modelo7", 450.60);
        Telefono telefonoInsertado = repositorio.insertar(telefono);
        assertEquals(telefono, telefonoInsertado);
    }

    @Test
    public void actualizarTest() {

        Telefono telefono = new Telefono(6);
        Telefono telefonoActualizado = repositorio.actualizar(telefono, "xiaomi", "modelo8", 1200);

        assertEquals(telefono, telefonoActualizado);
    }

    @Test
    public void obtenerMediaTest() {

        double media = repositorio.mediaPrecios();

        assertEquals(688.5, media);
    }


}
