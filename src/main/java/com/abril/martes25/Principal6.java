package com.abril.martes25;


import java.util.List;

public class Principal6 {

    public static void main(String[] args) {

        List<OrdenadorAR> lista = OrdenadorAR.buscarPorConcepto("modelo2");
        List<OrdenadorAR> lista2 = OrdenadorAR.buscarPorRangoPrecio(500, 1000);

        OrdenadorAR o = new OrdenadorAR(1);
        o.actualizar(1, "modelo3", 550.30);
        OrdenadorAR o2 = OrdenadorAR.buscarUno(2);

        System.out.println(o2.getModelo());

        System.out.println("Ordenadores del modelo 2");
        for (OrdenadorAR or : lista) {
            System.out.println(or.getNumero() + " : " + or.getModelo());
        }

        System.out.println("Ordenadores por Rango de precio entre 500 y 1000.");
        for (OrdenadorAR or : lista2) {
            System.out.println(or.getNumero() + " : " + or.getModelo());
        }
    }
}