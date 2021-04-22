package automationcraft.testcreation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import automationcraft.engine.selenium.SeleniumBase;


/**
 * Page Url: https://booking.jetsmart.com/V2/Login
 */
public class JetSmartInicioSesionPage extends SeleniumBase {

    public JetSmartInicioSesionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Identificacion de Objetos
    private By seleccionPersonas = By.cssSelector("#memberLoginForm > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > label:nth-child(1) > span:nth-child(2)");
    private By seleccionEmpresas = By.cssSelector("#memberLoginForm > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > label:nth-child(2) > span:nth-child(2)");
    private By seleccionBancoEstado = By.xpath("//form[@id='memberLoginForm']//span[@class='mdl-radio__label nowrap radio-with-img'][contains(text(),'Clientes')]");

    private By userMail = By.xpath("//form[@id='memberLoginForm']//input[@class='mdl-textfield__input js-input ts-login-email']");
    private By userPass = By.xpath("//form[@id='memberLoginForm']//div[@class='col-xs-1']//div[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label float-center is-upgraded']//input[@type='password']");
    private By botonInicioSesion = By.xpath("//button[contains(text(),'Inicia sesión')]");

    //Metodos Keyword Driven: JetSmartInicioSesionPage
    public void IniciarSesionPersonas(String userMailtxt, String userPasstxt){
        click(seleccionPersonas);
        type(userMailtxt,userMail);
        type(userPasstxt,userPass);
        click(botonInicioSesion);
    }


}
