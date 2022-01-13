package automationcraft.testcreation.apple.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CarritoDeCompraApplePages extends SeleniumBase {

    public CarritoDeCompraApplePages(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By barraBusqueda = By.xpath("//input[@id=\"search\"]");
    By btnAgregarCarrito = By.xpath("//button[@title=\"Añadir al carro\"]");
    By btnCerrar = By.xpath("//*[contains(@class, 'warranty-modal__close')]");
    By btnMas= By.xpath("//*[@id='btn-plusMC']");

    public void validacionUrl(String url) throws Exception {
        goToUrl(url);
    }

    public void guardarProducto() throws Exception {
        explicitWait(1500);
        click(btnAgregarCarrito);
        explicitWait(2000);
    }
    public void Cerrar() throws InterruptedException {
        click(btnCerrar);
    }
    public void clickEnMas() throws InterruptedException {
        explicitWait(4000);
        for (int i = 0; i <= 20 ; i++) {
            click(btnMas);
            explicitWait(600);
        }
    }
    public void validarBotonMas() throws Exception {

    }

}
