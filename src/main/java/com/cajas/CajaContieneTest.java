package com.cajas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CajaContieneTest {

    @Test
    public void pesoTotalTest() {

        Caja c1 = new Caja(2);
        Caja c2 = new Caja(4);
        CajaContiene cc = new CajaContiene(c1, c2);
        double pesoTotal = cc.pesoTotal();
        assertEquals(6, pesoTotal, 0.1);
    }
}
