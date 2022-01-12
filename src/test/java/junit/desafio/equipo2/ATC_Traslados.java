package junit.desafio.equipo2;

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
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ATC_Traslados {

    private WebDriver driver;
    String currentHandle = "https://www.viajesfalabella.cl/";

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        driver = new ChromeDriver();
        driver.get(currentHandle);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void TC001_TrasladoDesdeElAeropuerto() throws InterruptedException {


        String locatorTraslados = "//i[@title='Traslados']";
        String fieldDesde = ".sbox-origin";
        String fieldHasta = "//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']";
        String fieldFecha = "//input[@placeholder='Arribo']";
        String numberDateIda = "//body/div[3]/div[1]/div[5]/div[2]/div[4]/span[4]/span[1]";
        String numberDateRegreso = "//body/div[3]/div[1]/div[5]/div[2]/div[4]/span[8]/span[1]";
        String checkboxRegreso = "//i[@class='checkbox-check sbox-3-icon-checkmark -mr1 sbox-ui-icon']";
        String locatorHoraIda = "//*[contains(@class, 'sbox-time-arrival')]";
        String locatorHoraRegreso = ".sbox-time-departure";
        String locatorPasajeros = "//*[contains(@class, 'sbox-distri-input')]//*[contains(@class, 'input-container')]";
        String locatorMenorEdad = "//*[contains(@class, '_pnlpk-stepper-minors')]//*[contains(@class, 'steppers-icon-right')]";
        String locatorDropMenorEdad = "//*[contains(@class, '_pnlpk-minor-age-select-last-item')]//*[contains(@class, 'select-tag')]";
        String btnComprar = "//em[contains(text(),'Buscar')]";
        String locatorComprar = "//*[contains(@class, '-eva-3-mb-lg')]//*[contains(@class, 'eva-3-btn')]";
        String locatorVerMapa = "//a[contains(text(),'Ver mapa')]";
        String locatorMenosZoom = "//button[@title='Alejar']";
        String locatorCerrarMapa = "//*[contains(@class, 'map')]//*[contains(@class, 'modal-close')]";

        System.out.println("Test Case 1");

        //validate string title pestaña of the page
        Assert.assertEquals("Vuelos baratos, Hoteles, Paquetes y más | Viajes Falabella", driver.getTitle());

        //wait until element is visible - click en traslados
        WebDriverWait driverWithMoreWait = new WebDriverWait(driver, 20);

        //click Traslados Page Home
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorTraslados))).click();


        // form element field "desde"
        String wordDesdeLocation = "Aeropuerto Arturo Merino Benitez, Santiago de Chile, Chile";
        WebElement searchFieldLocationDesde = driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(fieldDesde)));
        searchFieldLocationDesde.sendKeys(wordDesdeLocation);
        Thread.sleep(500);
        searchFieldLocationDesde.sendKeys(Keys.DOWN);
        searchFieldLocationDesde.sendKeys(Keys.ENTER);

        //escribir texto desde donde
        String wordHaciaLocation = "Hyatt Centric Las Condes Santiago - Enrique Foster, Las Condes, Chile";
        WebElement searchFieldLocationHacia = driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldHasta)));
        searchFieldLocationHacia.sendKeys(wordHaciaLocation);
        Thread.sleep(500);
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
        Select horaRegreso = new Select(driver.findElement(By.cssSelector(locatorHoraRegreso)));
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
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
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


        String textValidate = driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='eva-3-h3 -eva-3-tc-gray-0']"))).getText();
        //Validate Traslado de Aeropuerto a Hotel
        Assert.assertEquals("De Aeropuerto Arturo Merino Benitez a Hyatt Centric Las Condes Santiago", textValidate);


    }

    @Test
    public void TC002TrasladoHaciaElAeropuerto() throws InterruptedException {


        String locatorTraslados = "//i[@title='Traslados']";
        String checkHacia = ".sbox-radio-buttons > span:nth-of-type(2) > label > i";
        String fieldDesde = "//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']";
        String fieldHasta = "//input[@placeholder='Ingresa un aeropuerto']";
        String fieldFecha= "//input[@placeholder='Partida']";
        String numberDateIda = "//div[@class='datepicker-transfers-hotel-to-airport sbox-v4-components']//div[2]//div[4]//span[14]";
        String aplicar = "//*[contains(@class, '_dpmg2--show')]//*[contains(@class, '_dpmg2--desktopFooter-button-apply')]";
        String locatorHoraIda = ".sbox-time-departure";
        String locatorPasajeros = ".sbox-distri-input .input-container";
        String locatorMenorEdad = "//*[contains(@class, '_pnlpk-stepper-minors')]//*[contains(@class, 'steppers-icon-right')]";
        String locatorDropMenorEdad = "//*[contains(@class, '_pnlpk-minor-age-select-last-item')]//*[contains(@class, 'select-tag')]";
        String btnHaciaBuscar = "//*[contains(@class, 'sbox-search')]";


        System.out.println("Test Case 2");

        //validate string title pestaña of the page
        Assert.assertEquals("Vuelos baratos, Hoteles, Paquetes y más | Viajes Falabella", driver.getTitle());

        //wait until element is visible - click en traslados
        WebDriverWait driverWithMoreWait = new WebDriverWait(driver,20);

        //click Traslados Page Home
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorTraslados))).click();

        //check Traslados desde hotel
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(checkHacia))).click();

        //check Traslados desde hotel
        String wordHaciaLocation = "santiago marriot chile";
        WebElement searchFieldLocationHacia = driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldDesde)));
        searchFieldLocationHacia.sendKeys(wordHaciaLocation);
        Thread.sleep(500);
        searchFieldLocationHacia.sendKeys(Keys.DOWN);
        searchFieldLocationHacia.sendKeys(Keys.ENTER);

        // form element field "hasta" aeropuerto
        String wordDesdeLocation = "Aeropuerto Arturo Merino Benitez";
        WebElement searchFieldLocationDesde = driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldHasta)));
        searchFieldLocationDesde.sendKeys(wordDesdeLocation);
        Thread.sleep(500);
        searchFieldLocationDesde.sendKeys(Keys.DOWN);
        searchFieldLocationDesde.sendKeys(Keys.ENTER);

        //clickFecha IDA
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldFecha))).click();

        //click number in date IDA
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(numberDateIda))).click();
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(aplicar))).click();

        //dropdown Hora Ida
        Select horaIda = new Select(driver.findElement(By.cssSelector(locatorHoraIda)));
        horaIda.selectByValue("450");

        //click en pasajeros
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorPasajeros))).click();


        //agregar menor de edad
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorMenorEdad))).click();

        //dropdown menor de edad
        Select agregarMenorYEdad = new Select(driver.findElement(By.xpath(locatorDropMenorEdad)));
        agregarMenorYEdad.selectByValue("0");

        //agregar menor de edad dos
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorMenorEdad))).click();

        //dropdown menor de edad dos
        Select agregarMenorYEdadDos = new Select(driver.findElement(By.xpath(locatorDropMenorEdad)));
        agregarMenorYEdadDos.selectByValue("17");

        //click Buscar
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnHaciaBuscar))).click();

        //Get all the handles currently available
        Set<String> handles=driver.getWindowHandles();
        for(String actual: handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                //Switch to the opened tab
                driver.switchTo().window(actual);
            }

        }

        //click Buscar
        driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='eva-3-btn -md -eva-3-fwidth -secondary']"))).click();

        String textValidate = driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='eva-3-h3 -eva-3-tc-gray-0']"))).getText();
        //Validate Traslado de Hotel a Eropuerto
        Assert.assertEquals("De hotel marriot a Aeropuerto Arturo Merino Benitez", textValidate);


    }


    @Test
    public void TC003ReservarEnDólarEnServiciosDeTraslados() throws InterruptedException {


        String locatorTraslados = "//i[@title='Traslados']";
        String cardAuto = "//html/body/app-root/div/div[5]/div/offers/div/div[2]/div/offer-card/div/a/div/div/img";
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

        String textValidateMoneda = driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='eva-3-container results-container -eva-3-pt-lg']//div[1]//transfer-cluster[1]//div[1]//div[1]//div[2]//ds-cluster-pricebox[1]//div[1]//div[1]//div[1]//div[2]//span[1]"))).getText();
        //Validate Traslado de Hotel a Eropuerto
        Assert.assertEquals("US$", textValidateMoneda);

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
