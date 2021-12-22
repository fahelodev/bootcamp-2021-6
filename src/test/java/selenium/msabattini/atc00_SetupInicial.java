package selenium.msabattini;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.regex.Pattern;

public class atc00_SetupInicial {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();

        //Inicialización del WebDriver con Firefox
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //Cargar la página
        /*
        driver.get("http://automationpractice.com/");
        driver.findElement(new By.ByXPath("//*[@id='search_query_top']")).sendKeys("dress");
        driver.findElement(new By.ByXPath("//*[@id='searchbox']/button")).click();

        String resultados = driver.findElement(new By.ByXPath("//*[@id='center_column']/h1/span[2]")).getText();
        char[] resultados_array = resultados.toCharArray();

        if (resultados_array[0] >= 2) {
            System.out.println("Prueba exitosa");
        }
        */

        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector("#searchbox > button")).click();


        String resultados = driver.findElement(By.cssSelector("#center_column > h1 > span.heading-counter")).getText();
        char[] resultados_array = resultados.toCharArray();
        String numeros = "";

        for (int i = 0; i < resultados_array.length; i++) {
            if (Character.isDigit(resultados_array[i])) numeros += resultados_array[i];
        }

        if (Integer.parseInt(numeros) >= 2) System.out.println("Se encontraron " + numeros + " " + "por lo tanto la prueba fue exitosa!");

    }
}