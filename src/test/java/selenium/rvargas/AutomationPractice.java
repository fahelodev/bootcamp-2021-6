package selenium.rvargas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationPractice {

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
        //driver.get("http://automationpractice.com/");
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void atc01_BusquedaPalabrasClaves_XPATH(){
        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("dress");
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();

        List<WebElement> result = driver.findElements(By.xpath("//li[contains(@class, \"ajax_block_product\")]"));

        Assert.assertEquals("7", "" + result.size());

    }

    @Test
    public void atc01_BusquedaPalabrasClaves_CSS(){
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        List<WebElement> result = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));

        Assert.assertEquals("7", "" + result.size());

    }


    @Test
    public void atc02busquedaprintedchiffondress_XPATH(){
        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("printed chiffon dress");
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();

        List<WebElement> result = driver.findElements(By.xpath("//*[@id=\'center_column\']/ul/li"));

        String text = result.get(0).findElement(By.xpath("//a[contains(@class, 'product-name')]")).getText();

        Assert.assertEquals("Printed Chiffon Dress",text);
    }

    @Test
    public void atc02busquedaprintedchiffondress_CSS(){
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        List<WebElement> result = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));

        String text = result.get(0).findElement(By.cssSelector(".product-name")).getText();

        Assert.assertEquals("Printed Chiffon Dress",text);
    }

    @Test
    public void atc03_MensajeProductoNoEncontrado_XPATH(){

        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("liquido matapulgas");
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();

        String text = driver.findElement(By.xpath("//*[@id=\'center_column\']/p")).getText();

        //System.out.println("text");

        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", text);

    }

    @Test@Ignore
    public void atc04_EncontrarProductoDeListaDinamica_XPATH(){

        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("blo");

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(5));
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results")));


        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys(Keys.DOWN);
        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys(Keys.ENTER);


        Assert.assertEquals("Model demo_2",driver.findElement(By.cssSelector("#product_reference")).getText());
    }



    @After
    public void close(){
        if(driver != null){
            System.out.println("Close");
            //driver.close();
        }

    }

    @AfterClass
    public static void closeAll(){
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }

}