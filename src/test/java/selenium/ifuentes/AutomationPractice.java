package selenium.ifuentes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        List<WebElement> objetoBuscado = driver.findElements(By.xpath("//*[@id=\'center_column\']/ul/li"));
        String texto = objetoBuscado.get(0).findElement(By.xpath("//a[contains ( @class, 'product-name')]")).getText();
        // se espera "Printed Chiffon Dress" comprara objero buscado
        assertEquals("Printed Chiffon Dress", texto );

    }
    @Test
    public void atc02_css_busquedaDirectaProductoExistente(){
        System.out.println("Test Case 2");
        //Cargar la página
        driver.get("http://automationpractice.com/");
        //Introducir"printed chiffon dress" en campo busqueda
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        //Hacer click en campo SEARCH
        driver.findElement(By.cssSelector("#searchbox > button")).click();
        //guardo objeto buscado nombre
        WebElement objetoBuscado = driver.findElement(By.cssSelector("button.btn:nth-child(5)"));
        // se espera "Printed Chiffon Dress"- (comprara objero buscado)
        assertEquals("Printed Chiffon Dress", objetoBuscado.getText());
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