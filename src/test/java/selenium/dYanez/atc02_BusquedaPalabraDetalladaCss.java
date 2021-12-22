package selenium.dYanez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class atc02_BusquedaPalabraDetalladaCss {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        //element field write "printed chiffon dress"
        String wordSearchDress = "Printed Chiffon Dress";
        WebElement searchFieldDress = driver.findElement(By.cssSelector("#search_query_top"));
        searchFieldDress.sendKeys(wordSearchDress);

        //element click in btn search
        WebElement btnSearch = driver.findElement(By.cssSelector("#search_block_top .btn.button-search"));
        btnSearch.click();

        //firts element result product search get text
        String resultTitleExpected = driver.findElement(By.cssSelector
                ("ul.product_list.grid.row>li")).getText();
        // System.out.println(resultTitleExpected);

        //validate Results compare string title product
        if (resultTitleExpected.contains(wordSearchDress)) {
            System.out.println("Prueba Exitosa");
        }
        Thread.sleep(2000);
        driver.close();


    }

}
