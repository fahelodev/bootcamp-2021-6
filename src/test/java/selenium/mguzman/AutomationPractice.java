package selenium.mguzman;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationPractice {

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        System.out.println("instanciar");
        driver = new ChromeDriver();
        //Page practice.
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void atc01_CSS_searchDress() {
        // Buscar dress y ver cuantos resultados hay (Con CSS)
        System.out.println("Test Case 1");
        //Poner en caja de busqueda la palabra dress
        driver.findElement(By.cssSelector("input.search_query")).sendKeys("dress");
        //Hacer click para buscar
        driver.findElement(By.cssSelector("button.button-search")).click();
        List<WebElement> result = driver.findElements(By.cssSelector("ul.product_list.grid.row  a.product-name"));
        Assert.assertEquals(7, result.size());
    }

    @Test
    public void atc01_Xpath_searchDress() {
        //Buscar dress y ver cuantos resultados hay (Con Xpath)
        System.out.println("Test Case 2");
        //Poner en caja de busqueda la palabra dress
        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("dress");
        //Hacer click para buscar
        driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();
        List<WebElement> result = driver.findElements(By.xpath("//ul[@class=\"product_list grid row\"]//a[@class=\"product-name\"]"));

        Assert.assertEquals(7, result.size());
    }

    @Test
    public void atc02_CSS_search() {
        //Buscar printed chiffon dress y comparar el productor del articulo (Con CSS)
        System.out.println("Test Case 3");
        //Poner en caja de busqueda la palabra printed chiffon dress
        driver.findElement(By.cssSelector("input.search_query")).sendKeys("printed chiffon dress");
        //Hacer click para buscar
        driver.findElement(By.cssSelector("button.button-search")).click();
        //Obtener texto
        String result = driver.findElement(By.cssSelector("ul.product_list.grid.row li:nth-of-type(1) a.product-name")).getText();
        Assert.assertEquals("Printed Chiffon Dress", result);
    }

    @Test
    public void atc02_Xpath() {
        //Buscar printed chiffon dress y comparar el productor del articulo (Con Xpath)
        System.out.println("Test Case 4");
        //Poner en caja de busqueda la palabra printed chiffon dress
        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("printed chiffon dress");
        driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();
        //Obtener texto
        String result = driver.findElement(By.xpath("//ul[@class=\"product_list grid row\"]/li//a[contains(text(),\"Printed\")]")).getText();
        Assert.assertEquals("Printed Chiffon Dress", result);
    }

    @Test
    public void atc03_Xpath() {
        //Escribir liquido matapulgas y mostrar el error
        System.out.println("Test Case 5");
        //Poner en caja de busqueda la palabra liquido matapulga
        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("liquido matapulgas" + Keys.RETURN);
        //Obtener texto
        String m = driver.findElement(By.xpath("//div//p[@class=\"alert alert-warning\"]")).getText();
        String n = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span")).getText();
        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", m);
        Assert.assertEquals("0 results have been found.",n);

    }

    @Test
    public void atc04_Xpath() {
        //En la caja de busqueda poner blo y seleccionar lo pre-buscado "blouses"
        System.out.println("Test Case 6");
        //Poner en caja de busqueda la palabra blo
        driver.findElement(By.cssSelector("input.search_query")).sendKeys("blo");
        //Hacer click en lo pre-buscado
        driver.findElement(By.xpath("//div//ul//li[@class=\"ac_even\"]")).click();
        //obternet texto
        String result = driver.findElement(By.xpath("//div//p[@id=\"product_reference\"]")).getText();
        Assert.assertEquals("Model demo_2", result);
    }

    @Test
    public void atc05_Xpath() {

        System.out.println("Test Case 7");

        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("Blouse");
        driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();
        driver.findElement( By.xpath("(//a//img[@class=\"replace-2x img-responsive\"])[@alt=\"Blouse\"]")).click();
        driver.findElement( By.xpath("//select[@id=\"group_1\"]")).click();
            WebElement Talla = driver.findElement( By.xpath("//select[@id=\"group_1\"]"));
            Select select = new Select(Talla);
            select.selectByVisibleText("L");
        //Seleccionar color blanco
        driver.findElement(By.xpath("(//a[@id=\"color_8\"])[@name=\"White\"]")).click();
        driver.findElement(By.xpath("(//button[@class=\"exclusive\"])[@name=\"Submit\"]")).click();

        //Creamos variables para traer el precio y verificar la compra
        String price = driver.findElement(By.xpath("//div[@class=\"layer_cart_row\"]/span[contains(text(),\"$29.00\")]")).getText();
        String check = driver.findElement(By.xpath("//div//span[@class=\"ajax_block_cart_total\"]")).getText();

        Assert.assertEquals(price,check);

    }


    @After
      public void close() {
       if (driver != null) {
           System.out.println("Close");
           driver.close();
        }

    }

}