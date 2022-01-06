package Test_Falabella;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.font.FontRenderContext;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ATC_Alojamientos {
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
        //Page practice
        driver.get("https://www.viajesfalabella.cl/hoteles/ ");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void TC001_BuscarAlojamientoSinFechaNacional(){
        //buscar Arica
    driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus.sbox-destination.sbox-primary.undefined")).sendKeys("Arica");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    //Click en el autocompletado
    driver.findElement(By.cssSelector("span.item-text")).click();
    //Seleccionar Checkbox
    driver.findElement(By.cssSelector("i.checkbox-check.sbox-3-icon-checkmark.-mr1")).click();
    //Buscar
    driver.findElement(By.cssSelector("div.sbox-button-container")).click();
    //Comparacion con Asserts
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        String Result = driver.findElement(By.cssSelector("h2.eva-3-h2.tag-text-heading")).getText();
        Assert.assertEquals("Hoteles destacados en Arica", Result);
    }
    @Test
    public void TC002_FiltrarPorEstrellas() throws InterruptedException {
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus.sbox-destination.sbox-primary.undefined")).sendKeys("Arica");
        Thread.sleep(3000);
        //Click en el autocompletado
        driver.findElement(By.cssSelector("span.item-text")).click();
        //Seleccionar Checkbox
        driver.findElement(By.cssSelector("i.checkbox-check.sbox-3-icon-checkmark.-mr1")).click();
        //Buscar
        driver.findElement(By.cssSelector("div.sbox-button-container")).click();
        //Click en estrellas
        driver.findElement(By.xpath("//span[text()='Estrellas']")).click();
        Thread.sleep(3000);
        //Seleccionar 3 estrellas
        driver.findElement(By.xpath("//em[@class=\"filter-name\" and text()=\"3\"]")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'filter-tags-wrapper')]//*[contains(@class, '-primary')]/em")).click();
        Thread.sleep(4000);
        //Seleccionar primera opcion
        driver.findElement(By.xpath("//div[@class=\"cluster-content\"][1]")).click();
        //Switch entre tabs
        String mainTab= driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual: handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
                Thread.sleep(2000);
            }
        }
        //AssertEquals
        String result = driver.findElement(By.xpath("//span[text()='Amaru Express']")).getText();
        Assert.assertEquals("Amaru Express", result);

    }
    @Test
    public void TC003_CheckoutAlojamientoInternacional() throws InterruptedException {
        //Destacados en Brasil -Rio de Janeiro
        driver.findElement(By.cssSelector(".sbox-main-focus")).sendKeys("Rio de Janeiro");
        driver.findElement(By.xpath("//*[contains(@class, 'ac-container')]/div/ul/li/span")).click();
        //Seleccion de fechas
        driver.findElement(By.cssSelector("input.input-tag.sbox-checkin-date")).click();
        driver.findElement(By.xpath("//*[contains(@class, '_dpmg2--month-active')]//span[text()='25']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@class, '_dpmg2--months')]/div[2]/div[4]/span[10]/span")).click();
        driver.findElement(By.xpath("//em[text()='Aplicar']")).click();
        //Buscar
        driver.findElement(By.cssSelector(".sbox-search .btn-text")).click();
        //Seleccionar Hotel Royalty
        driver.findElement(By.xpath("//span[text()='Royalty Barra Hotel']")).click();
          //Switch entre tabs
            String mainTab= driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
        for (String actual: handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
                Thread.sleep(2000);
            }
        }
        //Mostrar fotos del hotel
        driver.findElement(By.xpath("//button[text()='Ver galería']")).click();
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.cssSelector(".arrow-right")).click();
            Thread.sleep(1000);
        }
        driver.findElement(By.cssSelector("Body")).sendKeys(Keys.ESCAPE);
        //Mostrar mapa (Ubicación)
        driver.findElement(By.xpath("//em[text()='Ver en mapa']")).click();
        Thread.sleep(1000);
        Actions act = new Actions(driver);
        for(int i = 0;i<3;i++) {
            WebElement ele = driver.findElement(By.xpath("//*[@aria-label='Map']/div[2]"));
            act.doubleClick(ele).perform();
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@class, 'modal-fullscreen-close')]")).click();
        //Seleccionar Reserva
        driver.findElement(By.xpath("//em[text()='Reservar ahora']")).click();
        Thread.sleep(2000);
        //Agregar Paquetes
        driver.findElement(By.xpath("//*[contains(@class, 'activity-highlight-slide')]//*[contains(@class, 'highlight-card-container')]")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'detail-actions')]//*[contains(@class, 'btn-text')]")).click();
        //Confirmar reserva y paquetes
        driver.findElement(By.cssSelector(".pricebox-sticky-button .btn-text")).click();
        //Rellenar datos
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@name='formData.paymentData.cardPayments[0].card.number']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@name='formData.paymentData.cardPayments[0].card.holderName']")).sendKeys("Mionel Lessi");
        driver.findElement(By.xpath("//*[@name='formData.paymentData.cardPayments[0].card.expirationDate']")).sendKeys("08/29");
        driver.findElement(By.xpath("//*[@name='formData.paymentData.cardPayments[0].card.securityCode']")).sendKeys("689");
        driver.findElement(By.xpath("//*[@name='formData.paymentData.cardPayments[0].cardHolderIdentification.number']")).sendKeys("20386159");
        //driver.findElement(By.id("0viqcqnx7mmzggd1kle0vf")).sendKeys("Mionel");
        //driver.findElement(By.id("tpsjku910au0yanl8dwah")).sendKeys("Lessi");
        //driver.findElement(By.id("oo3zb4ivisqb57p3vdwjvk")).sendKeys("Mionel_LessiARG@gmail.com");
        //driver.findElement(By.id("iu6v8hnhxmdt2q4iwilqi")).sendKeys("Mionel_LessiARG@gmail.com");
        //driver.findElement(By.id("mxvuvfrwjcfnn24hyzt4rj")).click();
        //driver.findElement(By.xpath("//span[text()='Argentina (54)']")).click();
        //driver.findElement(By.xpath("//*[@name='formData.contactData.phones[0].areaCode']")).sendKeys("1234");
        //driver.findElement(By.xpath("//*[@name='formData.contactData.phones[0].number']")).sendKeys("1234567");
        //driver.findElement(By.xpath("//*[contains(@class, 'terms-checkbox')]//*[contains(@class, 'checkbox-check')]")).click();
        //Comparacion de resultados
        String result = driver.findElement(By.cssSelector(".dm-title-container .eva-3-h3")).getText();
        Assert.assertEquals("Royalty Barra Hotel", result);
    }

    @After
    public void close () {
        if (driver != null) {
            System.out.println("Close");
            driver.close();
        }
    }
}
