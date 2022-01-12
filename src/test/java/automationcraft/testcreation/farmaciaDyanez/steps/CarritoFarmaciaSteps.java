package automationcraft.testcreation.farmaciaDyanez.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.farmaciaDyanez.page.CarritoFarmaciaPage;
import io.cucumber.java.en.*;


public class CarritoFarmaciaSteps {

    protected CarritoFarmaciaPage pageFarmacia = new CarritoFarmaciaPage(DriverFactory.getDriver());

    @Given("^que estoy en la url$")
    public void que_estoy_en_la_url() {
        pageFarmacia.navigateToFarmacia("https://farmaciasahumada.cl/catalogsearch/result/?q=bromex");
    }

    @When("presiono el boton guardar")
    public void presiono_el_boton_guardar() {
        pageFarmacia.clickInBtnProduct();
    }

    @And("se debe agregar correctamente el producto al carrito")
    public void se_debe_agregar_correctamente_el_producto_al_carrito() throws Exception {
        pageFarmacia.validarCargaEnCarrito();
    }

    @Then("ver el carrito de compra en pantalla")
    public void ver_el_carrito_de_compra_en_pantalla() {

    }


}
