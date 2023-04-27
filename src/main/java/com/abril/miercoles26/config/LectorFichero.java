package com.abril.miercoles26.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectorFichero {

    private String fichero;

    public LectorFichero(String fichero) {
        this.fichero = fichero;
    }

    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

    // es un lector generico
    public List<String> leerLineas() throws IOException {

        List<String> listaLineas = new ArrayList<String>();
        Path path = Paths.get(fichero);
        listaLineas = Files.readAllLines(path, StandardCharsets.UTF_8);
        return listaLineas;
    }
}