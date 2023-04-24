package com.abril.jueves20.alumno.notas;

public class Nota {

    private double qualification;

    public Nota(double qualification) {
        setQualification(qualification);
    }

    public void setQualification(double qualification) {
        if (qualification < 0 || 10 < qualification)
            throw new IllegalArgumentException("Calificación no valida");
        this.qualification = qualification;
    }

    public boolean failed () {
        return 5 > qualification;
    }

    public boolean passed () {
        return 5 <= qualification;
    }

    public boolean salient () {
        return 9 <= qualification;
    }

    public double getQualification() {
        return qualification;
    }
}
