package pom.Grupo4.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.Grupo4.base.SeleniumBase;

public class VFPaquetesPage extends SeleniumBase {
    public VFPaquetesPage(WebDriver driver) {
        super(driver);
    }

    //atributos de la pagina -> Localizadores
    By containerSugerenciasSudamerica = By.id("MultiproductOffersModule_6385");
    By primeraSugerenciaSudamerica = By.xpath("//div[contains(text(),'Rio de Janeiro')]");
    By sugerenciasSudamerica = By.cssSelector("div.offer-card-title.small-title");
    By btnfechas = By.xpath("//input[@placeholder='Ida']");
    By inpOrigen = By.xpath("//input[contains(@class, 'input-tag sbox-main-focus sbox-o')]");
    By inpDestino = By.xpath("//input[contains(@class, 'input-tag sbox-main-focus sbox-d')]");
    By sugerenciasOrigenDestino = By.xpath("//ul[@class='ac-group-items']");
    By popupVentanaEmergenteFecha = By.cssSelector("a.date-box");


    //metodos de la pagina - Keyword Driven
    //Seleccionar primera sugerencia sudamerica
    public void clickPaqueteSugerido(){
        clickear(primeraSugerenciaSudamerica);
    }

    //Seleccionar Origen
    public void seleccionarOrigen(String origen) {
        enviarTexto(inpOrigen, origen);
        esperarElementoVisible(10, sugerenciasOrigenDestino);
        enviarEnter(inpOrigen);
    }

    //Seleccionar Destino
    public void seleccionarDestino(String destino){
        enviarTexto(inpDestino,destino);
        esperarElementoVisible(10, sugerenciasOrigenDestino);
        enviarEnter(inpDestino);
    }

    //Seleccionar fechaIdaYVuelta
    public void seleccionarFechaIdaYVuelta(String diaIda, String diaVuelta, String anioMes) {
        clickear(btnfechas);
        By fechaIda = By.xpath("//div[contains(@class, 'o _dpmg2--show')]//div[@data-month='"+anioMes+"']//span[contains(@class, 'number')][text()='"+diaIda+"']");
        clickear(fechaIda);
        By fechaVuelta = By.xpath("//div[contains(@class, 'o _dpmg2--show')]//div[@data-month='"+anioMes+"']//span[contains(@class, 'number')][text()='"+diaVuelta+"']");
        esperarElementoClickeable(10,fechaVuelta);
        clickear(fechaVuelta);
        By btnAplicarFecha = By.xpath("//div[contains(@class, 'info _dpmg2--show')]//em[contains(@class, 'apply-text btn-text')]");
        clickear(btnAplicarFecha);
    }

    //Seleccionar ventana emergente
    public void seleccionarVentanaEmergenta (){
        clickear(popupVentanaEmergenteFecha);
    }

    //Obtener lugar sugerencia
    public String obtenerSugerencia(){
        WebElement containerPaquetesSudamerica = encontrarElementoWeb(containerSugerenciasSudamerica);
        String paquete = obtenerTexto(containerPaquetesSudamerica);
        String [] palabras = paquete.split(" ");
        String lugar = palabras[palabras.length-1];
        return lugar;
    }

    public void cambioDePestaña(){
        pestañaSiguiente();
    }
}
