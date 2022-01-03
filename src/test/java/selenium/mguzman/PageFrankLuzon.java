package desafio.equipo2.selenium.mguzman;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class PageFrankLuzon {

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
        //Page practice
        driver.get("http://automation.frankluzon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void atc06_Xpath() {
        //Ingresar CAP en el buscador.
        driver.findElement(By.xpath("//input[@class=\"search-field\"]")).sendKeys("CAP"+Keys.RETURN);
        //click en reviews
        driver.findElement(By.xpath("//a[@href=\"#tab-reviews\"]")).click();
        //seleccionamos las estrellas
        driver.findElement(By.xpath("//span//a[@class=\"star-5\"]")).click();
        //cometario en page
        driver.findElement(By.xpath("//textarea[@id=\"comment\"]")).sendKeys("Una excelente pagina 'Very good'  ");
        //Agregar nombre
        driver.findElement(By.xpath("//input[@id=\"author\"]")).sendKeys("Manuel Guzmán");
        //Agregar correo
        driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("manuguz73@gmail.com");
        //Click submit
        driver.findElement(By.xpath("//input[@id=\"submit\"]")).click();
        //captura el msj
        String Text = driver.findElement( By.xpath("//div[@class=\"wp-die-message\"]")).getText();
        //Comprueba que sea el mismo
        Assert.assertEquals("Duplicate comment detected; it looks as though you’ve already said that!", Text);
    }
}
