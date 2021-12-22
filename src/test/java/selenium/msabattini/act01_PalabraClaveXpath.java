package selenium.msabattini;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class act01_PalabraClaveXpath {

    public static void main(String[] args) throws InterruptedException{

        WebDriver driver;

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("http://automationpractice.com/");
        driver.findElement(new By.ByXPath("//*[@id='search_query_top']")).sendKeys("dress");
        driver.findElement(new By.ByXPath("//*[@id='searchbox']/button")).click();

        String resultados = driver.findElement(new By.ByXPath("//*[@id='center_column']/h1/span[2]")).getText();
        char[] resultados_array = resultados.toCharArray();
        StringBuilder numeros = new StringBuilder();

        for (char c : resultados_array) if (Character.isDigit(c)) numeros.append(c);

        if (Integer.parseInt(numeros.toString()) >= 2) System.out.println("Se encontraron " + numeros + " por lo tanto la prueba fue exitosa!");

    }

}
