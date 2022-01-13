package pom.equipo6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo6.base.SeleniumBase;

public class ResultadoAlojamientoPage extends SeleniumBase {

    public ResultadoAlojamientoPage(WebDriver driver) {
        super(driver);
    }

    By primerHotel = By.xpath("(//div[@class='pricebox-action']//a)[1]");


    public void Resultado() {
        clickear(primerHotel);

    }
}
