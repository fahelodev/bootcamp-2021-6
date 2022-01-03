package desafio.equipo2.selenium.fmarfull;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
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
        System.out.println("Test Case 2\n" + "atc02_busquedaDirectaProductoExistenteXPath");

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

    @Test
    public void atc03_MensajeProductoNoEncontradoXPath() {
        System.out.println("Test Case 3\n" + "MensajeProductoNoEncontradoXPath");

        String strToSearch = "liquido matapulgas";
        String boilerplate = "No results were found for your search ";
        String strExpected = boilerplate + '"' + strToSearch + '"';
        String strReceived;

        // Búsqueda del término.
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(strToSearch);

        // Click al botón buscar.
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();

        // Revisar si se encuentran productos.
        strReceived = driver.findElement(By.xpath("//p[contains(@class, 'alert alert-warning')]")).getText();

        Assert.assertEquals(strExpected, strReceived);
    }

    @Test
    public void atc04_EncontrarProductoDeListaDinamicaXPath() {
        System.out.println("Test Case 4\n" + "EncontrarProductoDeListaDinamica");

        String strToSearch = "blo";
        String strExpected = "Model demo_2";
        String strReceived;

        // Búsqueda del término.
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(strToSearch);

        // Se hace una espera hasta ver la lista de resultados.
        WebDriverWait delay = new WebDriverWait(driver,5);
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac_results']")));

        // Click al botón buscar.
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(Keys.TAB);

        // Revisar si se encuentran productos.
        strReceived = driver.findElement(By.xpath("//p[@id='product_reference']")).getText();

        Assert.assertEquals(strExpected, strReceived);
    }

    @Test
    public void atc05_AgregarProductoCambiandoTallaYColor() {
        System.out.println("Test Case 5\n" + "AgregarProductoCambiandoTallaYColor");

        String strToSearch = "blo";
        String strExpected = "Product successfully added to your shopping cart";
        String strReceived;

        // Búsqueda del término.
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(strToSearch);

        // Se hace una espera hasta ver la lista de resultados.
        WebDriverWait delay = new WebDriverWait(driver,8);
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac_results']")));

        // Click al botón buscar.
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(Keys.TAB);

        // Cambiar la talla que tiene por defecto.
        Select s =new Select(driver.findElement(By.id("group_1")));
        s.selectByVisibleText("M");

        // Cambio del color por defecto.
        driver.findElement(By.id("color_8")).click();

        // Añadir al carrito
        driver.findElement(By.xpath("//p[@id='add_to_cart']/button")).click();

        // Esperar que se abra el _modal_ y leer el mensaje de confirmación.
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
        strReceived = driver.findElement(By.xpath("//*[@id='layer_cart']//h2")).getText();

        Assert.assertEquals(strReceived, strExpected);
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