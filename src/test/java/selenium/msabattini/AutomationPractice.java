package desafio.equipo2.selenium.msabattini;
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
            driver = new ChromeDriver   ();
            driver.get("http://automationpractice.com/");
        }

    @Test
    public void act01_PalabraClaveXpath(){

        //Palabra clave - XPATH

        //Escribimos el texto por el campo de busqueda.
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("dress");
        //Enviamos el texto presionando en el icono de la lupa.
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();

        //En una variable guardamos el texto que contiene la cantidad de resultados obtenidos.
        String resultados = driver.findElement(new By.ByXPath("//*[@id='center_column']/h1/span[2]")).getText();
        //Convertimos a char.
        char[] resultados_array = resultados.toCharArray();
        StringBuilder numeros = new StringBuilder();

        //Recorremos el arreglo y si algun elemento es un digito lo concatenamos.
        for (char c : resultados_array) if (Character.isDigit(c)) numeros.append(c);

        Assert.assertTrue(Integer.parseInt(numeros.toString())>=2);


    }

    @Test
    public void act01__PalabraClaveCSS(){
        //Palabra clave - CSS

        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector("#searchbox > button")).click();
        String resultados = driver.findElement(By.cssSelector("#center_column > h1 > span.heading-counter")).getText();
        char[] resultados_array = resultados.toCharArray();
        StringBuilder numeros = new StringBuilder();

        for (char c : resultados_array) if (Character.isDigit(c)) numeros.append(c);

        Assert.assertTrue(Integer.parseInt(numeros.toString())>=2);
    }

    @Test
    public void act02_PrimerResultadoXpath(){

        //Primer resultado - XPATH

        //Escribimos el texto en el área de búsqueda.
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("printed chiffon dress");
        //Damos click en el icono de la lupa.
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();
        //Almacenamos la lista de resultados en un List<WebElement>
        List<WebElement> resultados_busqueda = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));
        //Obtenemos el primer resultado.
        String primer_resultado = resultados_busqueda.get(0).findElement(By.xpath("//a[contains(@class, 'product-name')]")).getText();

        Assert.assertEquals( "Printed Chiffon Dress" ,primer_resultado);
    }

    @Test
    public void act02__PrimerResultadoCSS(){

        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("#searchbox > button")).click();
        List<WebElement> resultados_busqueda = driver.findElements(By.cssSelector("ul.product_list.grid.row>li")); //lista-elementos
        String primer_resultado = resultados_busqueda.get(0).findElement(By.cssSelector(".product-name")).getText(); //primer elemento

        Assert.assertEquals( "Printed Chiffon Dress" ,primer_resultado);
    }

    @Test
    public void act03_MensajeProductoNoEncontrado(){

        //Enviamos el texto al campo de busqueda.
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("liquido matapulgas");
        //Presionamos enter para buscar.
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.ENTER);
        //Guardamos el texto de la alerta en una variable
        String texto_alerta = driver.findElement(By.cssSelector("#center_column > p")).getText();

        Assert.assertEquals( "No results were found for your search \"liquido matapulgas\"" ,texto_alerta);

    }

    @Test
    public void act04_EncontrarProductoDeListaDinamica(){

        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("blo");

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Esperamos explicitamente
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results")));

        //bajamos en los resultados.
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.DOWN);
        //Presionamos enter.
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.ENTER);

        Assert.assertEquals("Model demo_2",driver.findElement(By.cssSelector("#product_reference")).getText());
    }

    @Test
    public void atc05_AgregarProductoCambiandoTallaYColor() throws InterruptedException {

        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("blo");

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Esperamos explicitamente
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results")));

        //bajamos en los resultados.
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.DOWN);
        //Presionamos enter.
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(Keys.ENTER);


        Select select = new Select(driver.findElement(By.cssSelector("#group_1")));
        select.selectByVisibleText("L");

        driver.findElement(By.cssSelector("#color_8")).click();
        driver.findElement(By.cssSelector("#add_to_cart > button")).click();
        String texto_busqueda = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")).getText();
        Thread.sleep(6000);
        Assert.assertEquals("Product successfully added to your shopping cart",texto_busqueda);

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
