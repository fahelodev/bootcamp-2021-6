package selenium.iromero;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import java.util.List;

public class AutomationPractice {
    private WebDriver driver;

    //Se inicializa el uso de chrome
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();

    }

    //se instancia el driver y se le entrega la url a testear
    @Before
    public void initial() {

        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Busqueda de dress y confirmar cantidad de elementos encontrados en la busqueda utilizando Xpath
    @Test
    public void atc01_BusquedaXpath() {
        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("dress");//escribir en la barra de busqueda
        driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();//click en boton de busqueda
        List<WebElement> result = driver.findElements(By.xpath("//ul[@class=\"product_list grid row\"]//a[@class=\"product-name\"]")); //enlistar elementos encontrado
        Assert.assertTrue(result.size()>=2);
    }

    //Busqueda de dress y confirmar cantidad de elementos encontrados en la busqueda utilizando css selector
    @Test
    public void atc01_BusquedaCss(){
        driver.findElement(By.cssSelector("input.search_query")).sendKeys("dress");//escribir en la barra de busqueda
        driver.findElement(By.cssSelector("button.button-search")).click();//click en boton de busqueda
        List<WebElement> result = driver.findElements(By.cssSelector("ul.product_list.grid.row  a.product-name")); //enlistar elementos encontrado
        Assert.assertTrue(result.size()>=2);
    }

    //Busqueda de printed chiffon dress y validacion de elementos buscado sea el primera elementos encontrado utilizando Xpath
    @Test
    public void atc02_BusquedaXpath(){
        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("printed chiffon dress");//escribir en la barra de busqueda
        driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();//click en boton de busqueda
        String result = driver.findElement(By.xpath("//ul[@class=\"product_list grid row\"]/li//a[contains(text(),\"Printed\")]")).getText();  //obtener el texto del primer elemento encontrado
        Assert.assertEquals("Printed Chiffon Dress", result);
    }

    //Busqueda de printed chiffon dress y validacion de elementos buscado sea el primera elementos encontrado utilizando css selector
    @Test
    public void atc02_BusquedaCss(){
        driver.findElement(By.cssSelector("input.search_query")).sendKeys("printed chiffon dress"); //escribir en la barra de busqueda
        driver.findElement(By.cssSelector("button.button-search")).click(); //click en boton de busqueda
        String result = driver.findElement(By.cssSelector("ul.product_list.grid.row a.product-name")).getText(); //obtener el texto del primer elemento encontrado
        Assert.assertEquals("Printed Chiffon Dress", result);
    }
    @Test
    public void atc03_EmptySearch(){
        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("liquido matapulga"+ Keys.RETURN); //escribir en la barra de busqueda y hacer un enter
        String result = driver.findElement(By.xpath("//p[contains(text(),\"No results\")]")).getText(); //obtiene texto del resultado
        Assert.assertEquals("No results were found for your search \"liquido matapulga\"", result);
    }

    @Test
    public void atc04_EncontrarProductoDeListaDinamica(){
        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("blo"); //escribir en la barra de busqueda blo
        driver.findElement(By.xpath("//ul/li[@class=\"ac_even\"]")).click(); //espera con el implicity wait para hacer click a la opcion desplegada
        String element = driver.findElement(By.xpath("//div[@class=\"pb-center-column col-xs-12 col-sm-4\"]/h1")).getText();
        Assert.assertEquals("Blouse", element);
    }

    //test realizado para confirmar dudas :D
    @Test
    public void testListaDinamica(){
        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("dress");
        List <WebElement> element = driver.findElements(By.xpath("//ul/li[@class=\"ac_odd\"]"));

        //recorre lista de opciones
        for (int i=1; i<=element.size(); i++){
            String result = driver.findElement(By.xpath("//ul/li[@class=\"ac_odd\"]["+i+"]")).getText();//obtiene texto de la opcion---error pero funciona
            if(result.equals("Summer Dresses > Printed Chiffon Dress")){
                driver.findElement(By.xpath("//ul/li[@class=\"ac_odd\"]["+i+"]")).click();//hace click en la opcion
            }
        }
        String result = driver.findElement(By.xpath("//div[@class=\"pb-center-column col-xs-12 col-sm-4\"]/h1")).getText();
        Assert.assertEquals("Printed Chiffon Dress", result);
    }

    //cerrado de chrome driver despues de cada test
    @After
    public void close(){
        if (driver != null) {
            driver.close();
        }
    }

}
