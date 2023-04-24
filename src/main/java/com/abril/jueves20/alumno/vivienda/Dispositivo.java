package com.abril.jueves20.alumno.vivienda;

public abstract class Dispositivo {
    private String Nombre;


    protected boolean conectado;

    public Dispositivo(String nombre) {
        Nombre = nombre;
        conectado = false;
    }

    public void apagar() {
        System.out.println("Dispositivo apagado.");
        conectado = false;
    }

    public void encender() {
        System.out.println("Dispositivo encendido.");
        conectado = true;
    }
    public String getNombre() {
        return Nombre;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
