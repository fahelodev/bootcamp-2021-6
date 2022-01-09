package pom.Grupo4.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pom.Grupo4.base.SeleniumBase;

public class VFPaquetesResultadosPage extends SeleniumBase {
    public VFPaquetesResultadosPage(WebDriver driver) {
        super(driver);
    }

    //Selectores
    By resultado = By.xpath("(//span[@class='-eva-3-tc-gray-2' and contains(text(),'Rio de Janeiro')])[1]");
    By btnDesayuno = By.xpath("(//span[contains(@class,'filters')])[3]");
    By txtDesayuno = By.xpath("(//div[contains(@class,'-eva-3-bold')])[3]");
    By filtroMoneda = By.xpath("//div[@class='eva-3-select -sm']//div[@class='select-container']//select[@class='select-tag']");
    By primeraOpcion = By.xpath("(//button[contains(@class,'eva-3-btn')])[5]");
    By btnSiguienteA = By.xpath("//div[contains(@class,'pricebox-action')]//button[contains(@class,'eva-3-btn')]");
    By btnVueloConveniente = By.xpath("(//a[contains(@class,'-md eva-3-btn')])[2]");
    By btnSiguiente = By.xpath("//div[@class='pricebox-content-container']//button[contains(@class,'eva-3-btn')]");
    By containerInferior = By.xpath("//div[@class='pricebox-sticky-more-info']//div[@class='pricebox-sticky-info-container']//div[contains(@class,'-eva-3-tc-gray')]");


    //Comportamientos
    public String obtenerResultadoEsperado() {
        esperarElementoVisible(15, resultado);
        return obtenerTexto(resultado);
    }

    public void filtroDesayuno(){
        esperarElementoVisible(15, btnDesayuno);
        clickear(btnDesayuno);
    }

    public String filtroBuscado(){return obtenerTexto(txtDesayuno);}

    public void cambioMoneda(){
        Select moneda = crearSelect(filtroMoneda);
        moneda.selectByVisibleText("Peso chileno");
    }

    public void seleccionarOpcion(){
        esperarElementoClickeable(15, primeraOpcion);
        clickear(primeraOpcion);
    }
    public void clickSiguienteA() {
        esperarElementoClickeable(15, btnSiguienteA);
        clickear(btnSiguienteA);
    }

    public void vueloConveniente(){
        esperarElementoClickeable(15, btnVueloConveniente);
        clickear(btnVueloConveniente);
    }

    public int obtenerPrecioCompleto(){
        esperarElementoVisible(15, containerInferior);
        String precioCompleto = obtenerTexto(containerInferior);
        String precioString = precioCompleto.replaceAll("\\p{Punct}", "");
        int precioPaquete = Integer.parseInt(precioString);
        return precioPaquete;
    }

    public void clickSiguiente(){
        esperarElementoClickeable(15, btnSiguiente);
        clickear(btnSiguiente);
    }
}
