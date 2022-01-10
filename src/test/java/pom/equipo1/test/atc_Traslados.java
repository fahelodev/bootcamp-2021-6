package pom.equipo1.test;

import org.junit.Test;
import pom.equipo1.base.TestBase;
import pom.equipo1.pages.ResultadoTrasladoPage;
import pom.equipo1.pages.TrasladoPage;
import pom.equipo1.pages.VFHomePage;

public class atc_Traslados extends TestBase {
    protected VFHomePage home;
    protected TrasladoPage traslado;
    protected ResultadoTrasladoPage resultado;

    @Test
    public void atc01_TrasladoBasico(){
        home = new VFHomePage(driver);
        traslado = new TrasladoPage(driver);
        resultado = new ResultadoTrasladoPage(driver);
        home.irATraslado();
        traslado.setTrasladoBasico();
        resultado.getPrices();
    }

    @Test
    public void atc02_TrasladoMedio(){
        home = new VFHomePage(driver);
        traslado = new TrasladoPage(driver);
        resultado = new ResultadoTrasladoPage(driver);
        home.irATraslado();
        traslado.setTrasladoMedio();


        resultado.getPassengers();
    }

    @Test
    public void atc03_TrasladoComplejo(){
        home = new VFHomePage(driver);
        traslado = new TrasladoPage(driver);
        resultado = new ResultadoTrasladoPage(driver);

        home.irATraslado();
        traslado.setTrasladoComplejo();
        resultado.changeReturn();
        resultado.changePassengersAndSearch();

        resultado.getDate();
    }
}
