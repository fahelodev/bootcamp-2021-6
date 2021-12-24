package selenium.iromero;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutomationFrank {
    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();

    }

    //se instancia el driver y se le entrega la url a testear
    @Before
    public void initial() {
        driver = new ChromeDriver();
        driver.get("http://automation.frankluzon.com/");
    }

    @Test
    public void atc01_AgregarReview() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"search-field\"]"))).sendKeys("CAP" + Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class=\"tabs wc-tabs\"]/li[@class=\"reviews_tab\"]/a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"comment-form-rating\"]/p/span/a[5]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class=\"comment-form-comment\"]//textarea"))).sendKeys("excelente producto y entrega");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class=\"comment-form-author\"]//input"))).sendKeys("Isaac Romero");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class=\"comment-form-email\"]//input"))).sendKeys("isaac.romero@tsoftlatam.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p/input[@id=\"submit\"]"))).click();
        String mensage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class=\"meta\"]/em"))).getText();
        Assert.assertEquals("Your review is awaiting approval", mensage);

        String rating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"comment-text\"]/div[@class=\"star-rating\"]"))).getText();
        String [] rate = rating.split(" ");
        Assert.assertEquals("5", rate[3].toString());
    }

    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}
