package pom.equipo3.test;

import org.junit.Test;
import pom.equipo3.base.TestBase;
import pom.equipo3.pages.act07HomePage;

public class atc07_TrasladosFamiliaDesdeAeropuerto extends TestBase {

    @Test
    public void act07(){
        act07HomePage traslado = new act07HomePage(driver);
        traslado.act07_TrasladosFamiliaDesde();
    }

}
