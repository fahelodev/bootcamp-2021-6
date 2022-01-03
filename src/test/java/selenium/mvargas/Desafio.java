package selenium.mvargas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Desafio {

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.viajesfalabella.cl/"); //Cargar la páginas
    }

    @Test
    public void atc01OrdenarLosComentariosdDeHotelPorMenorPuntajeAlojamiento() throws InterruptedException {
        System.out.println("Test Case 1: OrdenarLos Comentariosd De Hotel Por Menor Puntaje - Alojamiento");
        // Cargar la página y validar.
        driver.get("https://www.viajesfalabella.cl/");
        // Localizar el el boton de Alojamiento y hacer click
        driver.findElement(By.xpath("//a[@title='Alojamientos']")).click();
        // Localizar e ingresar en campo ciudad destino "Madrid, Comunidad de Madrid, España".
        WebElement buscador = driver.findElement(By.xpath("//*[@type='text']"));
        buscador.sendKeys("Madrid, Comunidad de Madrid, España");
        Thread.sleep(1000);
        buscador.sendKeys(Keys.TAB);
        // Seleccionar la casilla "Todavía no he decidido la fecha"
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@class='checkbox-label']")).click();
        driver.findElement(By.xpath("//div[@class='sbox-button-container']")).click();
        // Seleccionar el primer un hotel de la lista
        driver.findElement(By.xpath("//div[@title='Riu Plaza España']")).click();
        String mainTab= driver.getWindowHandle();
        String newTab = "";
        Set<String> handles = driver.getWindowHandles();
        for (String actual: handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
                newTab = actual;
            }
        }

        // En Comentarios sobre este alojamiento marcar, Ordenar por "Menor Puntaje"
        driver.findElement(By.xpath("//select[@id='jr-eva-select'] //option[@value='overall_rating_asc']")).click();
        Thread.sleep(2000);
        String Resultado = driver.findElement(By.xpath("//div[@class='comment-rating'] //span[@class='comment-rating-number']")).getText();
        System.out.println("Resultado esperado: " + Resultado);
        Assert.assertEquals("7,5", Resultado);
        Thread.sleep(1000);
    }


    @Test
    public void atc02_ValidarDisponibilidadDeAlojamientoEnFechaConAltaDemanda() throws InterruptedException {
        System.out.println("Test Case 2: Validar Disponibilidad De Alojamiento En Fecha Con Alta Demanda");
        // Cargar la página y validar.
        driver.get("https://www.viajesfalabella.cl/");
        // Localizar el el boton de Alojamiento y hacer click
        driver.findElement(By.xpath("//a[@title='Alojamientos']")).click();
        // Localizar e ingresar en campo ciudad destino "Hotel Club La Serena, La Serena, Chile".
        WebElement buscador = driver.findElement(By.xpath("(//*[@type='text'])"));
        buscador.sendKeys("Hotel Club La Serena, La Serena, Chile");
        Thread.sleep(3000);
        buscador.sendKeys(Keys.TAB);
        driver.findElement(By.xpath("//input[@placeholder='Entrada']")).click();
        // Ingresar en campo fecha Ida "Lun, 3 ene 2022
        driver.findElement(By.xpath("(//span[@class='_dpmg2--date _dpmg2--available'])[1]")).click();
        // Ingresar en campo fecha Ida "Sáb, 8 ene 2022"
        driver.findElement(By.xpath("(//span[@class='_dpmg2--date _dpmg2--available _dpmg2--weekend _dpmg2--nights-tooltip'])[1]")).click();
        driver.findElement(By.xpath("//em[@class='_dpmg2--desktopFooter-button-apply-text btn-text']")).click();
        // Añadir una habitacion extra para 3 adultos y realizar busqueda
        driver.findElement(By.xpath("//div[@class='sbox-distri-input-container sbox-distribution-picker-wrapper']")).click();
        driver.findElement(By.xpath("//a[@class='_pnlpk-panel__button _pnlpk-panel__button--link-left _pnlpk-add-room-button']")).click();
        driver.findElement(By.xpath("(//a[@class='steppers-icon-right sbox-3-icon-plus'])[3]")).click();
        driver.findElement(By.xpath("//div[@class='sbox-button-container']")).click();
        //Ingresamos al "Hotel Club La Serena, La Serena, Chile"
        driver.findElement(By.xpath("//div[@class='eva-3-pricebox-cluster -responsive']")).click();
        String mainTab= driver.getWindowHandle();
        String newTab = "";
        Set<String> handles = driver.getWindowHandles();
        for (String actual: handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
                newTab = actual;
            }
        }
        // Validar si el Hotel está agotado y presiorar en botón "Ver otros alojamientos"
        Thread.sleep(4000);
        String texto = driver.findElement(By.xpath("//h3[@class='eva-3-h3']")).getText();
        System.out.println(texto);
        Assert.assertEquals( "Agotado", texto);
        System.out.println("Estado de hotel: Agotado");
        driver.findElement(By.xpath("//a[@class='eva-3-btn-ghost -md -eva-3-fwidth']")).click();
        // En casilla Ordenar por, seleccionar "Mejor precio / calidad
        driver.findElement(By.xpath("//select//option[@value='quality_price_descending']")).click();
        // Seleccionar el hotel "Cabañas Campanario" de la lista"
        driver.findElement(By.xpath("//div[@class='cluster-content-wrapper']")).click();
        String MainTab= driver.getWindowHandle();
        String NewTab = "";
        Set<String> Handles = driver.getWindowHandles();
        for (String actual: Handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
                NewTab = actual;
                Thread.sleep(2000);
            }
        }
        // Validar que hotel "Cabañas Campanario" esta disponible para reservas"
        driver.findElement(By.xpath("//em[@class='btn-text']")).click();
        String Resultado = driver.findElement(By.xpath("//button[@class='eva-3-btn -md -secondary -eva-3-fwidth']")).getText();
        Assert.assertEquals("Reservar ahora", Resultado);
        System.out.println("Estado del hotel: Reservar ahora");
    }


    @Test @Ignore
    public void atc03_ValidadLecturaDeTerminosYCondiciones() throws InterruptedException {
        System.out.println("Test Case 3: Validad Lectura De Terminos Y Condiciones");
        // Cargar la página y validar.
        driver.get("https://www.viajesfalabella.cl/");
        // Localizar el el boton de Alojamiento y hacer click
        driver.findElement(By.xpath("//a[@title='Alojamientos']")).click();
        // Seleccionamos el banner de "usa"
        driver.findElement(By.xpath("(//div[@class='CENTERED_IMAGE image-wrapper'])[3]")).click();
        // Ingresar en campo de Origen  "arg"
        WebElement buscador = driver.findElement(By.xpath("(//*[@type='text'])"));
        buscador.sendKeys("arg");
        // Esperar que se listen los resultados automáticos.
        Thread.sleep(2000);
        //Seleccionamos "Buenos Aires, Argentina"
        buscador.sendKeys(Keys.TAB);
        // Introducir "mia" en el campo de destino.
        WebElement SegBuscador = driver.findElement(By.xpath("(//*[@type='text'])[2]"));
        SegBuscador.sendKeys("mia");
        //Esperamos que se listen los resultados automáticos.
        Thread.sleep(2000);
        //Seleccionamos "Miami Beach, Florida Estados Unidos.
        SegBuscador.sendKeys(Keys.ENTER);
        // Seleccionamos las fechas de ingreso y egreso.
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
        driver.findElement(By.xpath("//*[@class='datepicker-packages sbox-v4-components']//span[@class='_dpmg2--date _dpmg2--available']//span[.='17']")).click();
        driver.findElement(By.xpath("(//span[@class='_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip'])[9]")).click();
        //Seleccionamos la habitación para 3 adultos.
        driver.findElement(By.xpath("//div[@class='sbox-distri-input-container sbox-distribution-picker-wrapper']")).click();
        driver.findElement(By.xpath("//a[@class='_pnlpk-panel__button _pnlpk-panel__button--link-left _pnlpk-add-room-button']")).click();
        driver.findElement(By.xpath("(//a[@class='steppers-icon-right sbox-3-icon-plus'])[5]")).click();
        driver.findElement(By.xpath("//div[@class='sbox-button-container']")).click();
        // Ingresamos a el hotel "Loreine Hotel"
        Thread.sleep(6000);
        driver.findElement(By.xpath("(//div[@class='promotion-wrapper'])[2]")).click();
        // Filtramos reserva flexible.
        String mainTab = driver.getWindowHandle();
        String newTab = "";
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(mainTab)) {
                driver.switchTo().window(actual);
                newTab = actual;
            }
            Thread.sleep(2000);
            driver.findElement(By.xpath("//dic[@class='filters-wrapper -eva-3-fwidth'] //span[@class='scroll-wrapper']")).click();
            // Seleccionamos "habitación doble de lujo"
            // Oprimimos "siguiente" hasta llegar a la página para llenar datos.
            // Comprar la reserva sin marcar la casilla de "terminos y condiciones"
            Thread.sleep(2000);
        }
    }


    @Test
    public void atc07_ValidarNoDisponibilidadDeTraslados() {
        //ir a servicio Traslados
        driver.findElement(By.xpath("//ul[@class='header-list-products'] //a[@class='shifu-3-button-circle TRANSFERS paint-circle ']")).click();
        //Se ingresa aeropuerto de origen
        driver.findElement(By.xpath("//div[@class='input-container']//input[@class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline']")).sendKeys("Aeropuerto Fera Island, Fera Island, Islas Salomón");
        //selecciona el aeropuerto sugerido en la lista
        driver.findElement(By.xpath("//ul[@class='ac-group-items']//li[@class='item -active']")).click();
        //click en campo de Hotel de destino
        WebElement aDestino = driver.findElement(By.xpath("//div[@class='input-container'] //input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']"));
        aDestino.click();
        //Se ingresa aeropuerto de destino
        aDestino.sendKeys("Driftwood Lodge, Kavolavata, Islas Salomón");
        //se selecciona el Hotel de destino sugerido en la lista
        driver.findElement(By.xpath("//ul[@class='ac-group-items']//li[@class='item -active']")).click();
        //se hace click en el campo de fecha de traslado
        driver.findElement(By.xpath("//div[@class='input-container'] //input[@class='input-tag sbox-checkin']")).click();
        //seleccionar la fecha de arribo
        driver.findElement(By.xpath("//*[@class='datepicker-transfers sbox-v4-components']//span[@class='_dpmg2--date _dpmg2--available _dpmg2--weekend']//span[.='9']")).click();
        //Se ingresa en campo hora "04:00"
        Select objSelect = new Select(driver.findElement(By.xpath("//select[@class='select-tag sbox-time-arrival']")));
        objSelect.selectByValue("240");
        driver.findElement(By.xpath("//*[@class='sbox-3-input -md sbox-distri-input sbox-3-validation -top-right sbox-passengers-error-wrapper sbox-passengers-container']")).click();
        //agregar 20 adultos a los pasajeros
        int i=2;
        while(i<20) {
            driver.findElement(By.xpath("//a[@class='steppers-icon-right sbox-3-icon-plus']")).click();
            i++;
        }
        //presionar en "buscar"
        driver.findElement(By.xpath("//em[.='Buscar']")).click();
        WebElement txt = driver.findElement(By.xpath("//div[@class='empty-state-message-title']//span"));
        //se rescata el texto del webElement txt
        String texto = txt.getText();
        Assert.assertEquals("¡Ups! No hay traslados disponibles para esta fecha.",texto);
    }

    @Test
    public void atc08_ValidarQueNoSeAceptenRutConPuntosCMRInsuficientesParaCanjearUnTraslado() {
        //ir a servicio Traslados
        driver.findElement(By.xpath("//ul[@class='header-list-products'] //a[@class='shifu-3-button-circle TRANSFERS paint-circle ']")).click();
        //Se ingresa aeropuerto de origen
        driver.findElement(By.xpath("//div[@class='input-container']//input[@class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline']")).sendKeys("Aeropuerto Arturo Merino Benitez, Santiago de Chile, Chile");
        //selecciona el aeropuerto sugerido en la lista
        driver.findElement(By.xpath("//ul[@class='ac-group-items']//li[@class='item -active']")).click();
        //click en campo de Hotel de destino
        WebElement aDestino = driver.findElement(By.xpath("//div[@class='input-container'] //input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']"));
        aDestino.click();
        //Se ingresa Hotel de destino
        aDestino.sendKeys("Enjoy Viña del Mar - San Martín, Valparaíso, Viña del Mar, Chilen");
        //se selecciona el Hotel de destino sugerido en la lista
        driver.findElement(By.xpath("//ul[@class='ac-group-items']//li[@class='item -active']")).click();
        //se hace click en el campo de fecha de Arribo
        driver.findElement(By.xpath("//div[@class='input-container'] //input[@class='input-tag sbox-checkin']")).click();
        //seleccionar la fecha de arribo
        driver.findElement(By.xpath("//*[@class='datepicker-transfers sbox-v4-components']//span[@class='_dpmg2--date _dpmg2--available _dpmg2--today']//span[.='3']")).click();
        //Se ingresa en campo hora "20:00"
        Select objSelect = new Select(driver.findElement(By.xpath("//select[@class='select-tag sbox-time-arrival']")));
        objSelect.selectByValue("1200");
        //Se selecciona el checkbox 'Quiero agregar el regreso'
        driver.findElement(By.xpath("//i[@class='checkbox-check sbox-3-icon-checkmark -mr1 sbox-ui-icon']")).click();
        //seleccionar Fecha de partida 5 de febrero 2022
        driver.findElement(By.xpath("//input[@class='input-tag sbox-checkout']")).click();
        driver.findElement(By.xpath("//*[@class='datepicker-transfers sbox-v4-components']//span[@class='_dpmg2--date _dpmg2--available _dpmg2--weekend']//span[.='5']")).click();
        //Seleccionar hora de partida a las 12:00
        Select objSelect2 = new Select(driver.findElement(By.xpath("//select[@class='select-tag sbox-time-departure']")));
        objSelect2.selectByValue("720");
        //presionar en "buscar"
        driver.findElement(By.xpath("//em[.='Buscar']")).click();
        //comprar el primer traslado de la lista
        driver.findElement(By.xpath("//div[@class='cluster-container']//button[@class='eva-3-btn -md -eva-3-fwidth -secondary']")).click();
        //seleccionar ¿Quieres canjear tus CMR Puntos?
        driver.findElement(By.xpath("//span[@class='-sm -top-left eva-3-checkbox eva-3-validation-inline form-element']//i[@class='checkbox-check eva-3-icon-checkmark -eva-3-mr-sm']")).click();
        driver.findElement(By.id("cmr-payer-identification-number")).sendKeys("15752836k");
        //Presionar ENTER en campo RUT
        driver.findElement(By.id("cmr-payer-identification-number")).sendKeys(Keys.ENTER);
        WebElement txt = driver.findElement(By.xpath("//div[@class='eva-3-message -error -eva-3-mb-md -eva-3-mt-md -no-title']//p[@class='eva-3-p message-text']"));
        //se rescata el texto del webElement txt
        String texto = txt.getText();
        Assert.assertEquals("El documento ingresado, no tiene puntos suficientes para realizar esta operación.",texto);
    }

    @Test @Ignore
    public void atc09_validarFlujodeCompraDeUnTrasladoConTransferencia() throws InterruptedException {
        //ir a servicio Traslados
        driver.findElement(By.xpath("//ul[@class='header-list-products'] //a[@class='shifu-3-button-circle TRANSFERS paint-circle ']")).click();
        //Se ingresa aeropuerto de origen
        driver.findElement(By.xpath("//div[@class='input-container']//input[@class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline']")).sendKeys("Aeropuerto Barajas, Madrid, España");
        //selecciona el aeropuerto sugerido en la lista
        driver.findElement(By.xpath("//ul[@class='ac-group-items']//li[@class='item -active']")).click();
        //click en campo de Hotel de destino
        WebElement aDestino = driver.findElement(By.xpath("//div[@class='input-container'] //input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']"));
        aDestino.click();
        //Se ingresa Hotel de destino
        aDestino.sendKeys("Hotel Riu Plaza España, Calle Gran Vía, Madrid, España");
        //se selecciona el Hotel de destino sugerido en la lista
        driver.findElement(By.xpath("//ul[@class='ac-group-items']//li[@class='item -active']")).click();
        //se hace click en el campo de fecha de Arribo
        driver.findElement(By.xpath("//div[@class='input-container'] //input[@class='input-tag sbox-checkin']")).click();
        //seleccionar la fecha de arribo
        driver.findElement(By.xpath("//*[@class='datepicker-transfers sbox-v4-components']//span[@class='_dpmg2--date _dpmg2--available _dpmg2--weekend']//span[.='16']")).click();
        //presionar en "buscar"
        driver.findElement(By.xpath("//em[.='Buscar']")).click();
        //comprar el primer traslado de la lista
        driver.findElement(By.xpath("//div[@class='cluster-container']//button[@class='eva-3-btn -md -eva-3-fwidth -secondary']")).click();
        //se selecciona la transferencia bancaria
        driver.findElement(By.xpath("//li[@class='payment-method-option']//span[.='Transferencia Bancaria']")).click();
        //se ingresa el nombres y apellidos del usuario
        driver.findElement(By.cssSelector("[placeholder='Ej.: Juan Pérez']")).sendKeys("Marcela carolina Fredez vidal");
        //se selecciona la opcion 'PASAPORTE'
        driver.findElement(By.cssSelector(".invoice-fiscal-identification-number")).sendKeys("0201184541");
        Select objSelect = new Select(driver.findElement(By.id("invoice-fiscal-identification-type-0")));
        objSelect.selectByValue("PASAPORTE");
    }

    @After
    public void close() throws InterruptedException {
        if(driver != null){
            Thread.sleep(4000);
            System.out.println("Close");
            driver.quit();
        }

    }

    @AfterClass
    public static void closeAll(){
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }

}
