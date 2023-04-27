package com.abril.miercoles26.test.basic;

import com.abril.miercoles26.config.LectorFichero;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LectorFicheroTest {

    @Test
    void testLeerLineas() throws IOException {

        LectorFichero lector = new LectorFichero("cargaDatos.sql");
        int lineas = lector.leerLineas().size();
        assertEquals(1, lineas);
    }
}
