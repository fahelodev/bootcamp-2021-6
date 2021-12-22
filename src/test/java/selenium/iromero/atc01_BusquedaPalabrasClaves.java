package selenium.iromero;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class atc01_BusquedaPalabrasClaves {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");


        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("dress");

        driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();

/*
        int count = 0;

        for (int i = 1; i <= 7; i++) {
            if (driver.findElements(By.xpath("//ul[@class=\"product_list row grid\"]/li[" + i + "]")) != null) {count++;}
        }
        assert count > 2: "No se encontraron resultados";
*/
        List <WebElement> result = driver.findElements(By.xpath("//ul[@class=\"product_list grid row\"]//a[@class=\"product-name\"]"));

        assert result.size()>=2 : "Error test";

        Thread.sleep(2000);
        driver.close();

    }
}
