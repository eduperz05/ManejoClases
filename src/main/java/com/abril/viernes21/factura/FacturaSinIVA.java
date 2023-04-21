package com.abril.viernes21.factura;

public class FacturaSinIVA extends Factura {

    public FacturaSinIVA(double dinero, String usuario) {
        super(dinero, usuario);
    }

    @Override
    public double getFactura() {
        return dinero;
    }
}
