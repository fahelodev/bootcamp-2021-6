package selenium.ncorrea;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.*;

public class AutomationPractice {

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void atc01_BusquedaPalabrasClaveXpath() {
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dress");
        driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
        List<WebElement> results = driver.findElements(By.xpath("//ul[@class='product_list grid row']/descendant::a[@class='product-name']"));
        Assert.assertTrue(results.size() > 2);
    }

    @Test
    public void atc01_BusquedaPalabrasClaveCSS() {
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector("button.btn.btn-default.button-search")).click();
        List<WebElement> results = driver.findElements(By.cssSelector("ul.product_list.grid.row  a.product-name"));
        Assert.assertTrue(results.size() > 2);
    }

    @Test
    public void atc02_PrintedChiffonDressXpath() {
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("printed chiffon dress");
        driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
        String search = driver.findElement(By.xpath("(//ul[@class='product_list grid row']//a[@class='product-name'])[1]")).getText();
        Assert.assertEquals("Printed Chiffon Dress", search);
    }

    @Test
    public void atc02_PrintedChiffonDressCss() {
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("button.btn.btn-default.button-search")).click();
        String search = driver.findElement(By.cssSelector("ul.product_list.grid.row li:nth-of-type(1) a.product-name")).getText();
        Assert.assertEquals("Printed Chiffon Dress", search);
    }

    @Test
    public void aatc03_MensajeProductoNoEncontrado() {
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("liquido matapulgas" + ENTER);
        String notFound = driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText();
        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", notFound);
    }

    @Test
    public void atc04_EncontrarProductoDeListaDinamica() {
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("blo");
        driver.findElement(By.xpath("//li[@class='ac_even']")).click();
        String search = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
        Assert.assertEquals("Blouse", search);
    }

    @Test
    public void atc05_AgregarProductoCambiandoTallaYColor() {
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("blo");
        driver.findElement(By.xpath("//li[@class='ac_even']")).click();
        WebElement options = driver.findElement(By.xpath("//select[@id='group_1']"));
        Select sel = new Select(options);
        sel.selectByIndex(2);
        driver.findElement(By.xpath("//a[@id='color_8']")).click();
        driver.findElement(By.xpath("//button[@class='exclusive']")).click();
        String price = driver.findElement(By.xpath("//div[@class=\"layer_cart_row\"]/span[contains(text(),\"$29.00\")]")).getText();
        Assert.assertEquals("$29.00", price);
    }

        @After
        public void close(){
            if(driver != null){
                driver.close();
                System.out.println("Close");
            }
        }
    }
