package com.abril.martes25.iterable;


import java.util.ArrayList;
import java.util.Iterator;

public class IterableL {

    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<>();

        lista.add("hola");
        lista.add("que");
        lista.add("tal");
        lista.add("como");
        lista.add("estas");

        Iterable<String> iterable = lista;

        Iterator<String> iterador = iterable.iterator();

        while (iterador.hasNext()) {
            String texto = iterador.next();
            System.out.println(texto);
            if (texto.equals("hola")) {
                iterador.remove();
            }
        }

        System.out.println("/////////////");

        iterador = iterable.iterator();
        while (iterador.hasNext()) {
            String texto = iterador.next();
            System.out.println(texto);
        }

        for (String elemento : lista) {
            System.out.println(elemento);
        }
    }
}
