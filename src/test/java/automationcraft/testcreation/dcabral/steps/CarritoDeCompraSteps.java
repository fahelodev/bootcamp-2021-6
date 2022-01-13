package automationcraft.testcreation.dcabral.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.dcabral.pages.CarritoDeCompraPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoDeCompraSteps {

    CarritoDeCompraPages carritoDeCompraPages = new CarritoDeCompraPages(DriverFactory.getDriver());

    @Given("que estoy en la url {string}")
    public void que_estoy_en_la_url(String string) throws Exception {
        carritoDeCompraPages.validacionUrl(string);
    }

    @When("presiono el boton añadir al carro")
    public void presiono_el_boton_añadir_al_carro() throws InterruptedException {
        carritoDeCompraPages.presionarAnadirAlCarro();
    }

    @When("presiono el boton Continuar")
    public void presiono_el_boton_continuar() throws InterruptedException {
        carritoDeCompraPages.presionarContinuar();
    }

    @When("presiono ir al carro")
    public void presiono_ir_al_carro() throws InterruptedException {
        carritoDeCompraPages.presionarIrAlCarro();
    }

    @Then("se debe agregar correctamente el producto al carrito y ver el carrito de compra en pantalla")
    public void se_debe_agregar_correctamente_el_producto_al_carrito_y_ver_el_carrito_de_compra_en_pantalla() {
        carritoDeCompraPages.validacionCompraEnPantalla();

    }

    @Given("que el cliente está en el carrito con varios productos a comprar")
    public void que_el_cliente_está_en_el_carrito_con_varios_productos_a_comprar() {
        carritoDeCompraPages.validacionCompraEnPantalla();
    }

    @When("el cliente introduce un número de cupón inválido y hace clic en el botón {string}")
    public void el_cliente_introduce_un_número_de_cupón_inválido_y_hace_clic_en_el_botón(String string) throws InterruptedException {
        carritoDeCompraPages.ingresarCodigoCupon();
    }

    @Then("se muestra un mensaje de error cerca del campo que dice {string}")
    public void se_muestra_un_mensaje_de_error_cerca_del_campo_que_dice(String string) throws InterruptedException {
        carritoDeCompraPages.validarMensajeCuponInvalido();
    }

}


