package selenium.mguzman;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc02_SetupCSS {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("button.btn.btn-default.button-search")).click();
        String busqueda = driver.findElement(By.cssSelector("ul.product_list.grid.row li:nth-of-type(1) a.product-name")).getText();
        Assert.assertEquals("printed chiffon dress", busqueda.toLowerCase());

        Thread.sleep(2000);
        driver.close();
    }
}
