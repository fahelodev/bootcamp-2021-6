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

    @When("el cliente aumenta la cantidad a pedir del producto a un número mayor de {int}")
    public void el_cliente_aumenta_la_cantidad_a_pedir_del_producto_a_un_número_mayor_de(Integer int1) {

    }

    @When("hace clic en {string}")
    public void hace_clic_en(String string) {

    }

    @Then("se debe mostrar un popup que dice {string}")
    public void se_debe_mostrar_un_popup_que_dice(String string) {

    }

    @Then("en cada artículo que esté asociado a un producto con receta médica debe aparecer un mensaje de alerta {string}")
    public void en_cada_artículo_que_esté_asociado_a_un_producto_con_receta_médica_debe_aparecer_un_mensaje_de_alerta(String string) {

    }

    @Given("que el cliente está el en carrito de compras con al menos {int} producto")
    public void queElClienteEstáElEnCarritoDeComprasConAlMenosProducto(int arg0) {
    }

    @When("el cliente introduce un número de tarjeta CMR inválido")
    public void elClienteIntroduceUnNúmeroDeTarjetaCMRInválido() {

    }

    @Then("se despliega un mensaje de error en el carrito que dice {string}")
    public void seDespliegaUnMensajeDeErrorEnElCarritoQueDice(String arg0) {
    }
}