package selenium.mvargas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        driver.get("http://automationpractice.com/"); //Cargar la páginas

    }

    @Test
    public void atc01_BusquedaPalabrasClaves(){
        //Introducir DRESS en campo busqueda
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("dress");
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();//Hacer click en campo SEARCH
        List<WebElement> resultados = driver.findElements(By.xpath("//*[@id=\'center_column\']/ul/li"));
        Assert.assertTrue(resultados.size() > 1); //probar que se encuentren al menos 2 resultados
    }

    @Test
    public void atc02_busquedaDirectaProductoExistente(){
        //Introducir 'printed chiffon dress' en campo busqueda
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("printed chiffon dress");
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();//Hacer click en campo SEARCH
        WebElement producto = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a"));
        String primerProducto = producto.getText();//System.out.println("Titulo: " + primerProducto);
        String parametro = "Printed Chiffon Dress";
        Assert.assertEquals(primerProducto,parametro);//se comprara el primer resultado con el nombre buscado
    }

    @Test
    public void atc03_MensajeProductoNoEncontrado(){
        driver.findElement(By.cssSelector("input.search_query")).sendKeys("liquido matapulgas");//Introducir DRESS en campo busqueda
        driver.findElement(By.cssSelector("input.search_query")).sendKeys(Keys.ENTER);//Presionar enter en campo busqueda
        WebElement result = driver.findElement(By.cssSelector("p.alert.alert-warning"));
        String warning = result.getText(); //se rescata el texto del webElement result
        String parametro = "No results were found for your search \"liquido matapulgas\"";
        Assert.assertEquals(parametro,warning); //se compara el resultado del warning al no encontrar resultados
    }

    @Test
    public void atc05_AgregarProductoCambiandoTallaYColor() throws InterruptedException {
        driver.findElement(By.cssSelector("input.search_query")).sendKeys("Blouse");//Introducir Blouse en campo busqueda
        driver.findElement(By.cssSelector("input.search_query")).sendKeys(Keys.ENTER);//Presionar enter en campo busqueda
        driver.findElement(By.cssSelector("li.ajax_block_product")).click();//se ingresa a detalle del producto
        Select objSelect = new Select(driver.findElement(By.cssSelector("select.form-control")));
        objSelect.selectByValue("3"); //se cambia talla a "L" (value 3)
        driver.findElement(By.name("White")).click();//se cambia de a color blanco
        driver.findElement(By.cssSelector("button.exclusive")).click();//se envía el producto al carrito de compra
        WebElement cart = driver.findElement(By.cssSelector("span.product-name"));
        Thread.sleep(3000); //no usar sleep
        String inCart = cart.getText(); //se rescata el texto del webElement cart
        Assert.assertEquals("Blouse",inCart);

    }

    @Test @Ignore
    public void atc01CargarPaginaPrincipal2(){
        System.out.println("Test Case 2");
        driver.get("http://google.com/");
        Assert.assertEquals("My Store",driver.getTitle());
    }

    @After
    public void close() throws InterruptedException {
        if(driver != null){
            Thread.sleep(4000);
            System.out.println("Close");
            driver.close();
        }

    }

    @AfterClass
    public static void closeAll(){
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }

}