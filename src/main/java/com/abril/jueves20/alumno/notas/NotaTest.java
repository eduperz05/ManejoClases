package com.abril.jueves20.alumno.notas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotaTest {

    @Test
    public void failed () {
        Nota n1 =new Nota(4);
        boolean suspendido = n1.failed();

        assertTrue(suspendido);
    }
    @Test
    public void passed () {
        Nota n1 =new Nota(6);
        boolean aprobado = n1.passed();

        assertTrue(aprobado);
    }
    @Test
    public void salient () {
        Nota n1 =new Nota(9.5);
        boolean sobresaliente = n1.salient();

        assertTrue(sobresaliente);
    }

    @Test
    public void negativeNoteTest () {
        assertThrows(Exception.class, () -> new Nota(-1));
    }
    @Test
    public void over10NoteTest () {
        assertThrows(Exception.class, () -> new Nota(11));
    }

}
