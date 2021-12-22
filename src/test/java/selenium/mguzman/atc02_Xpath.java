package selenium.mguzman;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class atc02_Xpath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");


                driver.findElement(By.xpath("//input[@class=\"search_query form-control ac_input\"]")).sendKeys("printed chiffon dress");

        driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();


        String result = driver.findElement(By.xpath("//ul[@class=\"product_list grid row\"]/li[1]//a[contains(text(),\"Printed\")]")).getText();

        Assert.assertEquals("Printed Chiffon Dress", result);

        Thread.sleep(3000);
        driver.quit();

    }


}
