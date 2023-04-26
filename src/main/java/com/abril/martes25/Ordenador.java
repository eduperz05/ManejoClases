package com.abril.martes25;

public class Ordenador {

    private int numero;
    private String modelo;
    private double precio;
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
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
    public Ordenador(int numero, String modelo, double precio) {
        this.numero = numero;
        this.modelo = modelo;
        this.precio = precio;
    }


}