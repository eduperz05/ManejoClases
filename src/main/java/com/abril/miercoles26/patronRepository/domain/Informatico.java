package com.abril.miercoles26.patronRepository.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Informatico {

    private String nombre;
    private Calculadora calculadora;

    public Informatico(String nombre, Calculadora calculadora) {
        this.nombre = nombre;
        this.calculadora = calculadora;
    }

    public Informatico(String nombre) {
        this.nombre = nombre;
    }

    public Informatico() {
    }

    public ArrayList<Double> operar() {
        return this.calculadora.calcular();
    }

    public ArrayList<Double> operar(double num1, double num2, String op) {
        calculadora = new Calculadora(num1, num2, op);
        return operar();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Informatico that)) return false;
        return Objects.equals(nombre, that.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
