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
    By srchBox = By.xpath("//input[@class='gLFyf gsfi']");
    By btnSearch = By.xpath("(//input[@value='Buscar con Google'])[2]");
    By srchContainer = By.xpath("//div[@id='rcnt']");
    // Metodos KeywordDriven

    public void homeGoogle(){
        goToUrl(URL);
    }

    public void addString(String string){
        type(string, srchBox);
    }

    public void clickSearch(){
        typeEnter(srchBox);
    }

    public void srchValidation(String string){
        Assert.assertTrue(getText(srchContainer).contains(string));
    }
}
