package selenium.fmarfull;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc01_BusquedaPalabrasClavesXPath {
    public static void main(String[] args) throws InterruptedException
    {
        int elementsAmount;
        String strToSearch = "dress";
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(strToSearch);
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();
        elementsAmount = driver.findElements(By.xpath("//li[contains (@class, 'ajax_block_product')]")).size();

        if (elementsAmount > 1) {
            System.out.println("Más de un producto '"
                    + strToSearch
                    + "' encontrado "
                    + "(" + elementsAmount + " en total)");
        } else {
            System.out.println("Menos de dos productos encontrados.");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
