package automationcraft.testcreation.FMercado.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CarritoDeComprasPages extends SeleniumBase {
    public CarritoDeComprasPages(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By btnAgregarCarrito = By.xpath("//button[contains(@class,'add-to-cart btn-default')]");
    By btnContinuar = By.xpath("//button[@data-type='checkout']");
    By btnIrAlCarrito = By.id("mini-cart-link-cart");
    By prodAgregado = By.xpath("//div[contains(@class,'col-lg-8 col-md-9')]");

    By productUno = By.xpath("//span[text()='(1 productos)']");
    By btnAgregarProducto = By.xpath("//input[@class='button-plus__right js-button-plus']");
    By MaxProd = By.xpath("//span[text()='(20 productos)']");



    public void validacionUrl(String url) throws Exception {
        goToUrl(url);
    }

    public void guardarProducto() throws Exception {

        click(btnAgregarCarrito);
        explicitWait(2000);
        click(btnContinuar);
        explicitWait(2000);
    }

    public void validarCargaEnCarrito() throws Exception {
        if(!isDisplayed(btnIrAlCarrito)) {
            throw new Exception("Elemento no Encontrado");
        }
        click(btnIrAlCarrito);
    }

    public void validarCarritoEnPantalla() throws Exception {
        explicitWait(1500);
        if(!isDisplayed(prodAgregado)) {
            throw new Exception("Elemento no Encontrado");
        }
    }

    public void validarUnProducto(){
        Assert.assertEquals("(1 productos)", getText(productUno));

    }

    public void AgregarProductos() throws InterruptedException {

        int i=1;
        do{
            click(btnAgregarProducto);
            explicitWait(900);
            i++;
        }while(i<20);

        /*while(isEnabled(btnAgregarProducto)) {
            click(btnAgregarProducto);
            explicitWait(500);
        }*/
        System.out.println("Exito");

    }

    public void MaximoPermitido() throws InterruptedException {
        //Assert.assertEquals("false", MaxProd);
        if(!isEnabled(MaxProd)){
            System.out.println("Exito");
        }
    }


}
