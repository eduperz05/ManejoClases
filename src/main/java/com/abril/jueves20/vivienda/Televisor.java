package com.abril.jueves20.vivienda;

public class Televisor extends Dispositivo{

    public Televisor(String nombre) {
        super(nombre);
    }


    @Override
    public void apagar() {
        System.out.println("Televisión apagada.");
        conectado = false;
    }

    @Override
    public void encender() {
        System.out.println("Televisión encendida.");
        conectado = false;
    }
}
