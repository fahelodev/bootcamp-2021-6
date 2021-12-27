package selenium.mguzman;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Dic_24 {

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
        driver.get("https://www.amazon.com/-/es/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void N24_Dic(){
        //Body Page
        driver.findElement(By.xpath("/html/body")).click();
        //Click en tarjetas de regalo
        driver.findElement(By.xpath("//div[@id=\"nav-xshop\"]/a[4]")).click();
        //Filtramos por marca
        driver.findElement(By.xpath("//a[@data-nav-key=\"ab:gc-subnav-flyout-content-5,gc-subnav-flyout-promo-5:verticalstores-subnav-flyout\"]")).click();
        //Seleccionamos Google play
        driver.findElement(By.xpath("//div[@id=\"s-refinements\"]/div[3]/ul/li[2]")).click();
        //Creamos una lista para ver cuantos articulos hay relacionado con el resultado de la pagina
        List<WebElement> result = driver.findElements(By.xpath("//h2//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
        //Realizamos el hacer para comprobar la prueba
        Assert.assertEquals(11,result.size());



    }
}
