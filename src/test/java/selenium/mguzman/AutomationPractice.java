package selenium.mguzman;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationPractice {

        private WebDriver driver;
        @BeforeClass
        public static void setup(){
            System.out.println("Setup necesario antes de Instanciar");
            WebDriverManager.chromedriver().setup();
        }

        @Before
        public void init(){
            System.out.println("instanciar");
            driver = new ChromeDriver();
            //Page practice
            driver.get("http://automationpractice.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        @Test
        public void atc01_CSS_searchDress(){
            // Buscar dress y ver cuantos resultados hay (Con CSS)
            System.out.println("Test Case 1");
            //Poner en caja de busqueda la palabra dress
            driver.findElement(By.cssSelector("input.search_query")).sendKeys("dress");
            //Hacer click para buscar
            driver.findElement(By.cssSelector("button.button-search")).click();
            List<WebElement> result = driver.findElements(By.cssSelector("ul.product_list.grid.row  a.product-name"));
            Assert.assertEquals(7,result.size());
        }

        @Test
        public void atc01_Xpath_searchDress(){
            //Buscar dress y ver cuantos resultados hay (Con Xpath)
            System.out.println("Test Case 2");
            //Poner en caja de busqueda la palabra dress
            driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("dress");
            //Hacer click para buscar
            driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();
            List <WebElement> result = driver.findElements(By.xpath("//ul[@class=\"product_list grid row\"]//a[@class=\"product-name\"]"));
            Assert.assertEquals(7,result.size());
        }

        @Test
        public void atc02_CSS_search(){
            //Buscar printed chiffon dress y comparar el productor del articulo (Con CSS)
            System.out.println("Test Case 3");
            //Poner en caja de busqueda la palabra printed chiffon dress
            driver.findElement(By.cssSelector("input.search_query")).sendKeys("printed chiffon dress");
            //Hacer click para buscar
            driver.findElement(By.cssSelector("button.button-search")).click();
            //Obtener texto
            String result = driver.findElement(By.cssSelector("ul.product_list.grid.row li:nth-of-type(1) a.product-name")).getText();
            Assert.assertEquals("Printed Chiffon Dress", result);
        }

        @Test
        public void atc02_Xpath(){
            //Buscar printed chiffon dress y comparar el productor del articulo (Con Xpath)
            System.out.println("Test Case 4");
            //Poner en caja de busqueda la palabra printed chiffon dress
            driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("printed chiffon dress");
            driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();
            //Obtener texto
            String result = driver.findElement(By.xpath("//ul[@class=\"product_list grid row\"]/li//a[contains(text(),\"Printed\")]")).getText();
            Assert.assertEquals("Printed Chiffon Dress", result);
         }

        @Test
        public void atc03_Xpath(){
            //Escribir liquido matapulgas y mostrar el error
            System.out.println("Test Case 5");
            //Poner en caja de busqueda la palabra liquido matapulga
            driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("liquido matapulgas"+ Keys.RETURN);
            //Obtener texto
            String m = driver.findElement( By.xpath("//div//p[@class=\"alert alert-warning\"]")).getText();
            Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", m);
    }

        @Test
        public void atc04_Xpath() throws InterruptedException {
        //En la caja de busqueda poner blo y seleccionar lo pre-buscado
        System.out.println("Test Case 6");
        //Poner en caja de busqueda la palabra blo
        driver.findElement(By.cssSelector("input.search_query")).sendKeys("blo");
        //Hacer click en lo pre-buscado
        driver.findElement( By.xpath("//div//ul//li[@class=\"ac_even ac_over\"]")).click();
        //obternet texto
        String result = driver.findElement(By.xpath("//div//p[@id=\"product_reference\"]")).getText();
        Assert.assertEquals("Model demo_2", result );
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
