package desafio.equipo4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class Herramientas {
    public static void changeTab(WebDriver driver, int segundosEspera){
        WebDriverWait espera = new WebDriverWait(driver, segundosEspera);
        // cambiamos el driver a la nueva pestaña y cerramos la anterior
        espera.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }
}
