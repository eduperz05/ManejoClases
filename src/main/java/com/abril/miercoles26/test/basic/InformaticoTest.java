package com.abril.miercoles26.test.basic;

import com.abril.miercoles26.patronRepository.domain.Calculadora;
import com.abril.miercoles26.patronRepository.domain.Informatico;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class InformaticoTest {

    @Test
    public void resultadoCorrectoSumaTest() {
        Calculadora c = Mockito.mock(Calculadora.class);
        ArrayList<Double> lista = new ArrayList<>(Arrays.asList(10.0, 0.0));
        when(c.calcular(5, 5, "+")).thenReturn(lista);

        Informatico informatico = new Informatico("pepe", c);

        assertEquals(10, informatico.operar(5, 5, "+").get(0));
    }
}
