package pom.Grupo4.test;

import org.junit.Assert;
import org.junit.Test;
import pom.Grupo4.base.TestBase;
import pom.Grupo4.pages.*;


public class Paquetes extends TestBase{

    protected VFHomePage paginaHome;
    protected VFPaquetesPage paginaPaquetes;
    protected VFPaquetesResultadosPage paginaPaquetesResultado;
    protected VFCheckoutPage paginaCheckout;

    @Test
    public void atc01_PaqueteSugerido() {

        //Desde la Home vamos a Paquetes
        paginaHome = new VFHomePage(driver);
        paginaHome.irAPaquetes();

        //Instanciamos la pagina de paquetes y reasignamos el driver.
        paginaPaquetes = new VFPaquetesPage(driver);

        //Obtener region de las sugerencias y clickear en el primer paquete sugerido
        String region = paginaPaquetes.obtenerSugerencia();
        paginaPaquetes.clickPaqueteSugerido();

        //Click en la ventana emergente del paquete
        paginaPaquetes.seleccionarVentanaEmergenta();

        //cambio de pestaña
        paginaPaquetesResultado = new VFPaquetesResultadosPage(driver);
        paginaPaquetesResultado.changeTab(15);

        //Validacion
        String resultado = paginaPaquetesResultado.obtenerResultadoEsperado();
        Assert.assertTrue(resultado.contains(region));
    }

    @Test
    public void atc02_BusquedaEspecificaDesayuno(){

        //Desde la Home vamos a Paquetes
        String filtroEspecifico = "Desayuno";
        paginaHome = new VFHomePage(driver);
        paginaHome.irAPaquetes();

        //Instanciamos la pagina de paquetes y reasignamos el driver.
        paginaPaquetes = new VFPaquetesPage(driver);

        //Ingresamos origen, destino y fechas de ida y vuelta.
        paginaPaquetes.seleccionarOrigen("Buenos");
        paginaPaquetes.seleccionarDestino("Amst");
        paginaPaquetes.seleccionarFechaIdaYVuelta("15","25","2022-01");

        //Modificar habitaciones
        paginaPaquetes.modificarHabitaciones();

        //Buscar Paquete
        paginaPaquetes.clickBuscar();


        //Obtener el texto del filtro solicitado y validar que la sugerencia se haya filtrado bien.
        paginaPaquetesResultado = new VFPaquetesResultadosPage(driver);
        paginaPaquetesResultado.filtroDesayuno();
        String filtroPaquetes = paginaPaquetesResultado.filtroBuscado();
        Assert.assertTrue(filtroPaquetes.contains(filtroEspecifico));
    }

    @Test
    public void atc03_PrecioFinal(){

        //Desde la Home vamos a Paquetes
        paginaHome = new VFHomePage(driver);
        paginaHome.irAPaquetes();

        //Instanciamos la pagina de paquetes y reasignamos el driver.
        paginaPaquetes = new VFPaquetesPage(driver);

        //Ingresamos origen, destino y fechas de ida y vuelta.
        paginaPaquetes.seleccionarOrigen("Buenos");
        paginaPaquetes.seleccionarDestino("Amst");
        paginaPaquetes.seleccionarFechaIdaYVuelta("15","25","2022-01");

        //Modificar habitaciones
        paginaPaquetes.modificarHabitaciones();

        //Buscar paquete
        paginaPaquetes.clickBuscar();

        //Modificar moneda
        paginaPaquetesResultado = new VFPaquetesResultadosPage(driver);
        paginaPaquetesResultado.cambioMoneda();

        //Seleccionar primera opcion
        paginaPaquetesResultado.seleccionarOpcion();

        //cambiar pestaña
        paginaPaquetesResultado.changeTab(15);

        //Click opcion detallada
        paginaPaquetesResultado.clickSiguienteA();

        //Click vuelo conveniente
        paginaPaquetesResultado.vueloConveniente();

        //Obtener precio completo del paquete
        int precioCompleto = paginaPaquetesResultado.obtenerPrecioCompleto();
        paginaPaquetesResultado.clickSiguiente();

        //Obtener precio final del paquete
        paginaCheckout = new VFCheckoutPage(driver);
        int precioFinal = paginaCheckout.obtenerPrecioFinal();

        //Validacion
        Assert.assertTrue(precioFinal <= precioCompleto);


    }
}
