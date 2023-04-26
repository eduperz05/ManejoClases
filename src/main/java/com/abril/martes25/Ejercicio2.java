package com.abril.martes25;

import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<FacturaAR> facturas = FacturaAR.buscarTodas();

        for (FacturaAR f : facturas) {
            System.out.println(f.getConcepto());
        }

        FacturaAR f = new FacturaAR(1);
        f.borrar();
    }
}
