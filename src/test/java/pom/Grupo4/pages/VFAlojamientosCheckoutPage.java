package pom.Grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Grupo4.base.SeleniumBase;

import java.util.List;

public class VFAlojamientosCheckoutPage extends SeleniumBase {

    private String URL = "https://www.viajesfalabella.cl/checkout/";
    public VFAlojamientosCheckoutPage(WebDriver driver){super(driver);}
    //atributos de la pagina -> Localizadores
    By seccionMediosDePago = By.xpath("//payment-method-selector");
    By tarjetaDeCredito = By.xpath("//label[@for='payment-method-0']");
    By btnFormasDePago = By.xpath("//em[contains(text(),'Promociones y formas de pago')]");
    By tarjetas = By.xpath("//div[contains(@class,'card-logo-container')]");


    public void seleccionarTarjetaDeCredito() {
        esperarElementoVisible( 10,seccionMediosDePago);
        clickear(tarjetaDeCredito);
    }

    public void clickearFormasDePago() {
        clickear(btnFormasDePago);
    }

    public boolean numeroDeTarjetasSuperiorA(int numero) {
        List<WebElement> resultados = encontrarElementosWeb(tarjetas);
        return resultados.size() > numero;
    }


}