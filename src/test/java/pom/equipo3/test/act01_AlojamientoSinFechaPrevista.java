package pom.equipo3.test;
import org.junit.Test;
import pom.equipo3.base.TestBase;
import pom.equipo3.pages.act01HomePage;


public class act01_AlojamientoSinFechaPrevista extends TestBase {


    @Test
    public void test(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        act01HomePage obj1 = new act01HomePage(driver);
        obj1.act01_Alojamiento();
    }



}
