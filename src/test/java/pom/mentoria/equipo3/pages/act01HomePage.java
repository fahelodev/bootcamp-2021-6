package pom.mentoria.equipo3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.mentoria.equipo3.base.SeleniumBase;

public class act01HomePage extends SeleniumBase {
    private String URL = "https://www.viajesfalabella.cl/";

    String urlEsperada = "https://www.viajesfalabella.cl/hoteles/";
    String urlResultados = driver.getCurrentUrl();
    By alojamientos = By.xpath("//label[.='Alojamientos']");
    By NoDecidirFecha = By.xpath("//i[@class='checkbox-check sbox-3-icon-checkmark -mr1']");
    By inputDestino = By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-primary undefined']");

    By buscador = By.xpath("//em[.='Buscar']");
    String lugarDestino = "Rio de janeiro";

    public act01HomePage(WebDriver driver) {
        super(driver);
    }


    public void act01_Alojamiento(){
        obtenerUrl(URL);
        clickear(alojamientos);
        WebDriverWait espera = new WebDriverWait(driver,4);
        clickear(NoDecidirFecha);
        type("Rio de janeiro",inputDestino);
        clickear(buscador);

    }


    public void  resulEsperados(){

        Assert.assertTrue(urlResultados.startsWith(urlEsperada));

    }





}
