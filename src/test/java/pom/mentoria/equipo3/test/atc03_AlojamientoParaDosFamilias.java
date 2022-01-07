package pom.mentoria.equipo3.test;

import org.junit.Test;
import pom.mentoria.base.TestBase;
import pom.mentoria.equipo3.pages.act03HomePage;

public class atc03_AlojamientoParaDosFamilias extends TestBase {

    @Test
    public void Test(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        act03HomePage obj1 = new act03HomePage(driver);
        obj1.act03_Alojamiento();
    }

}
