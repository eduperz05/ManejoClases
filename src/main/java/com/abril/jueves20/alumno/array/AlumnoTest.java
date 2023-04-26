package com.abril.jueves20.alumno.array;

import com.abril.jueves20.notas.Nota;
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
        assertEquals(n3, notaMayor);
    }
}
