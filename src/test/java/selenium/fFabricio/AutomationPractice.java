package desafio.equipo2.selenium.fFabricio;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void atc01BusquedaDress()throws InterruptedException {
        //buscador dress
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("dress");
        //click boton
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();
        //resultado
        List<WebElement> resultado = driver.findElements(By.xpath("//*[@id='center_column'] /ul/li"));
        assertTrue(resultado.size()>2);

    }

    @Test
    public void atc02BusquedaChiffonDress()throws InterruptedException {
        //buscador printed chiffon dress
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        //click en boton buscar
        driver.findElement(By.cssSelector("button.btn:nth-child(5)")).click();
        //resultado
        assertEquals("Printed Chiffon Dress", driver.findElement(By.cssSelector("a.product-name")).getText());

    }

    @Test
    public void atc03Matapulgas() throws InterruptedException {

        //capturamos el buscador en un webElement
        WebElement txtEntrada = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        txtEntrada.sendKeys("liquido matapulgas");
        txtEntrada.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        //resultado y producto no encontrado
        WebElement resultado = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
        assertTrue(resultado.getText().equals("No results were found for your search \"liquido matapulgas\""));


    }

    @Test
    public void act04ListaDinamica() throws InterruptedException {

        WebElement Txtbusqueda = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        Txtbusqueda.sendKeys("blo");

        WebDriverWait espera = new WebDriverWait(driver,15);
        //espera a que salga el autocompletado
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"index\"]/div[2]/ul/li")));


        //clickea el autocompletado que escribimos
        WebElement itemAutocompleto = driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li"));
        itemAutocompleto.click();
        Thread.sleep(2000);

        //Capturamos el elementos al que hacemos referencia y lo comparamos con la salida
        WebElement elementoTXT = driver.findElement(By.xpath("//*[@id=\"product_reference\"]"));
        Assert.assertEquals("Model demo_2", elementoTXT.getText());


    }





    @Test
    public void atc05CambiandoProducto() throws InterruptedException {

        //capturamos el buscador en un webElement
        WebElement txtBusqueda = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        txtBusqueda.sendKeys("BLOUSE");


        //espera a que salga el autocompletado
        WebDriverWait espera = new WebDriverWait(driver,15);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"index\"]/div[2]/ul/li")));


        //clickea el autocompletado que escribimos
        WebElement itemAutocompleto = driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li"));
        itemAutocompleto.click();
        Thread.sleep(2000);

        //Capturamos el elementos al que hacemos referencia y lo comparamos con la salida
        WebElement elementoTXT = driver.findElement(By.xpath("//*[@id=\"product_reference\"]"));
        Thread.sleep(2000);

        //Capturamos el elemento del group1 y seleccionamos el texto visible en L
        Select s = new Select(driver.findElement(By.id("group_1")));
        s.selectByVisibleText("L");

        //seleccionamos color y agregamos al carrito
        driver.findElement(By.id("color_8")).click();
        driver.findElement(By.cssSelector("#add_to_cart > button")).click();

        WebElement productCart = driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2"));
        Thread.sleep(2000);


        Assert.assertEquals("Model demo_2", elementoTXT.getText());
        Assert.assertEquals("Product successfully added to your shopping cart", productCart.getText());




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
