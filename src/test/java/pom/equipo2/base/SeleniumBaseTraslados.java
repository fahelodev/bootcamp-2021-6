package pom.equipo2.base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static desafio.equipo4.Herramientas.changeTab;
import java.util.List;
import java.util.Set;


public class SeleniumBaseTraslados {


    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    public SeleniumBaseTraslados(WebDriver driver){
        SeleniumBaseTraslados.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void cleanBrowser(){
        driver.quit();
    }

    private WebElement Find (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textWrite);
    }

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

    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));

    }

    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }


    public void switchToiFrame(String iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        try{

            driver.switchTo().alert().dismiss();

        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    public boolean elementEnabled(String locator){

        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){

        return Find(locator).isDisplayed();

    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }

    public void SwitchTabs(){
        String mainTab= driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual: handles){
            if(!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
            }
        }
    }
    public void CloseTabs(){
        changeTab(driver, 10);
    }


}
