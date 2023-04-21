package com.persona;

public class ImpresoraLaser extends Impresora{

    @Override
    public void imprimir(String texto) {
        System.out.println(texto);
        System.out.println("Imprime 20 páginas por minuto.");
    }
}
