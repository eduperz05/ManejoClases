package com.alumno.array;

import com.notas.Nota;

public class Alumno {

    private Nota[] notas = new Nota[3];

    public Alumno(Nota[] notas) {
        if (notas.length != 3)
            throw new IllegalArgumentException("Tienes que añadir 3 notas");
        setNotas(notas);
    }

    public Nota mayorNota() {
        Nota nota = new Nota(0);
        for (Nota value : notas) {
            if (nota.getQualification() < value.getQualification())
                nota = value;
        }
        return nota;
    }

    public Nota[] getNotas() {
        return notas;
    }

    public void setNotas(Nota[] notas) {
        this.notas = notas;
    }
}
