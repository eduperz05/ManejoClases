package com.abril.viernes21.coche;

public class BMW extends Coche{
    public BMW(String modelo, double precio) {
        super(modelo, precio);
    }

    @Override
    public void arrancar() {
        System.out.println("El coche arranca con llave electronica.");
    }

    @Override
    public void acelerar() {
        System.out.println("El coche acelera de 0 a 100 en 7seg.");
    }
}
