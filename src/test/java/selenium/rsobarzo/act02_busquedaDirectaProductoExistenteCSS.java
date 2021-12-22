package selenium.rsobarzo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class act02_busquedaDirectaProductoExistenteCSS {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        List<WebElement> resultados = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));

        String texto = resultados.get(0).findElement(By.cssSelector(".product-name")).getText();
        String busqueda = ("Printed Chiffon Dress");

        if (texto.matches(busqueda)) {
            System.out.println("El resultado corresponde a "+texto);
        } else {
            System.out.println("Resultado erroneo");
        }

        //Thread.sleep(2000);
        driver.close();

    }

}