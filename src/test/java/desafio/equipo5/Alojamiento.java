package desafio.equipo5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Alojamiento {

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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

    }


    @Test

    public void tc_001_AlojamientoFiltroEstrellas()  {

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(6));


        //Cargar la página
        driver.get("https://www.viajesfalabella.cl/");

        //click en boton de Alojamiento
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[.='Alojamientos']"))).click();

        // Hacer la búsqueda introduciendo la palabra "Santi"
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-primary undefined']"))).sendKeys("santi");

        //selecciona el destino Santiago de chile
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-text']"))).click();

        //Ingresar cantidad de 3 huespedes
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sbox-3-input -md sbox-distri-input sbox-3-validation -top-right sbox-guests-container']/div[@class='input-container']"))).click(); //click selecionar cantidad
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]"))).click();//click en +(incrementar huespedes)

        //Hacer click en "Todavía no he decidido la fecha"
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='checkbox-label']"))).click();

        //Hacer click en "Buscar"
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[.='Buscar']"))).click();

        //hacer click en estrella
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//eva-tooltip[4]//span[@class='eva-3-tag']"))).click();

        // En el filtro se escoje 4 estrellas
        driver.findElement(By.xpath("//span[contains(@class,\"-show-tooltip\")]//em[contains(text(),\"4\")and contains(@class,\"filter-name\")]")).click();

        //Hacer click en el boton "aplicar"
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='eva-3-tooltip -white -bottom -right -not-hover -show-tooltip']//eva-button[.='Aplicar']"))).click();

        //Verificar que los primero 3 alojamientos sean de 4 estrellas

        List<WebElement> result = driver.findElements(By.xpath("(//div[contains(@class,\"card-rating\")])[1]//i"));
        //String results = result.get(0).findElement(By.xpath("//div[@class=\"offer-card-rating\"]//i")).getText();
        Assert.assertEquals(4,result.size());



    }
    @Test
    public void tc_002_AlojamientoReservados()  {

        //Cargar la página
        driver.get("https://www.viajesfalabella.cl/");

        //click en boton de Alojamiento
        driver.findElement(By.xpath("//label[.='Alojamientos']")).click();

        // Hacer la búsqueda introduciendo la palabra "puc"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-primary undefined']")).sendKeys("coyh");

        //Selecciona la primera opcion "Coyhaique, Aysén, Chile"
        driver.findElement(By.xpath("//span[@class='item-text']")).click();

        //En fecha de entrada selecionar "Sab, 5 mar 2022"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-checkin-date']")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--controls-next']/i[@class='_dpmg2--icon-ico-arrow']")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--months']/div[3]//span[@class='_dpmg2--date _dpmg2--available _dpmg2--weekend']/span[.='5']")).click();

        // En fecha de salida selecionar "Mar, 19 mar 2022"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-checkout-date']")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-2 _dpmg2--has-start-range _dpmg2--month-active']//span[.='9']")).click();

        //Seleccionar cantidad de 6 (Adultos)
        driver.findElement(By.xpath("//label[@class='sbox-input-label sbox-3-label-form sbox-label-dynamic-text']")).click();
        for (int i=0 ; i<4 ;i++)
            //hacer click en icono + para agregar mas personas
            driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]")).click();

        //Seleccionar cantidad de 2 (Menores)
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock']//label[@class='_pnlpk-minors-title']")).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]")).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock']//label[@class='_pnlpk-minors-title']")).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock']//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]")).click();

        //Seleccionar edad primer menor (3 Años)

        Select edad = new Select(driver.findElement(By.xpath("//div[@class=\"select-container\"] /select")));
        edad.selectByVisibleText("3 años");

        // Seleccionar edad segundo menor (4 Años)
        Select ed = new Select(driver.findElement(By.xpath("//div[@class='_pnlpk-minors-age-select-wrapper']/div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//select[@class='select-tag']")));
        ed.selectByVisibleText("4 años");

        // Se añade otra habitacion
        driver.findElement(By.xpath("//a[.='Añadir habitación']")).click();

        //Seleccionar cantidad de 4 (Adultos)
        driver.findElement(By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//label[@class='_pnlpk-adults-title']")).click();
        for (int i=0 ; i<2 ;i++)
            //hacer click en icono + para agregar mas personas
            driver.findElement(By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]")).click();

        //Seleccionar cantidad de 1 (Menor)
        driver.findElement(By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//label[@class='_pnlpk-minors-title']")).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]")).click();

        //Seleccionar edad (1 Año)
        Select menor = new Select(driver.findElement(By.xpath("//div[@class='_pnlpk-panel__blocks _pnlpk-dynamicContent']/div[2]//div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//select[@class='select-tag']")));
        menor.selectByVisibleText("1 año");

        //Click en el boton "aplicar"
        driver.findElement(By.xpath("//div[@class='_pnlpk-panel__footer -medium-down-to-lg']/a[.='Aplicar']")).click();

        //Click en el boton "buscar"
        driver.findElement(By.xpath("//em[.='Buscar']")).click();

        //Guardamos el mensaje"Todos los alojamientos en Coyhaique están reservados"
        String mensaje_alerta = driver.findElement(By.xpath("//h5[@class='message-title eva-3-h5']")).getText();

        //validamos el mensaje esperado
        Assert.assertEquals( "Todos los alojamientos en Coyhaique están reservados." ,mensaje_alerta);



    }

    @Test
    public void tc_003_alojamientoPrecioRango() {

        //Cargar la página
        driver.get("https://www.viajesfalabella.cl/");

        //click en boton de Alojamiento
        driver.findElement(By.xpath("//label[.='Alojamientos']")).click();

        // Hacer la búsqueda introduciendo la palabra "chill"
        driver.findElement(By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-primary undefined']")).sendKeys("chill");

        //selecciona el destino Chillan, Ñuble, Chile
        driver.findElement(By.xpath("//span[@class='item-text']")).click();

        //Hacer click en "Todavía no he decidido la fecha"
        driver.findElement(By.xpath("//label[@class='checkbox-label']")).click();

        //Hacer click en "Buscar"
        driver.findElement(By.xpath("//em[.='Buscar']")).click();

        //hacer click en filtrar por precio
        driver.findElement(By.xpath("//eva-tooltip[3]//span[@class='tag-text']")).click();

        //Mover deslizante para elegir el rango de precio
        WebElement menor = driver.findElement(By.xpath("//div[@class='slider-handler -left']"));
        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.dragAndDropBy(menor, 70, 0).build();
        action.perform();

        WebElement may = driver.findElement(By.xpath("//div[@class='slider-handler -right']"));
        Actions moveSlide = new Actions(driver);
        Action actionn = moveSlider.dragAndDropBy(may, -120, 0).build();
        actionn.perform();
        //click en rango seleccionado
        driver.findElement(By.xpath("//eva-button[2]/a[.='Aplicar']")).click();

        //Guardamos el mensaje"No podemos encontrar lo que estás buscando"
        String mensaje_alerta = driver.findElement(By.xpath("//h3[@class='eva-3-h3 tag-text-heading']")).getText();

        //validamos el mensaje esperado
        Assert.assertEquals( "No podemos encontrar lo que estás buscando" ,mensaje_alerta);


    }


    @After
    public void close() {
        if (driver != null) {
            System.out.println("Close");
            driver.close();
        }
    }
}