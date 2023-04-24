package com.abril.jueves20.alumno.vivienda;

public abstract class Mueble {
    public String getNombre() {
        return nombre;
    }

    private String nombre;
    protected double precio;

    public Mueble(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
