package com.abril.jueves20.vivienda;

import java.util.ArrayList;

public class Habitacion {
    private String nombre;
    private ArrayList<Mueble> muebles;

    public Habitacion(String nombre, ArrayList<Mueble> muebles) {
        this.nombre = nombre;
        this.muebles = muebles;
    }

    public Habitacion() {
    }

    public double getprecioMuebles () {
        double precio = 0;
        for (Mueble mueble: muebles) {
            precio += mueble.getPrecio();
        }
        return precio;
    }

}
