package com.abril.miercoles26.test.basic;

import com.abril.miercoles26.patronRepository.domain.Ordenador;
import com.abril.miercoles26.patronRepository.domain.Telefono;
import com.abril.miercoles26.patronRepository.repository.OrdenadorRepository;
import com.abril.miercoles26.patronRepository.repository.TelefonoRepository;
import com.abril.miercoles26.patronRepository.service.InformaticaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InformaticaServiceTest {

    @Mock
    private static OrdenadorRepository repositorioOrdenadorMock;
    @Mock
    private static TelefonoRepository repositorioTelefonoMock;
    @InjectMocks
    private static InformaticaService servicioInformatica;

    /// TEST TELEFONO

    @Test
    public void insertTelefonoTest() {
        //arrange
        Telefono telefono1 = new Telefono(600700800, "iphone", "XS", 1200);
        //mock
        when(repositorioTelefonoMock.insertar(telefono1)).thenReturn(telefono1);

        //act
        Telefono telefonoResultado = servicioInformatica.insertarTelefono(telefono1);
        //assertions
        verify(repositorioTelefonoMock, times(1)).insertar(telefono1);
        assertEquals(telefono1, telefonoResultado);
    }

    @Test
    public void insertarTelefonosTest() {
        //arrange
        Telefono tef1 = mock(Telefono.class);
        List<Telefono> lista = List.of(tef1, tef1, tef1);
        //mock
        when(repositorioTelefonoMock.insertar(any(Telefono.class)))
                .thenReturn(tef1, tef1, tef1, tef1);

        //act
        ArrayList<Telefono> listaResultado = servicioInformatica.insertarTelefonos(lista);
        //assertions
        verify(repositorioTelefonoMock, times(3)).insertar(any(Telefono.class));
        assertEquals(lista, listaResultado);
    }

    @Test
    public void actualizarTelefonoTest() {
        //arrange
        Telefono telefono1 = new Telefono(600700800, "iphone", "XS", 1200);
        Telefono telefonoMod = new Telefono(600700800, "iphone", "XL", 2000);
        //mock
        when(repositorioTelefonoMock.actualizar(telefono1, "iphone", "XL", 2000)).thenReturn(telefonoMod);

        //act
        Telefono telefonoResultado = servicioInformatica.actualizarTelefono(telefono1, "iphone", "XL", 2000);
        //assertions
        verify(repositorioTelefonoMock, times(1)).actualizar(telefono1, "iphone", "XL", 2000);
        assertEquals(telefonoMod, telefonoResultado);
    }

    @Test
    public void borrarTelefonosTest() {

        //arrange
        InformaticaService servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

        Telefono telefono1 = new Telefono(1);
        Telefono telefono2 = new Telefono(2);
        Telefono telefono3 = new Telefono(3);
        Telefono telefono4 = new Telefono(4);
        List<Telefono> lista = List.of(telefono1, telefono2, telefono3, telefono4);
        //act
        servicioInformatica.borrarTelefonos(lista);
        //assertions
        verify(repositorioTelefonoMock, times(4)).borrar(any(Telefono.class));
    }

    @Test
    public void buscarUnoTelefonoTest() {

        Telefono telefono1 = new Telefono(600700800, "iphone", "XS", 1200);
        //mock
        when(repositorioTelefonoMock.buscarUno(600700800)).thenReturn(telefono1);

        //act
        Telefono telefonoResultado = servicioInformatica.buscarUnoTelefono(600700800);

        verify(repositorioTelefonoMock, times(1)).buscarUno(600700800);
        assertEquals(telefono1, telefonoResultado);

    }

    /// TEST ORDENADOR

    @Test
    public void insertOrdenadorTest() {
        //arrange
        Ordenador ordenador = new Ordenador(1, "Mac", 1200);
        //mock
        when(repositorioOrdenadorMock.insertar(ordenador)).thenReturn(ordenador);

        //act
        Ordenador ordenadorResultado = servicioInformatica.insertarOrdenador(ordenador);
        //assertions
        verify(repositorioOrdenadorMock, times(1)).insertar(ordenador);
        assertEquals(ordenador, ordenadorResultado);
    }

    @Test
    public void insertarVariosOrdenadorTest() {
        //arrange
        Ordenador ordenador1 = new Ordenador(1, "Mac", 1200);
        Ordenador ordenador2 = new Ordenador(2, "Mac", 1200);
        Ordenador ordenador3 = new Ordenador(3, "Mac", 1200);
        Ordenador ordenador4 = new Ordenador(4, "Mac", 1200);
        List<Ordenador> lista = List.of(ordenador1, ordenador2, ordenador3, ordenador4);
        //mock
        when(repositorioOrdenadorMock.insertar(any(Ordenador.class)))
                .thenReturn(ordenador1, ordenador2, ordenador3, ordenador4);

        //act
        ArrayList<Ordenador> listaResultado = servicioInformatica.insertarOrdenadores(lista);
        //assertions
        verify(repositorioOrdenadorMock, times(4)).insertar(any(Ordenador.class));
        assertEquals(lista, listaResultado);
    }

    @Test
    public void borrarOrdenadorTest() {

        //arrange
        InformaticaService servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);
        Ordenador ordenador = new Ordenador(1);
        //act
        servicioInformatica.borrarOrdenador(ordenador);
        //assertions
        verify(repositorioOrdenadorMock, times(1)).borrar(ordenador);
    }

    @Test
    public void borrarOrdenadoresTest() {

        //arrange
        InformaticaService servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

        Ordenador ordenador1 = new Ordenador(1);
        Ordenador ordenador2 = new Ordenador(2);
        Ordenador ordenador3 = new Ordenador(3);
        Ordenador ordenador4 = new Ordenador(4);
        List<Ordenador> lista = List.of(ordenador1, ordenador2, ordenador3, ordenador4);
        //act
        servicioInformatica.borrarOrdenadores(lista);
        //assertions
        verify(repositorioOrdenadorMock, times(4)).borrar(any(Ordenador.class));
    }

    @Test
    public void actualizarOrdenadorTest() {
        //arrange
        Ordenador ordenador = new Ordenador(1, "Mac", 1200);
        Ordenador ordenadorMod = new Ordenador(1, "Lenovo", 500);
        //mock
        when(repositorioOrdenadorMock.actualizar(ordenador)).thenReturn(ordenadorMod);

        //act
        Ordenador ordenadorResultado = servicioInformatica.actualizarOrdenador(ordenador);
        //assertions
        verify(repositorioOrdenadorMock, times(1)).actualizar(ordenador);
        assertEquals(ordenadorMod, ordenadorResultado);
    }

    @Test
    public void buscarTodosOrdenadoresTest() {
        //arrange
        Ordenador telefono1 = new Ordenador(1, "Mac", 1200);
        Ordenador telefono2 = new Ordenador(2, "Lenovo", 500);
        List<Ordenador> listaOrdenadorMock = Arrays.asList(telefono1, telefono2);
        //mock
        when(repositorioOrdenadorMock.buscarTodos()).thenReturn(listaOrdenadorMock);

        //act
        List<Ordenador> listaOrdenadorResultado = servicioInformatica.buscarTodosOrdenadores();
        //assertions
        verify(repositorioOrdenadorMock, times(1)).buscarTodos();
        assertEquals(listaOrdenadorMock, listaOrdenadorResultado);
    }

    @Test
    public void buscarOrdenadoresBaratosTest() {
        //arrange
        Ordenador ordenador1 = new Ordenador(1, "Mac", 100);
        Ordenador ordenador2 = new Ordenador(2, "Lenovo", 200);
        List<Ordenador> listaOrdenadorMock = Arrays.asList(ordenador1, ordenador2);
        //mock
        when(repositorioOrdenadorMock.buscarOrdenadoresBaratos()).thenReturn(listaOrdenadorMock);

        //act
        List<Ordenador> listaOrdenadorResultado = servicioInformatica.buscarOrdenadoresBaratos();
        //assertions
        verify(repositorioOrdenadorMock, times(1)).buscarOrdenadoresBaratos();
        assertEquals(listaOrdenadorMock, listaOrdenadorResultado);
    }

    @Test
    public void buscarUnoOrdenadorTest() {

        Ordenador ordenador = new Ordenador(1, "Mac", 1200);
        //mock
        when(repositorioOrdenadorMock.buscarUno(1)).thenReturn(ordenador);

        //act
        Ordenador ordenadorResultado = servicioInformatica.buscarUnoOrdenador(1);

        verify(repositorioOrdenadorMock, times(1)).buscarUno(1);
        assertEquals(ordenador, ordenadorResultado);

    }

    @Test
    public void buscarPorRangoPreciosOrdenadoresTest() {
        //arrange
        Ordenador ordenador1 = new Ordenador(1, "Mac", 600);
        Ordenador ordenador2 = new Ordenador(2, "Lenovo", 500);
        List<Ordenador> listaOrdenadorMock = Arrays.asList(ordenador1, ordenador2);
        double minPrecio = 400;
        double maxPrecio = 700;
        //mock
        when(repositorioOrdenadorMock.buscarPorRangoPrecios(minPrecio, maxPrecio)).thenReturn(listaOrdenadorMock);

        //act
        List<Ordenador> listaOrdenadorResultado = servicioInformatica.buscarPorRangoPreciosOrdenadores(minPrecio, maxPrecio);
        //assertions
        verify(repositorioOrdenadorMock, times(1)).buscarPorRangoPrecios(minPrecio, maxPrecio);
        assertEquals(listaOrdenadorMock, listaOrdenadorResultado);
    }
}
