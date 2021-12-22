package selenium.iromero;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc02_BusquedaXpath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");


        driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("printed chiffon dress");

        driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();


        String result = driver.findElement(By.xpath("//ul[@class=\"product_list grid row\"]/li[1]//a[contains(text(),\"Printed\")]")).getText();

        Assert.assertEquals("printed chiffon dress", result.toLowerCase());


        Thread.sleep(2000);
        driver.close();

    }
}
