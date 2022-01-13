package automationcraft.testcreation.apple.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.apple.pages.CarritoDeCompraApplePages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoDeCompraAppleSteps {

    CarritoDeCompraApplePages carritoDeCompraPages = new CarritoDeCompraApplePages(DriverFactory.getDriver());

    @Given("que estoy en la url {string}")
    public void que_estoy_en_la_url(String string) throws Exception {
        carritoDeCompraPages.validacionUrl(string);
    }
    @Then("se debe agregar correctamente el producto al carrito")
    public void se_debe_agregar_correctamente_el_producto_al_carrito() throws Exception {
        carritoDeCompraPages.guardarProducto();
        carritoDeCompraPages.Cerrar();
    }

    @When("Cuando el cliente aumenta la cantidad a pedir del producto haciendo click en el botón \"+\" del producto a un número mayor de [limite stock]")
    public void Cuando_el_cliente_aumenta_la_cantidad_a_pedir_del_producto_haciendo_click() throws InterruptedException {
        carritoDeCompraPages.clickEnMas();
    }

    @Then("Entonces el botón \"+\" se deshabilita.")
    public void Entonces_el_boton() throws Exception {
        carritoDeCompraPages.validarBotonMas();
    }

}