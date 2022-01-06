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
import sun.java2d.loops.TransformHelper;


import javax.security.auth.kerberos.KerberosTicket;
import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static desafio.equipo4.Herramientas.changeTab;

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
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(15));

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

        //Espera
        WebDriverWait espera = new WebDriverWait(driver,15);

        //Variables
        String desayuno = "Desayuno";
        String anioMesIda = "2022-01";
        String diaIda = "5";
        String anioMesVuelta = "2022-01";
        String diaVuelta = "15";
        String ciudadOrigen = "bue";
        String ciudadDestino = "ams";

        //Seleccionar modulo PACKAGES
        driver.findElement(By.cssSelector("a.shifu-3-button-circle.PACKAGES.paint-circle")).click();

        //Ingresar origen
        WebElement origen = driver.findElement(By.xpath("//input[@placeholder='Ingresa una ciudad']"));
        origen.sendKeys(ciudadOrigen);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        origen.sendKeys(Keys.ENTER);

        //Ingresar destino
        WebElement destino = driver.findElement(By.xpath("(//input[@placeholder='Ingresa una ciudad'])[2]"));
        destino.sendKeys(ciudadDestino);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        destino.sendKeys(Keys.ENTER);

        //Seleccionar fecha de ida
        driver.findElement(By.xpath("//input[@placeholder='Ida']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'o _dpmg2--show')]//div[@data-month='"+anioMesIda+"']//span[contains(@class, 'number')][text()='"+diaIda+"']")).click();

        //Seleccionar fecha de vuelta y click en aplicar
        driver.findElement(By.xpath("//div[contains(@class, 'o _dpmg2--show')]//div[@data-month='"+anioMesVuelta+"']//span[contains(@class, 'number')][text()='"+diaVuelta+"']")).click();
        driver.findElement(By.xpath("(//button[contains(@class,'_dpmg2--desktopFooter-button')])[10]")).click();

        //Añadir habitaciones
        driver.findElement(By.xpath("(//div[@class='input-container'])[3]")).click();
        driver.findElement(By.xpath("(//a[contains(@class,'_pnlpk-panel__button')])[5]")).click();

        //Modificar cantidad de personas
        driver.findElement(By.xpath("(//a[contains(@class,'steppers-icon-right')])[3]")).click();
        driver.findElement(By.xpath("(//a[contains(@class,'_pnlpk-apply-button')])[2]")).click();

        //Buscar
        driver.findElement(By.xpath("//a[contains(@class,'sbox-search')]")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(@class,'filters')])[3]")));

        //Seleccionar filtro desayuno
        driver.findElement(By.xpath("(//span[contains(@class,'filters')])[3]")).click();

        //Validacion filtro desayuno
        String filtro = driver.findElement(By.xpath("(//div[contains(@class,'-eva-3-bold')])[3]")).getText();
        Assert.assertTrue(filtro.contains(desayuno));
    }

    @Test
    public void atc03PrecioFinal() throws InterruptedException {

        //Espera
        WebDriverWait espera = new WebDriverWait(driver,15);

        //Variables
        String anioMesIda = "2022-01";
        String diaIda = "5";
        String anioMesVuelta = "2022-01";
        String diaVuelta = "15";
        String ciudadOrigen = "bue";
        String ciudadDestino = "ams";

        //Seleccionar modulo PACKAGES
        driver.findElement(By.cssSelector("a.shifu-3-button-circle.PACKAGES.paint-circle")).click();

        //Ingresar origen
        WebElement origen = driver.findElement(By.xpath("//input[@placeholder='Ingresa una ciudad']"));
        origen.sendKeys(ciudadOrigen);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        origen.sendKeys(Keys.ENTER);

        //Ingresar destino
        WebElement destino = driver.findElement(By.xpath("(//input[@placeholder='Ingresa una ciudad'])[2]"));
        destino.sendKeys(ciudadDestino);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        destino.sendKeys(Keys.ENTER);

        //Seleccionar fecha de ida
        driver.findElement(By.xpath("//input[@placeholder='Ida']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'o _dpmg2--show')]//div[@data-month='"+anioMesIda+"']//span[contains(@class, 'number')][text()='"+diaIda+"']")).click();

        //Seleccionar fecha de vuelta y click en aplicar
        driver.findElement(By.xpath("//div[contains(@class, 'o _dpmg2--show')]//div[@data-month='"+anioMesVuelta+"']//span[contains(@class, 'number')][text()='"+diaVuelta+"']")).click();
        driver.findElement(By.xpath("(//button[contains(@class,'_dpmg2--desktopFooter-button')])[10]")).click();

        //Añadir habitaciones
        driver.findElement(By.xpath("(//div[@class='input-container'])[3]")).click();
        driver.findElement(By.xpath("(//a[contains(@class,'_pnlpk-panel__button')])[5]")).click();

        //Modificar cantidad de personas
        driver.findElement(By.xpath("(//a[contains(@class,'steppers-icon-right')])[3]")).click();
        driver.findElement(By.xpath("(//a[contains(@class,'_pnlpk-apply-button')])[2]")).click();

        //Buscar
        driver.findElement(By.xpath("//a[contains(@class,'sbox-search')]")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(@class,'filters')])[3]")));

        //Cambiar moneda a peso chileno
        Select moneda = new Select(driver.findElement(By.xpath("(//select[contains(@class,'select-tag')])[37]")));
        moneda.selectByVisibleText("Peso chileno");

        //Selecionar primera opcion
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class,'eva-3-btn')])[5]")));
        driver.findElement(By.xpath("(//button[contains(@class,'eva-3-btn')])[5]")).click();

        //Cambiar pestaña
        espera.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(1));
        espera.until(ExpectedConditions.titleIs("ibis Amsterdam Centre"));

        //Seleccionar siguiente para confirmar paquete
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'pricebox-action')]//button[contains(@class,'eva-3-btn')]")));
        driver.findElement(By.xpath("//div[contains(@class,'pricebox-action')]//button[contains(@class,'eva-3-btn')]")).click();

        //Seleccionar siguiente para confirmar vuelo mas conveniente
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class,'-md eva-3-btn')])[2]")));
        driver.findElement(By.xpath("(//a[contains(@class,'-md eva-3-btn')])[2]")).click();

        //Tranformar precio String a Int (quitandole el punto)
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricebox-sticky-more-info']//div[@class='pricebox-sticky-info-container']//div[contains(@class,'-eva-3-tc-gray')]")));
        String precioPaqueteCompleto = driver.findElement(By.xpath("//div[@class='pricebox-sticky-more-info']//div[@class='pricebox-sticky-info-container']//div[contains(@class,'-eva-3-tc-gray')]")).getText();

        //Uso de una regex para quitar el punto del numero.
        String precioString = precioPaqueteCompleto.replaceAll("\\p{Punct}", "");
        int precioPaquete = Integer.parseInt(precioString);

        //Seleccionar siguiente en el zocalo inferior
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricebox-content-container']//button[contains(@class,'eva-3-btn')]")));
        driver.findElement(By.xpath("//div[@class='pricebox-content-container']//button[contains(@class,'eva-3-btn')]")).click();

        //Obtener precio final
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricebox-content-wrap']//div[@id='chk-total-price']//div[contains(@class,'money-align')]//span[@class='amount']")));
        String precioPaqueteFinal = driver.findElement(By.xpath("//div[@class='pricebox-content-wrap']//div[@id='chk-total-price']//div[contains(@class,'money-align')]//span[@class='amount']")).getText();
        String precioFinalString = precioPaqueteFinal.replaceAll("\\p{Punct}", "");
        int precioFinal = Integer.parseInt(precioFinalString);

        //Validad precios finales
        Assert.assertTrue(precioFinal <= precioPaquete);

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
    }
}
