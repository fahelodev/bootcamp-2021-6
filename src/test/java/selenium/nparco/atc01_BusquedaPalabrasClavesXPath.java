package selenium.nparco;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class atc01_BusquedaPalabrasClavesXPath {
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

        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("dress");
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();

        List<WebElement> results = driver.findElements(By.xpath("//li[contains(@class,'ajax_block_product')]"));

        System.out.println(((List<?>) results).size());
        if (results.size()>1){
            System.out.println("Prueba Exitosa");
        }else{
            System.out.println("Prueba Fallida");
        }


        //Thread.sleep(2000);
        //driver.close();

    }
}
