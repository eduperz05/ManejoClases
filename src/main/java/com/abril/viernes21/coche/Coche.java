package com.abril.viernes21.coche;

public abstract class Coche {
    private String modelo;
    private double precio;

    public Coche(String modelo, double precio) {
        this.modelo = modelo;
        this.precio = precio;
    }

    public abstract void arrancar ();

    public abstract void acelerar ();

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }
}
