package automationcraft.testcreation.msabattini.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ParisCLPage extends SeleniumBase {

    public ParisCLPage(WebDriver driver) {
        super(driver);
    }


    By addToCar = By.xpath("//button[@value='Añadir al carro']");
    By boton_continuar = By.xpath("//button[@class='warranty-modal__button']");
    By texto_cantidad_carrito = By.xpath("//div[@class='info-carro clearfix']//span");
    By texto_addCar = By.xpath("//div[@class='warranty-modal__header-subtitle']//span");
    By botonIrAlCarro = By.xpath("//a[@id='mini-cart-link-cart']");
    By desplegar_carro = By.xpath("//div[@class='cart-icon']");


    public void irURL(String string){
        goToUrl(string);
    }

    public void click_boton_addToCar(){
        click(addToCar);
    }

    public void validar_carrito() throws Exception {
        explicitWait(5);
        if(!isDisplayed(texto_addCar)) {
            throw new Exception("Elemento no Encontrado");
        }
    }

    public void click_boton_continuar() throws InterruptedException {
        explicitWait(5);
        click(boton_continuar);
    }

    public void click_boton_irAlCarro() throws InterruptedException {
        explicitWait(5);
        click(botonIrAlCarro);
    }

    public void validad_cantidad_enCarro(int cantidad){
        String text = getText(texto_cantidad_carrito);
        Assert.assertTrue(text.contains(Integer.toString(cantidad)));
    }

    public void aumentar_cantidad(String string) throws InterruptedException {
        explicitWait(5);
        click(desplegar_carro);

        By agregar_producto = By.xpath("//input[@value='"+string+"']");
        for(int i=0; i<20; i++) click(agregar_producto);
    }

    public void boton_disable(String string){
        By agregar_producto = By.xpath("//input[@value='"+string+"']");
        Assert.assertFalse(isEnabled(agregar_producto));
    }



















}
