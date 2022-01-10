package automationcraft.testcreation.google.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePages extends SeleniumBase {
    public GooglePages(WebDriver driver) {
        super(driver);
    }
    private String url = "https://www.google.com";

    //Atributos o Localizadores
By SearchBox = By.xpath("//*[@name='q']");
By SearchButton= By.xpath("//*[contains(@class, 'FPdoLc')]//*[@name='btnK']");



// Metodos KeywordDriven
public void goToGoogle(){
        goToUrl(url);
    }

public void type(String inputText) throws InterruptedException {
        click(SearchBox);
        type(inputText,SearchBox);
        Thread.sleep(1000);
        type(String.valueOf(Keys.ESCAPE),SearchBox);
}
public void ClickButtonSearch() throws InterruptedException {
    click(SearchButton);
    Thread.sleep(2000);
}
public void validate(String inputText){
     String SearchResult = getTitle();
        Assert.assertTrue(SearchResult.contains(inputText));
 }
}
