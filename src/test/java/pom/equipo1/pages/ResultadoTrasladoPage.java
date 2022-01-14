package pom.equipo1.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pom.equipo1.base.SeleniumBase;

public class ResultadoTrasladoPage extends SeleniumBase {

    public ResultadoTrasladoPage(WebDriver driver) {
        super(driver);
    }
    By price = By.xpath("//div[@class='sub-nav-container']//label/span[2]");
    By price2 = By.xpath("//div[@class='pricebox-value']/span[2]");

    By quantityPerson = By.xpath("((//div[contains(@class,'re-search')])[2]//span[@class='item-container'])[3]");
    By quatityPerson2 = By.xpath("(//div[@class='item'])[1]/span[contains(text(), 'personas')]");


    By modify = By.xpath("(//div[contains(@class, 're-search')])[2]//span[contains(@class, 'btn')]");
    By returnDay = By.xpath("(//div[@class='sbox-row'])[2]//input");
    By changeDayReturn = By.xpath("(//div[contains(@class, 'has-end-range')]//span[contains(@class, 'number')])[19]");
    By applyChange = By.xpath("(//div[contains(@class, 'btn-container')])[2]/button[contains(@class, 'apply')]");
    By selectNewHour = By.xpath("(//div[@class='sbox-row'])[2]//select");
    By boxPassengers = By.xpath("//div[@class='sbox-distri-container']//div[@class='input-container']");
    By addAdult = By.xpath("(//div[contains(@class,'number-picker')])[1]//a[contains(@class, 'plus')]");
    By clickSearch = By.xpath("//div[@class='sbox-button']//a");
    By date = By.xpath("((//div[contains(@class, 're-search')])[2]//span[contains(@class, 'item-date')])[2]");
    By date2 = By.xpath("(//div[@class='-eva-3-mt-xsm']/span[contains(@class, 'eva-')])[1]");

    public void getPrices(){
        String value = devolverTexto(price);
        String[] arr = value.split(" ");
        String value2 = devolverTexto(price2);

        Assert.assertEquals(arr[1], value2);
    }

    public void getPassengers(){
        String person = devolverTexto(quantityPerson);
        String person2 = devolverTexto(quatityPerson2);
        String[] arr = person2.split(" ");
        String num = arr[0];

        int passengerTravel = Integer.parseInt(num);
        int passengerCar = Integer.parseInt(person);
        Assert.assertTrue(passengerCar>=passengerTravel);
    }

    public void changeReturn(){
        clickear(modify);
        clickear(returnDay);
        clickear(changeDayReturn);
        clickear(applyChange);
        selectReturnHour(42);
    }
    public void changePassengersAndSearch(){
        clickear(boxPassengers);
        clickear(addAdult);
        clickear(clickSearch);
    }

    public void getDate(){
        String newDate = devolverTexto(date);
        String[] arr = newDate.split(" ");
        String selectDate = arr[2]+arr[3];
        String finalDate = devolverTexto(date2);
        String[] arr2 = finalDate.split(" ");
        String getDate = arr2[0]+arr2[1];

        Assert.assertEquals(selectDate, getDate);

    }

    private void selectReturnHour(int hour) {
        Select time = new Select(encontrarElementoWeb(selectNewHour));
        time.selectByIndex(hour);
    }


}
