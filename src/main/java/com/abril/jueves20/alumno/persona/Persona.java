package com.abril.jueves20.alumno.persona;

public class Persona {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String andar() {
        return "Esta andando";
    }

    public String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }
}
