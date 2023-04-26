package com.vivienda;

import com.abril.jueves20.vivienda.Habitacion;
import com.abril.jueves20.vivienda.Mesa;
import com.abril.jueves20.vivienda.Mueble;
import com.abril.jueves20.vivienda.Sillas;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HabitacionTest {

    @Test
    void getprecioMuebles() {
        Mueble sillas = new Sillas("Bancos", 15, 3);
        Mueble mesa = new Mesa("Escritorio", 120.20);
        ArrayList<Mueble> muebles = juntarMuebles(sillas,mesa);
        Habitacion cuarto = new Habitacion("dormitorio", muebles);
        double precioMuebles = cuarto.getprecioMuebles();
        assertEquals(165.2, precioMuebles, 0.1);
    }

    private ArrayList<Mueble> juntarMuebles(Mueble ... muebles) {
        return new ArrayList<Mueble>(Arrays.asList(muebles));
    }
}