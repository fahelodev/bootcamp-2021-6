package desafio.equipo2.selenium.nparco;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc01_AgregarReview {
    private WebDriver driver;
    @BeforeClass
    public static void setup(){
        //System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        //System.out.println("init para instanciar");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void atc01_AgregarReview(){
        System.out.println("Test Case 1");
        driver.get("http://automation.frankluzon.com/");
        Assert.assertEquals("My Store",driver.getTitle());
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
