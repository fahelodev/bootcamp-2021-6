package pom.equipo6.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo6.base.SeleniumBase;

import static junit.desafio.equipo4.Herramientas.changeTab;

public class ResultadoHotel extends SeleniumBase {

    By ordenarPor = By.xpath("(//select[@class='select-tag'])[1]");
    By menorPuntaje = By.xpath("//select[@id='jr-eva-select'] //option[@value='overall_rating_asc']");
    By validacion = By.xpath("//span[text()='7,5']");

    public ResultadoHotel(WebDriver driver) {
        super(driver);
    }


    public void PuntajeHotel() {
        changeTab(driver, 10);
        clickear(ordenarPor);
        clickear(menorPuntaje);
        String Result = sacarTexto(validacion);


        Assert.assertEquals("7,5", Result);

    }
}
