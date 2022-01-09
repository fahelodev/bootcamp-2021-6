package pom.Grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Grupo4.base.SeleniumBase;

import java.util.List;

public class VFAlojamientosPage extends SeleniumBase {

    private String URL = "https://www.viajesfalabella.cl/hoteles/";
    public VFAlojamientosPage(WebDriver driver){super(driver);}

    //atributos de la pagina -> Localizadores
    By inpCiudadDestino = By.xpath("//input[contains(@class,'sbox-destination')]");
    By sugerenciasDeBusqueda = By.xpath("//ul[@class='ac-group-items']");
    By inpfechas = By.xpath("//input[contains(@class,'sbox-checkin-date')]");
    By inpHabitaciones = By.xpath("//div[contains(@class,'sbox-distribution ')]");
    By btnAgregarHabitacion = By.xpath("//div[contains(@class,'_pnlpk-panel--popup')]//a[contains(text(),'Añadir habitación')]");
    By btnAgregarAdulto = By.xpath("//div[contains(@class,'_pnlpk-panel--popup')]//a[contains(@class,'sbox-3-icon-plus')]");
    By btnAplicarHabitaciones = By.xpath("//a[contains(@class, '_pnlpk-apply-button')]");
    By btnBuscar = By.xpath("//em[contains(text(),'Buscar')]");

    public void clickearPrimeraOfertaSeccion(String tituloSeccion) {
        By Ofertas = By.xpath("//div[@class='offer-module-container' and contains(., '"+tituloSeccion+"')]//div[contains(@class,'offer-card-title')]");
        // selecciona solo la primera
        WebElement primeraOferta = encontrarElementoWeb(Ofertas);
        primeraOferta.click();
    }

    public String nombrePrimeraOfertaSeccion(String tituloSeccion) {
        By Ofertas = By.xpath("//div[@class='offer-module-container' and contains(., '"+tituloSeccion+"')]//div[contains(@class,'offer-card-title')]");
        // selecciona solo la primera
        String nombrePrimeraOferta = obtenerTexto(Ofertas);
        return nombrePrimeraOferta;
    }

    public void ingresarCiudadDestino(String ciudad) {
        enviarTexto(inpCiudadDestino, ciudad);
        esperarElementoVisible(15, sugerenciasDeBusqueda);
        enviarEnter(inpCiudadDestino);
    }

    //Seleccionar fechaIdaYVuelta
    public void seleccionarFechaIdaYVuelta(String diaIda, String diaVuelta, String anioMes) {
        clickear(inpfechas);
        By fechaIda = By.xpath("//div[contains(@class, 'o _dpmg2--show')]//div[@data-month='"+anioMes+"']//span[contains(@class, 'number')][text()='"+diaIda+"']");
        clickear(fechaIda);
        By fechaVuelta = By.xpath("//div[contains(@class, 'o _dpmg2--show')]//div[@data-month='"+anioMes+"']//span[contains(@class, 'number')][text()='"+diaVuelta+"']");

        esperarElementoClickeable(10,fechaVuelta);

        clickear(fechaVuelta);
        By btnAplicarFecha = By.xpath("//div[contains(@class, 'info _dpmg2--show')]//em[contains(@class, 'apply-text btn-text')]");
        clickear(btnAplicarFecha);
    }

    public void agregarHabitacionYAdulto() {
        clickear(inpHabitaciones);

        esperarElementoClickeable(10,btnAgregarHabitacion);
        clickear(btnAgregarHabitacion);

        clickear(btnAgregarAdulto);
        clickear(btnAplicarHabitaciones);
    }

    public void presionarBuscar(){clickear(btnBuscar);}
}
