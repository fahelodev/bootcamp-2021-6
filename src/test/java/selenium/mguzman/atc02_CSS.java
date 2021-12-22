package selenium.mguzman;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class atc02_CSS {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("input.search_query")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("button.button-search")).click();
        String result = driver.findElement(By.cssSelector("ul.product_list.grid.row li:nth-of-type(1) a.product-name")).getText();
        Assert.assertEquals("Printed Chiffon Dress", result);

        Thread.sleep(3000);
        driver.close();
    }
}
