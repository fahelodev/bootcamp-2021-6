package selenium.fmarfull;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class atc02_busquedaDirectaProductoExistenteXPath {

    public static void main(String[] args) throws InterruptedException {
        String strToSearch = "printed chiffon dress";
        String strExpected = "Printed Chiffon Dress";
        String strReceived;

        // Inicialización del automatizador
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Sitio a consultar.
        driver.get("http://automationpractice.com/");

        // Ingreso de palabras en la barra de búsqueda.
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(strToSearch);

        // Se inicia la búsqueda de los elementos.
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();

        // Primer elemento de la lista encontrada.
        strReceived = driver.findElement(By.xpath("//a[contains (@class, 'product-name')]")).getText();

        if (strReceived.contains(strExpected)) {
            System.out.println("Prueba exitosa.");
        }

        Thread.sleep(2000);
        driver.close();
    }


}
