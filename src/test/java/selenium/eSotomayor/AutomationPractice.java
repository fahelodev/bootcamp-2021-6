package selenium.eSotomayor;
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
        public void searchDress_CSS(){
            //Test Case 1 - Buscar dress y obtener cuantos resultados aparecen.
            //Poner en caja de "Search" la palabra "dress".
            driver.findElement(By.cssSelector("input.search_query")).sendKeys("dress");
            //Hacer click para buscar
            driver.findElement(By.cssSelector("button.button-search")).click();
            //Obtener resultados y compararlos con la cifra esperada.
            List<WebElement> result = driver.findElements(By.cssSelector("ul.product_list.grid.row  a.product-name"));
            Assert.assertEquals(7,result.size());
        }

        @Test
        public void searchDress_Xpath(){
            //Test Case 2 - Buscar dress y obtener cuantos resultados aparecen.
            //Poner en caja de "Search" la palabra "dress".
            driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("dress");
            //Hacer click para buscar
            driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();
            //Obtener resultados y compararlos con la cifra esperada.
            List <WebElement> result = driver.findElements(By.xpath("//ul[@class=\"product_list grid row\"]//a[@class=\"product-name\"]"));
            Assert.assertEquals(7,result.size());
        }

        @Test
        public void chiffonDress_CSS() {
            //Test Case 3 - Buscar printed chiffon dress y comparar el productor del articulo"
            //Poner en caja de "Search" las palabras "printed chiffon dress"
            driver.findElement(By.cssSelector("input.search_query")).sendKeys("printed chiffon dress");
            //Hacer click para buscar
            driver.findElement(By.cssSelector("button.button-search")).click();
            //Obtener texto del resultado
            String result = driver.findElement(By.cssSelector("ul.product_list.grid.row li:nth-of-type(1) a.product-name")).getText();
            //Comparar resultados
            Assert.assertEquals("Printed Chiffon Dress", result);
        }

        @Test
            public void chiffonDress_Xpath(){
            //Test Case 4 - Buscar printed chiffon dress y comparar el productor del articulo"
            //Poner en caja de "Search" las palabras "printed chiffon dress"
            driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("printed chiffon dress");
            //Hacer click para buscar
            driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();
            //Obtener texto del resultado
            String result = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]//a[@class=\"product-name\"] ")).getText();
            //Comparar resultados
            Assert.assertEquals("Printed Chiffon Dress", result);
         }

        @Test
        public void matapulgas_Xpath(){
            //Test Case 5 - Escribir "liquido matapulgas" y mostrar el error.
            //Poner en caja de "Search" las palabras "liquido matapulgas"
            driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("liquido matapulgas"+ Keys.RETURN);
            //Obtener texto del resultado
            String result= driver.findElement( By.xpath("//div//p[@class=\"alert alert-warning\"]")).getText();
            //Comparar resultados
            Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", result);
    }

        @Test
        public void bloTest(){
            //Test case 6 - Escribir "blo", clickear en autocompletar y comparar el resultado obtenido.
            // Escribir "blo" en "Search"
            driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("blo");
            //Clickear en autocompletar
            driver.findElement( By.cssSelector("div.ac_results")).click();
            String result = driver.findElement(By.xpath("//div//p[@id=\"product_reference\"]")).getText();
            Assert.assertEquals("Model demo_2", result );
        }
<<<<<<< HEAD

=======
>>>>>>> bf5227f253112f32df509045b3bb490c35bedf52
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
