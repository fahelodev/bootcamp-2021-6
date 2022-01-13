package pom.equipo3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.equipo3.base.SeleniumBase;

public class act03HomePage extends SeleniumBase {

    WebDriverWait wait = new WebDriverWait(driver,30);

    private String URL = "https://www.viajesfalabella.cl/";
    String urlEsperada = "https://www.viajesfalabella.cl/accommodations/results/";
    String urlResultados = driver.getCurrentUrl();
    String diaInicio = "10";
    String diaRetorno = "15";
    String[] edad_menores_habitacion1 = {"5 años", "7 años","9 años", "12 años", "14 años"};
    String[] edad_menores_habitacion2 = {"2 años", "10 años","15 años", "17 años"};

    By alojamientos = By.xpath("//label[.='Alojamientos']");
    By inputDestino = By.xpath("//label[.='Destino']/../input");
    By buscador = By.xpath("//em[.='Buscar']");
    By fecha = By.xpath("//input[@placeholder='Entrada']");
    By fechaInicio = By.xpath("//*[@data-month=\"2022-02\"]//span[.='" + diaInicio + "']");
    By FechaFin = By.xpath("//*[@data-month=\"2022-02\"]//span[.='" + diaRetorno + "']");
    By aplicar = By.xpath("//em[.='Aplicar']");
    By habitaciones = By.xpath("//*[@class='sbox-row sbox-distribution-picker-wrapper-ui']");
    By desplegableCiudades = By.xpath("//i[@class='suggester-icon-xsm suggester-icon-city']");
    By otraHabitacion = By.xpath("//a[.='Añadir habitación']");
    By aplicarHabitacion = By.xpath("//a[.='Aplicar']");


    public act03HomePage(WebDriver driver) {
        super(driver);
    }
    public void act03_Alojamiento(){
        obtenerUrl(URL);
        clickear(alojamientos);
        type("Rio de janeiro",inputDestino);
        wait.until(ExpectedConditions.elementToBeClickable(desplegableCiudades));
        presionarTecla(inputDestino);
        clickear(fecha);
        clickear(fechaInicio);
        clickear(FechaFin);
        clickear(aplicar);
        clickear(habitaciones);
        for (int i = 1; i <edad_menores_habitacion1.length; i++) {
            driver.findElement(By.xpath("//label[.='Menores']/../../..//*[@class='steppers-icon-right sbox-3-icon-plus']")).click();
            driver.findElement(By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[" + i + "]//select")).click();
            driver.findElement(By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[" + i + "]//select/option[.='"+edad_menores_habitacion1[i-1]+"']")).click();
        }
        //otra habitacion
        driver.findElement(otraHabitacion).click();

        for (int i = 1; i <edad_menores_habitacion2.length; i++) {
            driver.findElement(By.xpath("//div[@class='_pnlpk-panel-scroll']/div[2]/div[2]//label[.='Menores']/../../..//*[@class='steppers-icon-right sbox-3-icon-plus']")).click();
            driver.findElement(By.xpath("//div[@class='_pnlpk-panel-scroll']/div[2]/div[2]//*[@class='_pnlpk-minors-age-select-wrapper']/div[" + i + "]//select")).click();
            driver.findElement(By.xpath("//div[@class='_pnlpk-panel-scroll']/div[2]/div[2]//*[@class='_pnlpk-minors-age-select-wrapper']/div[" + i + "]//select/option[.='"+edad_menores_habitacion2[i-1]+"']")).click();
        }

        clickear(aplicarHabitacion);
        clickear(buscador);

    }

    public void  resulEsperados(){

        Assert.assertTrue(urlResultados.startsWith(urlEsperada));

    }

}
