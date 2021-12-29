package desafio.equipo4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.security.auth.kerberos.KerberosTicket;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class Paquetes {
    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        //setup necesario antes de instanciar
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        //Instanciando lo necesario
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.viajesfalabella.cl");
    }

    @Test
    public void atc01PaqueteSugerido() throws InterruptedException {

        //Establecer un tiempo de espera explicito
        WebDriverWait espera = new WebDriverWait(driver,15);

        //Seleccionar modulo PACKAGES
        driver.findElement(By.cssSelector("a.shifu-3-button-circle.PACKAGES.paint-circle")).click();

        //Almacenar el contenido del modulo de paquetes sudamerica en un WebElement
        WebElement moduloPaquetes = driver.findElement(By.id("MultiproductOffersModule_6385"));

        //Seleccionar el primer elemento 'offer-card-content' dentro del WebElement
        String paquete =  moduloPaquetes.findElement(By.cssSelector("div.offer-card-title.small-title")).getText();
        String [] palabras = paquete.split(" ");
        String lugar = palabras[palabras.length-1];
        moduloPaquetes.findElement(By.cssSelector("div.offer-card-title.small-title")).click();

        //Seleccionar la ventana emergente
        driver.findElement(By.cssSelector("a.date-box")).click();

        //Cambiar de pestaña
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(1));

        //Validamos caso de prueba
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("aloha-cluster-accommodation-info-container")));
        String resultado = driver.findElement(By.xpath("//span[@class='-eva-3-tc-gray-2']")).getText();
        Assert.assertTrue(resultado.contains(lugar));
    }

    @Test
    public void atc02BusquedaEspecificaDesayuno() throws InterruptedException {

        WebDriverWait espera = new WebDriverWait(driver,15);

        //Seleccionar modulo PACKAGES
        driver.findElement(By.cssSelector("a.shifu-3-button-circle.PACKAGES.paint-circle")).click();

        //Ingresamos origen
        WebElement origen = driver.findElement(By.xpath("//input[@placeholder='Ingresa una ciudad']"));
        origen.sendKeys("bue");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        origen.sendKeys(Keys.DOWN);
        origen.sendKeys(Keys.ENTER);

        WebElement destino = driver.findElement(By.xpath("(//input[@placeholder='Ingresa una ciudad'])[2]"));
        destino.sendKeys("ams");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        destino.sendKeys(Keys.DOWN);
        destino.sendKeys(Keys.ENTER);

        //Seleccionar fecha de ida

        //Seleccionar fecha de vuelta

        //driver.findElement(By.xpath("//em[@class='_dpmg2--desktopFooter-button-apply-text btn-text']")).click();

        //Modificar habitaciones
        //driver.findElement(By.xpath("//div[@class='imput-container']")).click();
        //driver.findElement(By.xpath("a [contains (@class, '_pnlpk-panel__button']")).click();
        //driver.findElement(By.xpath("//a[@class='steppers-icon-right']")).click();
        //driver.findElement(By.xpath("//a[@class='_pnlpk-apply-button']")).click();


        Thread.sleep(2000);


        //Ingresamos destino


    }

    @Test
    public void atc03(){

    }

    @After
    public void close(){
        //Cerrar browser
        if(driver != null){
            driver.close();
        }
    }

    @AfterClass
    public static void closeAll(){
        //Cerrar otras conexiones.
        if(driver != null){
            driver.quit();
        }
    }
}
