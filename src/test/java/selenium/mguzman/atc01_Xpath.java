package selenium.mguzman;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class atc01_Xpath {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");

        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("dress");

        driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();

        List <WebElement> result = driver.findElements(By.xpath("//ul[@class=\"product_list grid row\"]//a[@class=\"product-name\"]"));

        assert result.size()>=2 : "Test fallido";

        Thread.sleep(3000);
        driver.close();

    }
    


}
