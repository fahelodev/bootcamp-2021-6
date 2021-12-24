package selenium.fFabricio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutomationPracticeTemplate {

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
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void atc01BusquedaDress()throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("dress");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();
        Thread.sleep(3000);
        List<WebElement> resultado = driver.findElements(By.xpath("//*[@id='center_column'] /ul/li"));
        assertTrue(resultado.size()>2);

    }

    @Test
    public void atc02BusquedaChiffonDress()throws InterruptedException {

        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button.btn:nth-child(5)")).click();
        Thread.sleep(3000);
        assertEquals("Printed Chiffon Dress", driver.findElement(By.cssSelector("a.product-name")).getText());

    }

    @Test
    public void atc03Matapulgas() throws InterruptedException {

        //capturamos el buscador en un webElement
        WebElement txtEntrada = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        txtEntrada.sendKeys("liquido matapulgas");
        txtEntrada.sendKeys(Keys.ENTER);
        Thread.sleep(3000);


        WebElement resultado = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
        assertTrue(resultado.getText().equals("No results were found for your search \"liquido matapulgas\""));


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
