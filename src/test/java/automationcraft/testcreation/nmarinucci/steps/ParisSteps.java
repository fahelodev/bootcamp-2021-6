package automationcraft.testcreation.nmarinucci.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.nmarinucci.pages.ParisPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParisSteps {
    protected ParisPage parisPage;

    @Given("estoy en la url {string}")
    public void estoy_en_la_url(String string) {
        System.out.println("Configurado");
        parisPage = new ParisPage(DriverFactory.getDriver());
        parisPage.goToURL(string);

    }

    @When("presiono el boton añadir al carro")
    public void presiono_el_boton_añadir_al_carro() throws Exception {
        System.out.println("Configurado");
        parisPage.validarAñadirAlCarro();
    }

    @And("el producto se debe agregar correctamente al carro")
    public void el_producto_se_debe_agregar_correctamente_al_carro() throws Exception {
        System.out.println("Configurado");
       parisPage.validadProductoAñadido();
    }

    @Then("ver el carro de compra en pantalla")
    public void ver_el_carro_de_compra_en_pantalla()  {
        System.out.println("Configurado");

    }

    //AC-01
    @Given("el cliente esta en el carrito de compras")
    public void el_cliente_esta_en_el_carrito(){
        System.out.println("Configurado");
    }

    @When("el cliente aumenta la cantidad del producto a un numero mayor de {int}")
    public void el_cliente_aumenta_la_cantidad_del_producto_a_un_numero_mayor_de(Integer limite) throws Exception {
        parisPage.sumarCantidad(limite);
    }

    @Then("el boton + se deshabilita")
    public void el_boton_se_deshabilita() throws Exception {
        parisPage.validarBotonDeshabilitado();
    }
}
