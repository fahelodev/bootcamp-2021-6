package selenium.rgutierrez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class act01_BusquedaPalabrasClavesXpath {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("dress");
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> resultados = driver.findElements(By.xpath("//*[@id=\'center_column\']/ul/li"));

        if (resultados.size() > 1) {
            System.out.println("Cumple con la prueba, resultados encontrados: " + resultados.size());
        } else {
            System.out.println("la Busqueda arrojó menos resultados de los esperados, encontrados: " + resultados.size());
        }


        Thread.sleep(2000);
        driver.close();

    }
}
