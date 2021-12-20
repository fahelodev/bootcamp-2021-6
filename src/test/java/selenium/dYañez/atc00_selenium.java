package selenium.dYañez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc00_selenium {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Inicialización del WebDriver con Firefox
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        Thread.sleep(2000);
        driver.close();

    }

}
