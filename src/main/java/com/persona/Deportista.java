package com.persona;

public class Deportista extends Persona{

    public Deportista(String nombre) {
        super(nombre);
    }

    @Override
    public String andar() {
        return "El deportista anda muy rápido";
    }
}
