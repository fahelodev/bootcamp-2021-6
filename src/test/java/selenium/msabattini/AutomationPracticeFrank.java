package desafio.equipo2.selenium.msabattini;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPracticeFrank {
    private WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.get("http://automation.frankluzon.com/");
    }

    @Test
    public void atc01_AgregarReview() throws InterruptedException{

        String review = "a very good productd";
        WebDriverWait espera_ = new WebDriverWait(driver, Duration.ofSeconds(4));

        //Ingresar producto a buscar y dar enter
        driver.findElement(By.xpath("//*[@id=\"woocommerce-product-search-field-0\"]")).sendKeys("CAP");
        driver.findElement(By.xpath("//*[@id=\"woocommerce-product-search-field-0\"]")).sendKeys(Keys.ENTER);

        //ingresar a Reviews y completar campos
        driver.findElement(By.xpath("//*[@id=\"tab-title-reviews\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"commentform\"]/div/p/span/a[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys(review);
        driver.findElement(By.xpath("//*[@id=\"author\"]")).sendKeys("Nahuel");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("nahuelsabattini@gmail.com");

        //Click en submit
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        //Esperamos a que aparezca el campo de reviews
        espera_.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.description")));

        //Guardamos el texto de nuestro comentario
        String texto_verificacion = driver.findElement(By.cssSelector("div.description")).getText();

        Assert.assertEquals(review, texto_verificacion);

    }

    @After
    public void close(){
        if(driver != null){
            System.out.println("Close");
            driver.close();
        }

    }


}
