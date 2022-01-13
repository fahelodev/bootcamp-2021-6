package automationcraft.testcreation.google.pages;


import org.openqa.selenium.WebDriver;

public class DYanezPage extends SeleniumBaseDyanez {

    public DYanezPage(WebDriver driver) {
        super(driver);
    }

    //Localizadores Test Case 03

    private String btnVerMas = "//em[@class='btn-text'][contains(text(),'Ver más ofertas')]";
    private String cardAuto = "//*[contains(@class, 'section-4')]//*[contains(@class, 'offer-cards-container')]/offer-card/div/a/div/div/img";
    private String dropDownDolar = "//*[@id='currency-select']";
    private String uSDValue = "USD";
    private String uSDTexto = "//*[contains(@class, 'clusters-container')]/div/transfer-cluster/div/div/div[2]/ds-cluster-pricebox/div/div/div/div[2]/span";

    //Form 1
    public void irAPageTraslados(){

        navigateTo("https://www.viajesfalabella.cl/traslados/");
    }

    public void btnClickCardAutoTraslado(){
        clickElement(btnVerMas);
        clickElement(cardAuto);
    }

    public void dropDownChangeDolar(){
        SwitchTabs();
        selectFromDropdownByValue(dropDownDolar, uSDValue);
    }

    public String validaTextUsd(){
        return textFromElement(uSDTexto);

    }
}
