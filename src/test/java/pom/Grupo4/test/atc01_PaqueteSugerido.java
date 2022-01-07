package pom.Grupo4.test;

import org.junit.Test;
import pom.Grupo4.base.TestBase;
import pom.Grupo4.pages.VFHomePage;
import pom.Grupo4.pages.VFPaquetesPage;


public class atc01_PaqueteSugerido extends TestBase{

    protected VFHomePage paginaHome;
    protected VFPaquetesPage paginaPaquetes;

    @Test
    public void Test(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaHome = new VFHomePage(driver);
        paginaHome.irAPaquetes();
        //paginaHome.irATraslados();
        //paginaHome.irAAlojamientos();

        //Instanciamos la pagina de paquetes y reasignamos el driver.
        paginaPaquetes = new VFPaquetesPage(driver);
        paginaPaquetes.clickPaqueteSugerido();


    }

}
