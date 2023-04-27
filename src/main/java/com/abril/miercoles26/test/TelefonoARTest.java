package com.abril.miercoles26.test;

import com.abril.miercoles26.config.CargadorConsultasSQL;
import com.abril.miercoles26.config.DataBaseHelper2;
import com.abril.miercoles26.config.LectorFichero;
import com.abril.miercoles26.patronActiveRecord.telefono.TelefonoAR;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TelefonoARTest {

    @BeforeEach
    void setUp() throws IOException {
        LectorFichero lector = new LectorFichero("./public/cargartelefonostest.sql");
        DataBaseHelper2 dataBaseHelper2 = new DataBaseHelper2();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper2);
        cargador.cargarFichero();
    }

    @Test
    public void buscarTodosTest() {
        List<TelefonoAR> lista = TelefonoAR.buscarTodos();
        assertEquals(6, lista.size());
    }


    @Test
    public void buscarOrdenadoresBaratosTest() {

        List<TelefonoAR> lista = TelefonoAR.buscarTelefonoesBaratos(300);
        assertTrue(lista.size() <= 2);
    }

    @Test
    public void buscarUnoTest() {
        TelefonoAR or = TelefonoAR.buscarUno(1);
        assertEquals(1, or.getNumero());
        assertEquals("apple", or.getModelo());
        assertEquals(1200, or.getPrecio(), 0);
    }

    @Test
    public void buscarUnoNoEncontradoTest() {
        TelefonoAR or = TelefonoAR.buscarUno(10);
        assertNull(or);
    }

    @Test
    void borrarTest() {
        TelefonoAR telefono = new TelefonoAR(1);
        telefono.borrar();
        TelefonoAR telefonoBorrado = TelefonoAR.buscarUno(1);
        assertNull(telefonoBorrado);
    }

    @Test
    void insertarTest() throws SQLException {
        TelefonoAR or = new TelefonoAR(7, "xiaomi", "modelo7", 450.60);
        TelefonoAR orInsertado = or.insertar();
        assertEquals(or, orInsertado);
    }
}