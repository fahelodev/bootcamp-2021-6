package pom.Grupo4.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.kerberos.KerberosKey;
import java.util.ArrayList;
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
    //Sobrecarga encontrarElemento
    public WebElement encontrarElementoWeb(WebElement elemento, By localizador){
        return elemento.findElement(localizador);
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

    //Cambiar pestaña siguiente
    public void pestañaSiguiente(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> pestañas = new ArrayList<>(obtenerPestanias());
        driver.close();
        driver.switchTo().window(pestañas.get(1));
    }


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

    //crear un Select
    public Select crearSelect(By localizador){
        Select select = new Select(encontrarElementoWeb(localizador));
        return select;
    }

    //obtener texto
    public String obtenerTexto(By localizador){return encontrarElementoWeb(localizador).getText();}

    //Sobrecarga obtener texto
    public String obtenerTexto(WebElement elemento){return elemento.getText();}


}
