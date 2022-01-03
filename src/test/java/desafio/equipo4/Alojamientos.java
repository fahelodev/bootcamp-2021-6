package desafio.equipo4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver.get("http://www.viajesfalabella.cl");
    }

    @Test
    public void atc01_alojamientoSugerido() {
        System.out.println("Test Case atc01_alojamientoSugerido");
        WebDriverWait espera = new WebDriverWait(driver,10);

        String tituloSeccion = "Despierta en algun lugar de Chile";

        // seleccionamos Alojamientos en la barra de navegacion
        driver.findElement(By.xpath("//li[contains(@class,'header-product-item')]//label[contains(text(),'Alojamientos')]")).click();

        // obtenemos contenedores de ofertas
        List<WebElement> contenedores = driver.findElements(By.xpath("//div[contains(@class,'offer-module-container')]"));


        // variable que se cargará dependiendo de la sección y primera sugerencia correspondiente
        String nombreAlojamientoEsperado = "";

        // iteramos por las secciones hasta encontrar la que corresponda a tituloSeccion
        // hacemos click en la primera sugerencia
        for (int i = 0; i < contenedores.size(); i++) {

            String headerText = contenedores.get(i).findElement(By.xpath("//h2[contains(@class,'tag-text-heading')]")).getText();

            if (headerText.equals(tituloSeccion)) {
                WebElement primeraSugerencia = contenedores.get(i).findElement(By.xpath("//div[contains(@class,'offer-card-title')]"));
                nombreAlojamientoEsperado = primeraSugerencia.getText();
                primeraSugerencia.click();
                break;
            }
        }

        // cambiamos el driver a la nueva pestaña y cerramos la anterior
        espera.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(1));

        // obtenemos el nombre del primer alojamiento en la nueva pestaña
        String nombreAlojamientoEncontrado = driver.findElement(By.cssSelector(".cluster-content .offer-card-title")).getText();

        // validamos que las cadenas sean iguales
        Assert.assertEquals( nombreAlojamientoEsperado, nombreAlojamientoEncontrado);
    }

    @Test
    public void atc02_busquedaEspecifica() {
        System.out.println("Test Case atc02_busquedaEspecifica");

        String destino = "Nueva York";
        String diaSalida = "1"; //corresponde al dia a seleccionar en el mes siguiente al actual

        // seleccionamos Alojamientos en la barra de navegacion
        driver.findElement(By.xpath("//li[contains(@class,'header-product-item')]//label[contains(text(),'Alojamientos')]")).click();

        // Enviamos texto al input de destino y seleccionamos la primera sugerencia del autocompletado
        driver.findElement(By.xpath("//input[contains(@class,'sbox-destination')]")).sendKeys(destino);
        WebElement destinoSeleccionado = driver.findElement(By.xpath("//span[contains(@class,'item-text')]"));
        String ciudadDestino = destinoSeleccionado.getText().split(",")[0];
        destinoSeleccionado.click();

        // seleccionamos fecha de entrada y salida
        driver.findElement(By.xpath("//input[contains(@class,'sbox-checkin-date')]")).click();
        driver.findElement(By.cssSelector("._dpmg2--today")).click();
        driver.findElement(By.xpath("//div[contains(@class,'_dpmg2--has-limit-date')]//span[contains(text(),'"+diaSalida+"')]")).click();
        driver.findElement(By.xpath("//button[contains(@class,'_dpmg2--desktopFooter-button-apply')]")).click();

        // añadimos habitaciones y un adulto
        driver.findElement(By.xpath("//div[contains(@class,'sbox-distribution ')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'_pnlpk-panel--popup')]//a[contains(text(),'Añadir habitación')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'_pnlpk-panel--popup')]//a[contains(@class,'sbox-3-icon-plus')]")).click();
        driver.findElement(By.cssSelector("._pnlpk-apply-button")).click();

        // realizamos la busqueda
        driver.findElement(By.cssSelector(".sbox-search")).click();

        // esperamos a que los resultados de la busqueda sean clickeables
        WebDriverWait espera = new WebDriverWait(driver,10);
        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cluster-container")));

        // guardamos en una lista la ubicación de los alojamientos
        List<WebElement> resultados = driver.findElements(By.cssSelector("aloha-location-name span"));

        // iteramos sobre los resultados para verificar que todos corresponden a la ciudad de destino
        boolean allInCity = true;

        for (int i = 0; i < resultados.size(); i++) {
            if (!resultados.get(i).getText().contains(ciudadDestino)) {
                allInCity = false;
                break;
            }
        }

        Assert.assertTrue(allInCity);
    }

    @Test
    public void atc03_mediosDePago() {
        System.out.println("Test Case atc03_mediosDePago");

        String destino = "Nueva York";
        //corresponde al dia a seleccionar en el mes siguiente al actual (max 30 dias)
        String diaSalida = "1";

        // seleccionamos Alojamientos en la barra de navegacion
        driver.findElement(By.xpath("//li[contains(@class,'header-product-item')]//label[contains(text(),'Alojamientos')]")).click();

        // Enviamos texto al input de destino y seleccionamos la primera sugerencia del autocompletado
        driver.findElement(By.xpath("//input[contains(@class,'sbox-destination')]")).sendKeys(destino);
        driver.findElement(By.xpath("//span[contains(@class,'item-text')]")).click();

        // seleccionamos fecha de entrada y salida
        driver.findElement(By.xpath("//input[contains(@class,'sbox-checkin-date')]")).click();
        driver.findElement(By.cssSelector("._dpmg2--today")).click();
        driver.findElement(By.xpath("//div[contains(@class,'_dpmg2--has-limit-date')]//span[contains(text(),'"+diaSalida+"')]")).click();
        driver.findElement(By.xpath("//button[contains(@class,'_dpmg2--desktopFooter-button-apply')]")).click();

        // añadimos habitaciones y un adulto
        driver.findElement(By.xpath("//div[contains(@class,'sbox-distribution ')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'_pnlpk-panel--popup')]//a[contains(text(),'Añadir habitación')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'_pnlpk-panel--popup')]//a[contains(@class,'sbox-3-icon-plus')]")).click();
        driver.findElement(By.cssSelector("._pnlpk-apply-button")).click();

        // realizamos la busqueda
        driver.findElement(By.cssSelector(".sbox-search")).click();

        WebDriverWait espera = new WebDriverWait(driver,15);
        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".currency-selection select")));

        // Cambiamos la moneda a USD
        Select select = new Select(driver.findElement(By.cssSelector(".currency-selection select")));
        select.selectByValue("USD");

        // click en ver detalle del primer resultado
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath(".//aloha-cluster-container//aloha-button")));
        driver.findElement(By.xpath("//aloha-button//em[contains(text(),'Ver detalle')]")).click();

        // cambio driver a la nueva pestaña
        espera.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(1));

        // click en reservar ahora
        driver.findElement(By.xpath("//aloha-next-step-button//aloha-button")).click();

        // click en siguiente
        driver.findElement(By.xpath("//div[@id='pricebox-overlay']//button")).click();

        // seleccionamos tarjeta de credito
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//payment-method-selector")));
        driver.findElement(By.xpath("//label[@for='payment-method-0']")).click();

        // seleccionamos promociones y formas de pago
        driver.findElement(By.xpath("//em[contains(text(),'Promociones y formas de pago')]")).click();

        // validamos que el numero de tarjetas presentes sea mayor a 3
        WebElement contenedorTarjetas = driver.findElement(By.xpath("//div[contains(@class,'payment-method-container')]"));
        List<WebElement> tarjetas = contenedorTarjetas.findElements(By.xpath("//div[contains(@class,'card-logo-container')]"));
        int numTarjetas = tarjetas.size();

        Assert.assertTrue(numTarjetas > 3);
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
