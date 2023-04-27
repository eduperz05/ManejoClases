package com.abril.miercoles26.patronRepository.domain;


public class Nota {

    private double valor;

    public Nota(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean esAprobada() {

        return valor >= 8;
    }

}