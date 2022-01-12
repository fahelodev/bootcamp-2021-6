package pom.equipo6.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumBase {

    //Atributos
    protected WebDriver driver;

    //Constructor
    public SeleniumBase(WebDriver driver) {
        this.driver = driver;
    }

    //Metodos Wrapper - Envoltorios
    //Funciones de retorno ->  en su declaracion debe indicar que Objeto retorna
    public WebElement encontrarElementoWeb(By localizador){//encuentra los elementos a travez de variable localizador
        return driver.findElement(localizador);

    }
    //Lista
    public List<WebElement> encontrarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }

    //Funciones de accion -> void
    public void obtenerUrl(String URL){
        driver.get(URL);
    }
    //accion -> void
    public void clickear(By localizador){
        encontrarElementoWeb(localizador).click();
    }

    public void texto(By localizador) {
        encontrarElementoWeb(localizador).getText();
    }
    public void ingresarTexto(By localizador, String texto){ encontrarElementoWeb(localizador).sendKeys(texto);}

    public void enter(By localizador){ encontrarElementoWeb(localizador).sendKeys(Keys.ENTER);}

    public void teclear(By localizador, String text) {
        driver.findElement(localizador).sendKeys(text);
    }

    public String sacarTexto(By localizador){return encontrarElementoWeb(localizador).getText();}





}





