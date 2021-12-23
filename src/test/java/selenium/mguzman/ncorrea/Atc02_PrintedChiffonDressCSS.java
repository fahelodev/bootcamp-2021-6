package selenium.ncorrea;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Atc02_PrintedChiffonDressCSS {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("button.btn.btn-default.button-search")).click();
        String search = driver.findElement(By.cssSelector("ul.product_list.grid.row li:nth-of-type(1) a.product-name")).getText();
        Assert.assertEquals("Printed Chiffon Dress", search);
        Thread.sleep(2000);
        driver.close();
    }
}

