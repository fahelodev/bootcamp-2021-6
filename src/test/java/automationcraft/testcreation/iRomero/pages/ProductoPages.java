package automationcraft.testcreation.iRomero.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductoPages extends SeleniumBase {


    public ProductoPages(WebDriver driver) {
        super(driver);
    }

    By btnAdd = By.xpath("//button[@title=\"Añadir al carro\"]");
    By btnContinue = By.xpath("//button[@class=\"warranty-modal__button\"]");
    By productInCart = By.xpath("//div[@class=\"content-mini-carro\"]//h3/span");
    By goToCart = By.xpath("//div[@class=\"box-controles-mc clearfix\"]/a[@title=\"Ir al carro\"]");

    public void validacionUrl(String url){
        goToUrl(url);
    }

    public void agregadoCarrito() throws Exception {

        if (!isDisplayed(btnAdd)){
            throw new Exception("Elemento no Encontrado");
        }
        explicitWait(1500);
        click(btnAdd);
        if (!isDisplayed(btnContinue)){
            throw new Exception("Elemento no Encontrado");
        }
        explicitWait(5000);
        click(btnContinue);
    }

    public void validacionCarrito(){
        String carrito = getText(productInCart);
        String[] arr=carrito.split(" ");
        Assert.assertEquals("1", arr[0].replace("(", ""));
    }

    public void irACarrito(){
        implicitWait(goToCart);
        click(goToCart);
    }


}