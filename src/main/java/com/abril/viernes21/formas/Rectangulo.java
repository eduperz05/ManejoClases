package com.abril.viernes21.formas;

public class Rectangulo {
    private final double lado1;
    private final double lado2;

    public Rectangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public double area () {
        return Rectangulo.area(lado1,lado2);
    }

    public static double area ( double lado1, double lado2) {
        return lado1 * lado2;
    }
    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }
}
