package selenium.fmarfull;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class atc02_busquedaDirectaProductoExistenteCSS {

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
        driver.findElement(By.cssSelector("input[id='search_query_top']")).sendKeys(strToSearch);

        // Se inicia la búsqueda de los elementos.
        driver.findElement(By.cssSelector("button[name='submit_search']")).click();

        // Primer elemento de la lista encontrada.
        strReceived = driver.findElement(By.cssSelector("ul.product_list>li:first-child")).getText();

        if (strReceived.contains(strExpected)) {
            System.out.println("Prueba exitosa.");
        }

        Thread.sleep(2000);
        driver.close();
    }

}
