package pom.equipo1.test;

import org.junit.Test;
import pom.equipo1.base.TestBase;
import pom.equipo1.pages.ResultadoTrasladoPage;
import pom.equipo1.pages.TrasladoPage;
import pom.equipo1.pages.VFHomePage;

public class atc01_TrasladoBasico extends TestBase {
    protected VFHomePage home;
    protected TrasladoPage traslado;
    protected ResultadoTrasladoPage resultado;

    @Test
    public void Test(){
        home = new VFHomePage(driver);
        traslado = new TrasladoPage(driver);
        resultado = new ResultadoTrasladoPage(driver);
        home.irATraslado();
        traslado.setTraslado();
        resultado.getPrices();
    }

}
