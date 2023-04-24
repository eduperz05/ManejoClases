package com.alumno.arraylist;

import com.abril.jueves20.alumno.arraylist.AlumnoVIP;
import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoVIPTest {

    @Test
    void getPorcentajeBeca() {
        AlumnoVIP alumno = new AlumnoVIP("pedro", "normal");
        double porcentajeBeca = alumno.getPorcentajeBeca();
        assertEquals(0.2, porcentajeBeca, 0.1);
    }
}