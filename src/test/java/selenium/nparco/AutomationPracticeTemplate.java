package selenium.nparco;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class AutomationPracticeTemplate {

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @Test
    public void atc01BusquedaPalabraClave() {
        System.out.println("Test Case 1");
        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector(".btn.button-search")).click();
        List<WebElement> results = driver.findElements(By.cssSelector("ul.product_list.grid.row > li"));
        Assert.assertEquals(7, results.size());
    }

    @Test
    public void atc02BusquedaProductoExistente() {
        System.out.println("Test Case 2");
        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector(".btn.button-search")).click();
        List<WebElement> results = driver.findElements(By.cssSelector("ul.product_list.grid.row > li"));
        String text = results.get(0).findElement(By.cssSelector(".product-name")).getText();
        Assert.assertEquals("printed chiffon dress", text.toLowerCase());
    }

    @Test
    public void atc03_MensajeProductoNoEncontrado() {
        System.out.println("Test Case 3");
        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("liquido matapulgas");
        driver.findElement(By.cssSelector(".btn.button-search")).click();
        String text = driver.findElement(By.cssSelector(".alert.alert-warning")).getText();
        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", text);
    }

    @Test
    public void atc04_EncontrarProductoDeListaDinamica() throws InterruptedException {
        System.out.println("Test Case 4");
        WebDriverWait d = new WebDriverWait(driver,2);
        driver.get("http://automationpractice.com/");
        WebElement search = driver.findElement(By.cssSelector("#search_query_top"));
        search.sendKeys("blo");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ac_results")));
        search.sendKeys(Keys.ARROW_DOWN);
        search.sendKeys(Keys.TAB);
        String text = driver.findElement(By.cssSelector(".pb-center-column > h1:nth-child(1)")).getText();
        Assert.assertEquals("Blouse", text);
    }

    @After
    public void close() {
        if (driver != null) {
            System.out.println("Close");
            driver.close();
        }

    }

    @AfterClass
    public static void closeAll() {
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }
}
