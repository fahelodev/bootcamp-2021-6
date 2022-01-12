package automationcraft.engine.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.List;
import java.util.Set;



public class SeleniumBaseDyanez {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;


    public SeleniumBaseDyanez(WebDriver driver){
        SeleniumBaseDyanez.driver = driver;
        wait = new WebDriverWait(driver,10);
    }


    //navigate to page
    public static void navigateTo(String url){
        driver.get(url);
    }


    //clean browser
    public static void cleanBrowser(){
        driver.quit();
    }


    //find element with condition expected visibility of element
    private WebElement Find (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }


    //click in element
    public void clickElement(String locator){

        Find(locator).click();
    }


    //write in field with condition of key ESCAPE after write
    public void writeTextWithEscape(String locator, String textWrite) throws InterruptedException {
        Find(locator).clear();
        Find(locator).sendKeys(textWrite);
        Thread.sleep(200);
        Find(locator).sendKeys(Keys.ESCAPE);
    }


    //write in field
    public void write(String locator, String textWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textWrite);
    }


    //dropdowon selection for value
    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));


        dropdown.selectByValue(valueToSelect);


    }


    public void validationText(String localizator, String text){
        Assert.assertEquals(text, Find(localizator).getText());
    }


    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select (Find(locator));


        dropdown.selectByIndex(valueToSelect);
    }


    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));


        dropdown.selectByVisibleText(valueToSelect);
    }


    //get the text of some element
    public String textFromElement(String locator){
        return Find(locator).getText();
    }


    //change focus tabs page
    public void SwitchTabs(){
        String mainTab= driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual: handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
            }
        }
    }


    //get list of result of element
    public List<WebElement> bringMeAllElements(String locator){


        return driver.findElements(By.xpath(locator));
    }


    //get title of some element
    public String getTitle() {
        return driver.getTitle();
    }


    public boolean elementIsDisplayed(String locator){


        return Find(locator).isDisplayed();


    }

    public boolean elementIsNotDisplayed(String locator){

        return Find(locator).isDisplayed();

    }


}



