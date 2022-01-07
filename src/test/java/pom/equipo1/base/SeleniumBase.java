package pom.equipo1.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumBase {

    //Atributos
    WebDriver driver;

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

    //accion -> void
    public void obtenerUrl(String URL){
        driver.get(URL);
    }
    //accion -> void
    public void clickear(By localizador){
        encontrarElementoWeb(localizador).click();
    }

//    public void enviarKeysWithEnter(By localizador, String texto){ encontrarElementoWeb(localizador).sendKeys(texto + Keys.ENTER);}

    public String devolerTexto(By localizador){return encontrarElementoWeb(localizador).getText();}

    public void enviarKeys(By localizador, String texto){ encontrarElementoWeb(localizador).sendKeys(texto+ Keys.ENTER);}


}
