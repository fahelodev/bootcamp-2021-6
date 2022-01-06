package desafio.equipo1;

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
import java.util.List;

public class ViajesFalabellaTest {
    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();

    }

    //se instancia el driver y se le entrega la url a testear
    @Before
    public void initial() {
        driver = new ChromeDriver();
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().window().maximize();
    }

    @Test
    public void atc01_AlojamientoBasico() throws InterruptedException {
        //instancia de wait en 5 seg
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //click en seccion de alojamiento
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Alojamientos\")]"))).click();
        //escritura en destino
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,\"destination\")]"))).sendKeys("Rio");
        //click en primera coincidencia con el destino ingresado
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"ac-group-container\"]/ul/li"))).click();
        //click en checkbox como no esta definido el dia de viaje ni personas
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"checkbox\")]//label"))).click();
        //click en boton de buscar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"sbox-button\")]//a"))).click();
        //click en filtro de estrella
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"filter-tags-wrapper\"]//span[contains(text(),\"Estrellas\")]"))).click();
        //click en 5 estrellas
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,\"-show-tooltip\")]//em[contains(text(),\"5\")and contains(@class,\"filter-name\")]"))).click();

        //click de aplicar filtro
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,\"-show-tooltip\")]//em[contains(text(),\"Aplicar\")]"))).click();
        //sleep ya realiza demasiado rapido la obtencion del siguiente elemento
        Thread.sleep(1000);
        //obtencion de cantidad de estrellas
        List<WebElement> stars = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[contains(@class,\"card-rating\")])[1]//i")));

        Assert.assertEquals(5, stars.size());
    }

    @Test
    public void atc01_PaqueteBasico() {
        // Sincronizacion explicita
        WebDriverWait d = new WebDriverWait(driver, 5);
        // Instanciar objeto desplegable origen
        WebElement origen = driver.findElement(By.cssSelector(".sbox-origin"));
        origen.sendKeys("Arturo Merino");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item-text")));
        origen.sendKeys(Keys.ENTER);
        // Instanciar objeto desplegable destino
        WebElement destino = driver.findElement(By.cssSelector(".sbox-destination"));
        destino.sendKeys("Lima");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".-active")));
        destino.sendKeys(Keys.ENTER);
        // Click al boton swtich "Todavía no he decidido la fecha"
        WebElement switch1 = driver.findElement(By.cssSelector(".switch-container"));
        switch1.click();
        // Seleccionamos el mes de enero en el SELECT
        Select m = new Select(driver.findElement(By.cssSelector(".sbox-month-seletor")));
        m.selectByValue("2022-01");
        // Click boton BUSCAR
        WebElement btn = driver.findElement(By.cssSelector("a.-md"));
        btn.click();
        // Click filtro noches
        WebElement filter = driver.findElement(By.cssSelector("span.filter-tags-wrapper:nth-child(2) > div:nth-child(1)"));
        filter.click();
        // Click en boton "Mas 8 noches"
        WebElement filter_btn = driver.findElement(By.cssSelector(".filters-tooltip > div:nth-child(1) > div:nth-child(1) > div:nth-child(5)"));
        filter_btn.click();
        // Click boton Aplicar
        WebElement add = driver.findElement(By.cssSelector(".filters-tooltip > div:nth-child(2) > a:nth-child(2)"));
        add.click();
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".DESTINATION")));
        // Verificar que los filtros esten aplicados
        String text1 = driver.findElement(By.cssSelector("span.filter-tags-wrapper:nth-child(1) > div:nth-child(1) > p:nth-child(1)")).getText();
        String text2 = driver.findElement(By.cssSelector("span.filter-tags-wrapper:nth-child(2) > div:nth-child(1) > p:nth-child(1)")).getText();
        Assert.assertEquals("Enero", text1);
        Assert.assertEquals("Más de 8 noches", text2);
    }

    @Test
    public void atc01_TrasladoBasico() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Seleccionamos opción traslado
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Traslados\")]"))).click();
        //Seleccionar radiobutton Hacia el aeropuerto
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sbox-radio-buttons']//i[@class='radio-circle sbox-radio-circle'])[2]"))).click();
        //Escribimos el aeropuerto
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[contains(@placeholder, 'aeropuerto')]"))).sendKeys("Córdoba");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac-group-container']//span[@class='item-text']"))).click();
        //Escribimos el hotel
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[contains(@placeholder, 'hotel')]"))).sendKeys("Amerian Park Hotel");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac-container']//span[contains(text(), 'Amerian Córdoba')]"))).click();
        //Seleccionar la fecha del traslado
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='input-container']//input[contains(@placeholder, 'Partida')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='_dpmg2--dates']//span[contains(text(), '11')])[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--date-footer']//em[contains(@class, 'apply')]"))).click();
        //Seleccionar la hora del traslado
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select-container']//select[@class='select-tag sbox-time-departure']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='select-container']//option[text()='18:00'])[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='select-container']//select[contains(@class, 'time')])[2]"))).click();
        //Clickear boton de busqueda
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sbox-button-container']"))).click();
        //Crear variable y array para comparar los precios
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sub-nav-container']//label/span[2]"))).getText();
        String[] arr = value.split(" ");
        String value2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricebox-value']/span[2]"))).getText();
        Assert.assertEquals(arr[1], value2);
    }

    @Test
    public void atc02_AlojamientoMedio() throws InterruptedException {
        //instancia de wait con 5 seg
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //click en seccion de alojamiento
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Alojamientos\")]"))).click();
        //introducir texto en busqueda
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,\"destination\")]"))).sendKeys("Rio");
        //click en primera opcion mostrada relacionado a la busqueda
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"ac-group-container\"]/ul/li"))).click();
        //click en dias
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"checkin-date\")]"))).click();
        //bucle para obtencion de mes deseado
        while (true) {
            //guardando el nombre del mes que este activo
            String active = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,\"month-active\")]/div[contains(@class,\"month-title\")]/span"))).getText();
            //condicional si es que el nombre buscado no es el mes que esta activo hace click para pasar al siguiente mes
            if (!active.equals("Mayo")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"controls-next\")]"))).click();
            } else {
                //sale del ciclo ya que el mes buscado esta como activo
                break;
            }
        }
        //click en fecha de ida
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[1]"))).click();
        Thread.sleep(500);
        //click en fecha de vuelta
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[31]"))).click();
        //click en boton de aplicar fecha
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,\"button-apply\")]"))).click();
        //click en personas que alojan
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"guests-container\")]/div"))).click();
        //click para agregar un menor
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"stepper-minors\")]//a[not(contains(@class,\"disable\"))]"))).click();
        //uso de select para seleccionar la opcion de la edad
        Select age = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"select-container\"]/select"))));
        age.selectByIndex(15);
        //click para aplicar cantidad de personas
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"medium-down\")]/a[contains(@class,\"link-right\")]"))).click();
        //click en busqueda
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"sbox-button\"]//a"))).click();
        //seleccion para tipo de orden de ver alojamiento y hoteles
        Select order = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aloha-select[contains(@class,\"sorting\")]//select"))));
        order.selectByIndex(2);

        //click en opcion de filtro Desayuno
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aloha-checkbox-filter/ul/li//span[contains(text(),\"Desayuno\")]"))).click();
        //click en cantidad de estrellas
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aloha-checkbox-filter//em/i"))).click();
        //obtencion de especificacion que cumple el hotel
        String specf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"pricebox-top-container\"]//p[contains(text(),\"3 personas\")]"))).getText();
        Assert.assertEquals("30 noches, 3 personas", specf);
    }

    @Test
    public void atc02_PaqueteMedio() {
        // Sincronizacion explicita
        WebDriverWait d = new WebDriverWait(driver, 10);
        // Instanciar objeto desplegable origen
        WebElement origen = driver.findElement(By.cssSelector(".sbox-origin"));
        origen.sendKeys("bue");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item-text")));
        origen.sendKeys(Keys.ENTER);
        // Instanciar objeto desplegable destino
        WebElement destino = driver.findElement(By.cssSelector(".sbox-destination"));
        destino.sendKeys("mia");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".-active")));
        destino.sendKeys(Keys.ENTER);
        // Click en box fechas
        WebElement fechas = driver.findElement(By.cssSelector(".sbox-checkin-date"));
        fechas.click();
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._dpmg2--show > div:nth-child(2)")));
        WebElement ida_nro = driver.findElement(By.cssSelector("._dpmg2--show > div:nth-child(5) > div:nth-child(2) > div:nth-child(4) > span:nth-child(11) > span:nth-child(1)"));
        ida_nro.click();
        WebElement vuelta_nro = driver.findElement(By.cssSelector("._dpmg2--show > div:nth-child(5) > div:nth-child(2) > div:nth-child(4) > span:nth-child(25) > span:nth-child(1)"));
        vuelta_nro.click();
        // Click boton aplicar
        WebElement btn = driver.findElement(By.cssSelector("._dpmg2--show > div:nth-child(6) > div:nth-child(2) > button:nth-child(2) > em:nth-child(1)"));
        btn.click();
        // Click en box habitaciones
        WebElement room = driver.findElement(By.cssSelector(".sbox-distri-input > div:nth-child(1)"));
        room.click();
        // Agregar adulto
        WebElement plus = driver.findElement(By.cssSelector("div._pnlpk-dynamicContent:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(4)"));
        plus.click();
        // Click en boton Aplicar
        WebElement btn1 = driver.findElement(By.cssSelector("._pnlpk-panel--show > div:nth-child(2) > a:nth-child(1)"));
        btn1.click();
        // Click boton Buscar
        WebElement search = driver.findElement(By.cssSelector("em.btn-text:nth-child(2)"));
        search.click();
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.package-title:nth-child(1)")));
        String text = driver.findElement(By.cssSelector("h3.package-title:nth-child(1)")).getText();
        Assert.assertEquals("Este es el paquete perfecto para tí. ¡Empieza a vivir tu viaje!", text);
    }

    @Test
    public void atc02_TrasladoMedio() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Seleccionamos opción traslado
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Traslados\")]"))).click();
        //Escribimos el aeropuerto
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[contains(@placeholder, 'aeropuerto')]"))).sendKeys("Córdoba");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac-group-container']//span[@class='item-text']"))).click();
        //Escribimos el hotel
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[contains(@placeholder, 'hotel')]"))).sendKeys("Amerian Park Hotel");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac-container']//span[contains(text(), 'Amerian Córdoba')]"))).click();
        //Escogemos el mes a través de un bucle
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='input-container']//input[contains(@placeholder, 'Arribo')]"))).click();
        while (true) {
            //se crea un string con los meses
            String dates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'month-active')])[2]//span[contains(@class,\"title-month\")]"))).getText();
            //se crea la condicion de que si el nombre del mes no es igual a Febrero haga click
            if (!dates.equals("Febrero")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='_dpmg2--controls-next'])[2]"))).click();
            } else {//sale del bucle al cumplirse la condicion
                break;
            }
        }
        //Seleccionamos la fecha
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//div[contains(@class,'month-active')])[2]//span[contains(@class, 'number')])[7]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'btn-container')])[2]/button[contains(@class, 'apply')]"))).click();
        //Seleccionamos la hora
        Select hour = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sbox-moment-input']//select[contains(@class, 'arrival')]"))));
        hour.selectByIndex(16);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[contains(@class, 'arrival')]"))).click();
        //Clickeamos el checkbox "Quiero agregar el regreso"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'places-check')]//i"))).click();
        //Seleccionamos la fecha de regreso
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sbox-row'])[2]//input"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//div[contains(@class, 'month-active')])[2]//span[contains(@class, 'number')])[21]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'btn-container')])[2]/button[contains(@class, 'apply')]"))).click();
        //Seleccionamos la hora de regreso
        Select hour2 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sbox-row'])[2]//select"))));
        hour2.selectByIndex(40);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sbox-row'])[2]//select"))).click();
        //Añadimos un menor de edad a los pasajeros
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sbox-distri-container']//div[@class='input-container']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'number-picker')])[2]//a[contains(@class, 'plus')]"))).click();
        //Escogemos la edad del menor de edad
        Select age = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'minors-age')]//select"))));
        age.selectByIndex(18);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[contains(@class, 'apply')]"))).click();
        //Clickeamos el boton de busqueda
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sbox-button']//a"))).click();
        //Creamos variables y array para la validacion
        String person = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[contains(@class,'re-search')])[2]//span[@class='item-container'])[3]"))).getText();
        String person2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='item'])[1]/span[contains(text(), 'personas')]"))).getText();
        String[] arr = person2.split(" ");
        String num = arr[0];
        //Transformamos a int los Strings para comparar
        int passengerTravel = Integer.parseInt(num);
        int passengerCar = Integer.parseInt(person);
        Assert.assertTrue(passengerCar >= passengerTravel);
    }


    @Test
    public void atc03_AlojamientoComplejo() throws InterruptedException {
        //Instancia de wait
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //click en seccion de alojamientos
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Alojamientos\")]"))).click();
        //entrega de texto para seccion de destino
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,\"destination\")]"))).sendKeys("Rio");
        //click en la primera opcion entregada segun el texto de destino
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"ac-group-container\"]/ul/li"))).click();
        //click en opciones de fechas
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"checkin-date\")]"))).click();

        //click en flecha hasta encontrar el mes de mayo
        while (true) {
            String active = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,\"month-active\")]/div[contains(@class,\"month-title\")]/span"))).getText();
            if (!active.equals("Mayo")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"controls-next\")]"))).click();
            } else {
                break;
            }
        }
        //click en el dia de ida
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[1]"))).click();
        Thread.sleep(500);
        //click en el dia de vuelta
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[31]"))).click();
        //click en boton de aplicar fecha
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,\"button-apply\")]"))).click();
        //click en opciones de personas
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"guests-container\")]/div"))).click();
        //click en añadir una habitaciones
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"medium\")]/a[contains(text(),\"Añadir\")]"))).click();
        //click en añadir un menor
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"stepper-minors\")]//a[not(contains(@class,\"disable\"))]"))).click();
        //uso de clase Select para seleccionar edad
        Select age = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"select-container\"]/select"))));
        //seleccion de 14 años
        age.selectByIndex(15);
        //click en agregar un adulto
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=\"_pnlpk-itemBlock\"]//a[contains(@class,\"plus\")])[3]"))).click();
        //click en agregar un menor
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"stepper-minors\")]//a[not(contains(@class,\"disable\"))])[3]"))).click();
        //uso de clase Select para seleccionar edad
        Select ageSecond = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=\"select-container\"]/select)[8]"))));
        //seleccion de 17 años
        ageSecond.selectByIndex(18);
        //click en aplicar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"medium-down\")]/a[contains(@class,\"link-right\")]"))).click();
        //click en boton de buscar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"sbox-button\"]//a"))).click();
        //click en filtro de desayuno
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aloha-checkbox-filter//span[contains(text(),\"Desayuno\")]"))).click();
        Thread.sleep(2000);
        //click en ver en mapa
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"results-toolbar\")]//div[contains(@class,\"right-buttons\")]//label"))).click();

        //entrega de ubicacion cercana
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"input-container\"]/input[contains(@placeholder,\"lugares\")]"))).sendKeys("Copacabana");
        //click en nombre de ubicacion
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"tooltip-container\")]//ul/li"))).click();

        //obtencion de hoteles cercanos a la ubicacion
        List<WebElement> hotels = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"hotel-marker\"]//span[contains(@class,\"marker-text\")]")));
        int count = 0;

        //ciclo para iterar la cantidad de hoteles cercanos
        for (int i = 1; i <= hotels.size(); i++) {
            //si i+1 se sale del rango de cantidad hoteles hace un break
            if (i + 1 > hotels.size()) {
                break;
            }
            //obtencion de texto del precio en i
            String price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"hotel-marker\"]//span[contains(@class,\"marker-text\")])[" + i + "]"))).getText();
            //obtencion de texto del precio en i+1
            String priceAfter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"hotel-marker\"]//span[contains(@class,\"marker-text\")])[" + (i + 1) + "]"))).getText();
            //transformacion en array
            String[] arr = price.split(" ");
            String[] arr2 = priceAfter.split(" ");
            //guardar el primer elemento
            String elemtOne = arr[1];
            String elemtTwo = arr2[1];
            //trasformar a entero usando un replace para quitar .
            int priceInt = Integer.parseInt(elemtOne.replace(".", ""));
            int priceAfterInt = Integer.parseInt(elemtTwo.replace(".", ""));
            //si count tiene un valor hace el mismo proceso de obtencion de texto
            if (count != 0) {
                price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"hotel-marker\"]//span[contains(@class,\"marker-text\")])[" + count + "]"))).getText();
                arr = price.split(" ");
                elemtOne = arr[1];
                priceInt = Integer.parseInt(elemtOne.replace(".", ""));
            }
            //si el precio en i es mayo al de i+1
            if (priceInt > priceAfterInt) {
                //si contador es igual a 0 guardara se asignara i a count
                if (count == 0) {
                    count = i;
                }
            } else {//si el after price es mayor guardara i+1 en el count
                count = i + 1;
            }
        }
        //click en hotel mas caro
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=\"hotel-marker\"]//span[contains(@class,\"marker-text\")])[" + count + "]"))).click();
        //obtiene specificaciones del hotel y valida
        String specf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"reduced-cluster-wrapper\"]//p[contains(@class,\"first\")]"))).getText();
        Assert.assertEquals("30 noches, 7 personas", specf);
        //obtiene locadidad y valida
        String located = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"marker-container\"]//span[contains(@class,\"text\")])[1]"))).getText();
        Assert.assertEquals("Copacabana", located);
    }

    @Test
    public void atc03_PaqueteComplejo() throws InterruptedException {
        // Sincronizacion explicita
        WebDriverWait d = new WebDriverWait(driver, 10);
        //Seleccionar origen
        WebElement origen = driver.findElement(By.cssSelector(".sbox-origin"));
        origen.sendKeys("Cordoba");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Córdoba, Córdoba, Argentina']")));
        origen.sendKeys(Keys.ENTER);
        //Seleccionar destino
        WebElement destino = driver.findElement(By.cssSelector(".sbox-destination"));
        destino.sendKeys("Miami");
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ac-container > div > div")));
        destino.sendKeys(Keys.ENTER);
        //Seleccionar fecha
        driver.findElement(By.cssSelector(".sbox-checkin-date")).click();
        //Numero salida
        driver.findElement(By.xpath("//html/body/div[5]/div/div[5]/div/div[4]/span[11]")).click();
        //Numero vuelta
        driver.findElement(By.xpath("//html/body/div[5]/div/div[5]/div/div[4]/span[25]")).click();
        //Aplicar
        driver.findElement(By.xpath("//html/body/div[7]/div/div[6]/div[2]/button[2]/em")).click();
        //Click en habitaciones
        driver.findElement(By.cssSelector(".sbox-distri-input .input-container")).click();
        //Añadir habitacion
        driver.findElement(By.xpath("//a[text()='Añadir habitación']")).click();
        //Aplicar
        driver.findElement(By.cssSelector("._pnlpk-panel--show ._pnlpk-apply-button")).click();
        //Click en buscar
        driver.findElement(By.xpath("//em[text()='Buscar']")).click();
        // Explicita
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".results-items-wrapper > aloha-list-view-container > div:nth-of-type(2) > h3")));
        //Click en checkbox 5 estrellas
        driver.findElement(By.xpath("//*[contains(@class, 'eva-3-dropdown')]/li[3]/aloha-filter/aloha-checkbox-filter/ul/li[4]/span/span/aloha-checkbox/span/label/i")).click();
        //Explicita
//        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Mondrian South Beach']")));
        Thread.sleep(3000);
        //Verificar que la puntuacion del hotel sea mayor a 7
        String text = driver.findElement(By.xpath("//span[text()='7.6']")).getText();
        Double text_int = Double.parseDouble(text);
        if (text_int >= 7) {
            d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".filters-tag")));
            //Seleccionar hotel
            driver.findElement(By.xpath("//*[contains(@class, 'results-items-wrapper')]/aloha-list-view-container/div[4]/div[2]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button/em")).click();
        }
        //Cambio de pestaña
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //Seleccionar 2da Pestaña
        Thread.sleep(5000);
        driver.findElement(By.xpath("//body/aloha-app-root[1]/aloha-detail[1]/div[1]/div[4]/div[1]/div[1]/aloha-infobox-container[1]/aloha-infobox-wrapper-container[1]/div[1]/div[2]/div[1]/aloha-infobox-shopping-content[1]/div[1]/div[2]/aloha-next-step-button[1]/aloha-button[1]/button[1]/em[1]")).click();
        //Seleccionar escala
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#trips-cluster-selected-position .packages-title")));
        driver.findElement(By.cssSelector("#filter-stops .dropdown-subcontent > div > checkbox-filter > checkbox-filter-item:nth-of-type(2) > li > span > span > span > label > i")).click();
        //Seleccionar equipaje
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#filter-baggage .dropdown-subcontent > div > checkbox-filter > checkbox-filter-item:nth-of-type(2) > li > span > span > span > label > i")).click();
        //Seleccionar Aerolinea
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#filter-airlines .dropdown-icon")).click();
        driver.findElement(By.cssSelector("#filter-airlines .dropdown-subcontent > div > checkbox-filter > checkbox-filter-item:nth-of-type(2) > li > span > span > span > label > i")).click();
        //Verificacion
        String text2 = driver.findElement(By.xpath("//*[contains(@class, 'tags-scroll-hide')]//span[text()='1 Escala']")).getText();
        Assert.assertEquals("1 Escala", text2);
        String text3 = driver.findElement(By.xpath("//*[contains(@class, 'tags-scroll-hide')]//span[text()='Equipaje de mano']")).getText();
        Assert.assertEquals("Equipaje de mano", text3);
    }

    @Test
    public void atc03_TrasladoComplejo() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Seleccionamos opción traslado
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Traslados\")]"))).click();
        //Escribimos el aeropuerto
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[contains(@placeholder, 'aeropuerto')]"))).sendKeys("Córdoba");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac-group-container']//span[@class='item-text']"))).click();
        //Escribimos el hotel
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[contains(@placeholder, 'hotel')]"))).sendKeys("Amerian Park Hotel");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ac-container']//span[contains(text(), 'Amerian Córdoba')]"))).click();
        //Escogemos el mes a través de un bucle
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='input-container']//input[contains(@placeholder, 'Arribo')]"))).click();
        while (true) {
            //se crea un string con los meses
            String dates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'month-active')])[2]//span[contains(@class,\"title-month\")]"))).getText();
            //se crea la condicion de que si el nombre del mes no es igual a Febrero haga click
            if (!dates.equals("Junio")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='_dpmg2--controls-next'])[2]"))).click();
            } else {//sale del bucle al cumplirse la condicion
                break;
            }
        }
        //Seleccionamos la fecha
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//div[contains(@class,'month-active')])[2]//span[contains(@class, 'number')])[10]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'btn-container')])[2]/button[contains(@class, 'apply')]"))).click();
        //Seleccionamos la hora
        Select hour = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sbox-moment-input']//select[contains(@class, 'arrival')]"))));
        hour.selectByIndex(20);
        //Clickeamos el checkbox "Quiero agregar el regreso"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'places-check')]//i"))).click();
        //Seleccionamos la fecha de regreso
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sbox-row'])[2]//input"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//div[contains(@class, 'month-active')])[2]//span[contains(@class, 'number')])[20]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'btn-container')])[2]/button[contains(@class, 'apply')]"))).click();
        //Seleccionamos la hora de regreso
        Select hour2 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sbox-row'])[2]//select"))));
        hour2.selectByIndex(38);
        //Añadimos un adulto a los pasajeros
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sbox-distri-container']//div[@class='input-container']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'number-picker')])[1]//a[contains(@class, 'plus')]"))).click();
        //Añadimos un menor de edad a los pasajeros
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'number-picker')])[2]//a[contains(@class, 'plus')]"))).click();
        //Escogemos la edad del menor de edad
        Select age = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'minors-age')]//select"))));
        age.selectByIndex(11);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[contains(@class, 'apply')]"))).click();
        //Clickeamos el boton de busqueda
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sbox-button']//a"))).click();
        //Clickeamos el boton modificar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 're-search')])[2]//span[contains(@class, 'btn')]"))).click();
        //Cambiamos la fecha de regreso
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sbox-row'])[2]//input"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'has-end-range')]//span[contains(@class, 'number')])[19]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'btn-container')])[2]/button[contains(@class, 'apply')]"))).click();
        //Cambiamos la hora de regreso
        Select newHour = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sbox-row'])[2]//select"))));
        newHour.selectByIndex(42);
        //Añadimos otra persona adulta
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sbox-distri-container']//div[@class='input-container']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'number-picker')])[1]//a[contains(@class, 'plus')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sbox-button']//a"))).click();
        //Creamos variables y arrays para comparar
        String newDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 're-search')])[2]//span[contains(text(), '19 jun')]"))).getText();
        String finalDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='-eva-3-mt-xsm']/span[contains(text(), '19 jun')])[1]"))).getText();
        String[] arr = newDate.split(" ");
        String[] arr2 = finalDate.split(" ");
        String selectDate = arr[2] + arr[3];
        String getDate = arr2[0] + arr2[1];
        Assert.assertEquals(selectDate, getDate);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }


}