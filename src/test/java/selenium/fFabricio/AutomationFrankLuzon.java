package desafio.equipo2.selenium.fFabricio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutomationFrankLuzon {

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
        driver.get("http://automation.frankluzon.com/");
    }


    @Test
    public void FrankLuzon()throws InterruptedException {
        //ejecutamos el buscador cap
        WebElement buscador= driver.findElement(By.xpath("//*[@id=\"woocommerce-product-search-field-0\"]"));
        buscador.click();
        buscador.sendKeys("CAP");
        buscador.sendKeys(Keys.ENTER);

        //seleccionamos la opcion Review y las estrellas
        driver.findElement(By.xpath("//*[@id=\"tab-title-reviews\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"commentform\"]/div/p/span/a[3]")).click();

        //Escribimos un texto
        WebElement mensajeReviewUsuario = driver.findElement(By.xpath("//*[@id=\"comment\"]"));
        mensajeReviewUsuario.sendKeys("Holaaa Mundo , Holaaaaa !!!");

        //llenamos los campos de nombre y mail
        driver.findElement(By.xpath("//*[@id=\"author\"]")).sendKeys("Fabricio");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("fabriciof@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();


        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("dfn, cite, em, i")));
        WebElement vericarComent = driver.findElement(By.cssSelector("dfn, cite, em, i"));

        assertEquals("Your review is awaiting approval", vericarComent.getText());








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
