package automationcraft.testcreation.google.pages;

import automationcraft.engine.selenium.SeleniumBase;
import com.sun.deploy.cache.BaseLocalApplicationProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GooglePages extends SeleniumBase {
    public GooglePages(WebDriver driver) {
        super(driver);
    }

    //Atraibutos o Localizaodres
    String URL = "http://www.google.com";
    By srchBox = By.xpath("//div[@class='SDkEP']");
    By btnSearch = By.xpath("//input[contains(@data-ved,'gQ4dUDCAs')]");
    By srchContainer = By.xpath("//div[@class='GyAeWb']");

    // Metodos KeywordDriven

    public void homeGoogle(){
        goToUrl(URL);
    }

    public void addString(String string){
        type(string, srchBox);
    }

    public void clickSearch(){
        click(btnSearch);
    }

    public void srchValidation(String string){
        Assert.assertTrue(getText(srchContainer).contains(string));
    }
}
