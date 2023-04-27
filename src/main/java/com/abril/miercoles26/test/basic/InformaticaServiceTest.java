package com.abril.miercoles26.test.basic;

import com.abril.miercoles26.patronRepository.domain.Ordenador;
import com.abril.miercoles26.patronRepository.domain.Telefono;
import com.abril.miercoles26.patronRepository.repository.OrdenadorRepository;
import com.abril.miercoles26.patronRepository.repository.TelefonoRepository;
import com.abril.miercoles26.patronRepository.service.InformaticaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class InformaticaServiceTest {

    private static OrdenadorRepository repositorioOrdenadorMock;
    private static TelefonoRepository repositorioTelefonoMock;
    private static InformaticaService servicioInformatica;


    @BeforeAll
    public static void inicializarGlobal() {
        //instancio un solo objeto para todos
        repositorioTelefonoMock = mock(TelefonoRepository.class);
        repositorioOrdenadorMock = mock(OrdenadorRepository.class);
    }

    /// TEST TELEFONO

    @Test
    public void insertTelefonoTest() {
        //arrange
        Telefono telefono1 = new Telefono(600700800, "iphone", "XS", 1200);
        //mock
        when(repositorioTelefonoMock.insertar(telefono1)).thenReturn(telefono1);
        servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

        //act
        Telefono telefonoResultado = servicioInformatica.insertarTelefono(telefono1);
        //assertions
        verify(repositorioTelefonoMock, times(1)).insertar(telefono1);
        assertEquals(telefono1, telefonoResultado);
    }

    @Test
    public void actualizarTelefonoTest() {
        //arrange
        Telefono telefono1 = new Telefono(600700800, "iphone", "XS", 1200);
        Telefono telefonoMod = new Telefono(600700800, "iphone", "XL", 2000);
        //mock
        when(repositorioTelefonoMock.actualizar(telefono1, "iphone", "XL", 2000)).thenReturn(telefonoMod);
        servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

        //act
        Telefono telefonoResultado = servicioInformatica.actualizarTelefono(telefono1, "iphone", "XL", 2000);
        //assertions
        verify(repositorioTelefonoMock, times(1)).actualizar(telefono1, "iphone", "XL", 2000);
        assertEquals(telefonoMod, telefonoResultado);
    }

    @Test
    public void buscarTodosTelefonosTest() {
        //arrange
        Telefono telefono1 = new Telefono(600700800, "iphone", "XS", 1200);
        Telefono telefono2 = new Telefono(600700800, "iphone", "XL", 1999);
        List<Telefono> listaTelefonoMock = Arrays.asList(telefono1, telefono2);
        //mock
        when(repositorioTelefonoMock.buscarTodos()).thenReturn(listaTelefonoMock);
        servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

        //act
        List<Telefono> listaTelefonoResultado = servicioInformatica.buscarTodosTelefonos();
        //assertions
        verify(repositorioTelefonoMock, times(1)).buscarTodos();
        assertEquals(listaTelefonoMock, listaTelefonoResultado);
    }

    @Test
    public void buscarUnoTelefonoTest() {

        Telefono telefono1 = new Telefono(600700800, "iphone", "XS", 1200);
        //mock
        when(repositorioTelefonoMock.buscarUno(600700800)).thenReturn(telefono1);
        servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

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
        servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

        //act
        Ordenador ordenadorResultado = servicioInformatica.insertarOrdenador(ordenador);
        //assertions
        verify(repositorioOrdenadorMock, times(1)).insertar(ordenador);
        assertEquals(ordenador, ordenadorResultado);
    }

    @Test
    public void actualizarOrdenadorTest() {
        //arrange
        Ordenador ordenador = new Ordenador(1, "Mac", 1200);
        Ordenador ordenadorMod = new Ordenador(1, "Lenovo", 500);
        //mock
        when(repositorioOrdenadorMock.actualizar(ordenador)).thenReturn(ordenadorMod);
        servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

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
        servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

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
        servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

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
        servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

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
        servicioInformatica = new InformaticaService(repositorioTelefonoMock, repositorioOrdenadorMock);

        //act
        List<Ordenador> listaOrdenadorResultado = servicioInformatica.buscarPorRangoPreciosOrdenadores(minPrecio, maxPrecio);
        //assertions
        verify(repositorioOrdenadorMock, times(1)).buscarPorRangoPrecios(minPrecio, maxPrecio);
        assertEquals(listaOrdenadorMock, listaOrdenadorResultado);
    }
}
