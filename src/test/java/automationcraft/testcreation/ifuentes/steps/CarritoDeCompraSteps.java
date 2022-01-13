package automationcraft.testcreation.ifuentes.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.farmacia.pages.CarritoDeCompraPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoDeCompraSteps {

    CarritoDeCompraPages carritoDeCompraPages = new CarritoDeCompraPages(DriverFactory.getDriver());

    @Given("que estoy en la url {string}")
    public void que_estoy_en_la_url(String string) throws Exception {
        carritoDeCompraPages.validacionUrl(string);
    }
    @When("presiono anadir al carro")
    public void presiono_el_boton_guardar() throws Exception {
        carritoDeCompraPages.anadirCarro();
    }

    @When("se debe presionar en boton continuar")
    public void se_debe_presionar_en_boton_continuar() throws Exception {
        carritoDeCompraPages.Continauar();
    }


    @And("ir al carrito de compras")
    public void ir_al_carrito_de_compras() throws Exception {
        carritoDeCompraPages.irCarro();

    }

    @When("cliente aumenta la cantidad a pedir del producto ")
    public void cliente_aumenta_la_cantidad_a_pedir_del_producto ()throws Exception {
        carritoDeCompraPages.MasUnidades();

    }

    @Then("Entonces el botón \"+\" se deshabilita")
    public void el_botón_se_deshabilita() throws Exception {
        CarritoDeCompraPages.btnDeshabilita();

    }

}