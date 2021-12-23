package selenium.ncorrea;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;


public class atc01_BusquedaPalabrasClavesXpath {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dress");
        driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
        List <WebElement> results = driver.findElements(By.xpath("//ul[@class='product_list grid row']/descendant::a[@class='product-name']"));
        if(results.size()>1){
            System.out.println("Prueba realizada");
        }
        else{
            System.out.println("Prueba fallida");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
