package com.vivienda;

import com.abril.jueves20.vivienda.Consola;
import com.abril.jueves20.vivienda.Dispositivo;
import com.abril.jueves20.vivienda.Lampara;
import com.abril.jueves20.vivienda.Televisor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class DispositivoTest {

    @Test
    void apagarTest() {
        Dispositivo television = new Televisor("Tele");
        Dispositivo lampara = new Lampara("lamparita");
        Dispositivo consola = new Consola("Xbox");
        ArrayList<Dispositivo> dispositivos= añadirDispositivos( television, lampara, consola);

    }

    @Test
    void encenderTest() {
    }

    public ArrayList<Dispositivo> añadirDispositivos (Dispositivo ... dispositivos) {
        return new ArrayList<>(Arrays.asList(dispositivos));
    }
}