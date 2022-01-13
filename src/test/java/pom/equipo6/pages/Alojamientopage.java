package pom.equipo6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo6.base.SeleniumBase;

public class Alojamientopage extends SeleniumBase {

    public Alojamientopage(WebDriver driver) {
        super(driver);
    }

    By destino = By.xpath("//*[@type='text']");
    //By ciudadDestino = By.xpath("//div//input[contains(@placeholder, 'aeropuerto')]");
    By noSelecFecha = By.xpath("//input[@class='checkbox-tag sbox-no-date-specified']/following-sibling::i[1]");
    By buscar = By.xpath("(//a[contains(@class,'sbox-3-btn -primary')])[2]");


    public void BuscarHotel() throws InterruptedException {
        //clickear(destino);

        ingresarTexto(destino, "Madrid, Comunidad de Madrid, España");
        Thread.sleep(2000);
        enter(destino);
        clickear(noSelecFecha);
        clickear(buscar);


    }
}
