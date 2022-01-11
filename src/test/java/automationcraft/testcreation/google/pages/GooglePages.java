package automationcraft.testcreation.google.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePages extends SeleniumBase {
    public GooglePages(WebDriver driver) {
        super(driver);
    }

    //Atraibutos o Localizaodres

    By Search = By.xpath("//input[@class='gLFyf gsfi']");
    By prueba = By.xpath("//div[@class='iblpc']");

    // Metodos KeywordDriven
    public void abrirHome(){
        goToUrl("https://www.google.com.ar/");
    }

    public void Escribir(){
        teclear(Search,"cats");
    }

    public void ClickBuscar(){
        click(prueba);
    }

    public void Validacion() {
        ValidacionTitle("Google");
    }

}
