package pom.equipo3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.equipo3.base.SeleniumBase;

public class act09HomePage extends SeleniumBase {

    public act09HomePage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver,30);
    private String URL = "https://www.viajesfalabella.cl/";

    String aeropuerto = "Aeropuerto Desierto de Atacama, Copiapo, Chile";
    String hotel = "Hampton by Hilton Antofagasta - Avenida Edmundo Pérez Zujovic, Antofagasta, Chile";
    String horaArribo = "12:00";
    String[] edad_menores = {"10 años","9 años","12 años","9 años"};
    String fecha_regreso = "28";
    String hora_regreso = "16:00";

    By traslados = By.xpath("//label[.='Traslados']"); //boton
    By calendario = By.xpath("//*[@class='datepicker-transfers sbox-v4-components']");
    By desdeElAeropuerto = By.xpath("//*[@class='radio-circle sbox-radio-circle']");
    By inputAeropuerto = By.xpath("//*[@class='sbox-place-container -mb4-s']//input[@placeholder='Ingresa un aeropuerto']");
    By recomendaciones_aeropuerto = By.xpath("//ul[@class='ac-group-items']");
    By recomendaciones_hotel = By.xpath("//*[@class='ac-wrapper -desktop -facet -show']//ul");
    By pasajeros = By.xpath("//label[.='Pasajeros']/../*[@class='sbox-row sbox-distribution-picker-wrapper-ui']");
    By inputHotel = By.xpath("//*[@class='sbox-second-place-container']//span[@class='input-gradient']/..//input");
    By inputFecha = By.xpath("//*[@id=\"searchbox\"]//input[@placeholder='Arribo']");
    By spanDia = By.xpath("//*[@class='datepicker-transfers sbox-v4-components']//*[@data-month='2022-01']//span[.='25']");
    By buscar = By.xpath("//em[@class='btn-text']");
    By sumar_menores = By.xpath("//label[.='Menores']/../../..//*[@class='steppers-icon-right sbox-3-icon-plus']");
    By aplicar_pasajeros = By.xpath("//*[@class='_pnlpk-panel__footer -medium-down-to-lg']//a");
    By opciones_pasajeros = By.xpath("//*[@class='_pnlpk-panel-scroll']");
    By quiero_agregar_regreso = By.xpath("//label[.='Quiero agregar el regreso']");
    By input_regreso = By.xpath("//*[@class='sbox-row']//input[@class='input-tag sbox-checkout']");
    By spanDia_regreso = By.xpath("//*[@class='datepicker-transfers sbox-v4-components']//span[.='" + fecha_regreso + "']");
    By selec_hora = By.xpath("//span[.='hora']/..//*[@class='select-tag sbox-time-arrival']");
    By selec_hora_regreso = By.xpath("//*[@class='select-tag sbox-time-departure']");




    public void act09_TrasladoConRegreso(){


        obtenerUrl(URL);
        clickear(traslados);
        clickear(desdeElAeropuerto);

        //Aeropuerto
        type("Aeropuerto Desierto de Atacama, Copiapo, Chile",inputAeropuerto);
        wait.until(ExpectedConditions.visibilityOfElementLocated(recomendaciones_aeropuerto));
        presionarTecla(inputAeropuerto);

        //Hotel
        type("Hampton by Hilton Antofagasta - Avenida Edmundo Pérez Zujovic, Antofagasta, Chile",inputHotel);
        wait.until(ExpectedConditions.visibilityOfElementLocated(recomendaciones_hotel));
        presionarTecla(inputHotel);

        //Dia
        clickear(inputFecha);
        wait.until(ExpectedConditions.visibilityOfElementLocated(calendario));
        clickear(spanDia);

        //Hora
        select_dia_hora(selec_hora,horaArribo);

        //pasajeros
        clickear(pasajeros);
        wait.until(ExpectedConditions.visibilityOfElementLocated(opciones_pasajeros));

        //edad menores

        for (int i = 1; i <edad_menores.length; i++) {
            clickear(sumar_menores);
            clickear(By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[" + i + "]//select"));
            clickear(By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[" + i + "]//select/option[.='"+edad_menores[i-1]+"']"));
        }

        //aplicar
        clickear(aplicar_pasajeros);

        //agregar regreso
        clickear(quiero_agregar_regreso);

        //Hora regreso
        select_dia_hora(selec_hora_regreso,hora_regreso);

        //Buscar
        clickear(buscar);

    }


    public void resultado_esperado(){
        //Devuelve resultados según disponibilidad.
        String urlEsperada = "https://www.viajesfalabella.cl/transfers/search/";
        String urlResultados = driver.getCurrentUrl();

        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains(urlEsperada));

        Assert.assertTrue(urlResultados.startsWith(urlEsperada));
    }








}
