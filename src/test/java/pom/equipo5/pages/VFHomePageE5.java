package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo5.base.SeleniumBaseE5;
import pom.mentoria.base.SeleniumBase;

public class VFHomePageE5 extends SeleniumBaseE5 {

        private String URL = "https://www.viajesfalabella.cl/";

        public VFHomePageE5(WebDriver driver) {
            super(driver);
        }
     //metodos de la pagina - Keyword Driven
        public void abrirHome(){
            obtenerUrl(URL);
            }
        }
