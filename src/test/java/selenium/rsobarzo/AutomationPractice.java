package selenium.rsobarzo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.ZonedDateTime;
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

        WebDriverWait espera = new WebDriverWait(driver, 5);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results")));
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.DOWN);
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.ENTER);
        Assert.assertEquals(productoEsperado,driver.findElement(By.cssSelector("#product_reference")).getText());
    }


    @Test
    public void atc05_AgregarProductoCambiandoTallaYColor(){
        driver.get("http://automationpractice.com/");

        String busquedaPrimerResultado = ("blo");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(busquedaPrimerResultado);
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        List<WebElement> resultados = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));
        String texto = resultados.get(0).findElement(By.cssSelector(".product-name")).getText();
        System.out.println(texto);
        driver.findElement(By.xpath("//*[@id=\"color_7\"]")).click();
        System.out.println("paso x cambio de color");
        WebDriverWait espera = new WebDriverWait(driver, 5);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();

        System.out.println("add to cart");
       // Assert.assertEquals(texto, busquedaPrimerResultado);
    }

    @Test
    public void atc01_AgregarReview() throws InterruptedException {
        driver.get("http://automation.frankluzon.com/");
        WebDriverWait espera = new WebDriverWait(driver, 5);
        //ingreamos 'CAP' en el search box.

        String cajaBusqueda = "CAP";

        driver.findElement(By.xpath("//*[@id=\"woocommerce-product-search-field-0\"]")).sendKeys(cajaBusqueda);

        // enter en el search box.
        driver.findElement(By.xpath("//*[@id=\"woocommerce-product-search-field-0\"]")).sendKeys(Keys.ENTER);

        // click reviews
        driver.findElement(By.xpath("//*[@id=\"tab-title-reviews\"]/a")).click();

        // click en la estrella 3
        driver.findElement(By.xpath("//*[@id=\"commentform\"]/div/p/span/a[3]")).click();

        // genera cadena de texto aleatorio
        String comment = RandomStringUtils.randomAlphabetic(10);

        //Ingresamos un comentario en el review
        driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys(comment);

        //ingresamos el nombre del autor
        String creadorComentario = "Rodolfo Sobarzo Biere";
        driver.findElement(By.xpath("//*[@id=\"author\"]")).sendKeys(creadorComentario);

        //ingresamos un correo valido
        String emailComentario = "rodolfo.sobarzo@gmail.com";
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailComentario);

        // click en submit
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        //espera carga comentario
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.description")));

        //obtenemos mensaje
        String webComment = driver.findElement(By.cssSelector("div.description")).getText();

        System.out.println(comment);
        System.out.println(webComment);

        Assert.assertEquals(comment, webComment);
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