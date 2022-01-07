package pom.mentoria.equipo3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.mentoria.equipo3.base.SeleniumBase;

public class act02HomePage extends SeleniumBase {

    WebDriverWait wait = new WebDriverWait(driver,30);
    private String URL = "https://www.viajesfalabella.cl/";

    String urlEsperada = "https://www.viajesfalabella.cl/accommodations/results/";
    String urlResultados = driver.getCurrentUrl();
    String diaInicio = "18";
    String diaRetorno = "26";

    By alojamientos = By.xpath("//label[.='Alojamientos']");
    By inputDestino = By.xpath("//label[.='Destino']/../input");
    By buscador = By.xpath("//em[.='Buscar']");
    By fecha = By.xpath("//input[@placeholder='Entrada']");
    By fechaInicio = By.xpath("//*[@data-month=\"2022-02\"]//span[.='" + diaInicio + "']");
    By FechaFin = By.xpath("//*[@data-month=\"2022-02\"]//span[.='" + diaRetorno + "']");
    By aplicar = By.xpath("//em[.='Aplicar']");
    By desplegableCiudades = By.xpath("//i[@class='suggester-icon-xsm suggester-icon-city']");
    By iconoSumar = By.xpath("//label[.='Menores']/../../..//a[@class='steppers-icon-right sbox-3-icon-plus']");
    By habitaciones = By.xpath("//div[@class='sbox-passengers-container']/../..");
    By sumarMenor = By.xpath("//select");
    By edadMenor = By.xpath("//select/option[5]");
    By aplicarHabitacion = By.xpath("//a[.='Aplicar']");


    public act02HomePage(WebDriver driver) {
        super(driver);
    }

    public void act02_Alojamiento(){
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
        clickear(iconoSumar);
        clickear(sumarMenor);
        clickear(edadMenor);
        clickear(aplicarHabitacion);
        clickear(buscador);

    }

    public void  resulEsperados(){

        Assert.assertTrue(urlResultados.startsWith(urlEsperada));

    }
}
