package automationcraft.testcreation.google.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class CucumberTestBase {



        public WebDriver driver;

        @Before(order = 0)
        public static void setupDriver(){
            WebDriverManager.chromedriver().setup();
        }

        @Before(order = 1)
        public void initDriver(){
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

}

