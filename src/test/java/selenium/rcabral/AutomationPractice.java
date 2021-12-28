package selenium.rcabral;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
        //Enviamos "dress" por el searchbox
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("dress");
        //Clickeamos el boton para buscar.
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();
        //guardamos en una lista de WebElement todos los productos encontrados
        List<WebElement> listadoProductos = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));

        //si la cantidad de productos es mayor a 1 la prueba pasa correctamente.
        Assert.assertTrue(listadoProductos.size() > 1);
    }


    @Test
    public void busquedaPalabrasClaves_Css(){
        driver.get("http://automationpractice.com");
        //ingresamos "dress" en el searchbox
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
        //presionamos el boton para buscar
        driver.findElement(By.cssSelector("button.btn:nth-child(5)")).click();
        //agregamos en una lista todos los productos
        List<WebElement> listadoProductos = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));

        Assert.assertTrue(listadoProductos.size() > 1);
    }

    @Test
    public void busquedaDirectaProductoExistente_XPath(){
        driver.get("http://automationpractice.com");
        //Enviamos "Printed Chiffon Dress" por el searchbox
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("Printed Chiffon Dress");
        //Clickeamos el boton para buscar.
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();
        //guardamos en una lista de WebElement todos los productos encontrados
        List<WebElement> listadoProductos = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));
        //Guardamos el nombre del primer producto guardado en la lista.
        String nombreProducto = listadoProductos.get(0).findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a")).getText();

        Assert.assertEquals("Printed Chiffon Dress", nombreProducto);
    }

    @Test
    public void busquedaDirectaProductoExistente_Css(){
        driver.get("http://automationpractice.com");
        //ingresamos "Printed Chiffon Dress" en el searchbox
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("Printed Chiffon Dress");
        //presionamos el boton para buscar
        driver.findElement(By.cssSelector("button.btn:nth-child(5)")).click();
        //agregamos en una lista todos los productos
        List<WebElement> listadoProductos = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));
        //Guardamos el nombre del primer producto guardado en la lista.
        String nombreProducto = listadoProductos.get(0).findElement(By.cssSelector(".product-name")).getText();

        Assert.assertEquals(nombreProducto, "Printed Chiffon Dress");
    }

    @Test
    public void mensajeProductoNoEncontrado_XPath(){
        driver.get("http://automationpractice.com");
        //Enviamos "Printed Chiffon Dress" por el searchbox
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("liquido matapulgas");
        //Clickeamos el boton para buscar.
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();
        String mensaje = driver.findElement(By.xpath("//p[contains(@class, 'alert alert-warning')]")).getText();

        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", mensaje);
    }

    @Test
    public void encontrarProductoDeListaDinamica_XPath(){
        driver.get("http://automationpractice.com");
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Enviamos "blo" por el searchbox
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("blo");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='index']/div[2]/ul/li")));
        //precionamos la tecla flecha hacía abajo
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(Keys.ARROW_DOWN);
        //presionamos la tecla tabular para seleccionar la sugerencia
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(Keys.TAB);

        //guardamos el nombre del modelo
        String resultado = driver.findElement(By.xpath("//span[contains(@class, 'editable')]")).getText();

        Assert.assertEquals("Model demo_2", "Model "+resultado);
    }

    @Test
    public void atc05_AgregarProductoCambiandoTallaYColor(){
        driver.get("http://automationpractice.com");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("blo");

        //ingresamos al producto especificado
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(5));
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results")));
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.DOWN);
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.ENTER);

        //seleccionamos el combobox y elegimos la talla
        Select select = new Select(driver.findElement(By.xpath("//*[@id='group_1']")));
        select.selectByVisibleText("L");
        //cambiamos el color
        driver.findElement(By.xpath("//*[@id='color_8']")).click();
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();

        //esperamos a que aparezca el mensaje de la compra.
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")));
        //guardamos el mensaje de compra exitosa
        String mensaje =  driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).getText();

        Assert.assertEquals("Product successfully added to your shopping cart", mensaje);
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