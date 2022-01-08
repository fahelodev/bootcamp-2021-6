package pom.Grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Grupo4.base.SeleniumBase;

public class VFTrasladosResultadoPage extends SeleniumBase {
    public VFTrasladosResultadoPage(WebDriver driver) {super(driver);}
    //atributos de la pagina -> Localizadores
    By mensajeError = By.xpath("//p[contains(text(),'Sentimos')]");
    By btnComprar = By.xpath("//div[contains(@class, 'xxlg')]//em[contains(text(), 'Comprar')]");

    //metodos de la pagina - Keyword Driven

    //obtener texto del mensaje de error
    public String obtenerTextoError(){return obtenerTexto(mensajeError);}

    //presionar el boton comprar del primer resultado
    public void comprarPrimerResultado(){clickear(btnComprar);}

}
