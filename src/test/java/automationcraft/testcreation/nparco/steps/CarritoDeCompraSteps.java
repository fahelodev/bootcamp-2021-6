package automationcraft.testcreation.nparco.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.nparco.pages.CarritoDeCompraPages;
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

    @When("presiono el boton añadir al carro")
    public void presiono_el_boton_añadir_al_carro() throws Exception {
        carritoDeCompraPages.Anadir();
    }

    @Then("presiono el boton ir al carro")
    public void presiono_el_boton1() throws Exception {
        carritoDeCompraPages.irAlCarro();
    }

    @When("el cliente aumenta la cantidad a pedir del producto haciendo click en el botón del producto a un número mayor de {int}")
    public void elClienteAumentaLaCantidadAPedirDelProductoHaciendoClickEnElBotónDelProductoAUnNúmeroMayorDe(int arg1) throws InterruptedException {
        carritoDeCompraPages.aumentarCantidad(arg1);
    }


    @When("el botón {string} se deshabilita")
    public void el_botón_se_deshabilita(String string) {

    }

    @Given("que el cliente está el en carrito de compras con al menos {int} producto SIN Garantía Extendida")
    public void que_el_cliente_está_el_en_carrito_de_compras_con_al_menos_producto_sin_garantía_extendida(Integer int1) {

    }

    @Then("el cliente agrega la garantia de daño accidental")
    public void el_cliente_agrega_la_garantia_de_daño_accidental() {

    }

    @Then("el total a pagar incluye el monto a pagar del producto + el valor de la garantía del producto")
    public void el_total_a_pagar_incluye_el_monto_a_pagar_del_producto_el_valor_de_la_garantía_del_producto() {

    }

    @Given("el cliente está en el carrito con varios productos a comprar")
    public void el_cliente_está_en_el_carrito_con_varios_productos_a_comprar() {

    }

    @When("el cliente introduce un número de cupón inválido y hace clic en el botón {string}")
    public void el_cliente_introduce_un_número_de_cupón_inválido_y_hace_clic_en_el_botón(String string) {

    }

    @When("se muestra un mensaje de error cerca del campo que dice {string}")
    public void se_muestra_un_mensaje_de_error_cerca_del_campo_que_dice(String string) {

    }


}
