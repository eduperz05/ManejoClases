package com.abril.viernes21.factura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacturaTest {

    @Test
    void getFacturaIVATest() {
        Factura f1 = new FacturaIVA(100, "jose");
        double d1 = f1.getFactura();
        assertEquals(79, d1, 0.1);
    }

    @Test
    void getFacturaIVAReducidoTest() {
        Factura f1 = new FacturaIVAReducida(100,"jose");
        double d1 = f1.getFactura();
        assertEquals(90, d1, 0.1);
    }

    @Test
    void getFacturaSinIVATest() {
        Factura f1 = new FacturaSinIVA(100, "jose");
        double d1 = f1.getFactura();
        assertEquals(100, d1, 0.1);
    }
}