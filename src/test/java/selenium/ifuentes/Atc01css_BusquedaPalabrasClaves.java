package selenium.ifuentes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Atc01css_BusquedaPalabrasClaves {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;
        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Cargar la página
        driver.get("http://automationpractice.com/");
        //Introducir DRESS en campo busqueda
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
        //Hacer click en campo SEARCH
        driver.findElement(By.cssSelector("#searchbox > button")).click();
        List<WebElement> resultados = driver.findElements(By.cssSelector("#center_column > ul"));
        if (resultados.size() > 1) {
            System.out.println("Resultados de la busqueda '" + resultados.size() + "' - Prueba Exitosa");
        } else {
            System.out.println("Resultado es '" + resultados.size() +"' - No se el cumple resultado esperado");
        }

        Thread.sleep(2000);
        //driver.close();
    }
}