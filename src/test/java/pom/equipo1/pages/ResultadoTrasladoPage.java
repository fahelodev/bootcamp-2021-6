package pom.equipo1.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo1.base.SeleniumBase;

public class ResultadoTrasladoPage extends SeleniumBase {

    public ResultadoTrasladoPage(WebDriver driver) {
        super(driver);
    }
    By price = By.xpath("//div[@class='sub-nav-container']//label/span[2]");
    By price2 = By.xpath("//div[@class='pricebox-value']/span[2]");

    By person = By.xpath("((//div[contains(@class,'re-search')])[2]//span[@class='item-container'])[3]");

    public void getPrices(){
        String value = devolverTexto(price);
        String[] arr = value.split(" ");
        String value2 = devolverTexto(price2);

        Assert.assertEquals(arr[1], value2);
    }

    public void getPassengers(){

    }


}
