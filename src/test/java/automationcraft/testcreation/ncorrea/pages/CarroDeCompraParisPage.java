package automationcraft.testcreation.ncorrea.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CarroDeCompraParisPage extends SeleniumBase {

    public CarroDeCompraParisPage(WebDriver driver) {
        super(driver);
    }
    //Atributos o localizadores
    By btnCarrito = By.xpath("//button[@title=\"Añadir al carro\"]");
    By btnContinuar = By.xpath("//button[text()='Continuar']");
    By validacion = By.xpath("//span[text()='(1 productos)']");
    By btnIrAlCarro = By.xpath("//a[text()='Ir al carro']");
    By numProductos = By.xpath("//input[@type='number']");

    //Metodos
    public void validacionUrl (String url) throws Exception{
        goToUrl(url);
    }
    public void añadirAlCarrito(){
        implicitWait(btnCarrito);
        click(btnCarrito);
        implicitWait(btnContinuar);
        click(btnContinuar);
    }

    public void validacionProducto(){
        String val = getText(validacion);
        String [] arr = val.split(" ");
        Assert.assertEquals(1, arr[0].replace("(", ""));
    }

    public void irAlCarro(){
        click(btnIrAlCarro);
    }

    public void cantidadProductos(Integer val){
        String cantidad = getText(numProductos);
        String[] arr = cantidad.split(" ");
        String elemt = arr[0].replace("(", "");
        Integer num = Integer.parseInt(elemt);
        Assert.assertEquals(val, num);
    }


}
