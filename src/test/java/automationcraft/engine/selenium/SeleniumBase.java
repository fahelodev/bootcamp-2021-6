package automationcraft.engine.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.util.List;

/**
 * Clase Base de Selenium, para poder enmascarar
 * la version de Selenium
 * @responsable encargado framework
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

    /**
     * funcion que escribe un texto enviado a un objeto WebElement
     *
     * @param inputText : texto a escribir
     * @param locator   : Objeto By del repositorio
     */
    public void type(String inputText, By locator) throws InterruptedException {
        driver.findElement(locator).sendKeys(inputText);
    }

    /**
     * funcion que hace 1 click en un WebElement
     *
     * @param locator : Objeto By del repositorio
     */
    public void click(By locator) {
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
            implicitWait(locator);
            return driver.findElement(locator).isDisplayed();
    }

    public void implicitWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }

    public void explicitWait(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public Boolean isEnabled(By locator) {
            implicitWait(locator);
            return driver.findElement(locator).isEnabled();
    }

    /**
     * funcion para Navegar a un URL
     *
     * @param url : String con URL
     */
    public void goToUrl(String url) {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }
    public String getTitle(String url){
        return driver.getTitle();
    }

}
