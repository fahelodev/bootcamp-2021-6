package pom.mentoria.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.mentoria.base.CucumberTestBase;
import pom.mentoria.pages.GoogleHomePage;

public class SearchGoogleSteps {

    GoogleHomePage googleHomePage;

    @Given("estoy en un navegador con la pagina inicial de google")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_google() {
        googleHomePage = new GoogleHomePage(CucumberTestBase.getDriver());
        googleHomePage.irAHomeDeGoogle();
    }

    @When("introduzco la palabra {string} en la barra")
    public void introduzco_la_palabra_en_la_barra(String string) {
        googleHomePage.ingresarTextoABarraGoogle(string);
    }

    @And("realizo la busqueda con Enter")
    public void realizo_la_busqueda_con_enter() {
        googleHomePage.EnterABarraGoogle();
    }

    @Then("el navegador me muestra los resultados")
    public void el_navegador_me_muestra_los_resultados() throws InterruptedException {

        System.out.println("Ejecucuion OK");

    }

}
