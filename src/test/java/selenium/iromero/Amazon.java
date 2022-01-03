package desafio.equipo2.selenium.iromero;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class    Amazon {
    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();

    }

    //se instancia el driver y se le entrega la url a testear
    @Before
    public void initial() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testAmazon() throws InterruptedException {
        //inicializacion actions
        Actions builder = new Actions(driver);

        //click en ventana que aparece
        driver.findElement(By.xpath("//input[@class=\"a-button-input\"]")).click();

        //elemento de idioma
        WebElement idiom = driver.findElement(By.xpath("//span[@class=\"icp-nav-link-inner\"]"));
        //hover al elemento
        builder.moveToElement(idiom).perform();

        //click en idioma que tenga el texto ingles
        driver.findElement(By.xpath("//a[contains(@class,\"nav-link\")]//span[contains(text(),\"English\")]")).click();
        Thread.sleep(500);

        //click en todas las categorias
        driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
        Thread.sleep(600);

        //click en categoria electronica
        driver.findElement(By.xpath("//div[@id=\"hmenu-content\"]/ul/li/a/div[contains(text(),\"Electronics\")]")).click();
        Thread.sleep(500);

        //click en accesorios y suplementos
        driver.findElement(By.xpath("//ul[@class=\"hmenu hmenu-visible hmenu-translateX\"]/li/a[contains(text(),\"Accessories & Supplies\")]")).click();
        Thread.sleep(500);
        //click en tarjetas de relajos
        driver.findElement(By.xpath("//a[contains(text(),\"Gift Cards\")]")).click();

        //elemento de marcas
        WebElement brand = driver.findElement(By.xpath("//a/span[contains(text(),\"Brand\")]"));

        //hover en marcas
        builder.moveToElement(brand).perform();

        //click en marca de google
        driver.findElement(By.xpath("//div[@class=\"nav-template nav-flyout-content\"]//ul/li/a/div[contains(text(),\"Google\")]")).click();

        //obtencion de cantidad encontradas
        String result = driver.findElement(By.xpath("//div/span[contains(text(),\"results\")]")).getText();
        //convertir en array para obtener solo el numero
        String[] num = result.split(" ");

        //convertir de string a entero
        int number = Integer.parseInt((num[0]));

        //obtener todos elementos que contenga un texto "Google"
        List<WebElement> result_search = driver.findElements(By.xpath("//div[@class=\"sg-col-inner\"]//div[contains(@class,\"s-result-list\")]//span[contains(text(),\"Google\")]"));

        //assert de cantidad de elementos sean todos de google
        Assert.assertEquals(number, result_search.size());

    }

    //cerrado de chrome driver despues de cada test
    @After
    public void close(){
        if (driver != null) {
            driver.close();
        }
    }
}
