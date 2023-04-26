package com.abril.lunes24.interfaceConectable;

public class Televisor implements Conectable{

    @Override
    public void on() {
        System.out.println("el televisor se enciende");
    }

    @Override
    public void off() {
        System.out.println("el televisor se apaga");
    }


}