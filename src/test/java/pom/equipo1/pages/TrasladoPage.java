package pom.equipo1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pom.equipo1.base.SeleniumBase;

public class TrasladoPage extends SeleniumBase {

    public TrasladoPage(WebDriver driver) {
        super(driver);
    }

    //Atributos
    By haciaAerupuerto = By.xpath("(//div[@class='sbox-radio-buttons']//i[@class='radio-circle sbox-radio-circle'])[2]");
    By setAeropuerto = By.xpath("//div//input[contains(@placeholder, 'aeropuerto')]");
    By optionAeropuerto = By.xpath("//div[@class='ac-group-container']//span[@class='item-text']");
    By setHotel = By.xpath("//div//input[contains(@placeholder, 'hotel')]");
    By optionHotel = By.xpath("//div[@class='ac-container']//span[contains(text(), 'Amerian Córdoba')]");
    By setDate = By.xpath("//div[@class='input-container']//input[contains(@placeholder, 'Partida')]");
    By setDay = By.xpath("(//div[@class='_dpmg2--dates']//span[contains(text(), '31')])[1]");
    By apply = By.xpath("//div[@class='_dpmg2--date-footer']//em[contains(@class, 'apply')]");
    By selectHourTo = By.xpath("//div[@class='select-container']//select[@class='select-tag sbox-time-departure']");
    By setHour = By.xpath("(//div[@class='select-container']//option[text()='18:00'])[2]");
    By applyHour = By.xpath("(//div[@class='select-container']//select[contains(@class, 'time')])[2]");
    By buttonSearch = By.xpath("//div[@class='sbox-button-container']");

    By setArribo = By.xpath("//div[@class='input-container']//input[contains(@placeholder, 'Arribo')]");
    By datesActive = By.xpath("(//div[contains(@class,'month-active')])[2]//span[contains(@class,\"title-month\")]");
    By arrowDates = By.xpath("(//div[@class='_dpmg2--controls-next'])[2]");
    By dateGoing = By.xpath("((//div[contains(@class,'month-active')])[2]//span[contains(@class, 'number')])[10]");
    By applyDate = By.xpath("(//div[contains(@class,'btn-container')])[2]/button[contains(@class, 'apply')]");
    By selectDepartureTime = By.xpath("//div[@class='sbox-moment-input']//select[contains(@class, 'arrival')]");
    By checkboxAddReturn = By.xpath("//div[contains(@class, 'places-check')]//i");
    By startDate = By.xpath("(//div[@class='sbox-row'])[2]//input");
    By dateReturn = By.xpath("((//div[contains(@class, 'month-active')])[2]//span[contains(@class, 'number')])[20]");
    By applyDateReturn = By.xpath("(//div[contains(@class, 'btn-container')])[2]/button[contains(@class, 'apply')]");
    By selectReturnTime = By.xpath("(//div[@class='sbox-row'])[2]//select");
    By boxPassengers = By.xpath("//div[@class='sbox-distri-container']//div[@class='input-container']");
    By addMinor = By.xpath("(//div[contains(@class,'number-picker')])[2]//a[contains(@class, 'plus')]");
    By ageMinor = By.xpath("//div[contains(@class,'minors-age')]//select");
    By applyPassengers = By.xpath("//div/a[contains(@class, 'apply')]");
    By clickSearch = By.xpath("//div[@class='sbox-button']//a");

    //Metodos
    public void setTrasladoBasico() {
        clickear(haciaAerupuerto);
        doSendKeys(setAeropuerto, "Córdoba");
        clickear(optionAeropuerto);
        doSendKeys(setHotel, "Amerian Park Hotel");
        clickear(optionHotel);
        clickear(setDate);
        clickear(setDay);
        clickear(apply);
        clickear(selectHourTo);
        clickear(setHour);
        clickear(applyHour);
        clickear(buttonSearch);
    }

    public void setTrasladoMedio() {
        doSendKeys(setAeropuerto, "Córdoba");
        clickear(optionAeropuerto);
        doSendKeys(setHotel, "Amerian Park Hotel");
        clickear(optionHotel);
        clickear(setArribo);
        cicloDate("Febrero");
        clickear(dateGoing);
        clickear(applyDate);
        selectStartHour(16);
        clickear(checkboxAddReturn);
        clickear(startDate);
        clickear(dateReturn);
        clickear(applyDateReturn);
        selectReturnHour(40);
        clickear(boxPassengers);
        clickear(addMinor);
        selectAgeMinor(18);
        clickear(applyPassengers);
        clickear(clickSearch);
    }
    public void setTrasladoComplejo() {
        doSendKeys(setAeropuerto, "Córdoba");
        clickear(optionAeropuerto);
        doSendKeys(setHotel, "Amerian Park Hotel");
        clickear(optionHotel);
        clickear(setArribo);
        cicloDate("Junio");
        clickear(dateGoing);
        clickear(applyDate);
        selectStartHour(20);
        clickear(checkboxAddReturn);
        clickear(startDate);
        clickear(dateReturn);
        clickear(applyDateReturn);
        selectReturnHour(38);
        clickear(boxPassengers);
        clickear(addMinor);
        selectAgeMinor(11);
        clickear(applyPassengers);
        clickear(clickSearch);


    }

    //Metodos privados

    private void cicloDate(String month) {
        while (true) {
            //se crea un string con los meses
            String dates = devolverTexto(datesActive);
            //se crea la condicion de que si el nombre del mes no es igual a Febrero haga click
            if (!dates.equals(month)) {
                clickear(arrowDates);
            } else {//sale del bucle al cumplirse la condicion
                break;
            }
        }
    }

    private void selectStartHour(int hour) {
        Select time = new Select(encontrarElementoWeb(selectDepartureTime));
        time.selectByIndex(hour);
    }

    private void selectReturnHour(int hour) {
        Select time = new Select(encontrarElementoWeb(selectReturnTime));
        time.selectByIndex(hour);
    }

    private void selectAgeMinor(int agePeople){
        Select age = new Select(encontrarElementoWeb(ageMinor));
        age.selectByIndex(agePeople);
    }
}
