package com.alumno.arraylist;

import com.notas.Nota;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlumnoTest {

    @Test
    public void addNotaTest () {
        Alumno alumno = new Alumno("pedro");
        alumno.addNota(new Nota(5));
        int numeroNotas = alumno.getNotas().size();
        assertEquals(1, numeroNotas);
    }

    @Test
    public void addGroupNotaTest () {
        Alumno alumno = new Alumno("pedro");
        ArrayList<Nota> lista = crearNotas(4,3,5,8);
        alumno.addNota(lista);
        int numeroNotas = alumno.getNotas().size();
        assertEquals(4, numeroNotas);
    }

    @Test
    public void mejorNotaTest () {
        Alumno alumno = new Alumno("pedro");
        ArrayList<Nota> lista = crearNotas(4,3,5,8);
        alumno.setNotas(lista);
        Nota notaMayor = alumno.getMejorNota();

        assertEquals(8,notaMayor.getQualification());
    }
    @Test
    public void peorNotaTest () {
        Alumno alumno = new Alumno("pedro");
        ArrayList<Nota> lista = crearNotas(4,3,5,8);
        alumno.setNotas(lista);
        Nota notaMayor = alumno.getPeorNota();

        assertEquals(3,notaMayor.getQualification());
    }

    @Test
    public void notaMediaTest() {
        Alumno alumno = new Alumno("pedro");
        ArrayList<Nota> lista = crearNotas(4,3,5,8);
        alumno.setNotas(lista);
        Nota notaMedia = alumno.getNotaMedia();
        assertEquals(5, notaMedia.getQualification(), 0.1);
    }

    private ArrayList<Nota> crearNotas(double ... qualifications) {
        ArrayList<Nota> lista = new ArrayList<Nota>();
        for (double q: qualifications) {
            lista.add(new Nota(q));
        }
        return lista;
    }
}
