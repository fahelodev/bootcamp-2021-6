package pom.mentoria.equipo3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.mentoria.base.SeleniumBase;

public class VFHomePage extends SeleniumBase {

    private String URL = "https://www.viajesfalabella.cl/";
    public VFHomePage(WebDriver driver) {
        super(driver);
    }
    //atributos de la pagina -> Localizadores
    By btnInicioSesion = By.xpath("//span[@class=\"header-autogestion-title\"]");

    //metodos de la pagina - Keyword Driven
    public void irAInicioDeSesion(){
        obtenerUrl(URL);
        clickear(btnInicioSesion);
        WebElement validacion = encontrarElementoWeb(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div[1]/div/div/h3"));
        if(validacion.isEnabled()){
            System.out.println("LISTO");
        }
    }



}
