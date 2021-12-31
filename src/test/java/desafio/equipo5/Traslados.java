package desafio.equipo5;


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
import sun.security.pkcs11.wrapper.Constants;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Traslados {

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
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void TC001_TrasladoAuto(){

        //Seleccion de la seccion de traslados
        driver.findElement(By.xpath("//i[@class='shifu-icon-product shifu-3-icon-traslate']")).click();

        //Ingreso del texto "el loa" en el campo de "Ingresa un aeropuerto"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline']")).sendKeys("el loa");

        //Seleccion de la primera opcion
        driver.findElement(By.xpath("//span[@class='item-text']")).click();

        //Ingreso el texto "tarij" en el campo de "Ingresa un hotel...."
        driver.findElement(By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']")).sendKeys("tarij");

        //Seleccion de la primera opcion
        driver.findElement(By.xpath("//span[@class='item-text']")).click();

        //Seleccion de la fecha "Mar, 4 ene 2022"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-checkin']\n")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--onlyway _dpmg2--show-info _dpmg2--show']//div[2]//span[@class='_dpmg2--date _dpmg2--available']/span[.='4']\n")).click();

        //Seleccion de la cantidad de pasajeros "3 adultos"
        driver.findElement(By.xpath("//div[@class='sbox-3-input -md sbox-distri-input sbox-3-validation -top-right sbox-passengers-error-wrapper sbox-passengers-container']/div[@class='input-container']")).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]\n")).click();

        //Click en el boton "Buscar"
        driver.findElement(By.xpath("//em[.='Buscar']\n")).click();

        String text = driver.findElement(By.xpath("//span[.='Auto Estándar']")).getText();

        Assert.assertEquals("Auto Estándar",text);

    }

    @Test
    public void TC002_TrasladoSinResultados(){

        //Seleccion de la seccion de traslados
        driver.findElement(By.xpath("//i[@class='shifu-icon-product shifu-3-icon-traslate']")).click();

        //Ingreso del texto "el loa" en el campo de "Ingresa un aeropuerto"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline']")).sendKeys("el loa");

        //Seleccion de la primera opcion
        driver.findElement(By.xpath("//span[@class='item-text']")).click();

        //Ingreso el texto "tarij" en el campo de "Ingresa un hotel...."
        driver.findElement(By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']")).sendKeys("iqui");

        //Seleccion de la primera opcion
        driver.findElement(By.xpath("//span[@class='item-text']")).click();

        //Seleccion de la fecha entrada "Mar, 4 ene 2022"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-checkin']\n")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--onlyway _dpmg2--show-info _dpmg2--show']//div[2]//span[@class='_dpmg2--date _dpmg2--available']/span[.='4']\n")).click();

        //Seleccion de la cantidad de pasajeros "3 adultos"
        driver.findElement(By.xpath("//div[@class='sbox-3-input -md sbox-distri-input sbox-3-validation -top-right sbox-passengers-error-wrapper sbox-passengers-container']/div[@class='input-container']")).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]\n")).click();

        //Click en el boton "Buscar"
        driver.findElement(By.xpath("//em[.='Buscar']\n")).click();

        String text = driver.findElement(By.xpath("//span[.='¡Ups! No hay traslados disponibles para esta fecha.']")).getText();

        Assert.assertEquals("¡Ups! No hay traslados disponibles para esta fecha.",text);

    }

    @Test
    public void TC003_TrasladoMinivan(){


        //Seleccion de la seccion de traslados
        driver.findElement(By.xpath("//i[@class='shifu-icon-product shifu-3-icon-traslate']")).click();

        //Ingreso del texto "el loa" en el campo de "Ingresa un aeropuerto"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline']")).sendKeys("el loa");

        //Seleccion de la primera opcion
        driver.findElement(By.xpath("//span[@class='item-text']")).click();

        //Ingreso el texto "tarij" en el campo de "Ingresa un hotel...."
        driver.findElement(By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']")).sendKeys("tarij");

        //Seleccion de la primera opcion
        driver.findElement(By.xpath("//span[@class='item-text']")).click();

        //Seleccion de la fecha "Mar, 4 ene 2022"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-checkin']\n")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--onlyway _dpmg2--show-info _dpmg2--show']//div[2]//span[@class='_dpmg2--date _dpmg2--available']/span[.='4']\n")).click();

        //Seleccion de la cantidad de pasajeros 14 "adultos"

        driver.findElement(By.xpath("//div[@class='sbox-3-input -md sbox-distri-input sbox-3-validation -top-right sbox-passengers-error-wrapper sbox-passengers-container']/div[@class='input-container']")).click();
        for (int i = 0; i < 12; i++) {
            //Hacer click en la flechita de agergagar pasajeros hasta llegar a 14
            driver.findElement(By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]\n")).click();
        }

        //Click en el boton "Buscar"
        driver.findElement(By.xpath("//em[.='Buscar']\n")).click();

        String text = driver.findElement(By.xpath("//span[.='Minivan Estándar']")).getText();

        Assert.assertEquals("Minivan Estándar",text);

    }

    @Test
    public void TC004_TrasladoFalabella(){

        //Seleccion de la seccion de traslados
        driver.findElement(By.xpath("//i[@class='shifu-icon-product shifu-3-icon-traslate']")).click();
        //Click en el boton "ver mas"
        driver.findElement(By.xpath("//div[@class='content-wrapper eva-3-container module-MultiproductOffersModule section section-4']//em[@class='btn-text']\n")).click();

        //Seleccion el packete de punta cana
        driver.findElement(By.xpath("//div[.='Traslado en Punta Cana']\n")).click();

        // Realizar las acciones en una nueva ventana

        //nombre de la ventana
        //System.out.println(driver.getTitle());


        //Selecion de "Traslados compartidos"
        //driver.findElement(By.xpath("//*[@id="currency-select"]")).click();

        //Selecion de moneda
        //Select moneda = new Select();


        //
    }

    @Test
    public void PruebaDePestañas(){

        String mainTab = driver.getWindowHandle();
        System.out.println("MainTab" + mainTab);

        Set<String> handles = driver.getWindowHandles();

        for (String actual: handles) {
            System.out.println("--- Handled ID: " + actual);
            driver.switchTo().window(actual);
            //newTab = actual;
        }

    }

    @After
    public void close(){
        if(driver != null){
            System.out.println("Close");
            //driver.close();
        }

    }

    @AfterClass
    public static void closeAll(){
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }

}