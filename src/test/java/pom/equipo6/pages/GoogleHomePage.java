package pom.equipo6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo6.base.SeleniumBase;

public class GoogleHomePage extends SeleniumBase {

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    //atributos - localizadores

    String URL = "https://www.google.com/";

    By barraGoogle = By.xpath("//input[@name='q']");


    //Given estoy en un navegador con la pagina inicial de google
    public void irAHomeDeGoogle(){
        obtenerUrl(URL);
    }
    //When introduzco la palabra "arbol" en la barra"
    public void ingresarTextoABarraGoogle(String texto){
        teclear(barraGoogle,texto);
    }
    //And realizo la busqueda con Enter
    public void EnterABarraGoogle(){
        enter(barraGoogle);
    }

}
