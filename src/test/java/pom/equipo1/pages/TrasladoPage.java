package pom.equipo1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo1.base.SeleniumBase;

public class TrasladoPage extends SeleniumBase {

    public TrasladoPage(WebDriver driver) {
        super(driver);
    }

    By haciaAerupuerto = By.xpath("(//div[@class='sbox-radio-buttons']//i[@class='radio-circle sbox-radio-circle'])[2]");
    By setAeropuerto = By.xpath("//div//input[contains(@placeholder, 'aeropuerto')]");
    By optionAeropuerto = By.xpath("//div[@class='ac-group-container']//span[@class='item-text']");
    By setHotel = By.xpath("//div//input[contains(@placeholder, 'hotel')]");
    By optionHotel = By.xpath("//div[@class='ac-container']//span[contains(text(), 'Amerian Córdoba')]");
    By setDate = By.xpath("//div[@class='input-container']//input[contains(@placeholder, 'Partida')]");
    By setDay = By.xpath("(//div[@class='_dpmg2--dates']//span[contains(text(), '11')])[2]");
    By apply = By.xpath("//div[@class='_dpmg2--date-footer']//em[contains(@class, 'apply')]");
    By selectHour = By.xpath("//div[@class='select-container']//select[@class='select-tag sbox-time-departure']");
    By setHour = By.xpath("(//div[@class='select-container']//option[text()='18:00'])[2]");
    By applyHour = By.xpath("(//div[@class='select-container']//select[contains(@class, 'time')])[2]");
    By buttonSearch = By.xpath("//div[@class='sbox-button-container']");


    public void setTraslado(){
        clickear(haciaAerupuerto);
        enviarKeys(setAeropuerto, "Córdoba");
        clickear(optionAeropuerto);
        enviarKeys(setHotel, "Amerian Park Hotel");
        clickear(optionHotel);
        clickear(setDate);
        clickear(setDay);
        clickear(apply);
        clickear(selectHour);
        clickear(setHour);
        clickear(applyHour);
        clickear(buttonSearch);

    }
}
