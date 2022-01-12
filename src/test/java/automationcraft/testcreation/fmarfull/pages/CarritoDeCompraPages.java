package automationcraft.testcreation.fmarfull.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoDeCompraPages extends SeleniumBase {

    public CarritoDeCompraPages(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By btnAñadirAlCarrito = By.xpath("//*[@class=\"add-to-cart__label\"]");
    By barraBusqueda = By.xpath("//input[@id=\"search\"]");
    By btnAgregarCarritoBromex = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[2]/ol/li[1]/div/div[2]/div[2]/div/div[1]/form/button");
    By btnCantidadCarrito = By.xpath("//a[3]//span[@class='counter qty']");
    By btnVerCarrito = By.xpath("//a[@id=\"top-cart-btn-checkout\"]");


    public void validacionUrl(String url) throws Exception {
        goToUrl(url);
    }

    public void añadirAlCarrito() {
        click(btnAñadirAlCarrito);
    }

    public void guardarProducto() throws Exception {
        explicitWait(1500);
        click(btnAgregarCarritoBromex);
    }

    public void validarCargaEnCarrito() throws Exception {
        if(!isDisplayed(btnCantidadCarrito)) {
            throw new Exception("Elemento no Encontrado");
        }
        click(btnCantidadCarrito);
    }

    public void validarDespliegueCarritoCompraWeb() throws InterruptedException {
        explicitWait(1500);
        click(btnVerCarrito);
    }



}
