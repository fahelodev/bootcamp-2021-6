package Test_Falabella;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
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
    public void TC002_FiltrarPorEstrellas(){
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus.sbox-destination.sbox-primary.undefined")).sendKeys("Arica");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //Click en el autocompletado
        driver.findElement(By.cssSelector("span.item-text")).click();
        //Seleccionar Checkbox
        driver.findElement(By.cssSelector("i.checkbox-check.sbox-3-icon-checkmark.-mr1")).click();
        //Buscar
        driver.findElement(By.cssSelector("div.sbox-button-container")).click();
        //Click en estrellas
        driver.findElement(By.xpath("//body[1]//app-root//offers-filters//eva-tooltip[4]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //Seleccionar una estrella
        driver.findElement(By.xpath("//body[1]//app-root//offers-filters//eva-tooltip[4]//offers-filters-content[1]/div[1]/eva-checkbox[3]/span[1]/label[1]/span[1]/em[1]")).click();
        driver.findElement(By.cssSelector("a.eva-3-btn.-md.-primary")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //Seleccionar primera opcion
        driver.findElement(By.cssSelector("[title='Amaru Express'] .swiper-slide-active > media-picture > div > div > img")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }
    @After
    public void close () {
        if (driver != null) {
            System.out.println("Close");
            driver.close();
        }

    }

    @AfterClass
    public static void closeAll() {
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }
}
