package com.vivienda;

public class Lampara extends Dispositivo{

    public Lampara(String nombre) {
        super(nombre);
    }


    @Override
    public void apagar() {
        System.out.println("Lámpara apagada.");
        conectado = false;
    }

    @Override
    public void encender() {
        System.out.println("Lámpara encendida.");
        conectado = false;
    }
}
