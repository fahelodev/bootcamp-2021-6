package selenium.nmarinucci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class act02_BusquedaDirectaProductoExistente {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");

        //driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys( "printed chiffon dress");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys( "printed chiffon dress");

        //driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        //List<WebElement> resultado = driver.findElements(By.xpath("//li[contains (@class, 'ajax_block_product')]"));
        List<WebElement> resultado = driver.findElements(By.cssSelector("ul.product_list.grid.row > li"));

        if(((List<?>) resultado).size()>1) System.out.println("Prueba Exitosa");
        else System.out.println("Prueba Fallida");
        Thread.sleep(4000);
        driver.close();
    }
}
