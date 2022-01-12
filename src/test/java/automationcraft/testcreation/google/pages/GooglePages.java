package automationcraft.testcreation.google.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class GooglePages extends SeleniumBase {

    //Atraibutos o Localizaodres

    String URL = "https://www.google.com/";

    By campo_busqueda_google = By.xpath("//input[@name='q']");
    By boton_buscar_google = By.xpath("//input[@name='btnK']");



    public GooglePages(WebDriver driver) {
        super(driver);
    }

    // Metodos KeywordDriven

    public void IraHomeGoogle(){
        goToUrl(URL);
    }

    public void introducirBusqueda(String inputText){

        type(inputText,campo_busqueda_google);
    }

    public void buscar() {
        click(boton_buscar_google);
    }

    public void resultado_esperado(String string)  {
        String result = getTitle();
        Assert.assertTrue(result.contains(string));
    }

}
