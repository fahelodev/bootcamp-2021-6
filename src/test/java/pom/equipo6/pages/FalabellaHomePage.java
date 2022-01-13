package pom.equipo6.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo6.base.SeleniumBase;

public class FalabellaHomePage extends SeleniumBase {

    //Carga la pagina
    private String URL = "https://www.viajesfalabella.cl/";
    //atributos de la pagina -> Localizadores
    By btnAlojamiento = By.xpath("//a[@data-action='hotels-click']");

    public FalabellaHomePage(WebDriver driver) {
        super(driver);
    }

    //metodos de la pagina - Keyword Driven
    public void irAAlojamientos() {
    obtenerUrl(URL);
    clickear(btnAlojamiento);


    }

}
