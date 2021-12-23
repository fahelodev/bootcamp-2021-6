package selenium.rgutierrez;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    }

    @Test
    public void atc01_busquedaPalabrasClavesCSS(){
        System.out.println("Test Case atc01_busquedaPalabrasClavesCSS");

        driver.get("http://automationpractice.com/");

        // Definimos un implicit wait de 4 segundos
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        // Buscamos por la palabra dress
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        // Guardamos todos los resultados li encontrados correspondientes a productos
        List<WebElement> resultados = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));

        // Obtenemos la cantidad de resultados
        int numResultados = resultados.size();

        // Se espera que el numero de resultados sea 2 o más
        Assert.assertTrue( numResultados > 1);
    }

    @Test
    public void atc01_busquedaPalabrasClavesXpath(){
        System.out.println("Test Case atc01_busquedaPalabrasClavesXpath");

        driver.get("http://automationpractice.com/");

        // Definimos un implicit wait de 4 segundos
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        // Buscamos por la palabra dress
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("dress");
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();


        // Guardamos todos los resultados li encontrados correspondientes a productos
        List<WebElement> resultados = driver.findElements(By.xpath("//*[@id=\'center_column\']/ul/li"));

        // Obtenemos la cantidad de resultados
        int numResultados = resultados.size();

        // Se espera que el numero de resultados sea 2 o más
        Assert.assertTrue( numResultados > 1);
    }

    @Test
    public void atc02_busquedaDirectaProductoExistenteCSS(){
        System.out.println("Test Case atc02_busquedaDirectaProductoExistenteCSS");

        driver.get("http://automationpractice.com/");

        // Definimos un implicit wait de 4 segundos
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        // Buscamos por la palabra printed chiffon dress
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        // Guardamos todos los resultados li encontrados correspondientes a productos
        List<WebElement> resultados = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));

        // Obtenemos el texto correspondiente al nombre del primer producto
        String texto = resultados.get(0).findElement(By.cssSelector(".product-name")).getText();

        // Se espera que el nombre del primer producto sea igual a "Printed Chiffon Dress"
        Assert.assertEquals("Printed Chiffon Dress", texto);
    }

    @Test
    public void atc02_busquedaDirectaProductoExistenteXpath(){
        System.out.println("Test Case atc02_busquedaDirectaProductoExistenteCSS");

        driver.get("http://automationpractice.com/");

        // Definimos un implicit wait de 4 segundos
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        // Buscamos por la palabra printed chiffon dress
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("printed chiffon dress");
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();

        // Guardamos todos los resultados li encontrados correspondientes a productos
        List<WebElement> resultados = driver.findElements(By.xpath("//*[@id=\'center_column\']/ul/li"));

        // Obtenemos el texto correspondiente al nombre del primer producto
        String texto = resultados.get(0).findElement(By.xpath("//a[contains(@class, 'product-name')]")).getText();

        // Se espera que el nombre del primer producto sea igual a "Printed Chiffon Dress"
        Assert.assertEquals("Printed Chiffon Dress", texto);
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
