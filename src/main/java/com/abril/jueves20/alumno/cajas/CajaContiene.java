package com.abril.jueves20.alumno.cajas;

public class CajaContiene {

    private Caja Caja1;
    private Caja caja2;

    public CajaContiene(Caja caja1, Caja caja2) {
        Caja1 = caja1;
        this.caja2 = caja2;
    }

    public double pesoTotal() {
        return getCaja1().getPeso() + getCaja2().getPeso();
    }

    public Caja getCaja1() {
        return Caja1;
    }

    public void setCaja1(Caja caja1) {
        Caja1 = caja1;
    }

    public Caja getCaja2() {
        return caja2;
    }

    public void setCaja2(Caja caja2) {
        this.caja2 = caja2;
    }
}
