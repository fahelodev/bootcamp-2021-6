package Test_Falabella;
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
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ATC_Paquetes {
    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        System.out.println("instanciar");
        driver = new ChromeDriver();
        //Page practice
        driver.get("https://www.viajesfalabella.cl/paquetes/");
        driver.manage().window().maximize();

    }

    @Test
    public void TC002_VueloYAlojamiento()throws InterruptedException{

        /* 1. Seleccionar paquete de Vuelo y Alojamiento
        2. Ingresar Origen
        3. Ingresar Destino nacional
        4. Seleccionar fecha de ida
        5. Seleccionar fecha de vuelta
        5. Añadir cantidad de habitaciones y adultos
        6. Hacer click en el botón buscar*/

        // caja origen //*[@id="searchbox"]/div/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div/input
        WebElement origen = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div/input"));
        String txtOrigen = "Santiago de Chile, Santiago, Chile";
        origen.sendKeys(txtOrigen);
        Thread.sleep(2000);
        origen.sendKeys(Keys.DOWN);
        origen.sendKeys(Keys.ENTER);

        // caja destino //*[@id="searchbox"]/div/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div/input
        WebElement destino = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div/input"));
        String txtDestino = "Arica, Arica y Parinacota, Chile";
        destino.sendKeys(txtDestino);
        Thread.sleep(2000);
        destino.sendKeys(Keys.DOWN);
        destino.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector(".sbox-checkin-date")).click();

        // 7 de enero  //html/body/div[5]/div/div[5]/div/div[4]/span[7]/span
        driver.findElement(By.xpath("//html/body/div[5]/div/div[5]/div/div[4]/span[7]/span")).click();
        Thread.sleep(1000);
        // 13 de enero //html/body/div[5]/div/div[5]/div/div[4]/span[13]/span
        driver.findElement(By.xpath("//html/body/div[5]/div/div[5]/div/div[4]/span[13]/span")).click();

        //btn aplicar fecha //html/body/div[7]/div/div[6]/div[2]/button[2]/em
        driver.findElement(By.xpath("//html/body/div[7]/div/div[6]/div[2]/button[2]/em")).click();

        //btn buscar
        driver.findElement(By.xpath("//em[text()='Buscar']")).click();

        Thread.sleep(3000);
        /*driver.findElement(By.xpath("//*[contains(@class, 'results-items-wrapper')]/aloha-list-view-container/div[2]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button/em")).click();

        String mainTab= driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual: handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
                Thread.sleep(2000);
            }
        }*/

    }

    @Test
    public void TC001_ErrorDestinoYOrigenIguales() throws InterruptedException {

        /*1. Seleccionar "Ver mas ofertas"
        2. Ingresar en la segunda opcion
        3.Ingresar a la opcion del popup
        4.Click en Modificar
        5.Ingresar Santiago de Chile en origen.
        6.Ingresar Santiago de Chile en Destino.
        7.Click en Buscar */

        String resultError = "El destino debe ser diferente del origen.";



        //boton ver ofertas //*[contains(@class, 'section-5')]//em[text()='Ver más ofertas']
        WebElement btnVerMasOfertas =  driver.findElement(By.xpath("//*[contains(@class, 'section-5')]//em[text()='Ver más ofertas']"));
        btnVerMasOfertas.click();
        Thread.sleep(2000);

        //segundo item de paquetes *[contains(@class, 'section-5')]//*[contains(@class, 'offer-cards-container')]/offer-card[5]/div/a/div/div/img
        WebElement segundoItem = driver.findElement(By.xpath("//*[contains(@class, 'section-5')]//*[contains(@class, 'offer-cards-container')]/offer-card[5]/div/a/div/div/img"));
        segundoItem.click();
        Thread.sleep(2000);

        //clic en ventana popup //popup //div[text()='11 NOCHES']
        WebElement popUp = driver.findElement(By.xpath("//span[@class='eva-3-h3']"));
        popUp.click();
        Thread.sleep(2000);

        String mainTab= driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual: handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
            }
        }

        Thread.sleep(3000);
        //modifica destino
        String mod_destino = "Santiago de Chile, Chile";

        //html/body/aloha-app-root/aloha-results/div/div/div[2]/div/aloha-old-research/div/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div/input
        WebElement txtDestino = driver.findElement(By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']"));
        //Limpiar textBox
        txtDestino.sendKeys(Keys.CONTROL + "A");
        txtDestino.sendKeys(Keys.CLEAR);
        //Insertar nuevo destino
        txtDestino.sendKeys(mod_destino);
        Thread.sleep(2000);
        WebElement Prediccion= driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/ul/li[1]/span"));
        Prediccion.click();
        txtDestino.sendKeys(Keys.DOWN);
        txtDestino.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //clic en boton buscar //em[text()='Buscar']
        WebElement btnBuscar = driver.findElement(By.xpath("//em[text()='Buscar']"));
        btnBuscar.click();

        //guardar mensaje de error desde el sistema //*[contains(@class, 'sbox-destination-different-origin-error')]
        String mensajeError = driver.findElement(By.xpath("//*[contains(@class, 'sbox-destination-different-origin-error')]")).getText();
        // compara errores
        Assert.assertEquals(mensajeError,resultError);

        Thread.sleep(2000);
    }

    @Test
    public void TC003_Vuelo_con_2_Alojamientos() throws InterruptedException{

        /* 1. Seleccionar paquete de Vuelo y Dos Alojamientos ok
        2. Ingresar Origen ok
        3. Ingresar Destino internacional ok
        4. Seleccionar fecha de ida ok
        5. Seleccionar fecha de vuelta ok
        6. Añadir primer destino ok
        7. Ingresar fecha límite del primer destino ok
        8. Añadir segundo destino ok
        9. Ingresar fecha límite del segundo destino ok
        10. Añadir cantidad de habitaciones y adultos
        11. Hacer click en el botón buscar */

        //wait until element is visible - click en traslados
        WebDriverWait driverWithMoreWait = new WebDriverWait(driver, 20);

        // paquete vuelo 2 alojamientos //*[contains(@class, 'sbox-radio-vhh')]
        driver.findElement(By.xpath("//*[contains(@class, 'sbox-radio-vhh')]")).click();
        //Thread.sleep(2000);

        String txtOrigenPaquete = "Santiago de Chile, Santiago, Chile";
        String txtDestinoPaquete = "Rio de Janeiro, Rio de Janeiro, Brasil";
        String txtSegundoDestino = "San Pablo, San Pablo, Brasil";

        WebElement origenPaquete = driver.findElement(By.xpath("//html/body/app-root/div/header-wrapper/div/div/sbox/div/searchbox/div/div/div/div/div[3]/div[2]/div[2]/div/div/div/div/input"));
        origenPaquete.sendKeys(txtOrigenPaquete);
        Thread.sleep(500);
        origenPaquete.sendKeys(Keys.DOWN);
        origenPaquete.sendKeys(Keys.ENTER);



        WebElement destinoPaquete = driver.findElement(By.xpath("//html/body/app-root/div/header-wrapper/div/div/sbox/div/searchbox/div/div/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div/div/input"));
        destinoPaquete.sendKeys(txtDestinoPaquete);
        Thread.sleep(500);
        destinoPaquete.sendKeys(Keys.DOWN);
        destinoPaquete.sendKeys(Keys.ENTER);


        // clic caja fecha ida //*[contains(@class, 'sbox-checkin-date')]
        driver.findElement(By.xpath("//*[contains(@class, 'sbox-checkin-date')]")).click();

        // fecha ida 7 enero  //html/body/div[5]/div/div[5]/div/div[4]/span[7]/span
        driver.findElement(By.xpath("//html/body/div[5]/div/div[5]/div/div[4]/span[7]/span")).click();

        // clic caja fecha retorno //*[contains(@class, 'sbox-checkout-date')]
        driver.findElement(By.xpath("//*[contains(@class, 'sbox-checkout-date')]")).click();

        // fecha retorno 13 enero //html/body/div[5]/div/div[5]/div/div[4]/span[13]/span
        driver.findElement(By.xpath("//html/body/div[5]/div/div[5]/div/div[4]/span[13]/span")).click();

        // boton aplicar fechas  //html/body/div[7]/div/div[6]/div[2]/button[2]/em
        driver.findElement(By.xpath("//html/body/div[7]/div/div[6]/div[2]/button[2]/em")).click();

        // fecha hasta primer destino //*[contains(@class, 'sbox-hotel-first-checkout-date')]
        driver.findElement(By.xpath("//*[contains(@class, 'sbox-hotel-first-checkout-date')]")).click();

        // setear fecha 11 de enero //*[contains(@class, '_dpmg2--show')]//*[contains(@class, '_dpmg2--has-start-range')]/div[4]/span[11]/span
        driver.findElement(By.xpath("//*[contains(@class, '_dpmg2--show')]//*[contains(@class, '_dpmg2--has-start-range')]/div[4]/span[11]/span")).click();

        //boton aplicar segunda fecha //*[contains(@class, '_dpmg2--show')]//em[text()='Aplicar']
        driver.findElement(By.xpath("//*[contains(@class, '_dpmg2--show')]//em[text()='Aplicar']")).click();

        //segundo destino  //html/body/app-root/div/header-wrapper/div/div/sbox/div/searchbox/div/div/div/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/div/div/div/div/input
        WebElement segundoDestinoPaquete = driver.findElement(By.xpath("//html/body/app-root/div/header-wrapper/div/div/sbox/div/searchbox/div/div/div/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/div/div/div/div/input"));
        segundoDestinoPaquete.sendKeys(txtSegundoDestino);
        Thread.sleep(500);
        segundoDestinoPaquete.sendKeys(Keys.DOWN);
        segundoDestinoPaquete.sendKeys(Keys.ENTER);


        // boton buscar
        driver.findElement(By.xpath("//*[contains(@class, 'sbox-search')]")).click();


        String textValidate = driverWithMoreWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='trips-cluster-selected-position']//*[contains(@class, 'itineraries-container')]/span/route-choice/div/span[2]/span[2]/route-info-item[2]/span/span/span"))).getText();
        //Validacion
        Assert.assertEquals("Rio de Janeiro", textValidate);




    }

    @After
    public void close () {
        if (driver != null) {
            System.out.println("Close");
            driver.close();
        }

    }

    @AfterClass
    public static void closeAll() {
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }
}

