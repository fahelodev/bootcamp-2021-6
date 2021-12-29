package Test_Falabella;
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
    public void reservarEnDolaresEnServiciosDeTraslados() throws InterruptedException {


        String locatorTraslados = "//i[@title='Traslados']";
        String cardAuto = "//div[@class='content-wrapper eva-3-container module-MultiproductOffersModule section section-4']//offer-card[1]//div[1]//a[1]//div[1]//div[1]//img[1]";
        String modificar = "//em[@class='btn-text -eva-3-hide-small']";
        String monedaDolor= "";
        String dolar= "//select[@id='currency-select']";
        String comprar = "//em[normalize-space()='Comprar']";
        String locatorBtnVerMas = "//div[@class='content-wrapper eva-3-container module-MultiproductOffersModule section section-4']//offers//div[@class='offer-module-container']//div//em[@class='btn-text'][contains(text(),'Ver más ofertas')]";
        String btnModificar = "//span[@class='eva-3-btn -secondary -md -icon -eva-3-hide-small']";
        String dolarChange = "#currency-select";
        String FiltroTrasladoCompartido = "//div[@class='col -sm-12 -md-8']//li[2]";
        String btnComprar = "//ds-cluster-pricebox//div[@class='pricebox-action']";

        System.out.println("Test Case 1");

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
