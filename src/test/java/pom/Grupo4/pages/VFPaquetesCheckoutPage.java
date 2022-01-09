package pom.Grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Grupo4.base.SeleniumBase;

public class VFPaquetesCheckoutPage extends SeleniumBase {
    public VFPaquetesCheckoutPage(WebDriver driver) {
        super(driver);
    }

    //localizadores
    By precioFinal = By.xpath("//div[@class='pricebox-content-wrap']//div[@id='chk-total-price']//div[contains(@class,'money-align')]//span[@class='amount']");

    //comportamientos
    public int obtenerPrecioFinal(){
        esperarElementoVisible(15, precioFinal);
        String precioFinalPaquete = obtenerTexto(precioFinal);
        String precioString = precioFinalPaquete.replaceAll("\\p{Punct}", "");
        int precioPaqueteFinal = Integer.parseInt(precioString);
        return precioPaqueteFinal;

    }

}
