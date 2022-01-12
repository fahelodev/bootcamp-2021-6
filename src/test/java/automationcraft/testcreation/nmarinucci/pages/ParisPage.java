package automationcraft.testcreation.nmarinucci.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ParisPage extends SeleniumBase {
    public ParisPage(WebDriver driver) {
        super(driver);
    }
    //Localizadores
    By btnAniadirAlCarro = By.xpath("//button[@id='486146999-add-to-cart']");
    By btnGarantia = By.xpath("//button[@type='button' and @data-type='checkout']");
    By btnIrAlCarro = By.xpath("//a[@id='mini-cart-link-cart']");
    By btnSumarCantidad = By.xpath("//input[@id='GTM_cart_quantity-mas']");

    //Comportamientos
    public void goToURL(String string){
        goToUrl(string);
    }

    public void validarAñadirAlCarro() throws Exception {
        implicitWait(btnAniadirAlCarro);
        if(!isDisplayed(btnAniadirAlCarro)){
            throw new Exception("Elemento no encontrado");
        }
        click(btnAniadirAlCarro);

        explicitWait(2000);
        if(!isDisplayed(btnGarantia)){
            throw new Exception("Elemento no encontrado");
        }
        click(btnGarantia);
    }

    public void validadProductoAñadido() throws Exception {
        explicitWait(1500);
        if(!isDisplayed(btnIrAlCarro)){
            throw new Exception("Elemento no encontrado");
        }
        click(btnIrAlCarro);
    }


    public void sumarCantidad(int limite) throws Exception {
        for (int i = 1; i < limite; i++) {
            explicitWait(2000);
            if(!isDisplayed(btnSumarCantidad)){
                throw new Exception("Elemento no Encontrado");
            }
            click(btnSumarCantidad);
        }
    }

    public void validarBotonDeshabilitado() throws Exception {
        System.out.println("Boton Deshabilitado");
    }
}
