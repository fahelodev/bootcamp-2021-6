package pom.equipo2.base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class SeleniumBasePaquetes {

    WebDriver driver;


    public SeleniumBasePaquetes(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement encontrarElemento(By localizator) {

        return driver.findElement(localizator);
    }

    public List<WebElement> encontrarElementosWeb(By localizator) {
        return driver.findElements(localizator);
    }

    public void ObtenerURL(String URL) {

        driver.get(URL);
    }

    public void clic(By localizator) {

        encontrarElemento(localizator).click();
    }

    public void enviarSantiago(By localizator) {
        String Santiago = "Santiago de Chile, Santiago, Chile";
        encontrarElemento(localizator).sendKeys(Santiago);
        encontrarElemento(localizator).sendKeys(Keys.DOWN);
        encontrarElemento(localizator).sendKeys(Keys.ENTER);
    }

    public void enviarArica(By localizator) {
        String Arica = "Arica, Arica y Parinacota, Chile";
        encontrarElemento(localizator).sendKeys(Arica);
        encontrarElemento(localizator).sendKeys(Keys.DOWN);
        encontrarElemento(localizator).sendKeys(Keys.ENTER);
    }

    public void enviarSanPAblo(By localizator) {
        String saoPaulo = "San Pablo, San Pablo, Brasil";
        encontrarElemento(localizator).sendKeys(saoPaulo);
        encontrarElemento(localizator).sendKeys(Keys.DOWN);
        encontrarElemento(localizator).sendKeys(Keys.ENTER);
    }

    public void enviarRio(By localizator) {
        String rio = "Rio de Janeiro, Rio de Janeiro, Brasil";
        encontrarElemento(localizator).sendKeys(rio);
        encontrarElemento(localizator).sendKeys(Keys.DOWN);
        encontrarElemento(localizator).sendKeys(Keys.ENTER);
    }

    public void SwitchTabs() {
        String mainTab = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(mainTab)) {
                driver.switchTo().window(actual);
            }
        }
    }

    public void limpiarCajaTextoDestino(By localizator) {
        encontrarElemento(localizator).sendKeys(Keys.CONTROL + "A");
        encontrarElemento(localizator).sendKeys(Keys.CLEAR);
    }


    public void validarOrigenYdestino() {

        String mensajeErrorSistema = encontrarElemento(By.xpath("//*[contains(@class, 'sbox-destination-different-origin-error')]")).getText();
        String resultError = "El destino debe ser diferente del origen.";
        Assert.assertEquals(mensajeErrorSistema, resultError);

    }

    public void validaTC03() {
        WebDriverWait driverWithMoreWait = new WebDriverWait(driver, 20);
        String textValidate = driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='trips-cluster-selected-position']//*[contains(@class, 'itineraries-container')]/span/route-choice/div/span[2]/span[2]/route-info-item[2]/span/span/span"))).getText();
        //Validacion
        Assert.assertEquals("Rio de Janeiro", textValidate);
    }
}