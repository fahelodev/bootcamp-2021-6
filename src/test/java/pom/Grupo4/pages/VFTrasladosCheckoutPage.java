package pom.Grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Grupo4.base.SeleniumBase;

public class VFTrasladosCheckoutPage extends SeleniumBase {
    public VFTrasladosCheckoutPage(WebDriver driver) {super(driver);}
    //atributos de la pagina -> Localizadores
    By btnTransferenciaBancaria = By.xpath("//span[text()='Transferencia Bancaria']");
    By txtTransferenciaBancaria = By.xpath("//em[contains(text(),'Transfe')]");
    By txtCuponIncorrecto = By.xpath("//h5[contains(text(),'El email')]");
    By btnCupon = By.xpath("//div[contains(@class,'medium')]//a[contains(@class, 'coupon-title')]");
    By email = By.xpath("//input[@id='coupon-email']");
    By codigoCupon = By.xpath("//input[@id='coupon-code']");
    By btnValidar = By.xpath("//em[contains(text(),'Validar')]");

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
        clickear(btnCupon);
        enviarTexto(email, "jose@email.com");
        enviarTexto(codigoCupon, "123123");
        clickear(btnValidar);
    }
}
