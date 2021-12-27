package selenium.dYanez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.core.StringContains;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationPracticeAmazon{

    WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //wait implicit for list result visible cada vez que vaya a buscar al elemento
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void atcAmazon() throws InterruptedException {
        //En la caja de busqueda poner blo y seleccionar lo pre-buscado
        System.out.println("Test Case 7");
        //cargar page
        driver.get("http://amazon.com/");

       /* 1.- Seleccionar categoria: Electrónicos, Accesorios y Suministros
        2.- Seleccionar Tarjetas de Regalo
        3.- Seleccionar Marca Google Play
        4. Validar que todos los productos visibles sean de Google Play*/

        WebElement clickMenuHamburger = driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]"));
        clickMenuHamburger.click();

        WebElement clickElectronics = driver.findElement(By.xpath("//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[1]/li[7]/a[1]/i[1]"));
        clickElectronics.click();

        WebElement clickAccesorios = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[5]/li[3]/a"));
        clickAccesorios.click();


        WebElement clickTarjetas = driver.findElement(By.xpath("//a[contains(text(),'Tarjetas de Regalo')]"));
        clickTarjetas.click();
        Thread.sleep(400);

        WebElement clickGoogleFilter = driver.findElement(By.xpath("//span[contains(text(),'Google')]"));
        clickGoogleFilter.click();
        Thread.sleep(400);
        String locatorProduct = "//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]";
        List<WebElement> resultSearch = driver.findElements(By.xpath(locatorProduct));
        Thread.sleep(400);
        //firts element title product
        String resultProductExpected = resultSearch.get(0).findElement(By.xpath(locatorProduct)).getText();

        Assert.assertThat(resultProductExpected, StringContains.containsString("Google"));

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

    }




}
