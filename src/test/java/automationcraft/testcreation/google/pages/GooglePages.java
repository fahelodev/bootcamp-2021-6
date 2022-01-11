package automationcraft.testcreation.google.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GooglePages extends SeleniumBase {
    public GooglePages(WebDriver driver) {
        super(driver);
    }

    //Atraibutos o Localizaodres
    String URL = "https://www.google.com/";
    By searchBox = By.xpath("//input[@name='q']");
    By searchButton = By.xpath("(//input[contains(@name, 'btnK')])[2]");
    By listOfResults = By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']");

    // Metodos KeywordDriven

    public void goToTheUrl(){
        goToUrl(URL);
    }

    public void putTextIntoSearchBox(String string){
        type(string, searchBox);
    }

    public void pressSearchButton(){
        sendEnter(searchBox);
    }

    public void validateStringMentioned(String string){
        boolean flag = false;
        List<WebElement> resultsList = findElements(listOfResults);
        for(WebElement element : resultsList){
            if(getText(element).toLowerCase().contains(string)){
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new RuntimeException(string+" not mentioned");
        }
    }

}
