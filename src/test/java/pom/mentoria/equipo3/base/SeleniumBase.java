package pom.mentoria.equipo3.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumBase {

    //Atributos
    public WebDriver driver;

    public SeleniumBase(WebDriver driver) {
        this.driver = driver;
    }

    //Metodos Wrapper - Envoltorios

    //retorno ->  en su declaracion debe indicar que Objeto retorna
    public WebElement encontrarElementoWeb(By localizador){
        return driver.findElement(localizador);
    }

    public List<WebElement> encontrarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }
    public String getText(WebElement element){
        return element.getText();
    }
    public String getText(By localizador){
        return driver.findElement(localizador).getText();
    }


    //accion
    public void type(String inputText, By localizador){
        driver.findElement(localizador).sendKeys(inputText);
    }

    public void presionarTecla(By localizador){
        driver.findElement(localizador).sendKeys(Keys.RETURN);
    }

    //accion -> void
    public void obtenerUrl(String URL){
        driver.get(URL);
    }

    //accion -> void
    public void clickear(By localizador){
        driver.findElement(localizador).click();
    }

    public Boolean isABoolean(By localizador){
        try {
            return driver.findElement(localizador).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }

    }


}
