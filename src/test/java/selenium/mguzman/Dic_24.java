package desafio.equipo2.selenium.mguzman;
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
    public void N24_Dic() throws InterruptedException {
        //Body Page
        driver.findElement(By.xpath("/html/body")).click();
        //click menu.
        driver.findElement(By.xpath("//span[@class='hm-icon-label']")).click();
        Thread.sleep(2000);
        //click en electronico
        driver.findElement(By.xpath("//ul[@class='hmenu hmenu-visible']//div[.='Electrónicos']")).click();
        //Accesorios
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[.='Accesorios y suministros']")).click();
        //Click en tarjetas de regalo
        driver.findElement(By.xpath("//div[@id=\"nav-xshop\"]/a[4]")).click();
        //Filtramos por marca con un Mouse Hover
        Actions action = new Actions(driver);
        WebElement a = driver.findElement(By.xpath("//header[@id=\"navbar-main\"]/div/div[6]/div//a[7]/span"));
        action.moveToElement(a).perform();
        //Click en Play Store
        driver.findElement(By.xpath("//div[.='Google Play']")).click();
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
