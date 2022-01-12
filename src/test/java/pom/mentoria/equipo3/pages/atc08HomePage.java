package pom.mentoria.equipo3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.mentoria.equipo3.base.SeleniumBase;

public class atc08HomePage extends SeleniumBase {


    public atc08HomePage(WebDriver driver) {
        super(driver);
    }


    WebDriverWait wait = new WebDriverWait(driver,30);
    private String URL = "https://www.viajesfalabella.cl/";

    String aeropuerto = "Aeropuerto Desierto de Atacama, Copiapo, Chile";
    String hotel = "Hampton by Hilton Antofagasta - Avenida Edmundo Pérez Zujovic, Antofagasta, Chile";
    String diaArribo = "25";
    String horaArribo = "12:00";
    String edad_menor1 = "10 años";
    String edad_menor2 = "10 años";

    By traslados = By.xpath("//label[.='Traslados']"); //boton
    By calendario = By.xpath("//*[@class='datepicker-transfers sbox-v4-components']");
    By haciaElAeropuerto = By.xpath("//*[@class='sbox-radio-buttons']/span[2]");
    By inputAeropuerto = By.xpath("//*[@class='sbox-place-container -mb4-s']//input[@placeholder='Ingresa un aeropuerto']");
    By recomendaciones_aeropuerto = By.xpath("//ul[@class='ac-group-items']");
    By recomendaciones_hotel = By.xpath("//*[@class='ac-wrapper -desktop -facet -show']//ul");
    By pasajeros = By.xpath("//label[.='Pasajeros']/../*[@class='sbox-row sbox-distribution-picker-wrapper-ui']");
    By inputHotel = By.xpath("//*[@class='sbox-second-place-container']//span[@class='input-gradient']/..//input");
    By inputFecha = By.xpath("//*[@id=\"searchbox\"]//input[@placeholder='Partida']");
    By spanDia = By.xpath("//*[@data-month='2022-01']//span[.='" + diaArribo + "']");
    By buscar = By.xpath("//em[@class='btn-text']");
    By sumar_menores = By.xpath("//label[.='Menores']/../../..//a[@class='steppers-icon-right sbox-3-icon-plus']");
    By aplicar_pasajeros = By.xpath("//*[@class='_pnlpk-panel__footer -medium-down-to-lg']//a");
    By opciones_pasajeros = By.xpath("//*[@class='_pnlpk-panel-scroll']");
    By span_hora = By.xpath("//*[@class='select-tag sbox-time-departure']");
    By select_edad_menor1 = By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[1]//select");
    By select_edad_menor2 = By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[2]//select");


    public void atc08TrasladosFamiliaHaciaAero(){


        obtenerUrl(URL);
        clickear(traslados);
        clickear(haciaElAeropuerto);

        //Hotel
        type("Hampton by Hilton Antofagasta - Avenida Edmundo Pérez Zujovic, Antofagasta, Chile",inputHotel);
        wait.until(ExpectedConditions.visibilityOfElementLocated(recomendaciones_hotel));
        presionarTecla(inputHotel);

        //Aeropuerto
        type("Aeropuerto Desierto de Atacama, Copiapo, Chile",inputAeropuerto);
        wait.until(ExpectedConditions.visibilityOfElementLocated(recomendaciones_aeropuerto));
        presionarTecla(inputAeropuerto);

        //Fecha y Hora
        clickear(inputFecha);
        wait.until(ExpectedConditions.elementToBeClickable(calendario));
        clickear(spanDia);
        select_dia_hora(span_hora, horaArribo);

        //Sumar menores
        clickear(pasajeros);
        wait.until(ExpectedConditions.visibilityOfElementLocated(opciones_pasajeros));
        for(int i=0; i<2; i++) clickear(sumar_menores);
        clickear(aplicar_pasajeros);

        //seleccionar edad menores
        select_edad_menores(select_edad_menor1,edad_menor1);
        select_edad_menores(select_edad_menor2,edad_menor2);

        clickear(aplicar_pasajeros);
        clickear(buscar);

    }

    public void resultado_esperado(){
        String urlEsperada = "https://www.viajesfalabella.cl/transfers/search/";
        String urlResultados = driver.getCurrentUrl();

        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains(urlEsperada));

        Assert.assertTrue(urlResultados.startsWith(urlEsperada));
    }








}
