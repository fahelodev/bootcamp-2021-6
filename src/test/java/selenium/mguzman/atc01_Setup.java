package selenium.mguzman;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class atc01_Setup {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");
                driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dress");
        driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
        List<WebElement> dressResults = driver.findElements(By.xpath("//ul[@class='product_list grid row']/descendant::a[@class='product-name']"));
        if(dressResults.size()>1){
            System.out.println("Prueba Exitosa");
            System.out.println("Se encontro: "+ dressResults.size()+ " articulos");
        }
        else{
            System.out.println("Prueba fallida");
        }
        //Cerrar el navegador
        Thread.sleep(2000);
        driver.close();
    }

    }