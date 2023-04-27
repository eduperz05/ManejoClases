package com.abril.miercoles26.test.basic;

import com.abril.miercoles26.patronRepository.domain.Nota;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotaTest {


    @Test
    public void notaAprobada() {

        Nota nota = new Nota(6);
        assertTrue(nota.esAprobada());

    }
}
