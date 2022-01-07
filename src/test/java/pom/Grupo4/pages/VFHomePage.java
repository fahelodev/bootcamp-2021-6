package pom.Grupo4.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Grupo4.base.SeleniumBase;

public class VFHomePage extends SeleniumBase {

    private String URL = "https://www.viajesfalabella.cl/";
    public VFHomePage(WebDriver driver) {
        super(driver);
    }

    //atributos de la pagina -> Localizadores
    By btnPaquetes = By.cssSelector("a.shifu-3-button-circle.PACKAGES.paint-circle");
    By btnAlojamientos = By.xpath("//li[contains(@class,'header-product-item')]//label[contains(text(),'Alojamientos')]");
    By btnTraslados = By.xpath("//*[text()='Traslados']");

    //metodos de la pagina - Keyword Driven
       public void irAPaquetes(){
        obtenerUrl(URL);
        clickear(btnPaquetes);

    }

    public void irAAlojamientos(){
        obtenerUrl(URL);
        clickear(btnAlojamientos);

    }

    public void irATraslados(){
        obtenerUrl(URL);
        clickear(btnTraslados);

    }


}