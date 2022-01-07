package pom.Grupo4.test;

import org.junit.Test;
import pom.Grupo4.base.TestBase;
import pom.Grupo4.pages.VFHomePage;


public class atc01_PaqueteSugerido extends TestBase{

    protected VFHomePage paginaHome;

    @Test
    public void Test(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaHome = new VFHomePage(driver);
        paginaHome.irAPaquetes();


    }
}
