package automationcraft.testcreation.google.pages;

import automationcraft.engine.selenium.SeleniumBase;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public void goToGoogleHome(){goToUrl(URL);}



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




    public List<String> getAllSearchResults(){
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringFromList = new ArrayList<String>();
        for(WebElement e : list){
            stringFromList.add(e.getText());
        }

        return stringFromList;

    }

}
