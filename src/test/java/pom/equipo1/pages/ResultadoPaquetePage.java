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

}
