package pom.mentoria.equipo3.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumBase {


    //Atributos
    public WebDriver driver;
    WebDriverWait espera = new WebDriverWait(driver, 8000);


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


    //accion -> void
    public void obtenerUrl(String URL){
        driver.get(URL);
    }

    //accion -> void
    public void clickear(By localizador){
        driver.findElement(localizador).click();
    }

    //accion -> espera

    public void espera(By recomendaciones_aeropuerto, By inputAeropuerto){
        espera.until(ExpectedConditions.visibilityOfElementLocated(recomendaciones_aeropuerto));
        driver.findElement(inputAeropuerto).sendKeys(Keys.RETURN);
    }

    //accion -> select

    public void select_dia_hora(By localizador, String horaArribo){
        Select select = new Select(driver.findElement(localizador));
        select.selectByVisibleText(horaArribo); //hora
    }


    public Boolean isABoolean(By localizador){
        try {
            return driver.findElement(localizador).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }

    }


}
