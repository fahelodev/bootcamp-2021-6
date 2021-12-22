package selenium.rsobarzo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class atc01_BusquedaPalabrasClavesCSS {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        //element field write "dress"
        String vestidos = "Dress";
        WebElement searchFieldDress = driver.findElement(By.cssSelector("#search_query_top"));
        searchFieldDress.sendKeys(vestidos);

        //element click in btn search
        WebElement btnSearch = driver.findElement(By.cssSelector("#search_block_top .btn.button-search"));
        btnSearch.click();

        //validate Results
        List<WebElement> resultados = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));

        System.out.println(resultados.size());
        if (resultados.size() >= 1) {
            System.out.println("Prueba Exitosa, resultado : " + resultados.size());
        } else {
            System.out.println("La busqueda no arroja resultados");
        }

        //Thread.sleep(2000);
        driver.close();
    }
}
