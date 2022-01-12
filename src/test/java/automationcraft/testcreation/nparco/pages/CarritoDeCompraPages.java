package automationcraft.testcreation.nparco.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoDeCompraPages extends SeleniumBase {

    public CarritoDeCompraPages(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By btn_anadir = By.xpath("//span[text()='Añadir al carro']");
    By close = By.xpath("//*[contains(@class, 'warranty-modal__close')]");
    By cart = By.xpath("//*[@id='mini-cart-link-cart']");
    By plus = By.xpath("//*[@id='GTM_cart_quantity-mas']");


    public void validacionUrl(String url) throws Exception {
        goToUrl(url);
    }

    public void Anadir() throws Exception {
        Thread.sleep(2000);
        click(btn_anadir);
        Thread.sleep(2000);
        click(close);
    }

    public void irAlCarro() throws Exception {
        Thread.sleep(2000);
        click(cart);
        Thread.sleep(2000);
    }

    public void aumentarCantidad(int arg1) throws InterruptedException {
        implicitWait(plus);
        for (int i = 0; i < arg1; i++) {
            click(plus);
            Thread.sleep(2000);
        }
    }

    public void validarCargaEnCarrito() throws Exception {
//        if(!isDisplayed()) {
            throw new Exception("Elemento no Encontrado");
//        }

    }

    public void validarDespliegueCarritoCompraWeb() throws InterruptedException {
        explicitWait(1500);
//        String cart = getText(btnVerCarrito);
//        Assert.assertEquals("Ver Carrito", cart);
    }

    public void aumentaCantidadaProducto() throws InterruptedException {
        explicitWait(1500);
    }



}
