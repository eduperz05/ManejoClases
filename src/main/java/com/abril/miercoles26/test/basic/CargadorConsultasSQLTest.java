package com.abril.miercoles26.test.basic;

import com.abril.miercoles26.config.CargadorConsultasSQL;
import com.abril.miercoles26.config.DataBaseHelper2;
import com.abril.miercoles26.config.LectorFichero;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CargadorConsultasSQLTest {

    @Test
    void testCargarFichero() throws IOException {

        //ARRANGE
        LectorFichero lector = Mockito.mock(LectorFichero.class);
        List<String> lista = new ArrayList<>();
        lista.add("insert into ordenador (numero, modelo, precio) values (1, 'm1', 500);");
        lista.add("insert into ordenador (numero, modelo, precio) values (2, 'intel', 500.50);");
        when(lector.leerLineas()).thenReturn(lista);
        DataBaseHelper2 dataBaseHelper2 = Mockito.mock(DataBaseHelper2.class);
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper2);

        //ACT
        int lineas = cargador.cargarFichero();

        //ASSERTIONS
        verify(dataBaseHelper2, times(2)).executarConsulta(anyString());
        assertEquals(2, lineas);
    }
}