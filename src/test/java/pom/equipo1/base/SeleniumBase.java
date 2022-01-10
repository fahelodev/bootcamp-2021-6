package pom.equipo1.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public void enviarKeys(By localizador, String texto){ encontrarElementoWeb(localizador).sendKeys(texto);}

<<<<<<< HEAD
//    public void sendEnter(By localizador){ encontrarElementoWeb(localizador).sendKeys(Keys.ENTER);}

    public String devolverTexto(By localizador){return encontrarElementoWeb(localizador).getText();}

    public void setSelect(By localizador, String value){
        new Select(encontrarElementoWeb(localizador)).selectByValue(value);
    }

=======
    public String devolverTexto(By localizador){return encontrarElementoWeb(localizador).getText();}

    public void doSendKeys(By localizador, String texto){ encontrarElementoWeb(localizador).sendKeys(texto);}

    public void sendEnter(By localizador){ encontrarElementoWeb(localizador).sendKeys(Keys.ENTER);}
>>>>>>> 0ba90a06aaa7586fe906c6c647791cb30ee3535d


}
