package selenium.mguzman;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageBabytuto {

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        System.out.println("instanciar");
        driver = new ChromeDriver();
        //Page practice
        driver.get("https://www.babytuto.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    @Test
    public void atc_extra(){

        driver.findElement(By.xpath("//button[@class=\"close\"]")).click();
        driver.findElement(By.xpath("//div//ul//a[@href=\"javascript:;\"]")).click();
        driver.findElement( By.xpath("//ul//a[@href=\"/categoria/accesorios-para-coches\"]")).click();

        driver.findElement(By.xpath("//div/div[5]/ul/li[5]//a//span")).click();

        String bbpro = driver.findElement(By.xpath("(//div//a[@itemprop=\"brand\"])[19]")).getText();
        String n = driver.findElement(By.xpath("(//div//a[@itemprop=\"brand\"])[19]")).getText();
        
        Assert.assertEquals("BBPRO",bbpro);
    }

}
