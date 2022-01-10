package pom.equipo1.test;

import org.junit.Test;
import pom.equipo1.base.TestBase;
import pom.equipo1.pages.PaquetePage;
import pom.equipo1.pages.ResultadoPaquetePage;
import pom.equipo1.pages.VFHomePage;

public class atc_Paquetes extends TestBase {
    protected VFHomePage home;
    protected PaquetePage paquete;
    protected ResultadoPaquetePage resultado;

    @Test
    public void atc01_PaqueteBasico() throws InterruptedException {
        home = new VFHomePage(driver);
        paquete = new PaquetePage(driver);
        resultado = new ResultadoPaquetePage(driver);
        home.Paquetes();
        paquete.setPaqueteBasico();
        resultado.getPackageFilter();
    }

    @Test
    public void atc02_PaqueteMedio() throws InterruptedException {
        home = new VFHomePage(driver);
        paquete = new PaquetePage(driver);
        resultado = new ResultadoPaquetePage(driver);
        home.Paquetes();
        paquete.setPaqueteMedio();
        resultado.getPackage();
    }

    @Test
    public void atc03_PaqueteComplejo() throws InterruptedException {
        home = new VFHomePage(driver);
        paquete = new PaquetePage(driver);
        resultado = new ResultadoPaquetePage(driver);
        home.Paquetes();
        Thread.sleep(1000);
        paquete.setPaqueteComplejo();
        resultado.getPackageHard();
    }
}
