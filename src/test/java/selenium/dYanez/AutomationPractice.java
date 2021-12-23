package selenium.dYanez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        //wait implicit for list result visible cada vez que vaya a buscar al elemento
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

    @Test
    public void atc03MensajeProductoNoEncontrado() throws InterruptedException {
        System.out.println("Test Case 3");
        //cargar page
        driver.get("http://automationpractice.com/");
        //validate string title pestaña of the page
        Assert.assertEquals("My Store", driver.getTitle());
        //element field write "McBook"
        String wordSearchDress = "McBook";
        WebElement searchFieldDress = driver.findElement(By.xpath("//input[@id='search_query_top']"));
        searchFieldDress.sendKeys(wordSearchDress);

        //element click in btn search
        WebElement btnSearch = driver.findElement(By.xpath("//*[@id=\'searchbox\']/button"));
        btnSearch.click();


        //element string text information
        String titleText = driver.findElement
                (By.xpath("//p[contains(text(),'No results were found for your search \"McBook\"')]")).getText();

        //validate text msg
        Assert.assertEquals(titleText,"No results were found for your search \"McBook\"");



    }

    @Test
    public void atc04FindProductInListDymanic() {
        //En la caja de busqueda poner blo y seleccionar lo pre-buscado
        System.out.println("Test Case 4");
        //cargar page
        driver.get("http://automationpractice.com/");
        //Poner en caja de busqueda la palabra blo
        String wordSearchDress = "blo";
        WebElement searchFieldDress = driver.findElement(By.cssSelector("#search_query_top"));
        searchFieldDress.sendKeys(wordSearchDress);

        //click in list result
        driver.findElement(By.xpath("//ul/li[@class=\"ac_even\"]")).click();
        //get text for validate product name reference is visible
        String result = driver.findElement(By.xpath("//div//p[@id=\"product_reference\"]")).getText();
        Assert.assertEquals("Model demo_2", result );

    }


    @Test
    public void atc05FindProductInListDymanic() {
        //En la caja de busqueda poner blo y seleccionar lo pre-buscado
        System.out.println("Test Case 5");
        //cargar page
        driver.get("http://automationpractice.com/");
        //Poner en caja de busqueda la palabra blo
        String wordSearchDress = "blo";
        WebElement searchFieldDress = driver.findElement(By.cssSelector("#search_query_top"));
        searchFieldDress.sendKeys(wordSearchDress);
        //click in list result
        driver.findElement(By.xpath("//ul/li[@class=\"ac_even\"]")).click();

        //click list sizes
        WebElement sizeL = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
        sizeL.click();

        //click in size L
        WebElement clickSizeL = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[3]"));
        clickSizeL.click();
        //click in color white
        WebElement clickColorWhiteL = driver.findElement(By.cssSelector("#color_8"));
        clickColorWhiteL.click();
        //click add product to cart
        WebElement clickAddCart = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
        clickAddCart.click();


       /* String result = driver.findElement(By.className("//span[@id='layer_cart_product_title']")).getText();
        System.out.println(result);

        Assert.assertEquals("White, L", result );*/
    }
    @Test
    public void atc06AgregarReviewFrankPage() {
        //En la caja de busqueda poner blo y seleccionar lo pre-buscado
        System.out.println("Test Case 6");
        //cargar page
        driver.get("http://automation.frankluzon.com/");

        WebElement productClick = driver.findElement(By.xpath("//*[@id=\"post-27\"]/div/div[3]/ul/li[1]/a/div[1]/img"));
        productClick.click();


        WebElement reviewClick = driver.findElement(By.xpath("//*[@id=\"tab-title-reviews\"]/a"));
        reviewClick.click();

        WebElement startRatingClick = driver.findElement(By.xpath("//*[@id=\"commentform\"]/div/p/span/a[4]"));
        startRatingClick.click();


        WebElement writeComment = driver.findElement(By.xpath("//*[@id=\"comment\"]"));
        writeComment.sendKeys("lorem ipsum lorem ipsum lorem ipsum");

        WebElement writeName = driver.findElement(By.xpath("//input[@id='author']"));
        writeName.sendKeys("Diego");

        WebElement writeEmail = driver.findElement(By.xpath("//input[@id='email']"));
        writeName.sendKeys("diego@tsoft.cl");

        WebElement submitClick = driver.findElement(By.xpath("//input[@id='submit']"));
        submitClick.click();

        /*//element string text information
        String titleTextValidate = driver.findElement
                (By.xpath("")).getText();

        //validate text msg
        Assert.assertEquals(titleTextValidate,"");*/
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
