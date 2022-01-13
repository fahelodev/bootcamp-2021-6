package automationcraft.testcreation.ifuentes.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoDeCompraPages extends SeleniumBase {

    public CarritoDeCompraPages(WebDriver driver) {super(driver);}

    //Localizadores
    By anadirCarro = By.xpath("//button[@class='add-to-cart btn-default btn no-border-right btn-add-cart btn-block btn-sm js-button-warranty']");
    By btnContinuar = By.xpath("//button[@class='warranty-modal__button']");
    By btnIrCarro = By.xpath("//a[3]//span[@class='counter qty']");
    By iconoSumar = By.xpath("//button[@id='btn-plusMC']");
    By btndeshabilita = By.xpath("//input[@id='GTM_cart_quantity-mas']");



    public void validacionUrl(String url) throws Exception {
        goToUrl(url);
    }

    public void anadirCarro() throws Exception {
        explicitWait(1500);
        click(anadirCarro);
    }

    public void Continauar() throws Exception {
        explicitWait(1500);
        click(btnContinuar);
    }


    public void irCarro() throws Exception {
        explicitWait(1500);
        click(btnIrCarro);
    }

    public void MasUnidades() throws Exception {

        for (int i = 0; i < 19; i++) {
            click(iconoSumar);

        }

    }

    public void btnDeshabilita() throws Exception {
        explicitWait(1500);
        click(btndeshabilita);
    }


}

