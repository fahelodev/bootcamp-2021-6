package desafio.equipo1;

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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class ViajesFalabellaTest {
    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    //se instancia el driver y se le entrega la url a testear
    @Before
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().window().maximize();

    }
    @Test
    public void atc01_AlojamientoBasico() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Alojamientos\")]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,\"destination\")]"))).sendKeys("Rio");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"ac-group-container\"]/ul/li"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"checkbox\")]//label"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"sbox-button\")]//a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"filter-tags-wrapper\"]//span[contains(text(),\"Estrellas\")]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,\"-show-tooltip\")]//em[contains(text(),\"5\")and contains(@class,\"filter-name\")]"))).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,\"-show-tooltip\")]//em[contains(text(),\"Aplicar\")]"))).click();
        Thread.sleep(1000);
        List <WebElement> stars = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[contains(@class,\"card-rating\")])[1]//i")));
        Assert.assertEquals(5,stars.size());
    }

    @Test
    public void atc01_PaqueteBasico() {
        // Sincronizacion explicita
        WebDriverWait d = new WebDriverWait(driver, 5);
        // Instanciar objeto desplegable origen
        WebElement origen = driver.findElement(By.cssSelector(".sbox-origin"));
        origen.sendKeys("Arturo Merino");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item-text")));
        origen.sendKeys(Keys.ENTER);
        // Instanciar objeto desplegable destino
        WebElement destino = driver.findElement(By.cssSelector(".sbox-destination"));
        destino.sendKeys("Lima");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".-active")));
        destino.sendKeys(Keys.ENTER);
        // Click al boton swtich "Todavía no he decidido la fecha"
        WebElement switch1 = driver.findElement(By.cssSelector(".switch-container"));
        switch1.click();
        // Seleccionamos el mes de enero en el SELECT
        Select m = new Select(driver.findElement(By.cssSelector(".sbox-month-seletor")));
        m.selectByValue("2022-01");
        // Click boton BUSCAR
        WebElement btn = driver.findElement(By.cssSelector("a.-md"));
        btn.click();
        // Click filtro noches
        WebElement filter = driver.findElement(By.cssSelector("span.filter-tags-wrapper:nth-child(2) > div:nth-child(1)"));
        filter.click();
        // Click en boton "Mas 8 noches"
        WebElement filter_btn = driver.findElement(By.cssSelector(".filters-tooltip > div:nth-child(1) > div:nth-child(1) > div:nth-child(5)"));
        filter_btn.click();
        // Click boton Aplicar
        WebElement add = driver.findElement(By.cssSelector(".filters-tooltip > div:nth-child(2) > a:nth-child(2)"));
        add.click();
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".DESTINATION")));
        // Verificar que los filtros esten aplicados
        String text1 = driver.findElement(By.cssSelector("span.filter-tags-wrapper:nth-child(1) > div:nth-child(1) > p:nth-child(1)")).getText();
        String text2 = driver.findElement(By.cssSelector("span.filter-tags-wrapper:nth-child(2) > div:nth-child(1) > p:nth-child(1)")).getText();
        Assert.assertEquals("Enero", text1);
        Assert.assertEquals("Más de 8 noches", text2);
    }

    @Test
    public void atc01_TrasladoBasico(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Traslados\")]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sbox-radio-buttons']//i[@class='radio-circle sbox-radio-circle'])[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[contains(@placeholder, 'aeropuerto')]"))).sendKeys("Córdoba");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac-group-container']//span[@class='item-text']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[contains(@placeholder, 'hotel')]"))).sendKeys("Amerian Park Hotel");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac-container']//span[contains(text(), 'Amerian Córdoba')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='input-container']//input[contains(@placeholder, 'Partida')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='_dpmg2--dates']//span[contains(text(), '11')])[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--date-footer']//em[contains(@class, 'apply')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select-container']//select[@class='select-tag sbox-time-departure']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='select-container']//option[text()='18:00'])[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='select-container']//select[contains(@class, 'time')])[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sbox-button-container']"))).click();
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sub-nav-container']//label/span[2]"))).getText();
        String [] arr = value.split(" ");
        String value2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricebox-value']/span[2]"))).getText();
        Assert.assertEquals(arr[1], value2);
    }

    @Test
    public void atc02_AlojamientoMedio() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Alojamientos\")]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,\"destination\")]"))).sendKeys("Rio");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"ac-group-container\"]/ul/li"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"checkin-date\")]"))).click();

        while(true){
            String active = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,\"month-active\")]/div[contains(@class,\"month-title\")]/span"))).getText();
            if (!active.equals("Mayo")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"controls-next\")]"))).click();
            }else{break;}
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[31]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,\"button-apply\")]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"guests-container\")]/div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"stepper-minors\")]//a[not(contains(@class,\"disable\"))]"))).click();
        Select age = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"select-container\"]/select"))));
        age.selectByIndex(15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"medium-down\")]/a[contains(@class,\"link-right\")]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"sbox-button\"]//a"))).click();
        Select order = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aloha-select[contains(@class,\"sorting\")]//select"))));
        order.selectByIndex(2);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aloha-checkbox-filter/ul/li//span[contains(text(),\"Desayuno\")]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aloha-checkbox-filter//em/i"))).click();
        String specf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"pricebox-top-container\"]//p[contains(text(),\"3 personas\")]"))).getText();
        Assert.assertEquals("30 noches, 3 personas",specf);
    }

    @Test
    public void atc02_PaqueteMedio(){
        // Sincronizacion explicita
        WebDriverWait d = new WebDriverWait(driver, 5);
        // Instanciar objeto desplegable origen
        WebElement origen = driver.findElement(By.cssSelector(".sbox-origin"));
        origen.sendKeys("bue");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item-text")));
        origen.sendKeys(Keys.ENTER);
        // Instanciar objeto desplegable destino
        WebElement destino = driver.findElement(By.cssSelector(".sbox-destination"));
        destino.sendKeys("mia");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".-active")));
        destino.sendKeys(Keys.ENTER);
        // Click en box fechas
        WebElement fechas = driver.findElement(By.cssSelector(".sbox-checkin-date"));
        fechas.click();
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._dpmg2--show > div:nth-child(2)")));
        WebElement ida_nro = driver.findElement(By.cssSelector("._dpmg2--show > div:nth-child(5) > div:nth-child(2) > div:nth-child(4) > span:nth-child(11) > span:nth-child(1)"));
        ida_nro.click();
        WebElement vuelta_nro = driver.findElement(By.cssSelector("._dpmg2--show > div:nth-child(5) > div:nth-child(2) > div:nth-child(4) > span:nth-child(25) > span:nth-child(1)"));
        vuelta_nro.click();
        // Click boton aplicar
        WebElement btn = driver.findElement(By.cssSelector("._dpmg2--show > div:nth-child(6) > div:nth-child(2) > button:nth-child(2) > em:nth-child(1)"));
        btn.click();
        // Click en box habitaciones
        WebElement room = driver.findElement(By.cssSelector(".sbox-distri-input > div:nth-child(1)"));
        room.click();
        // Agregar adulto
        WebElement plus = driver.findElement(By.cssSelector("div._pnlpk-dynamicContent:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(4)"));
        plus.click();
        // Click en boton Aplicar
        WebElement btn1 = driver.findElement(By.cssSelector("._pnlpk-panel--show > div:nth-child(2) > a:nth-child(1)"));
        btn1.click();
        // Click boton Buscar
        WebElement search = driver.findElement(By.cssSelector("em.btn-text:nth-child(2)"));
        search.click();
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.package-title:nth-child(1)")));
        String text = driver.findElement(By.cssSelector("h3.package-title:nth-child(1)")).getText();
        Assert.assertEquals("Este es el paquete perfecto para tí. ¡Empieza a vivir tu viaje!", text);
    }

    @Test
    public void atc02_TrasladoMedio(){

    }

    @Test
    public void atc03_AlojamientoComplejo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Alojamientos\")]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,\"destination\")]"))).sendKeys("Rio");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"ac-group-container\"]/ul/li"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"checkin-date\")]"))).click();

        while(true){
            String active = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,\"month-active\")]/div[contains(@class,\"month-title\")]/span"))).getText();
            if (!active.equals("Mayo")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"controls-next\")]"))).click();
            }else{break;}
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[31]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,\"button-apply\")]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"guests-container\")]/div"))).click();

    }

    @Test
    public void atc03_PaqueteComplejo() throws InterruptedException {



    }

    @Test
    public void atc03_TrasladoComplejo(){

    }
   @After
    public void close(){
        if (driver != null) {
            //driver.quit();
        }
    }



}
