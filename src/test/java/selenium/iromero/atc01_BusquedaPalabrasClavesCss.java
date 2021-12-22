package selenium.iromero;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class atc01_BusquedaPalabrasClavesCss {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");


        driver.findElement(By.cssSelector("input.search_query")).sendKeys("dress");

        driver.findElement(By.cssSelector("button.button-search")).click();

        List<WebElement> result = driver.findElements(By.cssSelector("ul.product_list.grid.row  a.product-name"));

        assert (result.size()>=2):"Error test";

        Thread.sleep(2000);
        driver.close();

    }
}
