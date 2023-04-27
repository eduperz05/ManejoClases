package com.abril.miercoles26.test;

import com.abril.miercoles26.config.CargadorConsultasSQL;
import com.abril.miercoles26.config.DataBaseHelper2;
import com.abril.miercoles26.config.LectorFichero;
import com.abril.miercoles26.patronActiveRecord.ordenador.OrdenadorAR2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrdenadorAR2Test {

    @BeforeEach
    public void inicializar() throws IOException {

        LectorFichero lector = new LectorFichero("./public/cargartelefonostest.sql");
        DataBaseHelper2 dataBaseHelper2 = new DataBaseHelper2();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper2);
        cargador.cargarFichero();
    }

    @Test
    public void buscarTodosTest() {
        List<OrdenadorAR2> lista = OrdenadorAR2.buscarTodos();
        assertTrue(lista.size() > 5);
    }

    @Test
    public void buscarOrdenadoresBaratosTest() {

        List<OrdenadorAR2> lista = OrdenadorAR2.buscarOrdenadoresBaratos(300);
        assertTrue(lista.size() <= 2);
    }

    @Test
    public void buscarUnoTest() {
        OrdenadorAR2 or = OrdenadorAR2.buscarUno(1);
        assertEquals(1, or.getNumero());
        assertEquals("m1", or.getModelo());
        assertEquals(500, or.getPrecio(), 0);
    }

    @Test
    public void buscarUnoNoEncontradoTest() {
        OrdenadorAR2 or = OrdenadorAR2.buscarUno(10);
        assertNull(or);
    }

    @Test
    void borrarTest() {
        OrdenadorAR2 ordenador = new OrdenadorAR2(1);
        ordenador.borrar();
        OrdenadorAR2 ordenadorBorrado = OrdenadorAR2.buscarUno(1);
        assertNull(ordenadorBorrado);
        ;
    }

    @Test
    void insertarTest() throws SQLException {
        OrdenadorAR2 or = new OrdenadorAR2(10, "tablet", 905);
        OrdenadorAR2 orInsertado = or.insertar();
        assertEquals(or, orInsertado);
    }
}
