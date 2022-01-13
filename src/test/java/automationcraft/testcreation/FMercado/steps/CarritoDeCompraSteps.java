package automationcraft.testcreation.FMercado.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.FMercado.pages.CarritoDeComprasPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoDeCompraSteps {

    CarritoDeComprasPages carroDeComprasPages = new CarritoDeComprasPages(DriverFactory.getDriver());


    @Given("que estoy en la url {string}")
    public void que_estoy_en_la_url(String string) throws Exception {
        carroDeComprasPages.validacionUrl(string);
    }

    @When("presiono agregar producto al carrito")
    public void presiono_agregar_producto_al_carrito() throws Exception {
        carroDeComprasPages.guardarProducto();
    }

    @Then("se debe agregar correctamente el producto al carrito")
    public void se_debe_agregar_correctamente_el_producto_al_carrito() throws Exception {
        carroDeComprasPages.validarCargaEnCarrito();
    }

    @Then("ver el carrito de compra en pantalla")
    public void ver_el_carrito_de_compra_en_pantalla() throws Exception {
        carroDeComprasPages.validarCarritoEnPantalla();
    }

    //----------------------------------------

    @Given("que el cliente está el en carrito de compras con {int} producto")
    public void que_el_cliente_está_el_en_carrito_de_compras_con_producto(Integer int1){
        carroDeComprasPages.validarUnProducto();
    }

    @When("el cliente aumenta la cantidad a pedir del producto haciendo click en el botón {string} del producto a un número mayor de [limite stock]")
    public void el_cliente_aumenta_la_cantidad_a_pedir_del_producto_haciendo_click_en_el_botón_del_producto_a_un_número_mayor_de_limite_stock(String string) throws InterruptedException {
        carroDeComprasPages.AgregarProductos();
    }

    @Then("el botón {string} se deshabilita.")
    public void el_botón_se_deshabilita(String string) throws InterruptedException {
        carroDeComprasPages.MaximoPermitido();
    }

    //--------------------------------------------/


}
