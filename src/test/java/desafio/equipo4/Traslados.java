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
        driver.get("http://www.viajesfalabella.cl");
    }

    @Test
    public void atc01_mensajeDeError() throws InterruptedException {
        String desdeAeropuerto = "Copiapo";
        String hastaHotel = "copiapo"; //se recomienda usar estos datos para conseguir el error.
        String hora = "03:00";

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Seleccionamos el modulo traslados, 'Desde el aeropuerto e ingresamos un aeropuerto en 'desde'
        driver.findElement(By.xpath("//*[text()='Traslados']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Desde el aeropuerto')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un aeropuerto']")).sendKeys(desdeAeropuerto);

        //esperamos a que la sugerencia aparezca y presionamos Enter para elegirla
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un aeropuerto']")).sendKeys(Keys.ENTER);

        //Ingresamos una direccion en 'Hasta', esperamos que aparezca la sugerencia y presionamos enter.
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']")).sendKeys(hastaHotel);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']")).sendKeys(Keys.ENTER);

        //Hacemos click en 'Arribo' que se encuentra en 'fecha' y esperamos que aparezca la ventana
        driver.findElement(By.xpath("//input[@placeholder='Arribo']")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'datepicker-transfers sbox')]//div[contains(@class, 'controlsWrapper')]")));

        //seleccionamos la fecha actual, luego seleccionamos la hora utilizando la clase Select
        driver.findElement(By.xpath("//div[contains(@class, 'datepicker-transfers sbox')]//span[contains(@class, 'available _dpmg2--today')]")).click();
        WebElement horas = driver.findElement(By.xpath("//select[@class='select-tag sbox-time-arrival']"));
        Select select = new Select(horas);

        //seleccionamos la hora y luego hacemos click en 'Buscar'
        select.selectByVisibleText(hora);
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        //esperamos a que aparezca el texto necesario en la otra página y lo guardamos en una variable
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Sentimos')]")));

        String mensaje_esperado = "Sentimos no poder ayudarte. Esperamos que encuentres lo que estás buscando.";
        String mensaje_actual = driver.findElement(By.xpath("//p[contains(text(),'Sentimos')]")).getText();

        Assert.assertEquals(mensaje_esperado, mensaje_actual);
    }

    @Test
    public void atc02_opcionTransferencia(){
        String desdeAeropuerto = "Santiago";
        String hastaHotel = "Santiago";
        String hora = "21:30";

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Seleccionamos el modulo traslados, 'Desde el aeropuerto' e ingresamos un aeropuerto en 'desde'
        driver.findElement(By.xpath("//*[text()='Traslados']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Desde el aeropuerto')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un aeropuerto']")).sendKeys(desdeAeropuerto);

        //esperamos a que la sugerencia aparezca y presionamos Enter para elegirla
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un aeropuerto']")).sendKeys(Keys.ENTER);

        //Ingresamos una direccion en 'Hasta', esperamos que aparezca la sugerencia y presionamos Enter para elegirla
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']")).sendKeys(hastaHotel);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']")).sendKeys(Keys.ENTER);

        //Hacemos click en 'Arribo' que se encuentra en 'fecha', esperamos y elegimos la fecha actual
        driver.findElement(By.xpath("//input[@placeholder='Arribo']")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'datepicker-transfers sbox')]//div[contains(@class, 'controlsWrapper')]")));
        driver.findElement(By.xpath("//div[contains(@class, 'datepicker-transfers sbox')]//span[contains(@class, 'available _dpmg2--today')]")).click();

        //Seleccionamos una hora utilizando la clase 'Select'
        WebElement horas = driver.findElement(By.xpath("//select[@class='select-tag sbox-time-arrival']"));
        Select select = new Select(horas);
        select.selectByVisibleText(hora);

        //Hacemos click en 'Buscar' y esperamos al boton de comprar en la otra pagina
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'xxlg')]//em[contains(text(), 'Comprar')]")));

        //Hacemos click en comprar en el primer resultado y esperamos
        driver.findElement(By.xpath("//div[contains(@class, 'xxlg')]//em[contains(text(), 'Comprar')]")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Transferencia Bancaria']")));

        //Seleccionamos 'Transferencia Bancaria' y guardamos el texto para corroborar que aparece la sección
        //de transferencia bancaria para cargar los datos.
        driver.findElement(By.xpath("//span[text()='Transferencia Bancaria']")).click();

        String mensaje_esperado = "Transferencia Bancaria";
        String mensaje_actual = driver.findElement(By.xpath("//em[contains(text(),'Transfe')]")).getText();

        Assert.assertEquals(mensaje_esperado, mensaje_actual);
    }

    @Test
    public void atc03_mensajeError_cuponInvalido(){
        String desdeAeropuerto = "Santiago";
        String hastaHotel = "Santiago";
        String hora = "21:30";
        int edadMenor = 3;
        String email = "jose@email.com";
        String codigoCupon = "123123";

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Seleccionamos el modulo traslados, hacemos click en 'desde el aeropuerto' e ingresamos un aeropuerto
        driver.findElement(By.xpath("//*[text()='Traslados']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Desde el aeropuerto')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un aeropuerto']")).sendKeys(desdeAeropuerto);

        //esperamos a que la sugerencia aparezca y luego presionamos Enter para elegirla
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un aeropuerto']")).sendKeys(Keys.ENTER);

        //Ingresamos una direccion en 'Hasta', esperamos la sugerencia y luego presionamos Enter para elegirla.
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']")).sendKeys(hastaHotel);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ac-group-items']")));
        driver.findElement(By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']")).sendKeys(Keys.ENTER);

        //Hacemos click en 'Arribo' que se encuentra en 'fecha', esperamos a que aparezca y seleccionamos la fecha actual
        driver.findElement(By.xpath("//input[@placeholder='Arribo']")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'datepicker-transfers sbox')]//div[contains(@class, 'controlsWrapper')]")));
        driver.findElement(By.xpath("//div[contains(@class, 'datepicker-transfers sbox')]//span[contains(@class, 'available _dpmg2--today')]")).click();

        //Seleccionamos la hora utilizando la clae Select
        WebElement horas = driver.findElement(By.xpath("//select[@class='select-tag sbox-time-arrival']"));
        Select select = new Select(horas);
        select.selectByVisibleText(hora);

        //Hacemos click en 'Pasajeros', esperamos que aparezca la ventana y agregamos un adulto más.
        driver.findElement(By.xpath("//div[@class='sbox-row sbox-distribution-picker-wrapper-ui']")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'stepper-adults')]//a[contains(@class, 'icon-plus')]")));
        driver.findElement(By.xpath("//div[contains(@class, 'stepper-adults')]//a[contains(@class, 'icon-plus')]")).click();

        //Hacemos click para agregar un menor, y seleccionamos la edad del menor con la clase Select
        driver.findElement(By.xpath("//div[contains(@class, 'stepper-minors')]//a[contains(@class, 'icon-plus')]")).click();
        WebElement edad_menor = driver.findElement(By.xpath("//div[contains(@class, 'select-minor-age')]//select"));
        select = new Select(edad_menor);
        select.selectByIndex(edadMenor+1);

        //Hacemos click en Aplicar y luego en 'Buscar'
        driver.findElement(By.xpath("//a[contains(text(),'Aplicar')]")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        //esperamos que aparezca el boton de comprar en la otra pagina y Clickeamos en comprar en el primer resultado
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'xxlg')]//em[contains(text(), 'Comprar')]")));
        driver.findElement(By.xpath("//div[contains(@class, 'xxlg')]//em[contains(text(), 'Comprar')]")).click();

        //Esperamos a que cargue la página para seleccionar la opción del Cupón y hacemos click en Cupon.
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'medium')]//a[contains(@class, 'coupon')]")));
        driver.findElement(By.xpath("//div[contains(@class, 'medium')]//a[contains(@class, 'coupon')]")).click();

        //Esperamos y luego ingresamos un email y un cupón inválido en la sección de cupón y hacemos click en 'Validar'
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='coupon-email']")));
        driver.findElement(By.xpath("//input[@id='coupon-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='coupon-code']")).sendKeys(codigoCupon);
        driver.findElement(By.xpath("//em[contains(text(),'Validar')]")).click();

        //esperamos a que aparezca el mensaje de código invalido y luego lo guardamos en una variable
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'El email')]")));

        String mensaje_esperado = "El email o código ingresados son incorrectos";
        String mensaje_actual = driver.findElement(By.xpath("//h5[contains(text(),'El email')]")).getText();

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
