package selenium.dYanez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutomationPractice {

     WebDriver driver;


    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void atc01CargarPaginaPrincipal(){
        System.out.println("Test Case 1");
        //Cargar la página
        driver.get("http://automationpractice.com/");
        //validate string title pestaña of the page
        Assert.assertEquals("My Store",driver.getTitle());

        //element field write "dress"
        String wordSearchDress = "Dress";
        WebElement searchFieldDress = driver.findElement(By.cssSelector("#search_query_top"));
        searchFieldDress.sendKeys(wordSearchDress);

        //element click in btn search
        WebElement btnSearch = driver.findElement(By.cssSelector("#search_block_top .btn.button-search"));
        btnSearch.click();

        //validate Results
        List<WebElement> resultados = driver.findElements
                (By.cssSelector("ul.product_list.grid.row>li"));

        System.out.println(resultados.size());
        Assert.assertEquals(7,resultados.size());
    }
    @Test
    public void atc02CargarPaginaPrincipal2(){
        System.out.println("Test Case 2");
        //cargar page
        driver.get("http://automationpractice.com/");
        //validate string title pestaña of the page
        Assert.assertEquals("My Store",driver.getTitle());
        //element field write "printed chiffon dress"
        String wordSearchDress = "Printed Chiffon Dress";
        WebElement searchFieldDress = driver.findElement(By.xpath("//input[@id='search_query_top']"));
        searchFieldDress.sendKeys(wordSearchDress);

        //element click in btn search
        WebElement btnSearch = driver.findElement(By.xpath("//*[@id=\'searchbox\']/button"));
        btnSearch.click();

        //validate Results

        List<WebElement> resultSearch = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));

        //firts element title product
        String resultProductExpected = resultSearch.get(0).findElement(By.xpath("//a[contains(@class, 'product-name')]")).getText();


        //validate Results compare string title product
        Assert.assertEquals(resultProductExpected,wordSearchDress);
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
