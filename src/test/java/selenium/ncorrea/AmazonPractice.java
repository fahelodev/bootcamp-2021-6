package selenium.ncorrea;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonPractice {

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void atc01_TarjetasDeRegalo() {

        //instanciamos la clase Actions
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("(//div[@class='glow-toaster-footer']//input[@class='a-button-input'])[1]")).click();

        //se elige el idioma a traves de un hover
        WebElement language = driver.findElement(By.xpath("(//span[@class='nav-line-2']/span[@class='nav-icon nav-arrow'])[1]"));
        action.moveToElement(language).perform();
        driver.findElement(By.xpath("//div[@class='nav-template nav-flyout-content nav-tpl-itemList']//span[contains(text(), 'Español')]")).click();

        //se busca mediante el menu la opcion de tarjetas de regalo
        driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
        driver.findElement(By.xpath("//div[@id='hmenu-content']//a/div[text()='Electrónicos']")).click();
        driver.findElement(By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']//a[text()='Accesorios y suministros']")).click();
        driver.findElement(By.xpath("//div[@id='nav-xshop']//a[text()='Tarjetas de Regalo']")).click();

        //se elige la opcion googleplay a traves de un hover
        WebElement brand = driver.findElement(By.xpath("//div[@id='nav-subnav']//span[contains(text(), 'marca')]"));
        action.moveToElement(brand).perform();
        driver.findElement(By.xpath("//div[text()='Google Play']")).click();

        //se obtiene la cantidad de resultados para hacer una comparacion
        String results = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span")).getText();
        String[] arr = results.split(" ");
        int number = Integer.parseInt(arr[0]);
        List<WebElement> productsFound = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none']//span[contains(text(),'Google Play')]"));

        //se valida el test
        Assert.assertEquals(number, productsFound.size());
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
            System.out.println("Close");
        }
    }
}
