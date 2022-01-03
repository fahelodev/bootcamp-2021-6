package desafio.equipo2.selenium.nparco;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Locale;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class AutomationPracticeTemplate {

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @Test
    public void atc01BusquedaPalabraClave() {
        System.out.println("Test Case 1");
        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector(".btn.button-search")).click();
        List<WebElement> results = driver.findElements(By.cssSelector("ul.product_list.grid.row > li"));
        Assert.assertEquals(7, results.size());
    }

    @Test
    public void atc02BusquedaProductoExistente() {
        System.out.println("Test Case 2");
        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector(".btn.button-search")).click();
        List<WebElement> results = driver.findElements(By.cssSelector("ul.product_list.grid.row > li"));
        String text = results.get(0).findElement(By.cssSelector(".product-name")).getText();
        Assert.assertEquals("printed chiffon dress", text.toLowerCase());
    }

    @Test
    public void atc03_MensajeProductoNoEncontrado() {
        System.out.println("Test Case 3");
        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("liquido matapulgas");
        driver.findElement(By.cssSelector(".btn.button-search")).click();
        String text = driver.findElement(By.cssSelector(".alert.alert-warning")).getText();
        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", text);
    }

    @Test
    public void atc04_EncontrarProductoDeListaDinamica() throws InterruptedException {
        System.out.println("Test Case 4");
        WebDriverWait d = new WebDriverWait(driver,2);
        driver.get("http://automationpractice.com/");
        WebElement search = driver.findElement(By.cssSelector("#search_query_top"));
        search.sendKeys("blo");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ac_results")));
        search.sendKeys(Keys.ARROW_DOWN);
        search.sendKeys(Keys.TAB);
        String text = driver.findElement(By.cssSelector(".pb-center-column > h1:nth-child(1)")).getText();
        Assert.assertEquals("Blouse", text);
    }

    @Test
    public void atc05_AgregarProductoCambiandoTallaYColor() throws InterruptedException {
        System.out.println("Test Case 5");
        WebDriverWait d = new WebDriverWait(driver,5);
        driver.get("http://automationpractice.com/");
        WebElement search = driver.findElement(By.cssSelector("#search_query_top"));
        search.sendKeys("blo");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ac_results")));
        search.sendKeys(Keys.ARROW_DOWN);
        search.sendKeys(Keys.TAB);
        Select s = new Select(driver.findElement(By.cssSelector("#group_1")));
        s.selectByValue("3");
        driver.findElement(By.cssSelector("#color_11")).click();
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#layer_cart")));
        String text = driver.findElement(By.cssSelector(".layer_cart_product > h2:nth-child(2)")).getText();
        Assert.assertEquals("Product successfully added to your shopping cart", text);
    }

    @Test
    public void atc_FiltroMarcaTarjetasdeRegalo() {
        System.out.println("Amazon Case");
        //Sincronizacion explita
        WebDriverWait d = new WebDriverWait(driver,5);
        driver.get("https://www.amazon.com/");
        // Click menu hamburguesa
        WebElement nav = driver.findElement(By.cssSelector("#nav-hamburger-menu"));
        nav.click();
        // Click seccion electronics
        WebElement elec = driver.findElement(By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(7) > a"));
        elec.click();
        // Click seccion accesorios y suministros
        WebElement acc = driver.findElement(By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible.hmenu-translateX > li:nth-child(3) > a"));
        acc.click();
        // Sinc. explicita al aparecer menu hamburguesa
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-hamburger-menu")));
        // Click tarjetas de regalo
        WebElement gift = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(5)"));
        gift.click();

        WebElement brand = driver.findElement(By.cssSelector("#nav-subnav > a:nth-child(7) > span.nav-a-content"));
        // Accion de desplazamiento para hacer mouse hover a marcas
        Actions actions = new Actions(driver);
        actions.moveToElement(brand).build().perform();
        // Sincronizacion explicita para submenu marcas
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-flyout-ab\\:gc-subnav-flyout-content-5\\,gc-subnav-flyout-promo-5\\:verticalstores-subnav-flyout > div.nav-template.nav-flyout-content > div > div")));
        // Click en tarjeta google play
        WebElement google = driver.findElement(By.cssSelector("#nav-flyout-ab\\:gc-subnav-flyout-content-5\\,gc-subnav-flyout-promo-5\\:verticalstores-subnav-flyout > div.nav-template.nav-flyout-content > div > div > ul > li:nth-child(1)"));
        google.click();
        // Extraer texto de todas las tarjetas y validar si pertenecen a google play
        String text = driver.findElement(By.cssSelector("a.a-link-normal > span")).getText();
        Assert.assertEquals("Código de regalo de Google Play - regalo de juegos, aplicaciones y más (entrega por correo electrónico - únicamente en EE.UU.)", text);
    }

    @After
    public void close() {
        if (driver != null) {
            System.out.println("Close");
            //driver.close();
        }

    }

    @AfterClass
    public static void closeAll() {
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }
}
