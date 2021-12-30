package Test_Falabella;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
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
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class ATC_Traslados {
    private WebDriver driver;
    String currentHandle = "https://www.viajesfalabella.cl/";

    @BeforeClass
    public static void setup() {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        System.out.println("instanciar");
        driver = new ChromeDriver();
        //Page practice
        driver.get(currentHandle);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void TC003_reservarEnDólarEnServiciosDeTraslados() throws InterruptedException {


        String locatorTraslados = "//i[@title='Traslados']";
        String cardAuto = "//body/app-root[1]/div[1]/div[5]/div[1]/offers[1]/div[1]/div[2]/div[1]/offer-card[1]/div[1]/a[1]/div[1]";
        String modificar = "//em[@class='btn-text -eva-3-hide-small']";
        String dolar= "//select[@id='currency-select']";
        String comprar = "//em[normalize-space()='Comprar']";
        String locatorBtnVerMas = "//em[@class='btn-text'][contains(text(),'Ver más ofertas')]";
        String btnModificar = "//span[@class='eva-3-btn -secondary -md -icon -eva-3-hide-small']";
        String dolarChange = "#currency-select";
        String FiltroTrasladoCompartido = "//div[@class='col -sm-12 -md-8']//li[2]";
        String btnComprar = "//ds-cluster-pricebox//div[@class='pricebox-action']";

        System.out.println("Test Case 3");

        //validate string title pestaña of the page
        Assert.assertEquals("Vuelos baratos, Hoteles, Paquetes y más | Viajes Falabella", driver.getTitle());

        //wait until element is visible - click en traslados
        WebDriverWait driverWithMoreWait = new WebDriverWait(driver,20);

        //click Traslados Page Home
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorTraslados))).click();

        //click btn ver mas home Page
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorBtnVerMas))).click();

        //click en card autos traslados Destacados Home Page
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cardAuto))).click();

        //Get all the handles currently available
        Set<String> handles=driver.getWindowHandles();
        for(String actual: handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                //Switch to the opened tab
                driver.switchTo().window(actual);
            }

        }
        //click en btn Modificar Page Traslados
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnModificar))).click();

        //Change price Peso CL to Dolares
        Select dolarLocator = new Select(driver.findElement(By.cssSelector(dolarChange)));
        dolarLocator.selectByValue("USD");

        //click filter shared transfers Page Traslados
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FiltroTrasladoCompartido))).click();

        //click btn Comprar en Minivan Option
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnComprar))).click();

        Thread.sleep(10000);

    }


    @Test
    public void TC001_TrasladoDesdeElAeropuerto() throws InterruptedException {


        String locatorTraslados = "//i[@title='Traslados']";
        String fieldDesde = "//header-wrapper/div[@id='']/div[1]/sbox[1]/div[1]/searchbox[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
        String fieldHasta = "//header-wrapper/div[@id='']/div[1]/sbox[1]/div[1]/searchbox[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]";
        String fieldFecha= "//header-wrapper/div[@id='']/div[1]/sbox[1]/div[1]/searchbox[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
        String numberDateIda = "//body/div[3]/div[1]/div[5]/div[2]/div[4]/span[4]/span[1]";
        String numberDateRegreso = "//body/div[3]/div[1]/div[5]/div[2]/div[4]/span[8]/span[1]";
        String btnComprar = "//header-wrapper/div[@id='']/div[1]/sbox[1]/div[1]/searchbox[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[5]/div[1]/a[1]";
        String checkboxRegreso = "//i[@class='checkbox-check sbox-3-icon-checkmark -mr1 sbox-ui-icon']";
        String locatorHoraIda = "//header-wrapper/div[@id='']/div[1]/sbox[1]/div[1]/searchbox[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]";
        String locatorHoraRegreso = "//header-wrapper/div[@id='']/div[1]/sbox[1]/div[1]/searchbox[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]";
        String locatorPasajeros = "//header-wrapper/div[@id='']/div[1]/sbox[1]/div[1]/searchbox[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]";
        String locatorMenorEdad = "//body/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[2]";
        String locatorDropMenorEdad = "//body/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/select[1]";
        String locatorComprar = "/html/body/app-root/results/div/div[4]/div[1]/transfer-cluster/div/div/div[2]/ds-cluster-pricebox/div/div[1]/div[2]/button";
        String locatorVerMapa = "//a[contains(text(),'Ver mapa')]";
        String locatorMenosZoom = "//body/app-root[1]/results[1]/div[1]/div[2]/div[1]/transfers-map[1]/section[1]/map-modal[1]/div[1]/div[2]/gmap[1]/div[1]/div[1]/div[1]/div[8]/div[1]/div[1]/div[1]/button[2]";
        String locatorCerrarMapa = "//body/app-root[1]/results[1]/div[1]/div[2]/div[1]/transfers-map[1]/section[1]/map-modal[1]/div[1]/div[1]/i[1]";


        System.out.println("Test Case 1");

        //validate string title pestaña of the page
        Assert.assertEquals("Vuelos baratos, Hoteles, Paquetes y más | Viajes Falabella", driver.getTitle());

        //wait until element is visible - click en traslados
        WebDriverWait driverWithMoreWait = new WebDriverWait(driver,20);

        //click Traslados Page Home
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorTraslados))).click();


        // form element field "desde"
        String wordDesdeLocation = "Santiago";
        WebElement searchFieldLocationDesde = driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldDesde)));
        searchFieldLocationDesde.sendKeys(wordDesdeLocation);
        Thread.sleep(2000);
        searchFieldLocationDesde.sendKeys(Keys.DOWN);
        searchFieldLocationDesde.sendKeys(Keys.ENTER);

        //escribir texto desde donde
        String wordHaciaLocation = "Hyatt";
        WebElement searchFieldLocationHacia = driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldHasta)));
        searchFieldLocationHacia.sendKeys(wordHaciaLocation);
        Thread.sleep(2000);
        searchFieldLocationHacia.sendKeys(Keys.DOWN);
        searchFieldLocationHacia.sendKeys(Keys.ENTER);

        //click checkbox add regreso
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkboxRegreso))).click();

        //clickFecha IDA
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldFecha))).click();

        //click number in date IDA
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(numberDateIda))).click();
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(numberDateRegreso))).click();


        //dropdown Hora Ida
        Select horaIda = new Select(driver.findElement(By.xpath(locatorHoraIda)));
        horaIda.selectByValue("450");

        //dropdown Hora Regreso
        Select horaRegreso = new Select(driver.findElement(By.xpath(locatorHoraRegreso)));
        horaRegreso.selectByValue("600");

        //click en pasajeros
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPasajeros))).click();


        //agregar menor de edad
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorMenorEdad))).click();

        //dropdown menor de edad
        Select agregarMenorYEdad = new Select(driver.findElement(By.xpath(locatorDropMenorEdad)));
        agregarMenorYEdad.selectByValue("7");

        //click Buscar
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnComprar))).click();

       //Get all the handles currently available
        Set<String> handles=driver.getWindowHandles();
        for(String actual: handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                //Switch to the opened tab
                driver.switchTo().window(actual);
            }

        }

        //click ver mapa
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorVerMapa))).click();

        //click en menos zoom
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorMenosZoom))).click();

        //locator Cerrar Ver Mapa
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorCerrarMapa))).click();

        //click btn comprar
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorComprar))).click();

        Thread.sleep(10000);

    }
    @After
    public void close () {
        if (driver != null) {
            System.out.println("Close");
            driver.quit();
        }

    }

    @AfterClass
    public static void closeAll() {

    }
}
