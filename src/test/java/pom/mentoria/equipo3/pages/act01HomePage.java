package pom.mentoria.equipo3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.mentoria.equipo3.base.SeleniumBase;

public class act01HomePage extends SeleniumBase {
    private String URL = "https://www.viajesfalabella.cl/";

    String urlEsperada = "https://www.viajesfalabella.cl/hoteles/";
    String urlResultados = driver.getCurrentUrl();
    By alojamientos = By.xpath("//label[.='Alojamientos']");
    By NoDecidirFecha = By.xpath("//input[@class='checkbox-tag sbox-no-date-specified']");
    By inputDestino = By.xpath("//label[.='Destino']/../input");

    By buscador = By.xpath("//em[.='Buscar']");
    String lugarDestino = "Rio de janeiro";

    public act01HomePage(WebDriver driver) {
        super(driver);
    }


    public void act01_AlojamientoSinFechaPrevista(){
        obtenerUrl(URL);
        clickear(alojamientos);
        type("Rio de janeiro",inputDestino);
        clickear(NoDecidirFecha);
        clickear(buscador);

    }


    public void  resulEsperados(){

        Assert.assertTrue(urlResultados.startsWith(urlEsperada));

    }





}