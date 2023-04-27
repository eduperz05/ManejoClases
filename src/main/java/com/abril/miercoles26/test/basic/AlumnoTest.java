package com.abril.miercoles26.test.basic;

import com.abril.miercoles26.patronRepository.domain.Alumno;
import com.abril.miercoles26.patronRepository.domain.Nota;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlumnoTest {

    @Test
    public void notaEstaAprobadaTest() {

        Nota nota = Mockito.mock(Nota.class);
        when(nota.esAprobada()).thenReturn(true);

        Alumno alumno = new Alumno("pepe", nota);

        assertTrue(alumno.notaEstaAprobada());

    }
}
