package pom.Grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Grupo4.base.SeleniumBase;

public class VFTrasladosPage extends SeleniumBase {
    public VFTrasladosPage(WebDriver driver){super(driver);}
    //atributos de la pagina -> Localizadores
    By rbtnDesdeAeropuerto = By.xpath("//span[contains(text(),'Desde el aeropuerto')]");
    By inpIngresaAeropuerto  = By.xpath("//input[@placeholder='Ingresa un aeropuerto']");
    By inpIngresaHotel = By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']");
    By sugerenciasDeBusqueda = By.xpath("//ul[@class='ac-group-items']");
    By btnFecha = By.xpath("//input[@placeholder='Arribo']");
    By sltHoras = By.xpath("//select[@class='select-tag sbox-time-arrival']");
    By btnPasajeros = By.xpath("//div[@class='sbox-row sbox-distribution-picker-wrapper-ui']");
    By btnAgregarAdulto = By.xpath("//div[contains(@class, 'stepper-adults')]//a[contains(@class, 'icon-plus')]");
    By btnAgregarMenor = By.xpath("//div[contains(@class, 'stepper-minors')]//a[contains(@class, 'icon-plus')]");
    By sltEdadMenor = By.xpath("//div[contains(@class, 'select-minor-age')]//select");
    By btnAplicarPasajeros = By.xpath("//a[contains(text(),'Aplicar')]");
    By btnBuscar = By.xpath("//em[contains(text(),'Buscar')]");

    //metodos de la pagina - Keyword Driven

    //Seleccionar la opcion 'Desde el aeropuerto'
    public void seleccionarDesdeAeropuerto(){clickear(rbtnDesdeAeropuerto);}

    //Ingresamos un aeropuerto en 'DESDE'
    public void ingresarAeropuerto(String aeropuerto){
        enviarTexto(inpIngresaAeropuerto, aeropuerto);
        esperarElementoVisible(15, sugerenciasDeBusqueda);
        enviarEnter(inpIngresaAeropuerto);
    }

    //Ingresamos un Hotel en 'HASTA'
    public void ingresarHotel(String hotel){
        enviarTexto(inpIngresaHotel, hotel);
        esperarElementoVisible(15, sugerenciasDeBusqueda);
        enviarEnter(inpIngresaHotel);
    }

    //Seleccionamos una fecha
    public void seleccionarFecha(String dia, String anioMes){
        clickear(btnFecha);
        By fechaArribo = By.xpath("//div[contains(@class, 'datepicker-transfers sbox')]//div[contains(@data-month, '"+anioMes+"')]//span[contains(@class, '_dpmg2--date-number')][text()='"+dia+"']");
        esperarElementoClickeable(15, fechaArribo);
        clickear(fechaArribo);
    }

    //Seleccionamos una hora
    public void seleccionarHora(String hora){crearSelect(sltHoras).selectByVisibleText(hora);}

    //Modificamos los pasajeros (agregamos un adulto, un menor,
    // la edad del menor y presionamos en aplicar)
    public void modificarPasajeros(int edadMenor){
        clickear(btnPasajeros);
        esperarElementoVisible(15, btnAgregarAdulto);
        clickear(btnAgregarAdulto);
        clickear(btnAgregarMenor);
        crearSelect(sltEdadMenor).selectByIndex(edadMenor+1);
        clickear(btnAplicarPasajeros);
    }

    //Presionamos en Buscar
    public void presionarBuscar(){clickear(btnBuscar);}

}
