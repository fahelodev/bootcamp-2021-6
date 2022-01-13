package selenium.fluzon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class atc01_BusquedaPalabrasClaves {

    public static void main(String[] args) throws InterruptedException
    {

        //Inicialización del WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        //Introducir "chiffon dress" en el campo de busqueda
//        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dress");
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("dress");

        //Hacer clic en Search Button
//        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        driver.findElement(By.cssSelector("button[name='submit_search']")).sendKeys("dress");
        Thread.sleep(2000);
        //Introducir "chiffon dress" en el campo de busqueda
//        List<WebElement> results = driver.findElements(By.xpath("//li[contains (@class, \"ajax_block_product\")]"));
        List<WebElement> results = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));
        Thread.sleep(2000);
        System.out.println(results.size());
        if (results.size()>1)
        {
            System.out.println("Prueba Exitosa - Mas de 1 elemento");
        }
        else
        {
            System.out.println("Prueba Fallida - Menos de 1 elemeno");
        }
        driver.close();

    }
}
