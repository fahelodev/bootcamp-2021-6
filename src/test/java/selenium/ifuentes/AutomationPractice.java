package selenium.ifuentes;

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

import static org.junit.Assert.assertEquals;


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
    }

    @Test
    public void Atc01_BusquedaPalabrasClaves(){
        System.out.println("Test Case 1");
        //Cargar la página
        driver.get("http://automationpractice.com/");
        //Introducir DRESS en campo busqueda
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("dress");
        //Hacer click en campo SEARCH
        By.xpath("//*[@id=\'searchbox\']/button").findElement(driver).click();
        List<WebElement> resultados = driver.findElements(By.xpath("//*[@id=\'center_column\']/ul/li"));
        if (resultados.size() > 1) {
            System.out.println("Resultados de la busqueda '" + resultados.size() + "' - Prueba Exitosa");
        } else {
            System.out.println("No se cumple resultado esperado" + resultados.size());
        }
    }

    @Test
    public void Atc01css_BusquedaPalabrasClaves(){
        System.out.println("Test Case 1");
        //Cargar la página
        driver.get("http://automationpractice.com/");
        //Introducir DRESS en campo busqueda
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
        //Hacer click en campo SEARCH
        driver.findElement(By.cssSelector("#searchbox > button")).click();
        List<WebElement> resultados = driver.findElements(By.cssSelector("#center_column > ul"));
        if (resultados.size() > 1) {
            System.out.println("Resultados de la busqueda '" + resultados.size() + "' - Prueba Exitosa");
        } else {
            System.out.println("Resultado es '" + resultados.size() +"' - No se el cumple resultado esperado");
        }
    }
    @Test
    public void atc02_busquedaDirectaProductoExistente(){
        System.out.println("Test Case 2");
        //Cargar la página
        driver.get("http://automationpractice.com/");
        //Introducir printed chiffon dress en campo busqueda
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("printed chiffon dress");
        //Hacer click en campo SEARCH
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();
        //guardo objeto buscado nombre
        List<WebElement> resultado = driver.findElements(By.xpath("//*[@id=\'center_column\']/ul/li"));
        String texto = resultado.get(0).findElement(By.xpath("//a[contains ( @class, 'product-name')]")).getText();
        // se espera "Printed Chiffon Dress" comprara objero buscado
        assertEquals("Printed Chiffon Dress", texto );

    }
    @Test @Ignore
    public void atc02_css_busquedaDirectaProductoExistente(){
        System.out.println("Test Case 2");
        //Cargar la página
        driver.get("http://automationpractice.com/");
        //Introducir printed chiffon dress en campo busqueda
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("printed chiffon dress");
        //Hacer click en campo SEARCH
        driver.findElement(By.cssSelector("[name='submit_search']")).click();
        //guardo objeto buscado nombre
        List<WebElement> result = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));
        String text = result.get(0).findElement(By.cssSelector(".product-name")).getText();
        // se espera "Printed Chiffon Dress" comprara objero buscado
        Assert.assertEquals("Printed Chiffon Dress", text);
    }

    @Test @Ignore
    public void atc03_MensajeProductoNoEncontrado(){
        System.out.println("Test Case 3");
        //1. Cargar Home
        driver.get("http://automationpractice.com/");
        //2.Introducir "liquido matapulgas" en search
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("liquido matapulgas");
        //3.Hacer la búsqueda introduciendo Enter en el campo de búsqueda
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.ENTER);
        //Guardamos el mensaje "No results were found for your search "liquido matapulgas"
        String mensaje_alerta = driver.findElement(By.cssSelector("#center_column > p")).getText();
        Assert.assertEquals( "No results were found for your search \"liquido matapulgas\"" ,mensaje_alerta);

    }
    @Test
    public void atc05_AgregarProductoCambiandoTallaYColor() {
        System.out.println("Test Case 5");
        //1. Cargar Home
        driver.get("http://automationpractice.com/");
        //2.Buscar el producto "Blouse Model demo_2"
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("Blouse");
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Esperamos explicitamente
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results")));
        //hacer click en search para buscar producto
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();

        Assert.assertEquals("l",driver.findElement(By.xpath("//*[@id=\'group_1\']")).getText());



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