package com.abril.lunes24.interfaceConectable;

public class Principal {
    public static void main(String[] args) {

        Conectable c =new  Bombilla();

        c.on();
        c.off();
        c= new Televisor();

        c.on();
        c.off();
    }
}
