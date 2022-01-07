package desafio.equipo2.base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

import static desafio.equipo4.Herramientas.changeTab;

public class SeleniumBase {
    WebDriver driver;

    public SeleniumBase(WebDriver driver){
        this.driver = driver;
    }
    public WebElement encontrarElemento(By localizator){
        return driver.findElement(localizator);
    }

    public List<WebElement> encontrarElementosWeb(By localizator){return driver.findElements(localizator);}

    public void ObtenerURL(String URL){
        driver.get(URL);
    }
    public void Click(By localizator){
        encontrarElemento(localizator).click();
    }
    public void SendKeysArica(By localizator){
        String Arica = "Arica";
        encontrarElemento(localizator).sendKeys(Arica);
    }
    public void SendKeysRio(By localizator){
        String Rio = "Rio de Janeiro";
        encontrarElemento(localizator).sendKeys(Rio);
    }
    public void SwitchTabs(){
        String mainTab= driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual: handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
            }
        }
    }
    public void CloseTabs(){
        changeTab(driver, 10);
    }
    public void MostrarFotos() throws InterruptedException {
        encontrarElemento(By.xpath("//button[text()='Ver galería']")).click();
        for (int i = 0; i < 4; i++) {
            encontrarElemento(By.cssSelector(".arrow-right")).click();
            Thread.sleep(1000);
        }
        encontrarElemento(By.cssSelector("Body")).sendKeys(Keys.ESCAPE);
    }
    public void MostrarMapa() throws InterruptedException{
        encontrarElemento(By.xpath("//em[text()='Ver en mapa']")).click();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        for (int i = 0; i < 2; i++) {
            WebElement ele = driver.findElement(By.xpath("//*[@aria-label='Map']/div[2]"));
            actions.doubleClick(ele).perform();
        }
        encontrarElemento(By.xpath("//*[contains(@class, 'modal-fullscreen-close')]")).click();
    }
    public void ValidacionATC2(){
        String Validacion = encontrarElemento(By.xpath("//span[text()='Amaru Express']")).getText();
        String Result = "Amaru Express";
        Assert.assertEquals(Validacion, Result);
    }
    public void ValidacionATC3(){
        String Validacion = encontrarElemento(By.cssSelector(".dm-title-container .eva-3-h3")).getText();
        String Result = "Royalty Barra Hotel";
        Assert.assertEquals(Validacion, Result);
    }
}