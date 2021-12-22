package selenium.fFabricio;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BusquedaDress {


    public static void main(String[] args) throws InterruptedException {
        int lista;
        WebDriver driver;


        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        //Cargar la página
        driver.get("http://automationpractice.com/");

        //Introducir dress en la busqueda
        //driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("dress");
        driver.findElement(By.cssSelector("input[id='search_query_top']")).sendKeys("dress");


        //click
        //driver.findElement(By.cssSelector("button[name='submit_search']")).sendKeys("dress");
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();


        lista = driver.findElements(By.xpath("//li[contains (@class, 'ajax_block_product')]")).size();

        if (lista > 1) {
            System.out.println("Más de un producto '"

                    + "(" + lista + " en total)");
        } else {
            System.out.println("Menos de un productos encontrados.");
        }

        Thread.sleep(2000);
        driver.close();


    }
}
