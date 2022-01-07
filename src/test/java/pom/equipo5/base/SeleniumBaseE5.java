package pom.equipo5.base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumBaseE5 {

        //Atributos
        WebDriver driver;

        public SeleniumBaseE5(WebDriver driver) {
            this.driver = driver;
        }

        //Metodos Wrapper - Envoltorios

        //retorno ->  en su declaracion debe indicar que Objeto retorna
        public WebElement encontrarElementoWeb(By localizador){
            return driver.findElement(localizador);

        }

        public List<WebElement> encontrarElementosWeb(By localizador){
            return driver.findElements(localizador);
        }

        //accion -> void
        public void obtenerUrl(String URL){
            driver.get(URL);
        }
        //accion -> void
        public void clickear(By localizador){
            encontrarElementoWeb(localizador).click();
        }


        public void select(By localizador){

            Select lista = new Select(driver.findElement(localizador));

        }

        public void teclear(By localizador, String text){
            driver.findElement(localizador).sendKeys(text);
        }

        public void validacionText(By localizador, String text){
            Assert.assertEquals(text, driver.findElement(localizador).getText());
        }

    }

