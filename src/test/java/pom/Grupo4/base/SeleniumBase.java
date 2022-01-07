package pom.Grupo4.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

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

    //Envolver getWindowsHandle
    public Set<String> obtenerPestanias(){ return driver.getWindowHandles(); }

    //Espera explicita
    public WebDriverWait esperaExplicita(WebDriver driver, int tiempo){
        return new WebDriverWait(driver,tiempo);
    }

    //Espera hasta...

}
