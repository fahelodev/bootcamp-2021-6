package automationcraft.testcreation.rsobarzo.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.rsobarzo.pages.CarritoParisPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoParisSteps {

    CarritoParisPages carritoParisPages = new CarritoParisPages(DriverFactory.getDriver());

    @Given("que estoy en la url {string}")
    public void que_estoy_en_la_url(String string) throws Exception {
        carritoParisPages.validacionUrl(string);
    }
    @When("presiono el boton guardar")
    public void presiono_el_boton_guardar() throws Exception {
        carritoParisPages.guardarProducto();
    }

    @Then("se debe agregar correctamente el producto al carrito")
    public void se_debe_agregar_correctamente_el_producto_al_carrito() throws Exception {
        carritoParisPages.validarCargaEnCarrito();
    }

    @Then("ver el carrito de compra en pantalla")
    public void ver_el_carrito_de_compra_en_pantalla() throws InterruptedException {
        carritoParisPages.validarDespliegueCarritoCompraWeb();
    }

    @When("el cliente aumenta la cantidad a pedir del producto a un número mayor de {int}")
    public void el_cliente_aumenta_la_cantidad_a_pedir_del_producto_a_un_número_mayor_de(Integer int1) {
        carritoParisPages.cargar20veces();

    }

}
