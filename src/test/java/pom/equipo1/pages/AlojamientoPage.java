package pom.equipo1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pom.equipo1.base.SeleniumBase;

public class AlojamientoPage extends SeleniumBase {

    public AlojamientoPage(WebDriver driver) {
        super(driver);
    }

    //Atributos
    By setDestination = By.xpath("//input[contains(@class,\"destination\")]");
    By firstDestination = By.xpath("//div[@class=\"ac-group-container\"]/ul/li");
    By checkboxIndefiniteDay = By.xpath("//div[contains(@class,\"checkbox\")]//label");
    By buttonSearch = By.xpath("//div[contains(@class,\"sbox-button\")]//a");

    By setDay = By.xpath("//div[contains(@class,\"checkin-date\")]");
    By datesActive = By.xpath("//div[contains(@class,\"month-active\")]/div[contains(@class,\"month-title\")]/span");
    By arrowDates = By.xpath("//div[contains(@class,\"controls-next\")]");
    By departureDate = By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[1]");
    By returnDate = By.xpath("(//div[contains(@class,\"month-active\")]//span[contains(@class,\"number\")])[31]");
    By buttonApplyDate = By.xpath("//button[contains(@class,\"button-apply\")]");
    By accommodationOfPeople = By.xpath("//div[contains(@class,\"guests-container\")]/div");
    By addMinor = By.xpath("//div[contains(@class,\"stepper-minors\")]//a[not(contains(@class,\"disable\"))]");
    By ageMinor = By.xpath("//div[@class=\"select-container\"]/select");
    By applyPassengers = By.xpath("//div[contains(@class,\"medium-down\")]/a[contains(@class,\"link-right\")]");

    public void setAlojamientoBasico() {
        doSendKeys(setDestination, "Rio");
        clickear(firstDestination);
        clickear(checkboxIndefiniteDay);
        clickear(buttonSearch);
    }

    public void setAlojamientoMedio() throws InterruptedException {
        doSendKeys(setDestination, "Rio");
        clickear(firstDestination);
        clickear(setDay);
        cicloDate("Mayo");
        clickear(departureDate);
        Thread.sleep(2000);
        clickear(returnDate);
        clickear(buttonApplyDate);
        clickear(accommodationOfPeople);
        clickear(addMinor);
        selectAgeMinor(15);
        clickear(applyPassengers);
        clickear(buttonSearch);
    }
    public void setAlojamientoComplejo() {
        doSendKeys(setDestination, "Rio");
        clickear(firstDestination);
        //clickear(setDay);


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

    private void selectAgeMinor(int agePeople){
        Select age = new Select(encontrarElementoWeb(ageMinor));
        age.selectByIndex(agePeople);
    }
}