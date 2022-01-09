package pom.Grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Grupo4.base.SeleniumBase;

import java.util.List;

public class VFAlojamientosReservaPage extends SeleniumBase {

    private String URL = "https://www.viajesfalabella.cl/trips/xs/";
    public VFAlojamientosReservaPage(WebDriver driver){super(driver);}

    //atributos de la pagina -> Localizadores
    By btnSiguiente = By.xpath("//div[@id='pricebox-overlay']//button");


    public void clickearSiguiente() {
        esperarElementoVisible(10, btnSiguiente);
        clickear(btnSiguiente);
    }
}
