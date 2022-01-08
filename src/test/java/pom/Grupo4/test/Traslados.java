package pom.Grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import pom.Grupo4.base.TestBase;
import pom.Grupo4.pages.*;

public class Traslados extends TestBase{

    protected VFHomePage paginaHome;
    protected VFTrasladosPage paginaTraslados;
    //protected VFTrasladosReslutadoErrorPage paginaResultadoError;
    protected VFTrasladosResultadoPage paginaResultado;
    protected VFTrasladosCheckoutPage paginaCheckout;


    @Test
    public void atc01_mensajeDeError(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaHome = new VFHomePage(driver);
        paginaHome.irATraslados();

        //Instanciamos la pagina de paquetes y reasignamos el driver.
        paginaTraslados = new VFTrasladosPage(driver);
        paginaTraslados.seleccionarDesdeAeropuerto();
        paginaTraslados.ingresarAeropuerto("Copiapo");
        paginaTraslados.ingresarHotel("Copiapo");
        paginaTraslados.seleccionarFecha("15", "2022-01");
        paginaTraslados.seleccionarHora("03:30");
        paginaTraslados.presionarBuscar();

        paginaResultado = new VFTrasladosResultadoPage(driver);
        String mensajeEsperado = "Sentimos no poder ayudarte. Esperamos que encuentres lo que estás buscando.";
        String mensajeActual = paginaResultado.obtenerTextoError();

        Assert.assertEquals(mensajeEsperado, mensajeActual);
    }

    @Test
    public void atc02_opcionTransferencia(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaHome = new VFHomePage(driver);
        paginaHome.irATraslados();

        //Instanciamos la pagina de paquetes y reasignamos el driver.
        paginaTraslados = new VFTrasladosPage(driver);
        paginaTraslados.seleccionarDesdeAeropuerto();
        paginaTraslados.ingresarAeropuerto("Santiago");
        paginaTraslados.ingresarHotel("Santiago");
        paginaTraslados.seleccionarFecha("16", "2022-02");
        paginaTraslados.seleccionarHora("21:30");
        paginaTraslados.presionarBuscar();

        paginaResultado = new VFTrasladosResultadoPage(driver);
        paginaResultado.comprarPrimerResultado();

        paginaCheckout = new VFTrasladosCheckoutPage(driver);
        paginaCheckout.presionarTransferenciaBancaria();
        String mensajeEsperado = "Transferencia Bancaria";
        String mensajeActual = paginaCheckout.obtenerTextoTransferenciaBancaria();

        Assert.assertEquals(mensajeEsperado, mensajeActual);
    }

    @Test
    public void atc03_mensajeError_cuponInvalido(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaHome = new VFHomePage(driver);
        paginaHome.irATraslados();

        //Instanciamos la pagina de paquetes y reasignamos el driver.
        paginaTraslados = new VFTrasladosPage(driver);
        paginaTraslados.seleccionarDesdeAeropuerto();
        paginaTraslados.ingresarAeropuerto("Santiago");
        paginaTraslados.ingresarHotel("Santiago");
        paginaTraslados.seleccionarFecha("16", "2022-02");
        paginaTraslados.seleccionarHora("21:30");
        paginaTraslados.modificarPasajeros(4);
        paginaTraslados.presionarBuscar();

        paginaResultado = new VFTrasladosResultadoPage(driver);
        paginaResultado.comprarPrimerResultado();

        paginaCheckout = new VFTrasladosCheckoutPage(driver);
        paginaCheckout.ingresarDatosCupon();

        String mensajeEsperado = "El email o código ingresados son incorrectos";
        String mensajeActual = paginaCheckout.obtenerTextoCuponInvalido();

        Assert.assertEquals(mensajeEsperado, mensajeActual);
    }

}
