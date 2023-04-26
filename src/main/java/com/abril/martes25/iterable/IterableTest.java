package com.abril.martes25.iterable;

import java.util.ArrayList;

public class IterableTest {

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("hola");
        lista.add("que");
        lista.add("tal");
        lista.add("como");
        lista.add("estas");

        //cadena o string es un objeto que tiene equals y
        // hash code
        lista.remove("hola");
        for (String cadena : lista) {
            System.out.println(cadena);
        }

        
    }
}
