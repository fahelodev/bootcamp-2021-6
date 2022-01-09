package pom.Grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Grupo4.base.SeleniumBase;

import java.util.List;

public class VFAlojamientosResultadoSugerenciaPage extends SeleniumBase {

    private String URL = "https://www.viajesfalabella.cl/hoteles/hl/";
    public VFAlojamientosResultadoSugerenciaPage(WebDriver driver){super(driver);}

    //atributos de la pagina -> Localizadores
    By titulosResultados = By.cssSelector(".cluster-content .offer-card-title");


    public String nombrePrimerResultado() {
        String nombrePrimerResultado = obtenerTexto(titulosResultados);
        return nombrePrimerResultado;
    }
}

