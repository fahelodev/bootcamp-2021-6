package pom.mentoria.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.mentoria.base.SeleniumBase;

public class GoogleHomePage extends SeleniumBase {

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    //atributos - localizadores
    String URL = "https://www.google.com/";
    By barraGoogle = By.xpath("//input[@name='q']");

    //Metodo
    public void irAHomeDeGoogle(){
        obtenerUrl(URL);
    }

    public void ingresarTextoABarraGoogle(String texto){
        teclear(barraGoogle,texto);
    }

    public void EnterABarraGoogle(){
        enviarEnter(barraGoogle);
    }

}
