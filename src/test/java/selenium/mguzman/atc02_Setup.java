package selenium.mguzman;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc02_Setup {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");
                driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("printed chiffon dress");
        driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
        String busqueda = driver.findElement(By.xpath("(//ul[@class='product_list grid row']//a[@class='product-name'])[1]")).getText();
        Assert.assertEquals("printed chiffon dress", busqueda.toLowerCase());
    }

}
