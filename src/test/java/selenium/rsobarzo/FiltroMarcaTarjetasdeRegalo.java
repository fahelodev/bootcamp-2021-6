package selenium.rsobarzo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class FiltroMarcaTarjetasdeRegalo {

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
        driver.manage().window().maximize();
        //driver.get("http://automationpractice.com/");

    }

    @Test
    /*Pasos:
1.- Seleccionar categoria: Electrónicos, Accesorios y Suministros
2.- Seleccionar Tarjetas de Regalo
3.- Seleccionar Marca Google Play
4. Validar que todos los productos visibles sean de Google Play*/
    public void filtroMarcaTarjetasdeRegalo(){
        driver.get("https://www.amazon.com/-/es/");
        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]/span")).click();

        WebDriverWait espera = new WebDriverWait(driver, 5);
        espera.until(visibilityOfElementLocated(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[7]/a"))).click();

        espera.until(visibilityOfElementLocated(By.xpath("//*[@id=\"hmenu-content\"]/ul[5]/li[3]/a"))).click();

       // //*[@id="nav-xshop"]/a[4]
        espera.until(visibilityOfElementLocated(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"))).click();

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
