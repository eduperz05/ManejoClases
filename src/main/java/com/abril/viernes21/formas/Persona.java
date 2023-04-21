package com.abril.viernes21.formas;

public class Persona {
    private final String nombre;
    private static int contador;

    public Persona(String nombre) {
        this.nombre = nombre;
        Persona.contador++;
    }

    public String getNombre() {
        return nombre;
    }

    public static int getContador() {
        return contador;
    }
}
