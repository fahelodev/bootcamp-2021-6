package automationcraft.testcreation.iRomero.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.iRomero.pages.CarritoDeCompraPages;
import automationcraft.testcreation.iRomero.pages.ProductoPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoDeCompraParisSteps {
    protected ProductoPages product = new ProductoPages(DriverFactory.getDriver());
    protected CarritoDeCompraPages cart = new CarritoDeCompraPages(DriverFactory.getDriver());


    @Given("que estoy en la url {string}")
    public void que_estoy_en_la_url(String string)  {
        product.validacionUrl(string);
    }

    @When("presiono el boton Añadir al carro")
    public void presiono_el_boton_añadir_al_carro() throws Exception {
        product.agregadoCarrito();
    }

    @Then("se debe agregar correctamente el producto al carrito")
    public void se_debe_agregar_correctamente_el_productor_al_carrito() {
        product.validacionCarrito();

    }
    @Then("ver el carrito de compra en pantalla")
    public void ver_el_carrito_de_compra_en_pantalla() {
        product.irACarrito();
    }

    @Given("que el cliente está el en carrito de compras con {int} producto")
    public void que_el_cliente_está_el_en_carrito_de_compras_con_producto(Integer int1) throws Exception {
        cart.validacionCantidad(int1);
    }

    @When("el cliente aumenta la cantidad a pedir del producto haciendo click en el botón + del producto a un número mayor de {int}")
    public void el_cliente_aumenta_la_cantidad_a_pedir_del_producto_haciendo_click_en_el_botón_del_producto_a_un_número_mayor_de(Integer int1) throws InterruptedException {
        cart.agregadoDeProducto(int1);
    }

    @Then("el botón + se deshabilita.")
    public void el_botón_se_deshabilita() {
        cart.botonDesabilitado();
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
