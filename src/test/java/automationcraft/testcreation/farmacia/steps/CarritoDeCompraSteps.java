package automationcraft.testcreation.farmacia.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.farmacia.pages.CarritoDeCompraPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoDeCompraSteps {

    CarritoDeCompraPages carritoDeCompraPages = new CarritoDeCompraPages(DriverFactory.getDriver());

    @Given("que estoy en la url {string}")
    public void que_estoy_en_la_url(String string) throws Exception {
        carritoDeCompraPages.validacionUrl(string);
    }
    @When("presiono el boton guardar")
    public void presiono_el_boton_guardar() throws Exception {
        carritoDeCompraPages.guardarProducto();
    }

    @Then("se debe agregar correctamente el producto al carrito")
    public void se_debe_agregar_correctamente_el_producto_al_carrito() throws Exception {
        carritoDeCompraPages.validarCargaEnCarrito();
    }

    @Then("ver el carrito de compra en pantalla")
    public void ver_el_carrito_de_compra_en_pantalla() throws InterruptedException {
        carritoDeCompraPages.validarDespliegueCarritoCompraWeb();
    }
}