package automationcraft.testcreation.dYanez.pages;

import automationcraft.engine.selenium.SeleniumBaseDyanez;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CarritoCompraPageParis extends SeleniumBaseDyanez {


    public CarritoCompraPageParis(WebDriver driver) {
        super(driver);
    }



    //TestCase01 Locators
    String btnMasCantidadProduct = "//*[@id='GTM_cart_quantity-mas']";

    public void clickAumentarProduct() throws InterruptedException {
        clickElement(btnMasCantidadProduct);
        Thread.sleep(300);clickElement(btnMasCantidadProduct);
        Thread.sleep(300);clickElement(btnMasCantidadProduct);
        Thread.sleep(300);clickElement(btnMasCantidadProduct);
        Thread.sleep(300);clickElement(btnMasCantidadProduct);
        Thread.sleep(300);clickElement(btnMasCantidadProduct);
        Thread.sleep(300);clickElement(btnMasCantidadProduct);
        Thread.sleep(300);


    }



    //Locators TestCase 03
    String btnAgregarProduct = "//span[text()='Añadir al carro']";
    String btnContinuareAgregarProduct = "//button[text()='Continuar']";
    String btnIrAlCarrito = "//*[@id='mini-cart-link-cart']";
    String fieldCupon = "//*[@id='dwfrm_cart_couponCode']";
    String btnAplicarfieldCupon = "//*[@id='dwfrm_cart_couponCode']";
    String textInvalidCupon = "//*[contains(@class, 'error')]";


    public void navigateToParis(String string){
        navigateTo(string);
    }

    public void clickInBtnProduct(){
        clickElement(btnAgregarProduct);

    }

    public void clickContinuar(){
        clickElement(btnContinuareAgregarProduct);
    }

    public void clickIrAlCarrito(){
        clickElement(btnIrAlCarrito);
    }

    public void writeCuponInvalid(){
        write(fieldCupon,"123433");
        clickElement(btnAplicarfieldCupon);
    }

    public void validateTextErrorCupon(){

    }
}


