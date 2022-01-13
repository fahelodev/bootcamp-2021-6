package pom.Grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Grupo4.base.SeleniumBase;

import java.util.List;

public class VFAlojamientosResultadoBusquedaPage extends SeleniumBase {

    private String URL = "https://www.viajesfalabella.cl/accommodations/results/";
    public VFAlojamientosResultadoBusquedaPage(WebDriver driver){super(driver);}

    //atributos de la pagina -> Localizadores
    By contenedorResultados = By.cssSelector(".cluster-content");
    By nombresCiudadesResultados = By.cssSelector("aloha-location-name span");
    By btnVerDetalle = By.xpath("//aloha-button//em[contains(text(),'Ver detalle')]");

    public boolean validarCiudadResultados(String ciudad) {
        List<WebElement> resultados = encontrarElementosWeb(nombresCiudadesResultados);

        boolean allInCity = true;

        for (int i = 0; i < resultados.size(); i++) {
            if (!(obtenerTexto(resultados.get(i)).contains(ciudad))) {
                allInCity = false;
                break;
            }
        }

        return allInCity;
    }

    public void clickearPrimerResultado() {
        esperarElementoClickeable(15, btnVerDetalle);
        clickear(btnVerDetalle);
    }
}