package com.abril.viernes21.formas;

public class Principal {
    public static void main(String[] args) {

        Rectangulo  r1 = new Rectangulo(1,2);
        Rectangulo  r2 = new Rectangulo(2,2);
        Persona p1 = new Persona("jose");
        Persona p2 = new Persona("maria");

        System.out.println(r1.area());
        System.out.println(r2.area());
        System.out.println(Persona.getContador());
    }
}
