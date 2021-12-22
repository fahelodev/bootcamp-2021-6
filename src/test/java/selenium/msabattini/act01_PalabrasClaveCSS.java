package selenium.msabattini;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class act01_PalabrasClaveCSS {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        //Inicialización del WebDriver con Firefox
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //UTILIZANDO cssSelector
        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector("#searchbox > button")).click();

        String resultados = driver.findElement(By.cssSelector("#center_column > h1 > span.heading-counter")).getText();
        char[] resultados_array = resultados.toCharArray();
        StringBuilder numeros = new StringBuilder();

        for (char c : resultados_array) if (Character.isDigit(c)) numeros.append(c);

        if (Integer.parseInt(numeros.toString()) >= 2) System.out.println("Se encontraron " + numeros + " por lo tanto la prueba fue exitosa!");
    }
}
