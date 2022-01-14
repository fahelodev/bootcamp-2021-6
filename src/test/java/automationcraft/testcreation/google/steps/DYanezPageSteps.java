package automationcraft.testcreation.google.steps;


import automationcraft.testcreation.google.pages.DYanezPage;
import automationcraft.testcreation.google.pages.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class DYanezPageSteps {

    protected DYanezPage dYanezPage;

    @Given("I am on the modules Traslados page Viajes Falabella")
    public void i_am_on_the_modules_traslados_page_viajes_falabella() {
        dYanezPage = new DYanezPage(DriverFactory.getDriver());
        dYanezPage.irAPageTraslados();
    }

    @When("I click in card traslado auto")
    public void i_click_in_card_traslado_auto() {
        dYanezPage = new DYanezPage(DriverFactory.getDriver());
        dYanezPage.btnClickCardAutoTraslado();

    }
    @When("I change option of moneda of peso to dolar")
    public void i_change_option_of_moneda_of_peso_to_dolar() {
        dYanezPage = new DYanezPage(DriverFactory.getDriver());
        dYanezPage.dropDownChangeDolar();
    }

    @Then("the text moneda change")
    public void the_text_moneda_change() {
        dYanezPage = new DYanezPage(DriverFactory.getDriver());

        Assert.assertEquals("US$", dYanezPage.validaTextUsd());

    }

}
