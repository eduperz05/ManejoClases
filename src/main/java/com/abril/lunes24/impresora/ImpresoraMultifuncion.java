package com.abril.lunes24.impresora;

public class ImpresoraMultifuncion extends Impresora{
    public ImpresoraMultifuncion(int nSerie, Paginas paginas) {
        super(nSerie, paginas);
    }

    @Override
    public Paginas imprimir() {
        System.out.println("Deseas realizar otra opción?");
        return super.imprimir();
    }

    @Override
    public Paginas imprimir(Paginas paginas) {
        System.out.println("Deseas realizar otra opción?");
        return super.imprimir(paginas);
    }

    public void escanear(Paginas paginas) {
        super.paginas = paginas;
    }
}
