package pom.equipo1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo1.base.SeleniumBase;

public class PaquetePage extends SeleniumBase {
    public PaquetePage(WebDriver driver){
        super(driver);
    }

    By origen = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline\"]");
    By origen_destino= By.xpath("//span[@class=\"item-text\"]");
    By destino = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline\"]");
    By switch_fecha = By.xpath("//span[@class=\"switch-circle\"]");
    By mes = By.xpath("//select[@class=\"select-tag sbox-month-seletor\"]");
    By buscar = By.xpath("//em[@class=\"btn-text\"]");

    By box_fecha = By.xpath("//input[@class=\"input-tag sbox-checkin-date\"]");
    By ida = By.xpath("//html/body/div[5]/div/div[5]/div/div[4]/span[11]");
    By vuelta = By.xpath("//html/body/div[5]/div/div[5]/div/div[4]/span[25]");
    By apply = By.xpath("//html/body/div[7]/div/div[6]/div[2]/button[2]/em");
    By room = By.xpath("//*[contains(@class, 'sbox-distri-input')]//*[contains(@class, 'input-container')]");
    By plus = By.xpath("//*[contains(@class, '_pnlpk-panel--show')]//*[contains(@class, '_pnlpk-panel__blocks')]/div/div[2]/div/div[2]/div/a[2]");
    By apply1 = By.xpath("//*[contains(@class, '_pnlpk-panel--show')]//a[text()='Aplicar']");

    By add_room = By.xpath("//a[text()='Añadir habitación']");

    public void setPaqueteBasico(){
        enviarKeys(origen, "Arturo Merino");
        clickear(origen_destino);
        enviarKeys(destino, "Lima");
        clickear(origen_destino);
        clickear(switch_fecha);
        setSelect(mes, "2022-01");
        clickear(buscar);
    }

    public void setPaqueteMedio(){
        enviarKeys(origen, "bue");
        clickear(origen_destino);
        enviarKeys(destino, "mia");
        clickear(origen_destino);
        clickear(box_fecha);
        clickear(ida);
        clickear(vuelta);
        clickear(apply);
        clickear(room);
        clickear(plus);
        clickear(apply1);
        clickear(buscar);
    }

    public void setPaqueteComplejo(){
        enviarKeys(origen, "Cordoba");
        clickear(origen_destino);
        enviarKeys(destino, "Miami");
        clickear(origen_destino);
        clickear(box_fecha);
        clickear(ida);
        clickear(vuelta);
        clickear(apply);
        clickear(room);
        clickear(add_room);
        clickear(apply1);
        clickear(buscar);
    }
}
