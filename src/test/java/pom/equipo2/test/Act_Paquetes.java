package pom.equipo2.test;

import org.junit.Test;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.HomePagePaquetes;



public class Act_Paquetes extends TestBase {

    protected HomePagePaquetes paginaPaquetes ;

    @Test
    public void vueloYAlojamiento()  throws InterruptedException{
        paginaPaquetes = new HomePagePaquetes(driver);
        paginaPaquetes.buscarVueloYalojamiento();
    }
    @Test
    public void errorDestinoYOrigenIguales() throws InterruptedException {
        paginaPaquetes = new HomePagePaquetes(driver);
        paginaPaquetes.destinoYorigenIguales();
    }

    @Test
    public void vuelo_con_2_Alojamientos() throws InterruptedException {
        paginaPaquetes = new HomePagePaquetes(driver);
        paginaPaquetes.vueloConDosAlojamientos();
    }
}