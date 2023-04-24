package com.abril.jueves20.alumno.arraylist;

public class AlumnoVIP extends Alumno {

    private String tipoBeca;

    public AlumnoVIP(String nombre, String tipoBeca) {
        super(nombre);
        this.tipoBeca = tipoBeca;
    }

    public double getPorcentajeBeca (){
        if (tipoBeca.equals(("normal"))) {
            return 0.2;
        }
        return 0.3;
    }

    public String getTipoBeca() {
        return tipoBeca;
    }

    public void setTipoBeca(String tipoBeca) {
        this.tipoBeca = tipoBeca;
    }
}
