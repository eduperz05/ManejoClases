package com.abril.lunes24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LectorFicheroTest {

    @Test
    public void elFicheroNoExiste() throws IOException {
        LectorFichero lector = new LectorFichero("noexiste.txt");
        assertThrows(IOException.class, lector::leerLineas);
    }
    @Test
    public void leerLineasNoEsNulo() throws IOException {
        LectorFichero lector = new LectorFichero("facturastest1.txt");
        List<String> listaCadenas = lector.leerLineas();
        assertNotNull(listaCadenas);
    }
    @Test
    public void leerLineasDeFichero() throws IOException {
        LectorFichero lector = new LectorFichero("facturastest1.txt");
        List<String> listaCadenas = lector.leerLineas();
        assertEquals(3, listaCadenas.size());
    }
}
