package selenium.fmercado;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;
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

                // Cargar la página y validar.
            driver.get("http://automationpractice.com/");

                // Localizar el cuadro de busqueda e introducir "dress" en el campo de busqueda
            driver.findElement(By.id("search_query_top")).sendKeys("dress");

                // Localizar el boton de busqueda y hacer click.
            WebElement searchIcon = driver.findElement(By.name("submit_search"));//name locator for next button
            searchIcon.click();

                // Buscar elementos atravez de las listas ul/li y validar
            List<WebElement> allElements = driver.findElements(By.xpath("//div[@id='center_column']/ul/li"));
            Assert.assertEquals(7, allElements.size());
        }

        @Test
        public void atc01CargarPaginaPrincipal1css(){
            System.out.println("Test Case 1: Busqueda de palabra clave con css");

                // Cargar la página y validar.
            driver.get("http://automationpractice.com/");

                // Localizar el cuadro de busqueda e introducir "dress" en el campo de busqueda
            driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");

                // Localizar el boton de busqueda y hacer click.
            WebElement searchIcon = driver.findElement(By.cssSelector("#search_block_top .btn.button-search"));
            searchIcon.click();

                // Buscar elementos atravez de las listas ul/li y validar.
            List<WebElement> allElements = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));
            Assert.assertEquals(7,allElements.size());
        }

        @Test
        public void atc02CargarPaginaPrincipal2(){
            System.out.println("Test Case 2: Busqueda directa producto existente");

                // Cargar la página y validar.
            driver.get("http://automationpractice.com/");

                // Localizar el boton de busqueda y hacer click.
            WebElement searchIcon = driver.findElement(By.name("submit_search"));
            searchIcon.click();

                // Producto del primer elemento
            String resultProduct = driver.findElement(By.xpath("//a[contains(@class, 'product-name')]")).getText();
            Assert.assertEquals("Printed Chiffon Dress",resultProduct);
        }

        @Test
        public void atc02CargarPaginaPrincipal2css(){
            System.out.println("Test Case 2: Busqueda directa producto existente con css");
            driver.get("http://automationpractice.com/");

                // Localizar el cuadro de busqueda e introducir "printed chicffon dress" en el campo de busqueda
            driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");

                // Localizar el boton de busqueda y hacer click.
            WebElement searchIcon = driver.findElement(By.cssSelector("#search_block_top .btn.button-search"));
            searchIcon.click();

                // Obtener texto del primer elemento.
            String ResultTitle = driver.findElement(By.cssSelector("ul.product_list.grid.row li:nth-of-type(1) a.product-name")).getText();
            Assert.assertEquals("Printed Chiffon Dress",ResultTitle);
        }

        @Test
        public void atc03CargarPaginaPrincipal(){
            System.out.println("Test Case 3: Mensaje de producto no encontrado");

                // Cargar la página y validar.
            driver.get("http://automationpractice.com/");
            System.out.println(driver.getCurrentUrl());

                // Localizar el cuadro de busqueda e introducir "liquido matapulgas" en el campo de busqueda.
            driver.findElement(By.id("search_query_top")).sendKeys("liquido matapulgas");

                // Localizar el boton de busqueda y hacer click.
            WebElement searchIcon = driver.findElement(By.name("submit_search"));
            searchIcon.click();

                // Validacion del producto que no se encontro.
            String palabraBuscada = "liquido matapulgas";
            String resultado = driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText();
            Assert.assertEquals("No results were found for your search "+"\""+palabraBuscada+"\"",resultado);
        }

       @Test
        public void atc04CargarPaginaPrincipal4(){
            System.out.println("Test Case 4: Busqueda directa producto existente");

                // Cargar la página y validar.
            driver.get("http://automationpractice.com/");

                // Localizar el cuadro de busqueda e introducir "blo" en el campo de busqueda
            WebElement buscador = driver.findElement(By.id("search_query_top"));
            buscador.sendKeys("blo");

                // Establecer una espera explicita, para seleccionar la opcion suferida.
           WebDriverWait tiempo = new WebDriverWait(driver, 20);
           tiempo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac_results']")));

                // Movemos la seleccion de la busqueda con el teclado.
           buscador.sendKeys(Keys.DOWN);

                // Presionamos enter.
           buscador.sendKeys(Keys.ENTER);

                // Validar resultado.
           String resultado = driver.findElement(By.xpath("//p[@id='product_reference']")).getText();
           Assert.assertEquals("Model demo_2",resultado);
        }
        @Test
        public void atc05_AgregarProductoCambiandoTallaYColor(){
            driver.get("http://automationpractice.com");
            driver.findElement(By.cssSelector("#search_query_top")).sendKeys("blo");

                //seleccionamos el producto
            WebDriverWait espera = new WebDriverWait(driver, 5);
            espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results")));
            driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.DOWN);
            driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.ENTER);

                //elegimos la talla
            Select select = new Select(driver.findElement(By.xpath("//*[@id='group_1']")));
            select.selectByVisibleText("L");

                //cambiamos el color
            driver.findElement(By.xpath("//*[@id='color_8']")).click();
            driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();

                //esperamos a que aparezca el mensaje.

            espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")));

                //guardamos el mensaje de compra
            String mensaje =  driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).getText();

            Assert.assertEquals("Product successfully added to your shopping cart", mensaje);
        }

        @AfterClass
        public static void closeAll(){
            System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
        }

}
