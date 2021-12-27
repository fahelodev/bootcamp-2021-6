package selenium.fmercado;

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

public class AutomaticPractice2 {
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
            // Cargar la página y validar.
        driver.get("http://automation.frankluzon.com/");

            // Localizar el cuadro de busqueda e introducir "CAP" en el campo de busqueda y damos enter
        driver.findElement(By.xpath("//*[@id=\'woocommerce-product-search-field-0\']")).sendKeys("CAP" + Keys.ENTER);

            // Localizamos el href de reviews y clickeamos
        driver.findElement(By.linkText("Reviews (0)")).click();

            // Clickeamos en las estrellas para podes subri el comentario
        driver.findElement(By.cssSelector("form.comment-form a.star-5")).click();

            // Ingresamos nombre, email y comentario en su respectivos cuadros
        driver.findElement(By.xpath("//*[@id=\'comment\']")).sendKeys("El producto esta genial!!");
        driver.findElement(By.xpath("//*[@id=\'author\']")).sendKeys("Facu");
        driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("mercadofacundo21@gmail.com");

            // Click en el botón de submit
        driver.findElement(By.xpath("//*[@id=\'submit\']")).click();

        // explicit wait Esperamos el mensaje de aprobado
        WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-review__awaiting-approval")));

        // validamos el texto
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
