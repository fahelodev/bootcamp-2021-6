package automationcraft.testcreation.fmarfull.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.fmarfull.pages.CarritoDeCompraPages;
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
    public void presiono_el_boton_añadir_al_carro() {
        carritoDeCompraPages.añadirAlCarrito();
    }

    @Then("se debe agregar un producto al carro")
    public void se_debe_agregar_un_producto_al_carro() {
    }

    @Then("presiono el boton ir al carro")
    public void presiono_el_boton_ir_al_carro() {
    }

    @Then("puedo ver el carrito de compra en pantalla")
    public void puedo_ver_el_carrito_de_compra_en_pantalla() {
    }

    @Given("que el cliente está el en carrito de compras con {int} producto")
    public void que_el_cliente_está_el_en_carrito_de_compras_con_producto(Integer int1) throws Exception {
        carritoDeCompraPages.validacionUrl("https://www.paris.cl/cart");
    }

    @When("el cliente aumenta la cantidad a pedir del producto haciendo click en el botón {string} del producto a un número mayor de [limite stock]")
    public void el_cliente_aumenta_la_cantidad_a_pedir_del_producto_haciendo_click_en_el_botón_del_producto_a_un_número_mayor_de_limite_stock(String string) {
    }

    @Then("el botón {string} se deshabilita.")
    public void el_botón_se_deshabilita(String string) {
    }

    @Given("que el cliente está el en carrito de compras con al menos {int} producto SIN Garantía Extendida")
    public void que_el_cliente_está_el_en_carrito_de_compras_con_al_menos_producto_sin_garantía_extendida(Integer int1) {
    }

    @When("el cliente agrega la garantia de daño accidental")
    public void el_cliente_agrega_la_garantia_de_daño_accidental() {
    }

    @Then("el total a pagar incluye el monto a pagar del producto + el valor de la garantía del producto")
    public void el_total_a_pagar_incluye_el_monto_a_pagar_del_producto_el_valor_de_la_garantía_del_producto() {
    }

    @Given("que el cliente está en el carrito con varios productos a comprar")
    public void que_el_cliente_está_en_el_carrito_con_varios_productos_a_comprar() {
    }

    @When("el cliente introduce un número de cupón inválido y hace clic en el botón {string}")
    public void el_cliente_introduce_un_número_de_cupón_inválido_y_hace_clic_en_el_botón(String string) {
    }

    @Then("se muestra un mensaje de error cerca del campo que dice {string}")
    public void se_muestra_un_mensaje_de_error_cerca_del_campo_que_dice(String string) {
    }
}