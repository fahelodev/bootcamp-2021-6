package selenium.mguzman;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
        //click menu.
        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
        //click en electronico
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[7]/a")).click();
        //Accesorios
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[5]/li[3]/a")).click();
        //Click en tarjetas de regalo
        driver.findElement(By.xpath("//div[@id=\"nav-xshop\"]/a[4]")).click();
        //Filtramos por marca con un Mouse Hover
        Actions action = new Actions(driver);
        WebElement a = driver.findElement(By.xpath("//header[@id=\"navbar-main\"]/div/div[6]/div//a[7]/span"));
        action.moveToElement(a).perform();
        //Click en Play Store
        driver.findElement(By.xpath("//*[@id=\"nav-flyout-ab:gc-subnav-flyout-content-5,gc-subnav-flyout-promo-5:verticalstores-subnav-flyout\"]/div[2]/div/div/ul/li[1]/a")).click();
        //Cantidad de resultados
        String results = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span")).getText();
        String [] array = results.split(" ");
        //Los elementos de la array los transformamos a entero
        int number = Integer.parseInt(array[0]);
        //lista para recorrer los articulos
        List <WebElement> result = driver.findElements(By.xpath("//div[@class=\"sg-col-inner\"]//div[contains(@class,\"s-result-list\")]//span[contains(text(),\"Google\")]"));

        //como expect se deja number para obtener cantidad de articulo sirve si llega a cambiar en un futuro
        Assert.assertEquals(number,result.size());



    }
}
