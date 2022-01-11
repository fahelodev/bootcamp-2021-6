package automationcraft.testcreation.google.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GooglePages extends SeleniumBase {
    private String URL = "https://www.google.com/";
    public GooglePages(WebDriver driver) {
        super(driver);
    }
    By searchBox = By.xpath("//input[@class='gLFyf gsfi']");
    By searchButton = By.xpath("(//input[@class='gNO89b'])[2]");
    public void setup(){
        goToUrl(URL);
    }

    public void searchWord(String text){
        type(text, searchBox);
    }

    public void clickButton (){
        click(searchButton);
    }
}
