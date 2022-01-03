package desafio.equipo2.selenium.msabattini;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutomationPracticeAMAZON {

    private WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void act_ESPECIAL_filtroMarcaTarjetaRegalo() throws InterruptedException{

        //Acceder al nav
        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();

        //Tiempo de espera
        WebDriverWait espera_ = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[7]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[5]/li[3]/a")).click();

        //Click en tarjetas de regalo
        espera_.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-xshop\"]/a[4]")));
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]")).click();

        //Click en "por marca"

        //Identificamos el elemento
        WebElement por_marca = driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[7]/span[1]"));
        Actions accion = new Actions(driver); //Instanciamos una objeto de la clase Actions
        accion.moveToElement(por_marca).build().perform(); //Nos movemos hasta el elemento sin dar click

        //Esperamos a que apareza el submenu y damos click en el elemento ---- path a mejorar.
        espera_.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-flyout-ab:gc-subnav-flyout-content-5,gc-subnav-flyout-promo-5:verticalstores-subnav-flyout\"]/div[2]/div/div/ul/li[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"nav-flyout-ab:gc-subnav-flyout-content-5,gc-subnav-flyout-promo-5:verticalstores-subnav-flyout\"]/div[2]/div/div/ul/li[1]/a")).click();

        //Almacenamos los resultados en un List
        List<WebElement> resultados = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div"));

        //Establecemos una variable de control
        boolean control = true;

        //Comprobamos si en la descripción de cada card se encuentra "Google Play"
        for(WebElement resultado_mensaje : resultados){
            String textos = resultado_mensaje.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
            if(!textos.contains("Google Play")){
                control = false;
                break;
            }
        }

        Assert.assertTrue(control);
    }


    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }

    @AfterClass
    public static void closeAll(){
    }


}
