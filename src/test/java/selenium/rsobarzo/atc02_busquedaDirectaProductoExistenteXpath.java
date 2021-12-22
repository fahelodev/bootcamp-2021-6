package selenium.rsobarzo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class atc02_busquedaDirectaProductoExistenteXpath {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("printed chiffon dress");
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();

        List<WebElement> resultados = driver.findElements(By.xpath("//*[@id=\'center_column\']/ul/li"));

        String texto = resultados.get(0).findElement(By.xpath("//a[contains(@class, 'product-name')]")).getText();

        String busqueda = ("Printed Chiffon Dress");

        if (texto.contains(busqueda)) {
            System.out.println("El  resultado corresponde a "+texto);
        } else {
            System.out.println("Resultado erroneo");
        }

       // Thread.sleep(2000);
        driver.close();
    }
}
