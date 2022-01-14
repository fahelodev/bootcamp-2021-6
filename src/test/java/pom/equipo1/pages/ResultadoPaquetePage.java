package pom.equipo1.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo1.base.SeleniumBase;

public class ResultadoPaquetePage extends SeleniumBase {

    public ResultadoPaquetePage(WebDriver driver) {
        super(driver);
    }
    By filtro_noches = By.xpath("//div[@class=\"filter-value eva-3-tag nights_count-filter\"][1]");
    By filtro_noches1 = By.xpath("//*[contains(@class, 'filters-tooltip')]//p[text()='Más de 8 noches']");
    By apply = By.xpath("//*[contains(@class, 'filters-tooltip')]//em[text()='Aplicar']");
    By mes_text = By.xpath("//div[@class=\"filter-value eva-3-tag filter-tag -active\"]//p[text()='Enero']");
    By noches_text = By.xpath("//*[contains(@class, 'nights_count')]//p[text()='Más de 8 noches']");

    By package_text = By.xpath("//h3[contains(text(), 'Este es el paquete perfecto para tí. ¡Empieza a vivir tu viaje!')]");

    By stars_checkbox = By.xpath("//*[contains(@class, 'eva-3-dropdown')]/li[3]/aloha-filter/aloha-checkbox-filter/ul/li[4]/span/span/aloha-checkbox/span/label/i");
    By rate = By.xpath("//span[text()='7.6']");
    By hotel = By.xpath("//*[contains(@class, 'results-items-wrapper')]/aloha-list-view-container/div[4]/div/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button/em");
    By hotel1 = By.xpath("//*[contains(@class, 'pricebox-action')]//em[text()='Siguiente']");
    By scale = By.xpath("//*[@id='filter-stops']//*[contains(@class, 'dropdown-subcontent')]/div/checkbox-filter/checkbox-filter-item[2]/li/span/span/span/label/i");
    By baggage = By.xpath("//*[@id='filter-baggage']//*[contains(@class, 'dropdown-subcontent')]/div/checkbox-filter/checkbox-filter-item[2]/li/span/span/span/label/i");
    By airline = By.xpath("//*[@id='filter-airlines']//*[contains(@class, 'container-filter')]");
    By airline_select = By.xpath("//*[@id='filter-airlines']//*[contains(@class, 'dropdown-subcontent')]/div/checkbox-filter/checkbox-filter-item[2]/li/span/span/span/label/i");
    By scale_text = By.xpath("//*[contains(@class, 'tags-scroll-hide')]//span[text()='1 Escala']");
    By baggage_text = By.xpath("//*[contains(@class, 'tags-scroll-hide')]//span[text()='Equipaje de mano']");

    public void getPackageFilter() throws InterruptedException {
        clickear(filtro_noches);
        clickear(filtro_noches1);
        clickear(apply);
        Thread.sleep(2000);
        String mes = devolverTexto(mes_text);
        String text2 = devolverTexto(noches_text);
        Assert.assertEquals("Enero", mes);
        Assert.assertEquals("Más de 8 noches", text2);
    }

    public void getPackage() throws InterruptedException {
        Thread.sleep(2000);
        String text = devolverTexto(package_text);
        Assert.assertEquals("Este es el paquete perfecto para tí. ¡Empieza a vivir tu viaje!", text);
    }

    public void getPackageHard() throws InterruptedException {
        clickear(stars_checkbox);
        String text = devolverTexto(rate);
        double text_int = Double.parseDouble(text);
        if (text_int >= 7){
            Thread.sleep(2000);
            clickear(hotel);
        }
        handleTab();
        clickear(hotel1);
        clickear(scale);
        Thread.sleep(2000);
        clickear(baggage);
        Thread.sleep(2000);
        clickear(airline);
        clickear(airline_select);
        Thread.sleep(2000);
        String text2 = devolverTexto(scale_text);
        String text3 = devolverTexto(baggage_text);
        Assert.assertEquals("1 Escala", text2);
        Assert.assertEquals("Equipaje de mano", text3);
    }

}
