package pom.Grupo4.test;

import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.Grupo4.base.TestBase;
import pom.Grupo4.pages.VFHomePage;
import pom.Grupo4.pages.VFPaquetesPage;
import pom.Grupo4.pages.VFPaquetesResultadosPage;


public class Paquetes extends TestBase{

    protected VFHomePage paginaHome;
    protected VFPaquetesPage paginaPaquetes;
    protected VFPaquetesResultadosPage paginaPaquetesResultado;


    @Test
    public void atc01_PaqueteSugerido() {
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaHome = new VFHomePage(driver);
        paginaHome.irAPaquetes();

        //Instanciamos la pagina de paquetes y reasignamos el driver.
        paginaPaquetes = new VFPaquetesPage(driver);
        String region = paginaPaquetes.obtenerSugerencia();
        paginaPaquetes.clickPaqueteSugerido();
        paginaPaquetes.seleccionarVentanaEmergenta();

        //cambio de pestaña
        paginaPaquetesResultado = new VFPaquetesResultadosPage(driver);
        paginaPaquetesResultado.pestañaSiguiente();

        //Validacion
        paginaPaquetesResultado.validacionSugerencia(region);



    }
    @Test
    public void atc02_BusquedaEspecificaDesayuno(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaHome = new VFHomePage(driver);
        paginaHome.irAPaquetes();

        //Instanciamos la pagina de paquetes y reasignamos el driver.
        paginaPaquetes = new VFPaquetesPage(driver);
        paginaPaquetes.seleccionarOrigen("Buenos");
        paginaPaquetes.seleccionarDestino("Amst");
        paginaPaquetes.seleccionarFechaIdaYVuelta("15","25","2022-01");
    }

}
