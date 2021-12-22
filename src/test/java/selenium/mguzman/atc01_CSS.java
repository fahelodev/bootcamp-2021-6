package selenium.mguzman;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;

public class atc01_CSS {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");


        driver.findElement(By.cssSelector("input.search_query")).sendKeys("dress");

        driver.findElement(By.cssSelector("button.button-search")).click();

        List<WebElement> result = driver.findElements(By.cssSelector("ul.product_list.grid.row  a.product-name"));

        assert (result.size()>=2):"Test fallido";

        Thread.sleep(2000);
        driver.close();

    }

}
