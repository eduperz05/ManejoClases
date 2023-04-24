package com.abril.jueves20.alumno.muro;

public class Azulejo {

    private final double lado;

    public Azulejo(double lado) {
        this.lado = lado;
    }

    public double perimetro () {
        return lado * 4;
    }

    public double area () {
        return lado * lado;
    }
}
