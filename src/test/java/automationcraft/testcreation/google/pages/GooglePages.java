package automationcraft.testcreation.google.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GooglePages extends SeleniumBase {


    public GooglePages(WebDriver driver) {
        super(driver);
    }


    private String URL = "https://www.google.com";
    By CampoTexto = By.xpath("//input[@name='q']");
    By BotonBusca = By.xpath("//input[@name='btnK']");

    public void ingresaPagina(){

    goToUrl(URL);
    }

    public void ingresarTexto(String string){
        type(string,CampoTexto);
    }
    public void botonBusca(){
       click(BotonBusca);
    }

    public void resulEsperados(String string){
        String result = getTitle();
        Assert.assertTrue(result.contains(string));
    }

}
