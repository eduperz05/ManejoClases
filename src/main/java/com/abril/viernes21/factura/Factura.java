package com.abril.viernes21.factura;

public abstract class Factura {
    protected double dinero;
    protected String usuario;

    public Factura(double dinero, String usuario) {
        this.dinero = dinero;
        this.usuario = usuario;
    }

    public abstract double getFactura ();

    public double getDinero() {
        return dinero;
    }

    public String getUsuario() {
        return usuario;
    }
}
