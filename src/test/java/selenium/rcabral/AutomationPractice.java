package selenium.rcabral;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class AutomationPractice {

    private WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void busquedaPalabrasClaves_XPath(){
        driver.get("http://automationpractice.com");
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("dress"); //Enviamos "dress" por el searchbox
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click(); //Clickeamos el boton para buscar.
        List<WebElement> listadoProductos = driver.findElements(By.xpath("//*[@id='center_column']/ul/li")); //guardamos en una lista de WebElement todos los productos encontrados

        Assert.assertTrue(listadoProductos.size() > 1); //si la cantidad de productos es mayor a 1 la prueba pasa correctamente.
    }


    @Test
    public void busquedaPalabrasClaves_Css(){
        driver.get("http://automationpractice.com");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress"); //ingresamos "dress" en el searchbox
        driver.findElement(By.cssSelector("button.btn:nth-child(5)")).click(); //presionamos el boton para buscar
        List<WebElement> listadoProductos = driver.findElements(By.cssSelector("ul.product_list.grid.row>li")); //agregamos en una lista todos los productos

        Assert.assertTrue(listadoProductos.size() > 1);
    }

    @Test
    public void busquedaDirectaProductoExistente_XPath(){
        driver.get("http://automationpractice.com");
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("Printed Chiffon Dress"); //Enviamos "Printed Chiffon Dress" por el searchbox
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click(); //Clickeamos el boton para buscar.
        List<WebElement> listadoProductos = driver.findElements(By.xpath("//*[@id='center_column']/ul/li")); //guardamos en una lista de WebElement todos los productos encontrados
        String nombreProducto = listadoProductos.get(0).findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a")).getText(); //Guardamos el nombre del primer producto guardado en la lista.

        Assert.assertEquals("Printed Chiffon Dress", nombreProducto);
    }

    @Test
    public void busquedaDirectaProductoExistente_Css(){
        driver.get("http://automationpractice.com");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("Printed Chiffon Dress"); //ingresamos "Printed Chiffon Dress" en el searchbox
        driver.findElement(By.cssSelector("button.btn:nth-child(5)")).click(); //presionamos el boton para buscar
        List<WebElement> listadoProductos = driver.findElements(By.cssSelector("ul.product_list.grid.row>li")); //agregamos en una lista todos los productos
        String nombreProducto = listadoProductos.get(0).findElement(By.cssSelector(".product-name")).getText(); //Guardamos el nombre del primer producto guardado en la lista.

        Assert.assertEquals(nombreProducto, "Printed Chiffon Dress");
    }

    @Test
    public void mensajeProductoNoEncontrado_XPath(){
        driver.get("http://automationpractice.com");
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("liquido matapulgas"); //Enviamos "Printed Chiffon Dress" por el searchbox
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click(); //Clickeamos el boton para buscar.
        String mensaje = driver.findElement(By.xpath("//p[contains(@class, 'alert alert-warning')]")).getText();

        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", mensaje);
    }

    @Test
    public void encontrarProductoDeListaDinamica_XPath() throws InterruptedException {
        driver.get("http://automationpractice.com");
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("blo"); //Enviamos "blo" por el searchbox
        Thread.sleep(4000); //Esperamos 5 segundos
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(Keys.ARROW_DOWN); //precionamos la tecla flecha hacía abajo
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(Keys.TAB); //presionamos la tecla tabular para seleccionar la sugerencia

        String resultado = driver.findElement(By.xpath("//span[contains(@class, 'editable')]")).getText(); //guardamos el nombre del modelo

        Assert.assertEquals("Model demo_2", "Model "+resultado);
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }

    @AfterClass
    public static void closeAll(){

    }
}