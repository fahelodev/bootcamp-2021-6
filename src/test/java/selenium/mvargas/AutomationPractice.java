package selenium.mvargas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPractice {

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
    public void atc02_Busqueda_directa_de_Productos_existente_Xpath(){
        //Cargar la páginas
        driver.get("http://automationpractice.com/");
        //Introducir 'printed chiffon dress' en campo busqueda
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("printed chiffon dress");
        //Hacer click en campo SEARCH
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();
        WebElement producto = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a"));
        String primerProducto = producto.getText();
        System.out.println("Titulo: " + primerProducto);
        String parametro = "Printed Chiffon Dress";
        System.out.println("Titulo2: " + primerProducto);

        //if(primerProducto == parametro) {

        if(primerProducto.equals(parametro)) {
            System.out.println("Prueba Exitosa");
        }else {
            System.out.println("Prueba no Exitosa");
        }
    }

    /*@Test
    public void atc01CargarPaginaPrincipal2(){
        System.out.println("Test Case 2");
        driver.get("http://google.com/");
        Assert.assertEquals("My Store",driver.getTitle());
    } */

    @After
    public void close() throws InterruptedException {
        if(driver != null){
            Thread.sleep(4000);
            System.out.println("Close");
            driver.close();
        }

    }

    @AfterClass
    public static void closeAll(){
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }

}