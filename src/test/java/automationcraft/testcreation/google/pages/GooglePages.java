package automationcraft.testcreation.google.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePages extends SeleniumBase {
    public GooglePages(WebDriver driver) {
        super(driver);
    }

    //Atraibutos o Localizaodres
    private String URL = "https://www.google.com/";
    By googleBar = By.xpath("//*[@name='q']");
    By btn_googleBar = By.xpath("//*[@name='btnK']");

    // Metodos KeywordDriven
    public void goToGoogleHome(){goToUrl(URL);}

    public void addTextGoogleBar(String inputText){
        click(googleBar);
        type(inputText, googleBar);
        type(String.valueOf(Keys.ESCAPE),googleBar);
    }

    public void enterGoogleBar() throws InterruptedException {
        click(btn_googleBar);
        Thread.sleep(2000);
    }

    public void validation(String inputText){
        String result = getTitle();
        Assert.assertTrue(result.contains(inputText));
    }
}
