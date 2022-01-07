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

    public void getPrices(){
        String value = devolerTexto(price);
        String[] arr = value.split(" ");
        String value2 = devolerTexto(price2);

        Assert.assertEquals(arr[1], value2);
    }


}
