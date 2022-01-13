package automationcraft.testcreation.mvargas.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.mvargas.pages.CarritoCompraParisPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoCompraParisSteps {

    CarritoCompraParisPages carritoCompraParisPages = new CarritoCompraParisPages(DriverFactory.getDriver());

    @Given("que entro en la url {string}")
    public void que_entro_en_la_url(String string) throws Exception {
        carritoCompraParisPages.validacionUrl(string);
    }


    @Then("se debe agregar correctamente el producto al carro")
    public void se_debe_agregar_correctamente_el_producto_al_carro() throws Exception {
        carritoCompraParisPages.validarCargaEnCarro();
    }

    @Then("ver el carro de compra en pantalla")
    public void ver_el_carro_de_compra_en_pantalla() throws InterruptedException {
        carritoCompraParisPages.validarDespliegueCarroCompraWeb();
    }

    @Given("el cliente está el en carro de compras con {int} producto {string}")
    public void elClienteEstáElEnCarroDeComprasConProducto(int arg0, String arg1) {

    }

    @When("presiono el boton Añadir al carro")
    public void presionoElBotonAñadirAlCarro() {
    }
}