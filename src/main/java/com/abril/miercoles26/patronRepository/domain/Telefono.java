package com.abril.miercoles26.patronRepository.domain;

import java.util.Objects;

public class Telefono {

    private int numero;
    private String marca;
    private String modelo;
    private double precio;

    public Telefono() {
    }

    public Telefono(int numero) {
        this.numero = numero;
    }

    public Telefono(int numero, String marca, String modelo, double precio) {
        this.numero = numero;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefono telefono)) return false;
        return getNumero() == telefono.getNumero();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
