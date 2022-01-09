package pom.Grupo4.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.Grupo4.base.SeleniumBase;

public class VFPaquetesResultadosPage extends SeleniumBase {
    public VFPaquetesResultadosPage(WebDriver driver) {
        super(driver);
    }

    //Selectores
    By resultado = By.xpath("(//span[@class='-eva-3-tc-gray-2' and contains(text(),'Rio de Janeiro')])[1]");

    //Comportamientos
    public void validacionSugerencia (String region){
        String resultados = obtenerTexto(resultado);
        Assert.assertTrue(resultados.contains(region));
    }
}
