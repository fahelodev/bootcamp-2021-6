package selenium.ifuentes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;


public class atc01_AgregarReview {

    private WebDriver driver;
    @BeforeClass
    public static void setup(){
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test @Ignore
    public void atc01_AgregarReview() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.findElement(By.cssSelector("#woocommerce-product-search-field-0")).sendKeys("CAP");
        driver.findElement(By.cssSelector("#woocommerce-product-search-field-0")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tab-title-reviews > a"))).click();
        driver.findElement(By.cssSelector("#commentform > div > p > span > a.star-5")).click();
        driver.findElement(By.xpath("//*[@id='comment']")).sendKeys("muy lindo colo, calida y textura!!!");
        driver.findElement(By.cssSelector("#author")).sendKeys("Franco Javier");
        driver.findElement(By.cssSelector("#email")).sendKeys("chuck_ledbetter@hotmail.com");
        driver.findElement(By.cssSelector("#submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("em.woocommerce-review__awaiting-approval")));
        assertEquals("Your review is awaiting approval", driver.findElement(By.cssSelector("em.woocommerce-review__awaiting-approval")).getText());
    }

    @After
    public void close(){
        if(driver != null){
            System.out.println("Close");
            driver.close();
        }

    }

    @AfterClass
    public static void closeAll(){
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }

}
