package automationcraft.engine.selenium;

import org.openqa.selenium.By;
<<<<<<< HEAD
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
=======
>>>>>>> f30a182f5f34c9a61d5d331efd57bfab2a7077e1
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

<<<<<<< HEAD
import java.util.ArrayList;
import java.time.Instant;
=======
import java.time.Duration;
>>>>>>> f30a182f5f34c9a61d5d331efd57bfab2a7077e1
import java.util.List;

/**
 * Clase Base de Selenium, para poder enmascarar
 * la version de Selenium
 * @responsable eduardo.araya
 */
public class SeleniumBase {

    //Atributos
    public WebDriver driver;

    //Constructor Base
    public SeleniumBase(WebDriver driver) {
        this.driver = driver;
    }

    //Wrappers Selenium

    /**
     * funcion wrapper para obtener un WebElement
     *
     * @param locator: Objeto By de la Page
     * @return WebElement
     */
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    /**
     * funcion wrapper para obtener una Lista de WebElement
     *
     * @param locator: Objeto By de la Page
     * @return Lista de WebElement
     */
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * funcion que obtiene el texto de un objeto WebElement
     *
     * @param locator: Objeto By del repositorio
     * @return String     *
     */
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    /**
     * funcion que escribe un texto enviado a un objeto WebElement
     *
     * @param inputText : texto a escribir
     * @param locator   : Objeto By del repositorio
     */
    public void type(String inputText, By locator) throws InterruptedException {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void sendEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    /**
     * funcion que hace 1 click en un WebElement
     *
     * @param locator : Objeto By del repositorio
     */

    public void click(By locator){
        WebDriverWait espera = new WebDriverWait(driver, 2);
        espera.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    /**
     * funcion que cierra el Objeto WebDriver
     */
    public void closeDriver() {
        driver.close();
    }

    /**
     * funcion para saber si un WebElement esta desplegado en pantalla
     *
     * @param locator : Objeto By del repositorio
     * @return : verdadero o falso
     */
    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    /**
     * funcion para Navegar a un URL
     *
     * @param url : String con URL
     */
    public void goToUrl(String url) {
        driver.get(url);
    }

<<<<<<< HEAD

    public void validacionText(By localizador, String text){
        Assert.assertEquals(text, driver.findElement(localizador).getText());
    }

    public String getTitle() {
        return driver.getTitle();
    }
    //Espera explicita hasta elemento visible
    public void esperarElementoVisible (int tiempo,By localizador){
        WebDriverWait espera = new WebDriverWait(driver,tiempo);
        espera.until(ExpectedConditions.visibilityOfElementLocated(localizador));
    }
=======
    public String getTitle() {
        return driver.getTitle();
    }
>>>>>>> f30a182f5f34c9a61d5d331efd57bfab2a7077e1

}

