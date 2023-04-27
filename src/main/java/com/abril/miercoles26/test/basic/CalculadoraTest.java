package com.abril.miercoles26.test.basic;

import com.abril.miercoles26.patronRepository.domain.Calculadora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    public void sumaCorrecta() {
        Calculadora c = new Calculadora(5, 5, "+");
        double resultado = c.getResult();
        assertEquals(10, resultado);
    }
}
