package desafio.equipo2.test;

import desafio.equipo2.base.TestBase;
import desafio.equipo2.pages.HomePageHoteles;
import org.junit.Test;

public class Act_Alojamientos extends TestBase {
    protected HomePageHoteles paginaHome;

    @Test
    public void BuscarAlojamientoSinFecha() throws InterruptedException {
        paginaHome = new HomePageHoteles(driver);
        paginaHome.IngresarDestino_Buscar();
    }
    @Test
    public void FiltrarPorEstrellas() throws InterruptedException {
        paginaHome = new HomePageHoteles(driver);
        paginaHome.FiltrarEstrellas();
    }
    @Test
    public void CheckOutInternacional() throws InterruptedException {
        paginaHome = new HomePageHoteles(driver);
        paginaHome.CheckoutInternacional();
    }
}
