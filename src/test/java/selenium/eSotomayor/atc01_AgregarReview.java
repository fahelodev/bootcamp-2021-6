package desafio.equipo2.selenium.eSotomayor;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class atc01_AgregarReview {

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
        driver.get("http://automation.frankluzon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void agregarReview() throws InterruptedException {
    //Buscar CAP
        driver.findElement(By.xpath("//*[@id=\"woocommerce-product-search-field-0\"]")).sendKeys("CAP" + Keys.ENTER);

        //Click en las reviews
        driver.findElement(By.xpath("//*[@id=\"tab-title-reviews\"]")).click();
        //Seleccionar las estrellas
        driver.findElement(By.xpath("//*[@id=\"commentform\"]/div/p/span/a[4]")).click();
        //Escribir la review
        driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys("Your Review");
        //Escribir el nombre
        driver.findElement(By.xpath("//*[@id=\"author\"]")).sendKeys("Emiliano");
        //Escribir el Email
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("emi.vega84@gmail.com");
        //Click en Submit
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(3500);

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
