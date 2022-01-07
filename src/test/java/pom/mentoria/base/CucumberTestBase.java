package pom.mentoria.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class CucumberTestBase {

    //atributos
    static WebDriver driver;

    @Before(order = 0)
    public static void initDriver(){
        WebDriverManager.chromedriver().setup();
    }
    @Before(order = 1)
    public void setupDriver(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @After
    public void closeDriver(){
        if(driver != null){
            driver.close();
        }

    }

    public static WebDriver getDriver(){
        return driver;
    }

}
