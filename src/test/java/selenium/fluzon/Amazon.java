package selenium.fluzon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Amazon {

    private WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void atc01_FiltroMarcaTarjetasdeRegalo() throws InterruptedException {
        //Cargar la página
        driver.get("http://amazon.com/");

        driver.findElement(By.cssSelector("#nav-hamburger-menu")).click();

        driver.findElement(By.cssSelector("#hmenu-content a[data-menu-id=\"5\"]")).click();


        driver.findElement(By.xpath("//ul[@data-menu-id='5']//a[text()='Accesorios y suministros']")).click();

        driver.findElement(By.xpath("//div[@id='nav-xshop']//a[text()='Tarjetas de Regalo']")).click();

        //Now Select 'Rock' from sub menu which has got displayed on mouse hover of 'Music'
        WebElement subMenuOption = driver.findElement(By.xpath("//div[@id='nav-subnav']//a[text()='Por marca']"));

        Actions actions = new Actions(driver);

        //Mouse hover menuOption 'Rock'
        actions.moveToElement(subMenuOption).perform();

        Thread.sleep(3000);

        /*
        List<WebElement> results = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));
        System.out.println(results.size());
        Assert.assertTrue(results.size()>1);


 */
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
