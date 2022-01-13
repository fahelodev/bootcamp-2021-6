package automationcraft.testcreation.mvargas.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoCompraParisPages extends SeleniumBase {

    public CarritoCompraParisPages(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By btnAgregarCarro = By.xpath("//button[@id=\"486146999-add-to-cart\"]");
    By btnCantidadCarro = By.xpath("//span[@class='minicart-quantity']");
    By btnContinuar= By.xpath("//button[@class='warranty-modal__button']");
    By btnVerCarro = By.xpath("//a[@id='mini-cart-link-cart']");


    public void validacionUrl(String url) throws Exception {
        goToUrl(url);
    }

    public void guardarProducto() throws Exception {
        explicitWait(1500);
        click(btnAgregarCarro);
        explicitWait(3000);
        click(btnContinuar);
    }

    public void validarCargaEnCarro() throws Exception {
        if(!isDisplayed(btnCantidadCarro)) {
            throw new Exception("Elemento no Encontrado");
        }
        click(btnCantidadCarro);
    }

    public void validarDespliegueCarroCompraWeb() throws InterruptedException {
        explicitWait(1500);
        click(btnVerCarro);
    }

}
