package selenium.dYanez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class atc02_BusquedaPalabraDetalladaXpath {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");

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
        if (resultProductExpected.contains(wordSearchDress)) {
            System.out.println("Prueba Exitosa");
        }
        Thread.sleep(2000);
        driver.close();

    }


}
