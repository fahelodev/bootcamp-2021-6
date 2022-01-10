package pom.equipo1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo1.base.SeleniumBase;

public class VFHomePage extends SeleniumBase {

    private String URL = "https://www.viajesfalabella.cl/";
    public VFHomePage(WebDriver driver) {
        super(driver);
    }
    //atributos de la pagina -> Localizadores
    By seccionTraslado = By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Traslados\")]");

    //metodos de la pagina - Keyword Driven
    public void irATraslado(){
        obtenerUrl(URL);
        clickear(seccionTraslado);
    }

    public void Paquetes(){
        obtenerUrl(URL);
    }



}
