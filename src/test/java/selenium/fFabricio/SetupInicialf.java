package selenium.fFabricio;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetupInicialf {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();

        //Inicialización del WebDriver con Firefox
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        Thread.sleep(2000);
        driver.close();

    }

}
