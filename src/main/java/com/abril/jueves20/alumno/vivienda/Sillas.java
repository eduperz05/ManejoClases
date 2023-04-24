package com.abril.jueves20.alumno.vivienda;

public class Sillas extends Mueble {

    private final int cantidad;
    public Sillas(String nombre, double precio, int cantidad) {
        super(nombre, precio);
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio * cantidad;
    }


}
