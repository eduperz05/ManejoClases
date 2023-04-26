package com.abril.jueves20.vivienda;

public class Consola extends Dispositivo{

    public Consola(String nombre) {
        super(nombre);
    }


    @Override
    public void apagar() {
        System.out.println("Consola apagada.");
        conectado = false;
    }

    @Override
    public void encender() {
        System.out.println("Consola encendida.");
        conectado = false;
    }
}
