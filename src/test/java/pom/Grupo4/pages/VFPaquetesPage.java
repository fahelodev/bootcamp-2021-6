package pom.Grupo4.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Grupo4.base.SeleniumBase;

public class VFPaquetesPage extends SeleniumBase {
    public VFPaquetesPage(WebDriver driver) {
        super(driver);
    }

    //atributos de la pagina -> Localizadores
    By containerSugerenciasSudamerica = By.id("MultiproductOffersModule_6385");
    By primeraSugerenciaSudamerica = By.xpath("//div[contains(text(),'Rio de Janeiro')]");
    By sugerenciasSudamerica = By.cssSelector("div.offer-card-title.small-title");
    By sugerenciasOrigenDestino = By.xpath("//ul[@class='ac-group-items']");
    By popupVentanaEmergenteFecha = By.cssSelector("a.date-box");
    By btnFechas = By.xpath("//input[@placeholder='Ida']");
    By inpOrigen = By.xpath("//input[contains(@class, 'input-tag sbox-main-focus sbox-o')]");
    By inpDestino = By.xpath("//input[contains(@class, 'input-tag sbox-main-focus sbox-d')]");
    By btnHabitaciones = By.xpath("//div[contains(@class,'sbox-distri-input-container')]");
    By inpAniadirHabitacion = By.xpath("//a[contains(@class,'_pnlpk-add-room-button')]");
    By btnSumarAdulto = By.xpath("(//a[contains(@class,'steppers-icon-right')])[3]");
    By btnAplicarHabitaciones = By.xpath("(//a[contains(@class,'_pnlpk-apply-button')])[2]");
    By btnBuscar = By.xpath("//div[@class='sbox-button-container']");


    //metodos de la pagina - Keyword Driven
    //Seleccionar primera sugerencia sudamerica
    public void clickPaqueteSugerido(){
        clickear(primeraSugerenciaSudamerica);
    }

    //Obtener lugar sugerencia
    public String obtenerSugerencia(){
        WebElement containerPaquetesSudamerica = encontrarElementoWeb(containerSugerenciasSudamerica);
        WebElement sugerenciaSudamerica = encontrarElementoWeb(containerPaquetesSudamerica,sugerenciasSudamerica);
        String paquete = obtenerTexto(sugerenciaSudamerica);
        String [] palabras = paquete.split(" ");
        String lugar = palabras[palabras.length-1];
        return lugar;
    }

    //Seleccionar ventana emergente
    public void seleccionarVentanaEmergenta (){
        clickear(popupVentanaEmergenteFecha);
    }

    //Cambio de pestaña
    public void cambioDePestaña(){ changeTab(15); }

    //Seleccionar Origen
    public void seleccionarOrigen(String origen) {
        enviarTexto(inpOrigen, origen);
        esperarElementoVisible(15, sugerenciasOrigenDestino);
        enviarEnter(inpOrigen);
    }

    //Seleccionar Destino
    public void seleccionarDestino(String destino){
        enviarTexto(inpDestino,destino);
        esperarElementoVisible(15, sugerenciasOrigenDestino);
        enviarEnter(inpDestino);
    }

    //Seleccionar fechaIdaYVuelta
    public void seleccionarFechaIdaYVuelta(String diaIda, String diaVuelta, String anioMes) {
        clickear(btnFechas);
        By fechaIda = By.xpath("//div[contains(@class, 'o _dpmg2--show')]//div[@data-month='"+anioMes+"']//span[contains(@class, 'number')][text()='"+diaIda+"']");
        clickear(fechaIda);
        By fechaVuelta = By.xpath("//div[contains(@class, 'o _dpmg2--show')]//div[@data-month='"+anioMes+"']//span[contains(@class, 'number')][text()='"+diaVuelta+"']");
        esperarElementoClickeable(15,fechaVuelta);
        clickear(fechaVuelta);
        By btnAplicarFecha = By.xpath("//div[contains(@class, 'info _dpmg2--show')]//em[contains(@class, 'apply-text btn-text')]");
        clickear(btnAplicarFecha);
    }

    public void modificarHabitaciones(){
        clickear(btnHabitaciones);
        clickear(inpAniadirHabitacion);
        clickear(btnSumarAdulto);
        clickear(btnAplicarHabitaciones);
    }

    //Click boton buscar
    public void clickBuscar(){
        clickear(btnBuscar);
    }
}
