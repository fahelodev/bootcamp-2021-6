package selenium.rsobarzo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");

    }

    @Test
    public void atc01_BusquedaPalabrasClavesCSS(){
        driver.get("http://automationpractice.com/");

        String palabraClave = ("Dress");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(palabraClave);
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        List<WebElement> resultados = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));
        String texto = resultados.get(0).findElement(By.cssSelector(".product-name")).getText();
        Assert.assertEquals(texto, palabraClave);
    }

    @Test
    public void atc02_busquedaDirectaProductoExistente(){
        //Cargar la página
        driver.get("http://automationpractice.com/");

        String busqueda = ("Printed Chiffon Dress");

        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys(busqueda);
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();

        List<WebElement> resultados = driver.findElements(By.xpath("//*[@id=\'center_column\']/ul/li"));
        String texto = resultados.get(0).findElement(By.xpath("//a[contains(@class, 'product-name')]")).getText();
        Assert.assertEquals(texto, busqueda);

    }

    @Test
    public void atc03_MensajeProductoNoEncontrado(){
        driver.get("http://automationpractice.com/");

        String productoBusqueda = "liquido matapulgas";
        String textoEsperado = "No results were found for your search \"liquido matapulgas\"";

        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(productoBusqueda);
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.ENTER);
        String mensaje = driver.findElement(By.cssSelector("#center_column > p")).getText();
        Assert.assertEquals( textoEsperado ,mensaje);

    }

    @Test
    public void atcPrimerResultadoCss(){
        driver.get("http://automationpractice.com/");

        String busquedaPrimerResultado = ("Printed Chiffon Dress");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(busquedaPrimerResultado);
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        List<WebElement> resultados = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));
        String texto = resultados.get(0).findElement(By.cssSelector(".product-name")).getText();
        Assert.assertEquals(texto, busquedaPrimerResultado);
    }

    @Test
    public void atc04_EncontrarProductoDeListaDinamica(){
        driver.get("http://automationpractice.com/");

        String productoBusqueda = "blo";
        String productoEsperado= "Model demo_2";

        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(productoBusqueda);

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(5));
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results")));
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.DOWN);
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.ENTER);
        Assert.assertEquals(productoEsperado,driver.findElement(By.cssSelector("#product_reference")).getText());
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