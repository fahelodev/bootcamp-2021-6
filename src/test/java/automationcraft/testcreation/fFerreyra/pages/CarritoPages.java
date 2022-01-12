package automationcraft.testcreation.fFerreyra.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoPages extends SeleniumBase {



    public CarritoPages(WebDriver driver) {
        super(driver);
    }

    private String URL = "https://www.paris.cl/iphone-11-64gb-negro%C2%A0%C2%A0-486146999.html#q=iphone&start=1";
    By clikmas = By.xpath("//button[@id='btn-plusMC']");
    By Deshabilita =  By.xpath("//button[@id='btn-plusMC']");



    public void CarritoConProducto(String URL){

        goToUrl(URL);
    }

    public void aumentaProducto(String string){

        for (int i = 0; i < 21; i++) {
            click(clikmas);
        }
    }

    public void desHabilita(String string){

            click(Deshabilita);

    }


}
