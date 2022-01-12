package pom.Grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Grupo4.base.SeleniumBase;

import java.util.List;

public class VFAlojamientosDetallePage extends SeleniumBase {

    private String URL = "https://www.viajesfalabella.cl/accommodations/detail/";
    public VFAlojamientosDetallePage(WebDriver driver){super(driver);}

    //atributos de la pagina -> Localizadores
    By btnReservarAhora = By.xpath("//aloha-next-step-button//aloha-button");


    public void clickearReservarAhora() {
        clickear(btnReservarAhora);
    }
}
