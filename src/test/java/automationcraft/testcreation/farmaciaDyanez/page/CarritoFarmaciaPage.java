package automationcraft.testcreation.farmaciaDyanez.page;

import automationcraft.engine.selenium.SeleniumBaseDyanez;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class CarritoFarmaciaPage extends SeleniumBaseDyanez {


    public CarritoFarmaciaPage(WebDriver driver) {
        super(driver);
    }
    String btnAgregarProduct = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[2]/ol/li[1]/div/div[2]/div[2]/div/div[1]/form/button";
    String btnCantidadCarrito = "//a[3]//span[@class='counter qty']";
    String btnVerCarrito = "//a[@id=\"top-cart-btn-checkout\"]";

    public void navigateToFarmacia(String string){

        navigateTo(string);
    }

    public void clickInBtnProduct(){

        clickElement(btnAgregarProduct);
    }

    public void validarCargaEnCarrito() throws Exception {
        if(!elementIsDisplayed(btnCantidadCarrito)) {
            throw new Exception("Elemento no Encontrado");
        }
        clickElement(btnCantidadCarrito);
    }

    public void validarDespliegueCarritoCompraWeb() throws InterruptedException {

        clickElement(btnVerCarrito);
    }



}
