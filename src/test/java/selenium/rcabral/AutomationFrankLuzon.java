package desafio.equipo2.selenium.rcabral;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.ZonedDateTime;



public class AutomationFrankLuzon {

    private WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void atc01_AgregarReview_xPath_Css() throws InterruptedException {
        driver.get("http://automation.frankluzon.com/");
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(4));
        //ingreamos 'CAP' en el search box.
        driver.findElement(By.xpath("//*[@id=\"woocommerce-product-search-field-0\"]")).sendKeys("CAP");

        //presionamos Enter en el search box.
        driver.findElement(By.xpath("//*[@id=\"woocommerce-product-search-field-0\"]")).sendKeys(Keys.ENTER);

        //Hacemos click en la opcion de reviews
        driver.findElement(By.xpath("//*[@id=\"tab-title-reviews\"]/a")).click();

        //hacemos click en la quinta estrella
        driver.findElement(By.xpath("//*[@id=\"commentform\"]/div/p/span/a[5]")).click();

        String mensaje_esperado = ZonedDateTime.now().toString();
        //Ingresamos un comentario en el review
        driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys(mensaje_esperado);

        //ingresamos el nombre del autor
        driver.findElement(By.xpath("//*[@id=\"author\"]")).sendKeys("David");

        //ingresamos un correo valido
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("david123@gmail.com");

        //hacemos click en submit
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        //realizamos una espera de 4 segundos hasta que aparezca el elemento donde se encuentra el comentario que hicimos.
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.description")));

        String mensaje_obtenido = driver.findElement(By.cssSelector("div.description")).getText();

        Assert.assertEquals(mensaje_esperado, mensaje_obtenido);
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }

    @AfterClass
    public static void closeAll(){
    }
}