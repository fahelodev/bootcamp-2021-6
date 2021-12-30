package desafio.equipo4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.lang.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Alojamientos {

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
        // Definimos un implicit wait de 6 segundos
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    public void atc01_alojamientoSugerido() {
        System.out.println("Test Case atc01_alojamientoSugerido");

        driver.get("http://www.viajesfalabella.cl");


        // navegamos por el menu lateral
        driver.findElement(By.xpath("//li[contains(@class,'header-product-item')]//label[contains(text(),'Alojamientos')]")).click();

        // contenedores de ofertas
        List<WebElement> contenedores = driver.findElements(By.xpath("//div[contains(@class,'offer-module-container')]"));


        String nombreAlojamientoEsperado = "";

        for (int i = 0; i < contenedores.size(); i++) {

            String headerText = contenedores.get(i).findElement(By.xpath("//h2[contains(@class,'tag-text-heading')]")).getText();

            if (headerText.equals("Despierta en algun lugar de Chile")) {
                WebElement primeraSugerencia = contenedores.get(i).findElement(By.xpath("//div[contains(@class,'offer-card-title')]"));
                nombreAlojamientoEsperado = primeraSugerencia.getText();
                primeraSugerencia.click();
                break;
            }
        }

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(1));

        String nombreAlojamientoEncontrado = driver.findElement(By.cssSelector(".cluster-content .offer-card-title")).getText();

        Assert.assertEquals( nombreAlojamientoEsperado, nombreAlojamientoEncontrado);
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
