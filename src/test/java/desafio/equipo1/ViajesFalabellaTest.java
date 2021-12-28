package desafio.equipo1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ViajesFalabellaTest {
    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();

    }

    //se instancia el driver y se le entrega la url a testear
    @Before
    public void initial() {
        driver = new ChromeDriver();
        driver.get("https://www.viajesfalabella.cl/");

    }
    @Test
    public void atc01_AlojamientoBasico(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Alojamientos\")]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,\"destination\")]"))).sendKeys("Rio");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"ac-group-container\"]/ul/li"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"checkbox\")]//label"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"sbox-button\")]//a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"filter-tags-wrapper\"]//span[contains(text(),\"Estrellas\")]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,\"-show-tooltip\")]//em[contains(text(),\"5\")and contains(@class,\"filter-name\")]"))).click();
    }
    @Test
    public void atc03_AlojamientoComplejo(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"header-products-container\"]//a[contains(@title,\"Alojamientos\")]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,\"destination\")]"))).sendKeys("Rio");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"ac-group-container\"]/ul/li"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"checkin-date\")]"))).click();

        while(true){
            String active = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,\"month-active\")]/div[contains(@class,\"month-title\")]/span"))).getText();
            if (!active.equals("Mayo")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"controls-next\")]"))).click();
            }else{break;}
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[31]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,\"button-apply\")]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,\"guests-container\")]/div"))).click();

    }
    @After
    public void close(){
        if (driver != null) {
            driver.close();
        }
    }
}
