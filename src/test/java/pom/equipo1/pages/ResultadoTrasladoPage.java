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

    By person = By.xpath("((//div[contains(@class,'re-search')])[2]//span[@class='item-container'])[3]");

    By modify = By.xpath("(//div[contains(@class, 're-search')])[2]//span[contains(@class, 'btn')]");
    By returnDay = By.xpath("(//div[@class='sbox-row'])[2]//input");
    By changeDayReturn = By.xpath("(//div[contains(@class, 'has-end-range')]//span[contains(@class, 'number')])[19]");
    By applyChange = By.xpath("(//div[contains(@class, 'btn-container')])[2]/button[contains(@class, 'apply')]");
    By selectNewHour = By.xpath("(//div[@class='sbox-row'])[2]//select");
    By boxPassengers = By.xpath("//div[@class='sbox-distri-container']//div[@class='input-container']");
    By addAdult = By.xpath("(//div[contains(@class,'number-picker')])[1]//a[contains(@class, 'plus')]");
    By clickSearch = By.xpath("//div[@class='sbox-button']//a");


    public void getPrices(){
        String value = devolverTexto(price);
        String[] arr = value.split(" ");
        String value2 = devolverTexto(price2);

        Assert.assertEquals(arr[1], value2);
    }

    public void getPassengers(){

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

    private void selectReturnHour(int hour) {
        Select time = new Select(encontrarElementoWeb(selectNewHour));
        time.selectByIndex(hour);
    }


}
