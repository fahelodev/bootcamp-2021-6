package pom.mentoria.equipo3.test;

import org.junit.Test;
import pom.mentoria.base.TestBase;
import pom.mentoria.pages.VFHomePage;

public class atc01_mensajeDeError extends TestBase{

    protected VFHomePage paginaHome;

    @Test
    public void Test(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaHome = new VFHomePage(driver);
        paginaHome.irAInicioDeSesion();
    }
}
