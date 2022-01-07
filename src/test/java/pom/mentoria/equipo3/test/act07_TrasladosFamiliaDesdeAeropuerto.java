package pom.mentoria.equipo3.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.mentoria.equipo3.base.TestBase;
import pom.mentoria.equipo3.pages.act07HomePage;

public class act07_TrasladosFamiliaDesdeAeropuerto extends TestBase {


    @Test
    public void act07(){
        act07HomePage ob1 = new act07HomePage(driver);
        ob1.act07_TrasladosFamiliaDesde();

    }



}
