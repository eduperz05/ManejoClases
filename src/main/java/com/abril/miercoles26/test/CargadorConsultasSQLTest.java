package com.abril.miercoles26.test;

import com.abril.miercoles26.config.CargadorConsultasSQL;
import com.abril.miercoles26.config.DataBaseHelper2;
import com.abril.miercoles26.config.LectorFichero;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CargadorConsultasSQLTest {

    @Test
    void testCargarFichero() throws IOException {

        LectorFichero lector = new LectorFichero("cargaDatos.sql");
        DataBaseHelper2 dataBaseHelper2 = new DataBaseHelper2();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper2);
        int lineas = cargador.cargarFichero();
        assertEquals(1, lineas);
    }
}