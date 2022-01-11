package automationcraft.testcreation.google.pages;

import automationcraft.engine.selenium.SeleniumBase;
import automationcraft.engine.selenium.SeleniumBaseDyanez;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GooglePages extends SeleniumBaseDyanez {



    //Atraibutos o Localizaodres
    private String searchTextField = "//*[@name='q']";
    private String searchButton = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]";
    private String searchResults = "//div[@class=\"g\"]//h3/a";
    private String firtsResults = "//*[@id='rso']/div/div";

    public GooglePages(WebDriver driver) {
        super(driver);
    }

    // Metodos KeywordDriven


    public void navigateToGoogle(){

        navigateTo("https://www.google.cl");
    }


    public void enterSearchCriteria(String nameAnimal) throws InterruptedException {
        writeTextWithEscape(searchTextField,nameAnimal);

    }

    public void clickGoogleSearch(){

        clickElement(searchButton);
    }

    public String validateTextCart(){

        return textFromElement(firtsResults);
    }

    public void validation(String inputText){
        String result = getTitle();
        Assert.assertTrue(result.contains(inputText));
    }



    public List<String> getAllSearchResults(){
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringFromList = new ArrayList<String>();
        for(WebElement e : list){
            stringFromList.add(e.getText());
        }

        return stringFromList;

    }




}
