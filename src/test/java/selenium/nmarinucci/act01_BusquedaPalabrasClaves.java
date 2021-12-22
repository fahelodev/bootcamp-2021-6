package selenium.nmarinucci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class act01_BusquedaPalabrasClaves{

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        //xpath = "//tag[@atributo = 'valor']"
        //Seleccionar area de busqueda y escribir 'dress'
        //driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
        //Seleccionar boton search y clickear
        //driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        driver.findElement(By.cssSelector("[name='submit_search']")).click();
        //Validacion test correcto
        //List<WebElement> resultado = driver.findElements(By.xpath("//li[contains (@class, 'ajax_block_product')]"));
        List<WebElement> resultado = driver.findElements(By.cssSelector("ul.product_list.grid.row > li"));

        if((resultado).size()>1) System.out.println("Prueba Exitosa");
        else System.out.println("Prueba Fallida");
        Thread.sleep(4000);
        driver.close();
    }
}

