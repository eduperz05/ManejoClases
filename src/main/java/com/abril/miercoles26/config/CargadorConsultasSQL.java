package com.abril.miercoles26.config;

import java.io.IOException;
import java.util.List;

public class CargadorConsultasSQL {

    private final LectorFichero lector;

    private final DataBaseHelper2 dataBaseHelper2;

    public CargadorConsultasSQL(LectorFichero lector, DataBaseHelper2 dataBaseHelper2) {
        this.lector = lector;
        this.dataBaseHelper2 = dataBaseHelper2;
    }

    public int cargarFichero() throws IOException {

        List<String> lineas = lector.leerLineas();
        for (String linea : lineas) {
            dataBaseHelper2.executarConsulta(linea);
        }
        return lineas.size();
    }
}
