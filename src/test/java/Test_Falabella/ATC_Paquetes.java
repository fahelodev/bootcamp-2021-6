package Test_Falabella;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ATC_Paquetes {
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
        driver.get("https://www.viajesfalabella.cl/paquetes/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    @Test
    public void TC002_VueloYAlojamiento()throws InterruptedException{
        
        /* 1. Seleccionar paquete de Vuelo y Alojamiento
        2. Ingresar Origen
        3. Ingresar Destino nacional
        4. Seleccionar fecha de ida
        5. Seleccionar fecha de vuelta
        5. Añadir cantidad de habitaciones y adultos
        6. Hacer click en el botón buscar*/

        // caja origen //*[@id="searchbox"]/div/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div/input
        WebElement origen = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div/input"));
        String txtOrigen = "Santiago de Chile, Santiago, Chile";
        origen.sendKeys(txtOrigen);
        Thread.sleep(2000);
        origen.sendKeys(Keys.DOWN);
        origen.sendKeys(Keys.ENTER);

        // caja destino //*[@id="searchbox"]/div/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div/input
        WebElement destino = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div/input"));
        String txtDestino = "Arica, Arica y Parinacota, Chile";
        destino.sendKeys(txtDestino);
        Thread.sleep(2000);
        destino.sendKeys(Keys.DOWN);
        destino.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector(".sbox-checkin-date")).click();

        // 7 de enero  //html/body/div[5]/div/div[5]/div/div[4]/span[7]/span
        driver.findElement(By.xpath("//html/body/div[5]/div/div[5]/div/div[4]/span[7]/span")).click();
        Thread.sleep(1000);
        // 13 de enero //html/body/div[5]/div/div[5]/div/div[4]/span[13]/span
        driver.findElement(By.xpath("//html/body/div[5]/div/div[5]/div/div[4]/span[13]/span")).click();

        //btn aplicar fecha //html/body/div[7]/div/div[6]/div[2]/button[2]/em
        driver.findElement(By.xpath("//html/body/div[7]/div/div[6]/div[2]/button[2]/em")).click();

        //btn buscar
        driver.findElement(By.xpath("//em[text()='Buscar']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@class, 'results-items-wrapper')]/aloha-list-view-container/div[2]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button/em")).click();

        String mainTab= driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual: handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
                Thread.sleep(2000);
            }
        }

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

