package com.muro;
import com.abril.jueves20.muro.Azulejo;
import com.abril.jueves20.muro.Pared;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParedTest {


    ArrayList<Azulejo> azulejos;
    Pared pared;

    @Test
    void area() {
        azulejos = new ArrayList<>();
        int cantidadAzulejos = 20;
        float lado = 3;
        for (int i = 0; i < cantidadAzulejos; i++) {
            azulejos.add(new Azulejo(lado));
        }
        pared = new Pared(azulejos);
        double area = pared.area();
        assertEquals(180, area, 0.1);
    }
}