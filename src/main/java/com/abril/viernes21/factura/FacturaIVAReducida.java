package com.abril.viernes21.factura;

public class FacturaIVAReducida extends Factura{

    public FacturaIVAReducida(double dinero, String usuario) {
        super(dinero, usuario);
    }

    @Override
    public double getFactura() {
        return dinero * 1.10;
    }
}
