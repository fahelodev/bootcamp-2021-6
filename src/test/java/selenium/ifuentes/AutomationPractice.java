package desafio.equipo2.selenium.ifuentes;

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



    @Test @Ignore
    public void Atc01css_BusquedaPalabrasClaves(){
        System.out.println("Test Case 1");
        //Cargar la página
        driver.get("http://automationpractice.com/");
        //escribir en la barra de busqueda
       driver.findElement(By.cssSelector("input.search_query")).sendKeys("dress");
        //click en boton de busqueda
        driver.findElement(By.cssSelector("button.button-search")).click();
        //enlistar elementos encontrado
        List<WebElement> result = driver.findElements(By.cssSelector("ul.product_list.grid.row  a.product-name"));
        Assert.assertTrue(result.size()>=2);
    }

    @Test @Ignore
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

    @Test
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

    @Test @Ignore
    public void atc04_Xpath() throws InterruptedException {
        //En la caja de busqueda poner blo y seleccionar lo pre-buscado
        System.out.println("Test Case 4");
        //Poner en caja de busqueda la palabra blo
        driver.findElement(By.cssSelector("input.search_query")).sendKeys("blo");
        //Hacer click en lo pre-buscado
        driver.findElement( By.xpath("//div//ul//li[@class=\"ac_even ac_over\"]")).click();
        //obternet texto
        String result = driver.findElement(By.xpath("//div//p[@id=\"product_reference\"]")).getText();
        Assert.assertEquals("Model demo_2", result );
    }

    @Test @Ignore
    public void atc05_AgregarProductoCambiandoTallaYColor() throws InterruptedException {
        System.out.println("Test Case 5");
        //1. Cargar Home
        driver.get("http://automationpractice.com/");
        //2.Buscar el producto "Blouse Model demo_2"
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("Blo");
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Esperamos explicitamente
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results")));
        //bajamos en los resultados.
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.DOWN);
        //Presionamos enter.
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.ENTER);
        //seleccionamos talla
        Select select = new Select(driver.findElement(By.cssSelector("#group_1")));
        select.selectByVisibleText("L");
        //cambiamos color
        driver.findElement(By.cssSelector("#color_8")).click();
        driver.findElement(By.cssSelector("#add_to_cart>button")).click();
        //aparece msj de compra
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2 > font > font")));
        //guardamos el msj de compra
        String mensaje =driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2 > font > font")).getText();
        //compara que el msj sea el esperado
        Assert.assertEquals("Producto agregado exitosamente a su carrito de compras",mensaje);
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