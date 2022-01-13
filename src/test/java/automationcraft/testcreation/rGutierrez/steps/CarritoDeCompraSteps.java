package automationcraft.testcreation.rGutierrez.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.rGutierrez.pages.CarritoDeCompraPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoDeCompraSteps {

    CarritoDeCompraPages carritoDeCompraPages = new CarritoDeCompraPages(DriverFactory.getDriver());

    @Given("que estoy en la url {string}")
    public void que_estoy_en_la_url(String string) throws Exception {
        carritoDeCompraPages.validacionUrl(string);
    }

    @When("presiono el boton Añadir al carro")
    public void presiono_el_boton_añadir_al_carro() throws Exception {
        carritoDeCompraPages.presionarAniadirAlCarro();
    }

    @When("presiono continuar")
    public void presiono_continuar() throws Exception {
        carritoDeCompraPages.presionarContinuar();
    }

    @When("presiono ir al carro")
    public void presiono_ir_al_carro() throws Exception {
        carritoDeCompraPages.presionarIrAlCarro();
    }

    @Then("se debe agregar correctamente el producto al carrito")
    public void se_debe_agregar_correctamente_el_producto_al_carrito() throws Exception {
        carritoDeCompraPages.validarProductoAgregado();
    }

    @Given("que el cliente está el en carrito de compras con al menos {int} producto")
    public void queElClienteEstáElEnCarritoDeComprasConAlMenosProducto(int arg0) throws Exception {
        carritoDeCompraPages.validarProductoAgregado();
    }

    @When("el cliente aumenta la cantidad a pedir del producto con el boton + a un numero mayor a {int}")
    public void elClienteAumentaLaCantidadAPedirDelProductoConElBotonAUnNumeroMayorA(int arg0) throws Exception {
        carritoDeCompraPages.aumentarProductoMayorA(arg0);
    }

    @Then("se debe deshabilitar el boton +")
    public void seDebeDeshabilitarElBoton() throws Exception {
        carritoDeCompraPages.validarBotonDeshabilitado();
        System.out.println("hola");
    }
}
