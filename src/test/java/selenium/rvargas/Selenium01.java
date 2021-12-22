package selenium.rvargas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Selenium01 {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Inicialización del WebDriver con Firefox
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

        //-XPATH--------------------------------------------------------------------------------------

        /*
        //Cargar la página
        driver.get("http://automationpractice.com/");

        // introducir la palabra "dress"
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dress");

        //Hacer click
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();

        //Introducir dress en el campo de busqueda
        List<WebElement> result = driver.findElements(By.xpath("//li[contains (@class, \"ajax_block_product\")]"));

        System.out.println(result.size());
        if (result.size()>1) System.out.println("prueba exitosa");
        else System.out.println("prueba fallida");
        driver.close();
        */

        //-CSS SELECTOR--------------------------------------------------------------------------------------


        //Cargar la pagina
        driver.get("http://automationpractice.com/");

        //introducir la palabra "dress"
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("dress");

        //Hacer click
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        //Introducir dress en el campo de busqueda
        List<WebElement> result = driver.findElements(By.cssSelector("ul.product_list.grid.row > li"));

        System.out.println(result.size());
        if (result.size()>1) System.out.println("prueba exitosa");
        else System.out.println("prueba fallida");
        driver.close();

        //Actividad N1
    }
}

