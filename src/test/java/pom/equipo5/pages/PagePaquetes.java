package pom.equipo5.pages;

import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBaseE5;

public class PagePaquetes extends SeleniumBaseE5 {

    public PagePaquetes(WebDriver driver, String text) {
        super(driver);
        this.text = text;
    }

    public String text = "Precio: menor a mayor";

}
