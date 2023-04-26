package com.abril.lunes24.impresora;

public class Impresora implements Imprimible {
    private int nSerie;
    protected Paginas paginas;

    public Impresora(int nSerie, Paginas paginas) {
        this.nSerie = nSerie;
        this.paginas = paginas;
    }

    public int getnSerie() {
        return nSerie;
    }

    public Paginas getPaginas() {
        return paginas;
    }

    @Override
    public Paginas imprimir() {
        return paginas;
    }

    @Override
    public Paginas imprimir(Paginas paginas) {
        return paginas;
    }
}
