package pom.equipo3.test;

import org.junit.Test;
import pom.equipo3.base.TestBase;
import pom.equipo3.pages.act02HomePage;

public class atc02_AlojamientoConFechas extends TestBase {

    @Test
    public void Test(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        act02HomePage obj1 = new act02HomePage(driver);
        obj1.act02_Alojamiento();
    }


}
