package com.abril.jueves20.alumno.persona;

public class Impresora2023 extends Impresora{

    @Override
    public void imprimir(String texto) {
        System.out.println(texto);
        System.out.println("Imprime 5 páginas por minuto.");
    }
}
