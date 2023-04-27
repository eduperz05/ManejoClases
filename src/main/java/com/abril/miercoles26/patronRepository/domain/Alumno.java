package com.abril.miercoles26.patronRepository.domain;


public class Alumno {

    private String nombre;
    private Nota nota;

    public Alumno(String nombre, Nota nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public boolean notaEstaAprobada() {
        return nota.esAprobada();
    }


}