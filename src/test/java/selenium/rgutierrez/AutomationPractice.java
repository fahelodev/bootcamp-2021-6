package selenium.rgutierrez;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class git adAutomationPractice {

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
        // Definimos un implicit wait de 4 segundos
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test
    public void atc01_busquedaPalabrasClavesCSS(){
        System.out.println("Test Case atc01_busquedaPalabrasClavesCSS");

        driver.get("http://automationpractice.com/");

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

    @Test
    public void atc03_mensajeProductoNoEncontrado(){
        System.out.println("Test Case atc03_mensajeProductoNoEncontrado");

        driver.get("http://automationpractice.com/");

        // Buscamos por la palabra "liquido matapulgas"
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("liquido matapulgas");
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).sendKeys(Keys.ENTER);

        // Guardamos en la variable resultado el elemento p que contiene el mensaje de no encontrados
        WebElement resultado = driver.findElement(By.xpath("//*[@id=\'center_column\']//p[contains(@class, 'alert-warning')]"));

        // Obtenemos el texto del elemento p
        String texto = resultado.getText();

        // Se espera que texto sea igual a "No results were found for your search "liquido matapulgas"
        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", texto);
    }

    @Test
    public void atc04_encontrarProductoDeListaDinamica(){
        System.out.println("atc04_encontrarProductoDeListaDinamica");

        driver.get("http://automationpractice.com/");

        // Ingresamos el texto "blo" en el campo de busqueda y guardamos los li correspondientes a la lista dinamica
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("blo");
        List<WebElement> resultados = driver.findElements(By.xpath("//*[@class=\'ac_results\']//li"));

        //Iteramos sobre las sugerencias y hacemos click en ella en caso de que alguna coincida con "Blouses > Blouse"
        for (int i = 0; i < resultados.size(); i++) {
            if (resultados.get(i).getText().equals("Blouses > Blouse")) {
                resultados.get(i).click();
                break;
            }
        }

        //Obtenemos el texto correspondiente al modelo del producto
        String referenciaProducto = driver.findElement(By.xpath("//*[@id=\'product_reference\']")).getText();

        // Se espera que la referencia sea igual a "Model demo_2"
        Assert.assertEquals("Model demo_2", referenciaProducto);
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
