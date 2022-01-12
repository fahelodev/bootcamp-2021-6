package junit.desafio.equipo5;

//Librerias importadas
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Paquetes {

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
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().window().maximize();
    }

    @Test
    public void TC001_PaqueteEconomico() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        //Origen
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox-row -wrap -row-bottom\"]//input"))).sendKeys("rio");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[12]//div/ul/li//span[contains(text(),' de Janeiro, ')]"))).click();

        //Destino
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox-second-place-container\"]//input"))).sendKeys("carm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[12]//div/ul/li//span[contains(text(),'Playa del ')]"))).click();

        //Fecha ida
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox-dates-row sbox-row\"]//input"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[5]//div//div[1]//span[4][contains(span, '4')]"))).click();
        //Fecha vuelta
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"_dpmg2--months\"])[3]//div[@class=\"_dpmg2--dates\"]/span[contains(span, '11')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[7]//div[6]/div[2]/button[2][@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]"))).click();

        //Seleccionar casilla de habitaciones y huspedes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[5]//div[@class=\"input-container\"]"))).click();
        //Boton menos husped
        for (int i = 0; i < 1; i++) {
            //Selecion de adulto 1
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[1][@class=\"steppers-icon-left sbox-3-icon-minus\"]\n"))).click();
        }
        //Click aplicar
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[4]/div/div[2]/a[1]"))).click();
        //Boton buscar
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[6]/div/a/em[@class=\"btn-text\"]"))).click();

        //Ordenar por Precio: menor a mayor. "Importando la clase Select"
        WebElement ordenar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div/aloha-select/div/div/select")));
        Select select = new Select(ordenar);
        select.selectByVisibleText("Precio: menor a mayor");
        Thread.sleep(3000);
        //Obtener texto de alojamiento
        String location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,\"cluster-container\")]//aloha-location-name/span)[2]"))).getText();
        String[] arr = location.split(" ");
        String nameLocation = arr[0] + " " + arr[1] + " " + arr[2].replace(",", "");

        //Verificar mas economico"
        Assert.assertEquals("Playa del Carmen", nameLocation);

    }

    @Test
    public void TC002_PaqueteFiltroMesNoche() {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        //Origen
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox-row -wrap -row-bottom\"]//input"))).sendKeys("merino");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[12]//div/ul/li[@class=\"item -active\"]"))).click();

        //Destino
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox-second-place-container\"]//input"))).sendKeys("ind");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[12]//div/ul/li[1][@class=\"item -active\"]"))).click();

        //Seleccionar casilla de habitaciones y huspedes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[5]//div[@class=\"input-container\"]"))).click();
        //Agregar husped
        for (int i = 2; i < 3; i++) {
            //Selecion de adultos 4

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[1]/div[2]//a[@class=\"steppers-icon-right sbox-3-icon-plus\"]\n"))).click();
        }
        //Click aplicar
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]//div[2]/a[@class=\"_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg\"]"))).click();
        //Selecciona Switch "Todavia no he decidido la fecha"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[9]/span/label/span[@class=\"switch-container\"]"))).click();
        //Selecionar mes
        WebElement mes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/select[@class=\"select-tag sbox-month-seletor\"]")));
        Select select = new Select(mes);
        select.selectByVisibleText("Febrero 2022");

        //Boton buscar
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[6]/div/a/em[@class=\"btn-text\"]"))).click();
        //Filtrar por noches
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span[@class=\"filter-tags-wrapper nights_count\"]"))).click();
        //5 a 7 noches
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/div[1]//div[@class=\"filter-value eva-3-tag nights_count-filter\"][2]"))).click();

        //Aplicar
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/div[2]/a[2]/em[@class=\"btn-text\"]"))).click();
        //Obtener texto "6 DÍAS / 5 NOCHES"
        String night = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/span/span[@class=\"driver-text\"]"))).getText();
        //Obtener texto "Febrero"
        String month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p/em[@class=\"-eva-3-bold month -eva-3-capitalize\"]"))).getText();
        //Validar noches y mes
        Assert.assertEquals("6 DÍAS / 5 NOCHES", night);
        Assert.assertEquals("Febrero", month);


    }

    @Test
    public void TC003_PaqueteRecomendado() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        //Tipo de paquete Vuelo + Auto
        driver.findElement(By.xpath("//div[@class=\"sbox-bundles\"]/span[3]/input[@type=\"radio\"]")).click();
        //Origen
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox-row -wrap -row-bottom\"]//input"))).sendKeys("pun");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[12]//div/ul/li[@class=\"item -active\"]"))).click();
        //Destino
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox-second-place-container\"]//input"))).sendKeys("nue");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[12]//div/ul/li[1][@class=\"item -active\"]"))).click();
        //Fecha ida
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"sbox-dates-row sbox-row\"]//input"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-range=\"start\"]//div[@class=\"_dpmg2--controls-next\"]/i"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[5]//div[5]/div[2]//span[8]/span[@class=\"_dpmg2--date-number\"]"))).click();
        //Fecha vuelta
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"_dpmg2--dates\"])[24]//span[contains(span,'15')]"))).click();
        //Aplicar
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[7]//div[6]/div[2]/button[2][@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]"))).click();

        //Seleccionar casilla de habitaciones y huspedes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[5]//div[@class=\"input-container\"]"))).click();

        for (int i = 2; i < 4; i++) {
            //Selecion de adultos 4
            driver.findElement(By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg']//a[2]\n")).click();
        }

        for (int j = 0; j < 2; j++) {
            //Selecion de menores 2
            driver.findElement(By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[2]\n")).click();
        }

        //Edad primer menor
        WebElement menor1 = driver.findElement(By.xpath("//div/div/select[@class=\"select-tag\"]"));
        Select select = new Select(menor1);
        select.selectByVisibleText("2 años");

        //Edad segundo menor
        WebElement menor2 = driver.findElement(By.xpath("//div[2]/div[2]/div/div/select[@class=\"select-tag\"]"));
        Select elegir = new Select(menor2);
        elegir.selectByVisibleText("8 años");

        //Click aplicar
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/a[@class=\"_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg\"]"))).click();
        //Boton buscar
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[6]/div/a/em[@class=\"btn-text\"]"))).click();

        //Filtrar por Aerolineas
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//filter-group[@data-sfa-id=\"airlines\"]/li/span[contains(div, 'Aerolíneas')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//checkbox-filter[@class=\"airlines\"]//checkbox-filter-item//li/span[contains(span,'American Airlines')]"))).click();
        Thread.sleep(3000);
        //Filtrar por equipaje
        driver.findElement(By.xpath("//checkbox-filter[@class=\"baggage\"]//checkbox-filter-item[2]/li/span")).click();

        //Seleccionar la opcion de ordenar por precio
        WebElement ordenar = driver.findElement(By.xpath("(//div[@class=\"select-container\"])/select[@id=\"eva-select\"]"));
        Select orden = new Select(ordenar);
        orden.selectByVisibleText("Precio");
        Thread.sleep(3000);
        //Obtener Texto "Vuelo mas conveniente"
        String Recomendado = driver.findElement(By.xpath("//div/highlight-level-three//span[contains(text(),\"Vuelo más conveniente\")]")).getText();
        //Validar vuelo mas coveniente
        Assert.assertEquals("Vuelo más conveniente", Recomendado);

    }

    @After
    public void close() {
        if (driver != null) {
            System.out.println("Close");
            driver.close();
        }

    }
}
