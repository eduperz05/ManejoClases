package com.abril.viernes21.factura;

public class FacturaIVA extends Factura {

    public FacturaIVA(double dinero, String usuario) {
        super(dinero, usuario);
    }

    @Override
    public double getFactura() {
        return dinero * 1.21;
    }
}
