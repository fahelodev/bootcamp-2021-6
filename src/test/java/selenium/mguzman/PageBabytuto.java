package selenium.mguzman;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageBabytuto {

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
        driver.get("https://www.babytuto.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void atc_extra(){
        //Cerramos la pestaña de suscripción
        driver.findElement(By.xpath("//button[@class=\"close\"]")).click();
        //Seleccionamos la pestaña de coches
        driver.findElement(By.xpath("//div//ul//a[@href=\"javascript:;\"]")).click();
        //Seleccionamos accesorios para coche
        driver.findElement( By.xpath("//ul//a[@href=\"/categoria/accesorios-para-coches\"]")).click();
        //Filtramos por BBpro
        driver.findElement(By.xpath("//div[@class=\"filter\"][4]/ul/li[5]/a/span[@class=\"lbl\"]")).click();
        //Busca el path de BBpro
        String bbpro = driver.findElement(By.xpath("//div[@class=\"items lst-vertical\"]/div//div[2]/div/a")).getText();
        //comprueba que es BBpro el articulo
        Assert.assertEquals("BBPRO",bbpro);
    }

}
