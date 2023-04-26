package org.example;
import com.abril.jueves20.persona.Impresora;
import com.abril.jueves20.persona.Impresora2023;
import com.abril.jueves20.persona.ImpresoraLaser;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        imprimir(new Impresora(), "hola amigos");
        imprimir(new Impresora2023(), "hola amigos");
        imprimir(new ImpresoraLaser(), "hola amigos");
    }

    public static void imprimir(Impresora impresora, String texto) {
        impresora.imprimir(texto);
    }
}