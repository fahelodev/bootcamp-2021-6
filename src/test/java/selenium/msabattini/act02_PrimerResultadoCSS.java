package selenium.msabattini;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class act02_PrimerResultadoCSS {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //UTILIZANDO cssSelector
        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("#searchbox > button")).click();

        List<WebElement> resultados_busqueda = driver.findElements(By.cssSelector("ul.product_list.grid.row>li")); //lista-elementos
        String primer_resultado = resultados_busqueda.get(0).findElement(By.cssSelector(".product-name")).getText(); //primer elemento

        if(primer_resultado.equals("Printed Chiffon Dress")) System.out.println("Resultado correcto");

        Thread.sleep(4000);
        driver.close();
    }
}
