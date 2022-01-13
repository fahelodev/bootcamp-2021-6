package pom.mentoria.test;

import org.junit.Test;
import pom.mentoria.base.JunitTestBase;
import pom.mentoria.pages.VFHomePage;

public class atc01_mensajeDeError extends JunitTestBase {

    protected VFHomePage paginaHome;

    @Test
    public void Test(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginaHome = new VFHomePage(driver);
        paginaHome.irAInicioDeSesion();
    }
}
