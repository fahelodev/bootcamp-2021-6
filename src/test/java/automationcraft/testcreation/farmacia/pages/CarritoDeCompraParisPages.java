package automationcraft.testcreation.farmacia.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CarritoDeCompraPages extends SeleniumBase {

    public CarritoDeCompraPages(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By barraBusqueda = By.xpath("//input[@id=\"search\"]");
    By btnAgregarCarritoBromex = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[2]/ol/li[1]/div/div[2]/div[2]/div/div[1]/form/button");
    By btnCantidadCarrito = By.xpath("//a[3]//span[@class='counter qty']");
    By btnVerCarrito = By.xpath("//a[@id=\"top-cart-btn-checkout\"]");
<<<<<<< HEAD:src/test/java/automationcraft/testcreation/farmacia/pages/CarritoDeCompraParisPages.java
    By btnAumentarCantidad = By.xpath("//input[@id='cart-2598860-qty']");

=======
    By boxCantidadProductos = By.xpath("//input[@title=\"Cant.\"]");
    By btnActualizarCompra = By.xpath("//*[@title='Actualizar la Compra ']");
    By txtAdvertencia = By.xpath("//div[contains(text(), 'Has excedido el número máximo')]");
    By txtAdvertenciaReceta = By.xpath("//div[contains(text(), 'Este medicamento requiere receta médica.')]");
    By boxTarjetasCMR = By.xpath("//input[@id=\"cmr_coupon_code\"]");
    By btnAplicarCupon = By.xpath("//*[@id='send-cmr-coupon']");
    By getTxtAdvertenciaCuponInvalido = By.xpath("//div[contains(text(), 'El número ingresado no es válido,')]");
>>>>>>> 1adab6b6401189b004df320cd2a81cd84b0dd5a8:src/test/java/automationcraft/testcreation/farmacia/pages/CarritoDeCompraPages.java

    //Comportamientos
    public void validacionUrl(String url) throws Exception {
        goToUrl(url);
    }

    public void guardarProducto() throws Exception {
        explicitWait(1500);
        click(btnAgregarCarritoBromex);
    }

    public void validarCargaEnCarrito() throws Exception {
        if (!isDisplayed(btnCantidadCarrito)) {
            throw new Exception("Elemento no Encontrado");
        }
        click(btnCantidadCarrito);
    }

    public void IngresarCantidadDeProductos() throws InterruptedException {
        explicitWait(3000);
        click(boxCantidadProductos);
        type(String.valueOf(Keys.BACK_SPACE), boxCantidadProductos);
        type("11", boxCantidadProductos);
    }

    public void AplicarCantidadProductos() throws InterruptedException {
        click(btnActualizarCompra);
        explicitWait(2000);
    }

    public void validarCantidadProductos(String inputText) {
        String msgAdvertencia = getText(txtAdvertencia);
        Assert.assertEquals(inputText, msgAdvertencia);
    }

    public void validarRecetaMedica(String inputText) throws InterruptedException {
        explicitWait(3000);
        String msgAdvertenciaReceta = getText(txtAdvertenciaReceta);
        Assert.assertEquals(inputText, msgAdvertenciaReceta);
    }

    public void validarDespliegueCarritoCompraWeb() throws InterruptedException {
        explicitWait(1500);
        click(btnVerCarrito);
    }

<<<<<<< HEAD:src/test/java/automationcraft/testcreation/farmacia/pages/CarritoDeCompraParisPages.java
    public void validarAumentarCantidadProducto(int cantidad) throws Exception {
        if(!isDisplayed(btnAumentarCantidad)) {
            throw new Exception("Elemento no Encontrado");
        }
        type(String.valueOf(cantidad), btnAumentarCantidad);
    }

    public void validarActualizarCompra(String string) {
        By btnActualizarCompra = By.xpath("//button[@name='update_cart_action' and @title='"+string+ "']");
        click(btnActualizarCompra);
=======
    public void ingresarCupon() throws InterruptedException {
        Thread.sleep(3000);
        click(boxTarjetasCMR);
        type("123456", boxTarjetasCMR);
        click(btnAplicarCupon);
    }
    public void validarTarjetas(String inputText) throws InterruptedException {
        String msgAdvertenciaCupon = getText(getTxtAdvertenciaCuponInvalido);
        Assert.assertEquals(inputText,msgAdvertenciaCupon);
>>>>>>> 1adab6b6401189b004df320cd2a81cd84b0dd5a8:src/test/java/automationcraft/testcreation/farmacia/pages/CarritoDeCompraPages.java
    }

}
