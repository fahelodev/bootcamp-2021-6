package automationcraft.testcreation.iRomero.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoDeCompraPages extends SeleniumBase {

    public CarritoDeCompraPages(WebDriver driver) {
        super(driver);
    }

    By numberProducts = By.xpath("//div[@class=\"col-1-background\"]//h3/span");
    By addProduct = By.xpath("//input[@id=\"GTM_cart_quantity-mas\"]");
    By btnDisable = By.xpath("//input[(@disabled)]");

    public void validacionCantidad(Integer val)throws Exception{
        if (!isDisplayed(numberProducts)){
            throw new Exception("Elemento no Encontrado");
        }

        String quantity = getText(numberProducts);
        String[] arr = quantity.split(" ");
        String elemt = arr[0].replace("(", "");
        Integer number = Integer.parseInt(elemt);

        Assert.assertEquals(val, number);
    }

    public void agregadoDeProducto(Integer num) throws InterruptedException {
        for (int i=0; i<num; i++){
            if (!isDisplayed(addProduct)){
                break;
            }
            explicitWait(2000);
            click(addProduct);
        }
    }

    public void botonDesabilitado(){
        Assert.assertTrue(isDisplayed(btnDisable));
    }


}