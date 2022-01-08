package pom.equipo2.test;

import org.junit.Test;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.HomePageTraslados;

public class Act_Traslados extends TestBase {

    protected HomePageTraslados pagineTraslados;

    @Test
    public void CambiarMoneda()  {
        pagineTraslados = new HomePageTraslados(driver);
        pagineTraslados.cambiarPesoToDolar();
    }
    @Test
    public void BusquedaEspecificaTestCase() throws InterruptedException {
        pagineTraslados = new HomePageTraslados(driver);
        pagineTraslados.busquedaEspecificaTrasladoIda();
    }

    @Test
    public void testBusquedaEspecificaTrasladoIdaYVuelta() throws InterruptedException {
        pagineTraslados = new HomePageTraslados(driver);
        pagineTraslados.busquedaEspecificaTrasladoIdaYVuelta();
    }

}
