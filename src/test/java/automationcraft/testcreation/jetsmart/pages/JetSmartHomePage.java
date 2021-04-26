package automationcraft.testcreation.jetsmart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import automationcraft.engine.selenium.SeleniumBase;

/**
 * URL: https://jetsmart.com/cl/es/
 * HomePage para automatizacion de casos de Pruebas
 */
public class JetSmartHomePage extends SeleniumBase {

    public JetSmartHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Identificacion de Objetos
    private By aTagCheckIn = By.xpath("//a[@href='#dg-check-in-modal']");
    private By aTagAdministraTuViaje = By.xpath("//a[@href='#dg-administer-modal']");
    private By aTagEmpresas = By.xpath("//a[@href='./empresas']");
    private By aTagIniciaSesion = By.xpath("//span[contains(text(),'Inicia Sesión')]");
    private By aTagClienteBancoEstado = By.cssSelector(".login-container > li:nth-child(5) > a:nth-child(1)");
    private By btnPopUp = By.xpath("//div[@class='modal-header']//button[@type='button']");



    //Metodos Keyword Driven:  JetSmartHomePage
    public void clickCheckIn(){
        click(aTagCheckIn);
    }
    public void clickAdministraTuViaje(){
        click(aTagAdministraTuViaje);
    }
    public void clickEmpresas(){
        click(aTagEmpresas);
    }
    public void clickIniciaSesion(){
        click(aTagIniciaSesion);
    }
    public void clickClienteBancoEstado(){
        click(aTagClienteBancoEstado);
    }

    public void cerrarPopUp() throws InterruptedException {
        if(isDisplayed(btnPopUp)){
            click(btnPopUp);
        }
    }






}
