package desafio.equipo2.selenium.rgutierrez;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationAmazon {

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
        // Definimos un implicit wait de 5 segundos
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void atc01_muestraTarjetasGooglePlay(){
        System.out.println("Test Case atc01_muestraTarjetasGooglePlay");

        driver.get("https://www.amazon.com/");

        // navegamos por el menu lateral
        driver.findElement(By.cssSelector("#nav-hamburger-menu")).click();
        driver.findElement(By.xpath("//a[contains(@data-menu-id, '5')] // div[contains(text(),'Electrónicos')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Accesorios y suministros')]")).click();
        driver.findElement(By.xpath("//div[@id='nav-xshop']//a[contains(text(),'Tarjetas de Regalo')]")).click();

        // guardamos los webelements para generar un action builder
        WebElement porMarca = driver.findElement(By.xpath("//div[@id='nav-progressive-subnav'] // span[contains(text(),'Por marca')]"));
        WebElement recargarSaldo = driver.findElement(By.xpath("//div[@id='nav-progressive-subnav'] // span[contains(text(),'Recargar tu saldo')]"));

        // ejecutamos el action builder para hacer un "hover" en marca
        Actions builder = new Actions(driver);
        builder.moveToElement(recargarSaldo).moveToElement(porMarca).perform();

        // seleccionamos google play del menu flyout
        driver.findElement(By.xpath("//*[@id='nav-flyout-ab:gc-subnav-flyout-content-5,gc-subnav-flyout-promo-5:verticalstores-subnav-flyout'] // div[contains(text(),'Google Play')]")).click();

        // Guardamos los resultados en una lista
        List<WebElement> resultados = driver.findElements(By.xpath("//div[contains(@class, 's-result-list')] // span[contains(@class, 'a-size-base-plus a-color-base a-text-normal')]"));

        boolean alleGoogleProducts = true;

        // Verificamos que todos los resultados contengan el texto "Google Play"
        for (int i = 0; i < resultados.size(); i++) {
            if(!resultados.get(0).getText().contains("Google Play")) {
                alleGoogleProducts = false;
            }
        }

        Assert.assertTrue( alleGoogleProducts);
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