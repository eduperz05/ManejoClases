package com.abril.lunes24.impresora;

public class ImpresoraLaser extends Impresora{
    public ImpresoraLaser(int nSerie, Paginas paginas) {
        super(nSerie, paginas);
    }

    @Override
    public Paginas imprimir() {
        System.out.println("Imprimiendo a la velocidad de la luz.");
        return super.imprimir();
    }

    @Override
    public Paginas imprimir(Paginas paginas) {
        System.out.println("Imprimiendo a la velocidad de la luz.");
        return super.imprimir(paginas);
    }
}
