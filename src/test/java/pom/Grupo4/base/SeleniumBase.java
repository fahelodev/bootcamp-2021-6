package pom.Grupo4.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.kerberos.KerberosKey;
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

    //Clickear sobre WebElement
    public void clickear(WebElement elemento){ elemento.click(); }

    //Envolver getWindowsHandle
    public Set<String> obtenerPestanias(){ return driver.getWindowHandles(); }

    //Espera explicita hasta elemento visible
    public void esperarElementoVisible (int tiempo,By localizador){
        WebDriverWait espera = new WebDriverWait(driver,tiempo);
        espera.until(ExpectedConditions.visibilityOfElementLocated(localizador));
    }

    //Espera explicita hasta elemento clickeable
    public void esperarElementoClickeable (int tiempo,By localizador){
        WebDriverWait espera = new WebDriverWait(driver,tiempo);
        espera.until(ExpectedConditions.elementToBeClickable(localizador));
    }



    //Enviar ENTER
    public void enviarEnter(By localizador){encontrarElementoWeb(localizador).sendKeys(Keys.ENTER);}

    //Enviar DOWN
    public void enviarDown(By localizador){encontrarElementoWeb(localizador).sendKeys(Keys.DOWN);}

    //Enviar texto
    public void enviarTexto(By localizador, String texto){encontrarElementoWeb(localizador).sendKeys(texto);}

    //


}
