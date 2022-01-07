package pom.Grupo4.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Grupo4.base.SeleniumBase;

public class VFPaquetesPage extends SeleniumBase{
    public VFPaquetesPage(WebDriver driver) {
        super(driver);
    }
    //atributos de la pagina -> Localizadores
    //TODO: refactorizar localizadores.
    By primeraSugerenciaSudamerica = By.xpath("//*[@id='MultiproductOffersModule_6385']/div/offers/div/div[2]/div[1]/offer-card[1]/div/a/div/offer-card-info/div[1]/div[2]");

    //metodos de la pagina - Keyword Driven
    public void clickPaqueteSugerido(){
        clickear(primeraSugerenciaSudamerica);
    }
}
