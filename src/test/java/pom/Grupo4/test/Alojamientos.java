package pom.Grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pom.Grupo4.base.TestBase;
import pom.Grupo4.pages.*;

public class Alojamientos extends TestBase{

    protected VFHomePage paginaHome;
    protected VFAlojamientosPage paginaAlojamientos;
    protected VFAlojamientosResultadoSugerenciaPage paginaAlojamientosResultadoSugerencia;
    protected VFAlojamientosResultadoBusquedaPage paginaAlojamientosResultadoBusqueda;
    protected VFAlojamientosDetallePage paginaAlojamientosDetalle;
    protected VFAlojamientosReservaPage paginaAlojamientosReserva;
    protected VFAlojamientosCheckoutPage paginaAlojamientosCheckout;

    @Test
    public void atc01_alojamientoSugerido(){

        String tituloSeccion = "Despierta en algun lugar de Chile";

        paginaHome = new VFHomePage(driver);
        paginaHome.irAAlojamientos();

        paginaAlojamientos = new VFAlojamientosPage(driver);
        String nombrePrimeraOferta = paginaAlojamientos.nombrePrimeraOfertaSeccion(tituloSeccion);
        paginaAlojamientos.clickearPrimeraOfertaSeccion(tituloSeccion);
        paginaAlojamientos.changeTab(10);

        paginaAlojamientosResultadoSugerencia = new VFAlojamientosResultadoSugerenciaPage(driver);
        String nombrePrimerResultado = paginaAlojamientosResultadoSugerencia.nombrePrimerResultado();

        Assert.assertEquals(nombrePrimeraOferta, nombrePrimerResultado);

    }

    @Test
    public void atc02_busquedaEspecifica(){

        String ciudadDestino = "Nueva York";

        paginaHome = new VFHomePage(driver);
        paginaHome.irAAlojamientos();

        paginaAlojamientos = new VFAlojamientosPage(driver);
        paginaAlojamientos.ingresarCiudadDestino(ciudadDestino);
        paginaAlojamientos.seleccionarFechaIdaYVuelta("15","25","2022-01");
        paginaAlojamientos.agregarHabitacionYAdulto();
        paginaAlojamientos.presionarBuscar();

        paginaAlojamientosResultadoBusqueda = new VFAlojamientosResultadoBusquedaPage(driver);
        boolean resultadosCorresponden = paginaAlojamientosResultadoBusqueda.validarCiudadResultados(ciudadDestino);

        Assert.assertTrue(resultadosCorresponden);
    }

    @Test
    public void atc03_mediosDePago(){

        String ciudadDestino = "Nueva York";

        paginaHome = new VFHomePage(driver);
        paginaHome.irAAlojamientos();

        paginaAlojamientos = new VFAlojamientosPage(driver);
        paginaAlojamientos.ingresarCiudadDestino(ciudadDestino);
        paginaAlojamientos.seleccionarFechaIdaYVuelta("15","25","2022-01");
        paginaAlojamientos.agregarHabitacionYAdulto();
        paginaAlojamientos.presionarBuscar();

        paginaAlojamientosResultadoBusqueda = new VFAlojamientosResultadoBusquedaPage(driver);
        paginaAlojamientosResultadoBusqueda.clickearPrimerResultado();
        paginaAlojamientos.changeTab(10);

        paginaAlojamientosDetalle = new VFAlojamientosDetallePage(driver);
        paginaAlojamientosDetalle.clickearReservarAhora();

        paginaAlojamientosReserva = new VFAlojamientosReservaPage(driver);
        paginaAlojamientosReserva.clickearSiguiente();

        paginaAlojamientosCheckout = new VFAlojamientosCheckoutPage(driver);
        paginaAlojamientosCheckout.seleccionarTarjetaDeCredito();
        paginaAlojamientosCheckout.clickearFormasDePago();

        boolean cumple = paginaAlojamientosCheckout.numeroDeTarjetasSuperiorA(3);

        Assert.assertTrue(cumple);
    }

}
