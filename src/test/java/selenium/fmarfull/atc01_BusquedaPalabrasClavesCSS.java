package selenium.fmarfull;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc01_BusquedaPalabrasClavesCSS {
    public static void main(String[] args) throws InterruptedException
    {
        int elemsAmount;
        String strToSearch = "dress";
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.findElement(By.cssSelector("input[id='search_query_top']")).sendKeys(strToSearch);
        driver.findElement(By.cssSelector("button[name='submit_search']")).click();
        elemsAmount = driver.findElements(By.cssSelector("ul.product_list>li")).size();

        if (elemsAmount > 1) {
            System.out.println("Más de un producto '" + strToSearch + "' encontrado " + "(" + elemsAmount + " en total)");
        } else {
            System.out.println("Menos de dos productos encontrados.");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
