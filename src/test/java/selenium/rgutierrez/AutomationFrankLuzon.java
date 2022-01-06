package selenium.rgutierrez;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AutomationFrankLuzon {

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
        // Definimos un implicit wait de 5 segundos
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void atc01_agregarReview(){
        System.out.println("Test Case atc01_atc01_agregarReview");

        driver.get("http://automation.frankluzon.com/");
        driver.manage().deleteAllCookies();

        // Buscamos por la palabra CAP y seleccionamos 5 estrellas en la sección de review
        driver.findElement(By.cssSelector("#woocommerce-product-search-field-0")).sendKeys("CAP" + Keys.ENTER);
        driver.findElement(By.cssSelector(".reviews_tab")).click();
        driver.findElement(By.cssSelector("form.comment-form a.star-5")).click();

        // ingresamos un texto de review, un nombre y un mail
        driver.findElement(By.xpath("//*[@id=\'comment\']")).sendKeys("For years I have searched for the perfect CAP");
        driver.findElement(By.xpath("//*[@id=\'author\']")).sendKeys("Rodrigo");
        driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("rodrigo.prueba@gmail.com");

        // click en el botón de submit
        driver.findElement(By.xpath("//*[@id=\'submit\']")).click();

        // explicit wait esperando el mensaje de la solicitud
        WebDriverWait expWait = new WebDriverWait(driver, 10);
        expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-review__awaiting-approval")));

        // validamos que el texto corresponda a "Your review is awaiting approval"
        String texto = driver.findElement(By.cssSelector(".woocommerce-review__awaiting-approval")).getText();

        Assert.assertEquals( "Your review is awaiting approval", texto);
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
