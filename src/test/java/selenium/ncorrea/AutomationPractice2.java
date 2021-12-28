package selenium.ncorrea;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class AutomationPractice2 {

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.frankluzon.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void atc01_AgregarReview() {
        driver.findElement(By.xpath("//input[@id='woocommerce-product-search-field-0']")).sendKeys("CAP" + Keys.ENTER);
        driver.findElement(By.xpath("//li[@id='tab-title-reviews']/a[contains(text(), 'Reviews')]")).click();
        driver.findElement(By.xpath("//div[@class='comment-form-rating']//a[@class='star-4']")).click();
        driver.findElement(By.xpath("//p[@class='comment-form-comment']//textarea[@id='comment']")).sendKeys("Encontré lo que necesitaba :D");
        driver.findElement(By.xpath("//input[@id='author']")).sendKeys("Nicolás Correa");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nicolas.correa@tsoftlatam.com");
        driver.findElement(By.xpath("//input[@id='submit']")).click();
        String reviews = driver.findElement(By.xpath("//p[@class='meta']/em[contains(text(), 'Your review is awaiting approval')]\t\t")).getText();
        Assert.assertEquals("Your review is awaiting approval", reviews);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
            System.out.println("Close");
        }
    }
}
