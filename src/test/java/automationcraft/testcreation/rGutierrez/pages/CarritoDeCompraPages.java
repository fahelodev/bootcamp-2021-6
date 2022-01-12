package automationcraft.testcreation.rGutierrez.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class CarritoDeCompraPages extends SeleniumBase {

    public CarritoDeCompraPages(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By btnAniadirAlCarro = By.xpath("//button[contains(@id, 'add-to-cart')]");
    By btnContinuar = By.xpath("//button[contains(@data-type, 'checkout')]");
    By btnIrAlCarro = By.xpath("//a[@id='mini-cart-link-cart']");
    By spnCantidadProductos = By.xpath("//div[contains(@class, 'info-carro')]//span");
    By btnMas = By.xpath("//input[@id='GTM_cart_quantity-mas']");
    By btnMasDisabled = By.xpath("//input[@id='GTM_cart_quantity-mas'][@disabled]");

    public void validacionUrl(String url) throws Exception {
        goToUrl(url);
    }

    public void presionarAniadirAlCarro() throws Exception {
        if(!isDisplayed(btnAniadirAlCarro)) {
            throw new Exception("Elemento no Encontrado");
        }
        click(btnAniadirAlCarro);
    }

    public void presionarContinuar() throws Exception {
        explicitWait(1500);
        if(!isDisplayed(btnContinuar)) {
            throw new Exception("Elemento no Encontrado");
        }
        click(btnContinuar);
    }

    public void presionarIrAlCarro() throws Exception {
        explicitWait(1500);
        if(!isDisplayed(btnIrAlCarro)) {
            throw new Exception("Elemento no Encontrado");
        }
        click(btnIrAlCarro);
    }

    public void validarProductoAgregado() throws Exception {
        if(!isDisplayed(spnCantidadProductos)) {
            throw new Exception("Elemento no Encontrado");
        }

        if(!getText(spnCantidadProductos).equalsIgnoreCase("(1 productos)")) {
            throw new Exception("Problema al validar producto agregado");
        }
    }

    public void aumentarProductoMayorA(int num) throws Exception {

        if(!isDisplayed(btnMas)) {
            throw new Exception("Elemento no Encontrado");
        }

        int cantidadProductos = Integer.parseInt(getText(spnCantidadProductos).substring(1,3).trim());

        while(num > cantidadProductos){
            explicitWait(2000);
            click(btnMas);
            cantidadProductos = Integer.parseInt(getText(spnCantidadProductos).substring(1,3).trim());
        }
    }

    public void validarBotonDeshabilitado() throws Exception {
        WebElement btndisabled = findElement(btnMasDisabled);

        if (Objects.isNull(btndisabled)){
            throw new Exception("Elemento no deshabilitado");
        }
    }

}
