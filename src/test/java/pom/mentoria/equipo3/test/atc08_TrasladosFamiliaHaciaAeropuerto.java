package pom.mentoria.equipo3.test;

import org.junit.Test;
import pom.mentoria.base.TestBase;
import pom.mentoria.equipo3.pages.atc08HomePage;

public class atc08_TrasladosFamiliaHaciaAeropuerto extends TestBase {

    @Test
    public void atc08(){
        atc08HomePage traslado_hacia = new atc08HomePage(driver);
        traslado_hacia.atc08TrasladosFamiliaHaciaAero();
    }




}
