package desafio.equipo4;

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
import java.time.Duration;

public class Traslados {
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

    @Test
    public void atc01_mensajeDeError() throws InterruptedException {
        driver.get("http://www.viajesfalabella.cl");
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Seleccionamos el modulo traslados, 'Desde el aeropuerto e ingresamos un aeropuerto en 'desde'
        driver.findElement(By.xpath("//*[text()='Traslados']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Desde el aeropuerto')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un aeropuerto']")).sendKeys("copiapo");

        //esperamos a que la sugerencia aparezca y presionamos Enter para elegirla
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un aeropuerto']")).sendKeys(Keys.ENTER);

        //Ingresamos una direccion en 'Hasta', esperamos que aparezca la sugerencia y presionamos enter.
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']")).sendKeys("copiapo");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']")).sendKeys(Keys.ENTER);

        //Hacemos click en 'Arribo' que se encuentra en 'fecha' y esperamos que aparezca la ventana
        driver.findElement(By.xpath("//input[@placeholder='Arribo']")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'datepicker-transfers sbox')]//div[contains(@class, 'controlsWrapper')]")));

        //seleccionamos la fecha actual, luego seleccionamos la hora utilizando la clase Select
        driver.findElement(By.xpath("//div[contains(@class, 'datepicker-transfers sbox')]//span[contains(@class, 'available _dpmg2--today')]")).click();
        WebElement horas = driver.findElement(By.xpath("//select[@class='select-tag sbox-time-arrival']"));
        Select select = new Select(horas);
        //seleccionamos la hora: 3:00 y luego hacemos click en 'Buscar'
        select.selectByIndex(6);
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        //esperamos a que aparezca el texto necesario en la otra página y lo guardamos en una variable
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Sentimos')]")));

        String mensaje_esperado = "Sentimos no poder ayudarte. Esperamos que encuentres lo que estás buscando.";
        String mensaje_actual = driver.findElement(By.xpath("//p[contains(text(),'Sentimos')]")).getText();

        Assert.assertEquals(mensaje_esperado, mensaje_actual);
    }


    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }

    @AfterClass
    public static void closeAll(){
    }

}
