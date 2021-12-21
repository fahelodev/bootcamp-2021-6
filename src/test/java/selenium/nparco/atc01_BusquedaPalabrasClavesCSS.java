package selenium.nparco;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class atc01_BusquedaPalabrasClavesCSS {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Inicialización del WebDriver con Firefox
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector(".btn.button-search")).click();

        List<WebElement> results = driver.findElements(By.cssSelector("ul.product_list.grid.row > li"));

        System.out.println(results.size());
        if (results.size()>1){
            System.out.println("Prueba Exitosa");
        }else{
            System.out.println("Prueba Fallida");
        }


        //Thread.sleep(2000);
        //driver.close();

    }
}
