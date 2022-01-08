package pom.equipo2.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pom.equipo2.base.CucumberTestBase;
import pom.equipo2.pages.HomePageTraslados;

public class TrasladosDolarSteps{

    protected HomePageTraslados pageTraslados;

    @Given("I am on the modules Traslados page Viajes Falabella")
    public void i_am_on_the_modules_traslados_page_viajes_falabella() {
        pageTraslados = new HomePageTraslados(CucumberTestBase.getDriver());
        pageTraslados.irAPageTraslados();
    }

    @When("I click in card traslado auto")
    public void i_click_in_card_traslado_auto() {
        pageTraslados = new HomePageTraslados(CucumberTestBase.getDriver());
        pageTraslados.btnClickCardAutoTraslado();

    }
    @When("I change option of moneda of peso to dolar")
    public void i_change_option_of_moneda_of_peso_to_dolar() {
        pageTraslados = new HomePageTraslados(CucumberTestBase.getDriver());
        pageTraslados.dropDownChangeDolar();
    }

    @Then("the text moneda change")
    public void the_text_moneda_change() {
        pageTraslados = new HomePageTraslados(CucumberTestBase.getDriver());
        Assert.assertEquals("US$",pageTraslados.validaTextUsd());

    }


}
