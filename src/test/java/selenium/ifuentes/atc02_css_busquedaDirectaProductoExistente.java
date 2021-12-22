package selenium.ifuentes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc02_css_busquedaDirectaProductoExistente {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        //Introducir"printed chiffon dress" en campo busqueda
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        //Hacer click en campo SEARCH
        driver.findElement(By.cssSelector("#searchbox > button")).click();
        //guardo objeto buscado nombre
        WebElement objetoBuscado = driver.findElement(By.cssSelector("button.btn:nth-child(5)"));
        // se espera "Printed Chiffon Dress"- (comprara objero buscado)
        Assert.assertEquals("Printed Chiffon Dress", objetoBuscado.getText());
    }




    //Thread.sleep(2000);
    //driver.close();

}


