package selenium.fmarfull;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Amazon {

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
        driver.get("https://www.amazon.com/-/es/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @Test
    @Ignore
    public void atc00CargarPaginaPrincipal(){
        System.out.println("Test Case 0");

        String titleExpected = "Amazon.com. Gasta menos. Sonríe más.";
        // En algunos casos puede ser "Amazon.com. Spend less. Smile more."

        driver.get("https://www.amazon.com/-/es/");
        Assert.assertEquals(titleExpected, driver.getTitle());
    }

    @Test @Ignore
    public void atc00CargarPaginaPrincipal2(){
        System.out.println("Test Case 0");
        driver.get("http://google.com/");
        Assert.assertNotEquals("My Store",driver.getTitle());
    }

    @Test
    public void FiltroMarcaTarjetasdeRegalo() {
        System.out.println("Test case 1 - Filtro Marca Tarjetas de Regalo");

        List<WebElement> results;
        Integer amountFoundItems, amountFilteredItems;
        WebDriverWait delay = new WebDriverWait(driver,8);

        // Buscamos las tarjetas de regalo en el menú.

        // Vamos al botón hamburgesa con todos las secciones.
        driver.findElement(By.id("nav-hamburger-menu")).click();

        // Vamos a la sección de electrónicos.
        driver.findElement(By.xpath("//*[@id='hmenu-content']//a[contains (@data-menu-id, '5')]")).click();

        // Se hace una espera hasta que cargue.
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Accesorios y suministros")));

        // Sección al link buscado.
        driver.findElement(By.linkText("Accesorios y suministros")).click();

        // Sección de las tarjetas de regalo.
        driver.findElement(By.xpath("//a[contains(text(), 'Tarjetas de Regalo')]")).click();

        // Pasar el mouse sobre el menú desplegable.
        Actions action = new Actions(driver);
        WebElement btn = driver.findElement(By.xpath("//*[@id='nav-subnav']//span[contains(text(), 'Por marca')]"));
        action.moveToElement(btn).perform();

        // Esperar al menú desplegable.
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='navbar']")));

        // Click en Google Play
        driver.findElement(By.xpath("//*[@id='navbar']//*[contains(@alt, 'Google Play')]")).click();

        // Resultados con un texto para la descripción.
        results = driver.findElements(By.xpath("//*[@id='search']//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        amountFoundItems = results.size();

        // Resultados con Google Play en la descripción.
        results = driver.findElements(By.xpath("//*[@id='search']//h2//span[contains(text(),'Google')]"));
        amountFilteredItems = results.size();

        Assert.assertEquals(amountFoundItems, amountFilteredItems);
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