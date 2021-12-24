package selenium.fmercado;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutomationPractice {

    //inicializacion del webdrive de crhome
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
        }

        @Test
        public void atc01CargarPaginaPrincipal(){
            System.out.println("Test Case 1: Busqueda de Palabra Clave");
            driver.get("http://automationpractice.com/");
            //1) Cargar la página y validar
            driver.get("http://automationpractice.com/");
            System.out.println(driver.getCurrentUrl());
            //2) Localizar el cuadro de busqueda e introducir "dress" en el campo de busqueda
            driver.findElement(By.id("search_query_top")).sendKeys("dress");
            //3)Localizar el boton de busqueda y hacer click.
            WebElement searchIcon = driver.findElement(By.name("submit_search"));//name locator for next button
            searchIcon.click();
            //4)Buscar elementos atravez de las listas ul/li y validar
            List<WebElement> allElements = driver.findElements(By.xpath("//div[@id='center_column']/ul/li"));
            Assert.assertEquals(7, allElements.size());
        }

        @Test
        public void atc01CargarPaginaPrincipal1css(){
            System.out.println("Test Case 1: Busqueda de palabra clave con css");
            driver.get("http://automationpractice.com/");
            //2) Localizar el cuadro de busqueda e introducir "dress" en el campo de busqueda
            driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
            //3)Localizar el boton de busqueda y hacer click.
            WebElement searchIcon = driver.findElement(By.cssSelector("#search_block_top .btn.button-search"));
            searchIcon.click();
            //4)Buscar elementos atravez de las listas ul/li y validar
            List<WebElement> allElements = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));
            Assert.assertEquals(7,allElements.size());
        }

        @Test
        public void atc01CargarPaginaPrincipal2(){
            System.out.println("Test Case 2: Busqueda directa producto existente");
            driver.get("http://automationpractice.com/");
            //3)Localizar el boton de busqueda y hacer click.
            WebElement searchIcon = driver.findElement(By.name("submit_search"));//name locator for next button
            searchIcon.click();
            //Producto del primer elemento
            String resultProduct = driver.findElement(By.xpath("//a[contains(@class, 'product-name')]")).getText();
            Assert.assertEquals("Printed Chiffon Dress",resultProduct);
        }
    // Busqueda directa producto existente con css
        @Test
        public void atc01CargarPaginaPrincipal2css(){
            System.out.println("Test Case 2: Busqueda directa producto existente con css");
            driver.get("http://automationpractice.com/");
            //2) Localizar el cuadro de busqueda e introducir "printed chicffon dress" en el campo de busqueda
            driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
            //3)Localizar el boton de busqueda y hacer click.
            WebElement searchIcon = driver.findElement(By.cssSelector("#search_block_top .btn.button-search"));
            searchIcon.click();
            //4)Obtener texto del primer elemento
            String ResultTitle = driver.findElement(By.cssSelector("ul.product_list.grid.row li:nth-of-type(1) a.product-name")).getText();
            Assert.assertEquals("Printed Chiffon Dress",ResultTitle);
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
