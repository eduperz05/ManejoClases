package com.alumno;

import com.notas.Nota;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlumnoTest {

    @Test
    public void mayorNotaTest () {
        Nota n1 = new Nota(3.3);
        Nota n2 = new Nota(5.1);
        Nota n3 = new Nota(8.6);
        Nota[] notas = {n1,n2,n3};
        Alumno alumno = new Alumno(notas);
        Nota notaMayor = alumno.mayorNota();
        assertEquals(8.6, notaMayor.getQualification(), 0.1);
    }
}
