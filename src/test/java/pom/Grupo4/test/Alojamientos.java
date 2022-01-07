package pom.Grupo4.test;

import org.junit.Test;
import pom.Grupo4.base.TestBase;
import pom.Grupo4.pages.VFHomePage;

public class Alojamientos extends TestBase{

    protected VFHomePage paginaHome;


    @Test
    public void atc01(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaHome = new VFHomePage(driver);
        paginaHome.irAPaquetes();
        //paginaHome.irATraslados();
        //paginaHome.irAAlojamientos();

    }

}
