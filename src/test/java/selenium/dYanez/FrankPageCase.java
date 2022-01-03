package desafio.equipo2.selenium.dYanez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FrankPageCase {
    WebDriver driver;


    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        //cargar page
        driver.get("http://automation.frankluzon.com/");
        driver.manage().window().maximize();
        //wait implicit for list result visible cada vez que vaya a buscar al elemento
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    @Test
    public void atc06AgregarReviewFrankPage() throws InterruptedException {
        //En la caja de busqueda poner blo y seleccionar lo pre-buscado
        System.out.println("Test Case 6");

        WebElement productClick = driver.findElement(By.xpath("//*[@id=\"post-27\"]/div/div[3]/ul/li[1]/a/div[1]/img"));
        productClick.click();


        WebElement reviewClick = driver.findElement(By.xpath("//*[@id=\"tab-title-reviews\"]/a"));
        reviewClick.click();

        WebElement startRatingClick = driver.findElement(By.xpath("//*[@id=\"commentform\"]/div/p/span/a[4]"));
        startRatingClick.click();


        WebElement writeComment = driver.findElement(By.xpath("//*[@id=\"comment\"]"));
        writeComment.sendKeys("lorem ipsum lorem ipsum lorem ipsum");

        WebElement writeName = driver.findElement(By.xpath("//input[@id=\"author\"]"));
        writeName.sendKeys("DiegoY");

        WebElement writeEmail = driver.findElement(By.xpath("//input[@id='email']"));
        writeEmail.sendKeys("diegotsoft@gmail.cl");

        WebElement checkboxClick = driver.findElement(By.xpath("//*[@id=\"wp-comment-cookies-consent\"]"));
        checkboxClick.click();

        WebElement submitClick = driver.findElement(By.xpath("//input[@id='submit']"));
        submitClick.click();


        String textResult = driver.findElement( By.xpath("//div[@class=\"wp-die-message\"]")).getText();
        System.out.println(textResult);


        //validate msg
        String msgExpected = "Your review is awaiting approval";
        Assert.assertEquals(msgExpected,textResult);

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

    }
}
