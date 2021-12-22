package selenium.msabattini;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;


public class act02_PrimerResultadoXpath {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //UTILIZANDO Xpath
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("printed chiffon dress");
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();


        List<WebElement> resultados_busqueda = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));
        String primer_resultado = resultados_busqueda.get(0).findElement(By.xpath("//a[contains(@class, 'product-name')]")).getText();

        if(primer_resultado.equals("Printed Chiffon Dress")) System.out.println("Resultado correcto");

        Thread.sleep(4000);
        driver.close();

    }



}
