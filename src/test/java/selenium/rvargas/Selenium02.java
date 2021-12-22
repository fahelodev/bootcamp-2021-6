package selenium.rvargas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Selenium02 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //-CSS SELECTOR--------------------------------------------------------------------------------------

        //Cargar la pagina
        driver.get("http://automationpractice.com/");
        //buscar campo search
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("printed chiffon dress");
        //Hacer click
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        //Introducir dress en el campo de busqueda
        //List<WebElement> result = driver.findElements(By.cssSelector("a.product-name = printed chiffon dress"));

        driver.findElement(By.cssSelector("li.ajax_block_product:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h5:nth-child(1) > a:nth-child(1)")).getText();

    }
}
