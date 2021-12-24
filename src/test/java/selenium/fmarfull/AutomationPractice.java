package selenium.fmarfull;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test @Ignore
    public void atc00CargarPaginaPrincipal(){
        System.out.println("Test Case 0");
        driver.get("http://automationpractice.com");
        Assert.assertEquals("My Store",driver.getTitle());
    }

    @Test @Ignore
    public void atc00CargarPaginaPrincipal2(){
        System.out.println("Test Case 0");
        driver.get("http://google.com/");
        Assert.assertNotEquals("My Store",driver.getTitle());
    }

    @Test
    public void atc01_BusquedaPalabrasClavesCSS() {
        System.out.println("Test Case 1\n" + "BusquedaPalabrasClavesCSS");

        int elemsAmount;
        String strToSearch = "dress";

        driver.findElement(By.cssSelector("input[id='search_query_top']")).sendKeys(strToSearch);
        driver.findElement(By.cssSelector("button[name='submit_search']")).click();
        elemsAmount = driver.findElements(By.cssSelector("ul.product_list>li")).size();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        Assert.assertNotEquals(0, elemsAmount);
        Assert.assertNotEquals(1, elemsAmount);
    }

    @Test
    public void atc01_BusquedaPalabrasClavesXPath() {
        System.out.println("Test Case 1\n" + "BusquedaPalabrasClavesXPath");

        int elementsAmount;
        String strToSearch = "dress";

        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(strToSearch);
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();
        elementsAmount = driver.findElements(By.xpath("//li[contains (@class, 'ajax_block_product')]")).size();

        Assert.assertNotEquals(0, elementsAmount);
        Assert.assertNotEquals(1, elementsAmount);
    }

    @Test
    public void atc02_busquedaDirectaProductoExistenteCSS() {
        System.out.println("Test Case 2\n" + "atc02_busquedaDirectaProductoExistenteCSS");

        String strToSearch = "printed chiffon dress";
        String strExpected = "Printed Chiffon Dress";
        String strReceived;

        // Ingreso de palabras en la barra de búsqueda.
        driver.findElement(By.cssSelector("input[id='search_query_top']")).sendKeys(strToSearch);

        // Se inicia la búsqueda de los elementos.
        driver.findElement(By.cssSelector("button[name='submit_search']")).click();

        // Primer elemento de la lista encontrada.
        strReceived = driver.findElement(By.cssSelector("ul.product_list>li:first-child")).getText();

        // Se corrobora que exista.
        if (strReceived.contains(strExpected)) strReceived = strExpected;

        Assert.assertEquals(strExpected, strReceived);
    }

    @Test
    public void atc02_busquedaDirectaProductoExistenteXPath() {
        System.out.println("Test Case 1\n" + "BusquedaPalabrasClavesXPath");

        String strToSearch = "printed chiffon dress";
        String strExpected = "Printed Chiffon Dress";
        String strReceived;

        // Ingreso de palabras en la barra de búsqueda.
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(strToSearch);

        // Se inicia la búsqueda de los elementos.
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();

        // Primer elemento de la lista encontrada.
        strReceived = driver.findElement(By.xpath("//a[contains (@class, 'product-name')]")).getText();

        // Se corrobora que exista el término buscado en lo encontrado.
        if (strReceived.contains(strExpected)) strReceived = strExpected;

        Assert.assertEquals(strExpected, strReceived);
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