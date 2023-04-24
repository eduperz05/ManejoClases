package com.abril.jueves20.alumno.arraylist;

import com.abril.jueves20.alumno.notas.Nota;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private ArrayList<Nota> notas = new ArrayList<Nota>();

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public void addNota(Nota nota) {
        notas.add(nota);
    }

    public void addNota(ArrayList<Nota> nota) {
        notas.addAll(nota);
    }

    public Nota getMejorNota() {
        Nota mayor = new Nota(0);
        for(Nota nota: notas) {
            if(mayor.getQualification() < nota.getQualification()) {
                mayor=nota;
            }
        }
        return mayor;
    }

    public Nota getPeorNota() {
        Nota menor = new Nota(10);
        for(Nota nota: notas) {
            if(menor.getQualification() > nota.getQualification()) {
                menor=nota;
            }
        }
        return menor;
    }

    public Nota getNotaMedia() {
       double total=0;

        for (Nota nota : notas) {
            total += nota.getQualification();
        }
        
        double media = total/notas.size();
        return new Nota(media);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }



}
