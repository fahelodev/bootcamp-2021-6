package selenium.mvargas.nmarinucci;

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

import java.util.List;

public class AutomationPractice{

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void atc01BusquedaPalabrasClaves() {
        //Resuelto mediante xpath y css.
        System.out.println("Test Case 1");
        driver.get("http://automationpractice.com/");
        //xpath = "//tag[@atributo = 'valor']"

        //1- Seleccionamos el recuadro de busqueda.
        //driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");

        //2- Clickeamos en el boton 'search'.
        //driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        //Obtenemos y validamos resultados.
        //List<WebElement> resultado = driver.findElements(By.xpath("//li[contains (@class, 'ajax_block_product')]"));
        List<WebElement> resultado = driver.findElements(By.cssSelector("ul.product_list.grid.row > li"));
        Assert.assertEquals(7, resultado.size());
    }

    @Test
    public void atc02BusquedaDirectaProductoExistente() {
        System.out.println("Test Case 2");
        driver.get("http://automationpractice.com/");

        //Solucion xpath:
        //driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys( "printed chiffon dress");
        //driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        //List<WebElement> resultado = driver.findElements(By.xpath("//a[contains (@class,  'product-name')]"));
        //String dress = resultado.get(0).getText();
        //Assert.assertEquals("Printed Chiffon Dress", dress);

        //Solucion Css:
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("[name='submit_search']")).click();
        String resultado = driver.findElement(By.cssSelector("ul.product_list.grid.row li:nth-of-type(1) a.product-name")).getText();
        Assert.assertEquals("Printed Chiffon Dress", resultado);
    }

    @Test
    public void atc03MensajeProductoNoEncontrado(){
        System.out.println("Test Case 3");
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys( "liquido matapulgas" + Keys.ENTER);
        //driver.findElement(By.xpath("//button[@name='submit_search']")).click();

        //Validacion producto NO encontrado:
        String busqueda = "liquido matapulgas";
        String resultado = driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText();
        //System.out.println(resultado);
        Assert.assertEquals("No results were found for your search "+"\""+busqueda+"\"",resultado);
    }

    @Test
    public void atc04EncontrarProductoDeListaDinamica() throws InterruptedException {
        System.out.println("Test Case 4");
        driver.get("http://automationpractice.com/");

        //Seleccionando elemento de la lista dinamica.
        //Almacenamos el elemento en un WebElement
        WebElement listaDinamica = driver.findElement(By.id("search_query_top"));

        //Introducir elemento buscado.
        listaDinamica.sendKeys("blo");

        //Establecemos una espera explicita para que el selenium espere antes de seleccionar la opcion autosugerida.
        WebDriverWait espera = new WebDriverWait(driver,3);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac_results']")));

        //Moviendo el puntero dentro de la lista una posicion hacia abajo para seleccionar la opcion sugerida.
        listaDinamica.sendKeys(Keys.DOWN);

        //Presionar ENTER dentro de la lista.
        listaDinamica.sendKeys(Keys.ENTER);

        //Validando resultado esperado
        String resultado = driver.findElement(By.xpath("//p[@id='product_reference']")).getText();
        //System.out.println(resultado);
        Assert.assertEquals("Model demo_2",resultado);
    }

    @Test
    public void atc05AgregarProductoTallaColor() throws InterruptedException {
        System.out.println("Test Case 5");
        driver.get("http://automationpractice.com/");

        //Seleccionando elemento de la lista dinamica.
        //Almacenamos el elemento en un WebElement
        WebElement listaDinamica = driver.findElement(By.id("search_query_top"));

        //Introducir elemento buscado.
        listaDinamica.sendKeys("blo");

        //Establecemos una espera explicita para que el selenium espere antes de seleccionar la opcion autosugerida.
        WebDriverWait espera = new WebDriverWait(driver,3);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac_results']")));

        //Moviendo el puntero dentro de la lista una posicion hacia abajo para seleccionar la opcion sugerida.
        listaDinamica.sendKeys(Keys.DOWN);

        //Presionar ENTER dentro de la lista.
        listaDinamica.sendKeys(Keys.ENTER);

        //Modificar talle y color
        Select talle = new Select(driver.findElement(By.id("group_1")));
        talle.selectByVisibleText("L");
        driver.findElement(By.id("color_8")).click();
        driver.findElement(By.id("add_to_cart")).click();

        //espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='layer_cart_cart']")));
        Thread.sleep(3000);

        //Validar resultado
        String resultado = driver.findElement(By.xpath("//span[@class='ajax_cart_product_txt ']")).getText();
        Assert.assertEquals("There is 1 item in your cart.",resultado);

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