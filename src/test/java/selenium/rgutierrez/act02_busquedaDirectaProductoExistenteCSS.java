package selenium.rgutierrez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class act02_busquedaDirectaProductoExistenteCSS {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("[name='submit_search']")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        List<WebElement> resultados = driver.findElements(By.cssSelector("ul.product_list.grid.row>li"));

        String texto = resultados.get(0).findElement(By.cssSelector(".product-name")).getText();

        if (texto.equals("Printed Chiffon Dress")) {
            System.out.println("El primer resultado corresponde a Printed Chiffon Dress");
        } else {
            System.out.println("Resultado erroneo");
        }

        Thread.sleep(2000);
        driver.close();

    }
}