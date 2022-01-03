package desafio.equipo2.selenium.rcabral;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AutomationAmazon {
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
    public void filtroMarcaTarjetasDeRegalo() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(4));

        //click en el menu
        driver.findElement(By.xpath("//*[@id='nav-hamburger-menu']")).click();

        //esperamos a que se pueda hacer click en electronicos
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hmenu-content']/ul[1]/li[7]/a")));

        //Click en electronicos
        driver.findElement(By.xpath("//*[@id='hmenu-content']/ul[1]/li[7]/a")).click();

        //esperamos a que se pueda hacer click en accesorios y suministros
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hmenu-content']/ul[5]/li[3]/a")));

        //Click en accesorios y suministros
        driver.findElement(By.xpath("//*[@id='hmenu-content']/ul[5]/li[3]/a")).click();

        //esperamos a que se pueda hacer click en tarjetas de regalos
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-xshop\"]/a[4]")));

        //Click en tarjetas de regalos
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]")).click();

        //Click en Por marcas
        driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[7]/span[1]")).click();

        //Esperamos a que se pueda hacer click en Google Play
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Google Play link image']")));

        //Click en google play
        driver.findElement(By.xpath("//*[@aria-label='Google Play link image']")).click();

        //Guardamos en una lista de WebElement todos los productos encontrados.
        List<WebElement> lista_productos = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]"));

        boolean flag = true;

        //Recorremos la lista de productos
        for(WebElement productos : lista_productos){

            //guardamos la descripción del producto en la variable mensaje
            String mensaje = productos.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();

            //Si el mensaje no contiene la palabra 'Google', flag será falso y saldrá del for.
            if(!mensaje.contains("Google")){
                flag = false;
                break;
            }
        }

        Assert.assertTrue(flag);
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