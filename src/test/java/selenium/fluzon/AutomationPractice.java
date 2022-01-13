package selenium.fluzon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

import java.util.List;

public class AutomationPractice {

    private WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test @Ignore
    public void atc01_BusquedaPalabrasClavesCSS(){
        //Cargar la página
        driver.get("http://automationpractice.com/");

        //Introducir "chiffon dress" en el campo de busqueda
        driver.findElement(By.cssSelector("input#search_query_top")).sendKeys("dress");

        //Hacer clic en Search Button
        driver.findElement(By.cssSelector("button[name='submit_search']")).sendKeys("dress");

        //Introducir "chiffon dress" en el campo de busqueda
        List<WebElement> results = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));
        System.out.println(results.size());
        Assert.assertTrue(results.size()>1);
    }

    @Test
    public void atc03_TiendaEmiteMensajeProductoNoEncontrado(){

        //Cargar la página
        driver.get("http://automationpractice.com/");

        //Introducir "chiffon dress" en el campo de busqueda
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("liquido matapulgas");

        //Hacer la busqueda presionando Enter
        driver.findElement(By.cssSelector("#searchbox > button")).sendKeys(Keys.ENTER);

        String text = driver.findElement(By.cssSelector("p.alert.alert-warning")).getText();

        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"",text);

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
