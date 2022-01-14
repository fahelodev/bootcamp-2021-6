package automationcraft.testcreation.rsobarzo.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoParisPages extends SeleniumBase {

    public CarritoParisPages(WebDriver driver) {
        super(driver);
    }

    // localizadores

    By barraBusqueda = By.xpath("//input[@id='desktop-search__form-input']");
    By btn_agregar_carrito = By.xpath("//span[@class='add-to-cart__label']");
    By btn_continuar = By.xpath("//button[@class='warranty-modal__button']");
    By btn_sumar_cantidad = By.xpath("//button[@id='btn-plusMC']");
    By lnk_ir_carrito = By.xpath("//a[@id='mini-cart-link-cart']");
    By btn_sumar_desde_carrito = By.xpath("//input[@id='GTM_cart_quantity-mas']");

    public void validacionUrl(String url) throws Exception {
        goToUrl(url);
    }

    public void guardarProducto() throws Exception {
        explicitWait(1500);
        click(btn_agregar_carrito);
    }

    public void validarCargaEnCarrito() throws Exception {
        if(!isDisplayed(btn_agregar_carrito)) {
            throw new Exception("Elemento no Encontrado");
        }
        click(btn_agregar_carrito);
    }

    public void validarDespliegueCarritoCompraWeb() throws InterruptedException {
        explicitWait(1500);
        click(lnk_ir_carrito);
    }
    public void cargar20veces(){
        for (int i = 0; i < 20; i++) {
            click(btn_sumar_desde_carrito);
        }

    }

}
