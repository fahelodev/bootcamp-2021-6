package desafio.equipo6;

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

import static desafio.equipo4.Herramientas.changeTab;

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

    //----------------------------------Alojamiento------------------------------------------------------

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
        changeTab(driver, 10);

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
        changeTab(driver, 10);
        // Validar si el Hotel está agotado y presiorar en botón "Ver otros alojamientos"
        Thread.sleep(3000);
        String texto = driver.findElement(By.xpath("//h3[@class='eva-3-h3']")).getText();
        System.out.println(texto);
        Assert.assertEquals( "Agotado", texto);
        System.out.println("Estado de hotel: Agotado");
        driver.findElement(By.xpath("//a[@class='eva-3-btn-ghost -md -eva-3-fwidth']")).click();

        // En casilla Ordenar por, seleccionar "Mejor precio / calidad
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select//option[@value='quality_price_descending']")).click();

        // Seleccionar el hotel "Cabañas Campanario" de la lista"
        driver.findElement(By.xpath("//div[@class='cluster-content-wrapper']")).click();
        changeTab(driver, 10);

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
        driver.findElement(By.xpath("(//div[@class='promotion-wrapper'])[1]")).click();

        // Cambiamos de ventana
        changeTab(driver, 10);

        // Filtramos reserva flexible.
        Thread.sleep(2000);
        driver.findElement(By.xpath("//aloha-tag[@class='eva-3-tag' and contains(span, ' Reserva flexible ')]")).click();

            // Seleccionamos "habitación doble de lujo"
        driver.findElement(By.xpath("(//label[@class='radio-label-container'])[2]")).click();

            // Oprimimos "siguiente" hasta llegar a la página para llenar datos.
        driver.findElement(By.xpath("(//button[contains(@class,'eva-3-btn -md')])[2]")).click();
        driver.findElement(By.xpath("(//a[@tooltip-position='LEFT_BOTTOM']//div)[1]")).click();
        driver.findElement(By.xpath("//button[contains(@class,'eva-3-btn -lg')]")).click();

            // Comprar la reserva sin marcar la casilla de "terminos y condiciones"
        driver.findElement(By.xpath("//a[contains(@class,'eva-3-btn -lg')]")).click();
        String Resultado = driver.findElement(By.xpath("//span[text()='Acepta los términos y condiciones ']")).getText();
        Assert.assertEquals("Acepta los términos y condiciones", Resultado);
        }

    //-------------------------------------Paquetes------------------------------------------------------
    @Test @Ignore
    public void atc04_AplicarFiltrosEnBusquedaDePaquetes() throws InterruptedException {
        // Ir a servicio Paquetes
        driver.findElement(By.xpath("//a[@data-action='combinedproducts-click']")).click();

        // Buscar banner de "Paquetes a Rio de Janeiro"
        driver.findElement(By.xpath("//div[text()='Paquetes a Rio de Janeiro']")).click();

        // Seleccionar las "7 noches" predefinidas
        driver.findElement(By.xpath("//div[text()='7 NOCHES']")).click();
        // Cambiamos de ventana
        changeTab(driver, 10);

        // Marcar la casilla "5 estrellas"
        driver.findElement(By.xpath("(//i[contains(@class,'checkbox-check eva-3-icon-checkmark')])[5]")).click();
        Thread.sleep(2000);

        // Marcar la casilla "desayuno"
        driver.findElement(By.xpath("(//i[contains(@class,'checkbox-check eva-3-icon-checkmark')])[3]")).click();
        Thread.sleep(2000);

        // Marcar la casilla  "cadena hotelera windsor"
        driver.findElement(By.xpath("(//input[@class='checkbox-tag']/following-sibling::i)[2]")).click();
        Thread.sleep(2000);

        // Marcar la casilla "zona copacabana"
        driver.findElement(By.xpath("//em[@class='subitem-label filters-text-label']//span[contains(text(),'Windsor')]")).click();
        String Resultado = driver.findElement(By.xpath("//span[text()='Miramar Hotel by Windsor']")).getText();
        Assert.assertEquals("Miramar Hotel by Windsor", Resultado);
        Thread.sleep(8000);
    }

    @Test
    public void atc05_IngresarDatosInvalidosEnCamposDeBusqueda() throws InterruptedException {

        // Ir a servicio Paquetes
        driver.findElement(By.xpath("//a[@data-action='combinedproducts-click']")).click();

        // Ingresar en campo ciudad origen "Buenos Aires, Ciudad de Buenos Aires, Argentina"
        WebElement caja1 = driver.findElement(By.xpath("//input[@placeholder='Ingresa una ciudad']"));
        caja1.sendKeys("Buenos Aires, Ciudad de Buenos Aires, Argentina");
        Thread.sleep(2000);
        caja1.sendKeys(Keys.TAB);

        // Ingresar en campo ciudad Destino "Santiago de Chile, Santiago, Chile"
        WebElement caja2 = driver.findElement(By.xpath("(//input[@placeholder='Ingresa una ciudad'])[2]"));
        caja2.sendKeys("Santiago de Chile, Santiago, Chile");
        Thread.sleep(2000);
        caja2.sendKeys(Keys.TAB);

        // Ingresar en campo fecha Ida la mas proxima
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
        driver.findElement(By.xpath("//*[@class='datepicker-packages sbox-v4-components']//span[@class='_dpmg2--date _dpmg2--available']//span[.='10']")).click();

        // Ingresar en campo fecha Vuelta la mas proxima
        driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show _dpmg2--transition-displacement']//div[@class='_dpmg2--month _dpmg2--o-6 _dpmg2--has-start-range _dpmg2--month-active']//span[.='14']")).click();

        // Abrir opciones avanzadas del alojamiento
        driver.findElement(By.xpath("//div[contains(@class,'sbox-advanced-options-group-container -mt3-l')]//div[1]")).click();

        // Ingresar en campo destino "Viña del Mar, Valparaíso, Chile"
        driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::i)[1]")).click();
        Thread.sleep(2000);
        WebElement caja3 = driver.findElement(By.xpath("(//input[contains(@class,'input-tag sbox-main-focus')])[5]"));
        caja3.sendKeys("Viña del Mar, Valparaíso, Chile");
        Thread.sleep(2000);
        caja3.sendKeys(Keys.TAB);

        // Ingresar  en campo fecha desde una fecha dentro de las fechas asignadas
        driver.findElement(By.xpath("(//i[contains(@class,'checkbox-check sbox-3-icon-checkmark')])[2]")).click();
        driver.findElement(By.xpath("(//input[@placeholder='Desde'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--month _dpmg2--o-6 _dpmg2--has-start-range _dpmg2--has-end-range _dpmg2--month-active']//span[.='12']")).click();

        // Ingresar en campo fecha de estadía Hasta  fuera de las fechas asignadas
        driver.findElement(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-6 _dpmg2--has-start-range _dpmg2--month-active']//span[.='17']")).click();
        driver.findElement(By.xpath("//em[@class='btn-text']")).click();

        //Validacion
        String laFechaDe = driver.findElement(By.xpath("(//span[text()='La fecha de entrada y salida en el alojamiento, debe estar dentro de las fechas de partida y regreso de tu vuelo.'])[3]")).getText();
        Assert.assertEquals("La fecha de entrada y salida en el alojamiento, debe estar dentro de las fechas de partida y regreso de tu vuelo.",laFechaDe);

    }

    @Test
    public void atc06_IngresarDatosInvalidosEnCamposDeTarjetaDeCredito() throws InterruptedException {
        // Ir a servicio Paquetes
        driver.findElement(By.xpath("//a[@data-action='combinedproducts-click']")).click();

        // Seleccionar "vuelos + 2 Viajes"
        driver.findElement(By.xpath("(//input[@name='selected-box'])[2]")).click();

        // Rellenar el origen con "santiago de chile"
        WebElement caja1 = driver.findElement(By.xpath("(//input[@placeholder='Ingresa una ciudad'])[1]"));
        caja1.click();
        caja1.sendKeys("santiago de chile");
        Thread.sleep(2000);
        caja1.sendKeys(Keys.TAB);

        // rellenar destino "los angeles california"
        WebElement caja2 = driver.findElement(By.xpath("(//input[@placeholder='Ingresa una ciudad'])[2]"));
        caja2.click();
        caja2.sendKeys("los angeles california");
        Thread.sleep(2000);
        caja2.sendKeys(Keys.TAB);

        // Seleccionamos la fecha de ingreso de los dos alojamientos (aproximadamente 20 dias)
        driver.findElement(By.xpath("//input[@placeholder='Ida']")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--month _dpmg2--o-6 _dpmg2--month-active']//span[@class='_dpmg2--date _dpmg2--available']/span[.='17']")).click();

        // Elegir fecha de salida del primer destino
        driver.findElement(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-6 _dpmg2--has-start-range _dpmg2--month-active']//span[.='31']")).click();
        driver.findElement(By.xpath("(//input[@placeholder='Hasta'])[1]")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-6 _dpmg2--has-start-range _dpmg2--has-limit-date _dpmg2--month-active']//span[.='24']")).click();

        // Rellenar el segundo destino "nueva york"
        WebElement caja3 = driver.findElement(By.xpath("(//input[@placeholder='Ingresa una ciudad o un alojamiento'])[2]"));
        caja3.click();
        caja3.sendKeys("nueva york");
        Thread.sleep(2000);
        caja3.sendKeys(Keys.TAB);

        // Seleccionar la fecha del segundo destino y realizar la busqueda
        driver.findElement(By.xpath("(//input[@placeholder='Desde'])[2]")).click();
        driver.findElement(By.xpath("(//span[text()='25'])[1]")).click();
        driver.findElement(By.xpath("//div[@class='sbox-button-container']//a[1]")).click();

        // Seleccionar filtro "1 escala +"
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@data-sfa-id='fast-filter'])[1]")).click();

        // Seleccionar siguiente en el primer vuelo de "otros vuelos"
        driver.findElement(By.xpath("(//a[@class='-md eva-3-btn-ghost']//div)[1]")).click();

        // Seleccionar "Four Points by Sheraton Los Angeles International Aiport" y precionamos en continuar
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='cluster-description cluster-description-top'])[1]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'pricebox-action -eva-3-mt-lg')]//button[1]")).click();

        // Seleccionar el "Innside by Melia New York" y continuar
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='cluster-description cluster-description-top'])[1]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'pricebox-action -eva-3-mt-lg')]//button[1]")).click();

        // Seleccionar la "habitacion doble de lujo con vista con desayuno buffet"

        // Ingresar un numero invalido de tarjeta
        driver.findElement(By.xpath("//input[@placeholder='Ingresa el número de tu tarjeta']")).sendKeys("111111111111111");
        // Ingresar un nombre invalido del titular
        driver.findElement(By.xpath("//input[@placeholder='Como figura en la tarjeta']")).sendKeys("asdad");
        // Ingresar una fecha inexistente de vencimiento
        driver.findElement(By.xpath("//input[@placeholder='MM/AA']")).sendKeys("1");
        // Ingresar número de documento invalido
        driver.findElement(By.xpath("//input[@placeholder='Ej.: 15234765']")).sendKeys("asdasd");
        driver.findElement(By.id("buy-button")).click();
        Thread.sleep(2000);
        //Validacion
        String Resultado1 = driver.findElement(By.xpath("(//span[@class='validation-msg'])[1]")).getText();
        String Resultado2 = driver.findElement(By.xpath("(//span[@class='validation-msg'])[2]")).getText();
        String Resultado3 = driver.findElement(By.xpath("(//span[@class='validation-msg'])[3]")).getText();
        String Resultado4 = driver.findElement(By.xpath("(//span[@class='validation-msg'])[4]")).getText();
        Assert.assertEquals("Tarjeta inválida. Revisa la información de pago.", Resultado1);
        Assert.assertEquals("Verifique que el nombre del titular de la tarjeta esté completo, al menos un nombre y un apellido.", Resultado2);
        Assert.assertEquals("Formato inválido", Resultado3);
        Assert.assertEquals("Ingresa el código de seguridad", Resultado4);
    }

    //-------------------------------------Traslados----------------------------------------

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

    @Test
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
        //Se ingresa País
        Select objSelect2 = new Select(driver.findElement(By.xpath("//select[@id='invoice-fiscal-identification-issueCountry-0']")));
        objSelect2.selectByValue("AR");
        //Se ingresan datros personales para la compra
        driver.findElement(By.cssSelector(".invoice-fiscal-address-street")).sendKeys("Avenida perón");
        driver.findElement(By.cssSelector(".traveler-first-name")).sendKeys("Juan Carlos");
        driver.findElement(By.cssSelector(".traveler-last-name")).sendKeys("Perez Gomez");
        driver.findElement(By.xpath("//input[@id='transfer-info-departure-airline-0']")).sendKeys("Aerotransportes Mas de Carga (A7)");
        driver.findElement(By.xpath("//input[@id='transfer-info-departure-airline-0']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector(".ui-menu")).click();
        driver.findElement(By.xpath("//input[@id='transfer-info-departure-flightNumber-0']")).sendKeys("1780");
        driver.findElement(By.cssSelector("[placeholder='Ingresa el email de contacto']")).sendKeys("benjamin2525@gmail.com");
        driver.findElement(By.cssSelector("[placeholder='Ingresa tu email']")).sendKeys("benjamin2525@gmail.com");
        driver.findElement(By.cssSelector("[autocomplete='section-contact-phone-0 tel-area-code']")).sendKeys("9");
        driver.findElement(By.cssSelector("[placeholder='Ingresa un número']")).sendKeys("53542347");
        //se aceptan Terminos y Condiciones
        driver.findElement(By.cssSelector("[for='terms-checkbox'] > .checkbox-check")).click();
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
