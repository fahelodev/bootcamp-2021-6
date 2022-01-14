package pom.Grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Grupo4.base.SeleniumBase;

import java.util.List;

public class VFCheckoutPage extends SeleniumBase {
    public VFCheckoutPage(WebDriver driver) {super(driver);}
    //atributos de la pagina -> Localizadores
    By btnTransferenciaBancaria = By.xpath("//span[text()='Transferencia Bancaria']");
    By txtTransferenciaBancaria = By.xpath("//em[contains(text(),'Transfe')]");
    By txtCuponIncorrecto = By.xpath("//h5[contains(text(),'El email')]");
    By btnCupon = By.xpath("//div[contains(@class,'medium')]//a[contains(@class, 'coupon-title')]");
    By email = By.xpath("//input[@id='coupon-email']");
    By codigoCupon = By.xpath("//input[@id='coupon-code']");
    By btnValidar = By.xpath("//em[contains(text(),'Validar')]");
    By precioFinal = By.xpath("//div[@class='pricebox-content-wrap']//div[@id='chk-total-price']//div[contains(@class,'money-align')]//span[@class='amount']");
    By seccionMediosDePago = By.xpath("//payment-method-selector");
    By tarjetaDeCredito = By.xpath("//label[@for='payment-method-0']");
    By btnFormasDePago = By.xpath("//em[contains(text(),'Promociones y formas de pago')]");
    By tarjetas = By.xpath("//div[contains(@class,'card-logo-container')]");


    //metodos de la pagina - Keyword Driven

    //presionamos en 'Transferencia Bancaria'
    public void presionarTransferenciaBancaria(){clickear(btnTransferenciaBancaria);}

    //obtener texto de la seccion de datos de Transferencia Bancaria
    public String obtenerTextoTransferenciaBancaria(){return obtenerTexto(txtTransferenciaBancaria);}

    //obtener texto de email o codigo cupon incorrecto
    public String obtenerTextoCuponInvalido(){return obtenerTexto(txtCuponIncorrecto);}

    //presionamos en 'Cupon', ingresamos un email y un cupon invalido y luego
    //presionamos en validar
    public void ingresarDatosCupon(){
        esperarElementoClickeable(15, btnCupon);
        clickear(btnCupon);
        enviarTexto(email, "jose@email.com");
        enviarTexto(codigoCupon, "123123");
        clickear(btnValidar);
    }

    public int obtenerPrecioFinal(){
        esperarElementoVisible(15, precioFinal);
        String precioFinalPaquete = obtenerTexto(precioFinal);
        String precioString = precioFinalPaquete.replaceAll("\\p{Punct}", "");
        int precioPaqueteFinal = Integer.parseInt(precioString);
        return precioPaqueteFinal;

    }

    public void seleccionarTarjetaDeCredito() {
        esperarElementoVisible( 10,seccionMediosDePago);
        clickear(tarjetaDeCredito);
    }

    public void clickearFormasDePago() {
        clickear(btnFormasDePago);
    }

    public boolean numeroDeTarjetasSuperiorA(int numero) {
        List<WebElement> resultados = encontrarElementosWeb(tarjetas);
        return resultados.size() > numero;
    }
}
