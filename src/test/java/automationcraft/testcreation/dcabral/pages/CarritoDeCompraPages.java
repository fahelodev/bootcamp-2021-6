package automationcraft.testcreation.dcabral.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoDeCompraPages extends SeleniumBase {
    public CarritoDeCompraPages(WebDriver driver) {super(driver);}

    //Localizadores
    By botonAnadirAlCarro = By.xpath("//span[contains(@class, 'add-to-cart')]");
    By botonContinuar = By.xpath("//button[@data-type='checkout']");
    By botonIrAlCarro = By.xpath("//a[@id= 'mini-cart-link-cart']");
    By validarTexto1Producto = By.xpath("//span[contains(text(),'(1 productos)')]");
    By cuponBox = By.xpath("//input[@id='dwfrm_cart_couponCode']");
    By aplicarCupon = By.xpath("//button[@id='apply-coupon-cart']");
    By mensajeCuponInvalido = By.xpath("//div[contains(text(),'Código')]");

    //Metodos
    public void validacionUrl(String url) throws Exception {
        goToUrl(url);
    }

    public void presionarAnadirAlCarro() throws InterruptedException {
        explicitWait(1500);
        click(botonAnadirAlCarro);
    }

    public void presionarContinuar() throws InterruptedException {
        explicitWait(1500);
        click(botonContinuar);
    }

    public void presionarIrAlCarro() throws InterruptedException {
        explicitWait(1500);
        click(botonIrAlCarro);
    }

    public void validacionCompraEnPantalla(){
        if(!isDisplayed(validarTexto1Producto)){
            throw new RuntimeException("Elemento no encontrado");
        }

    }

    public void ingresarCodigoCupon(){
        type("123123123", cuponBox);
        click(aplicarCupon);
    }

    public void validarMensajeCuponInvalido() throws InterruptedException {
        explicitWait(1500);
        if(!isDisplayed(mensajeCuponInvalido)){
            throw new RuntimeException("Mensaje de error no localizado");
        }
    }
}
