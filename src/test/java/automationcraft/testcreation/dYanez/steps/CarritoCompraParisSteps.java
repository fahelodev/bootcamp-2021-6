package automationcraft.testcreation.dYanez.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.dYanez.pages.CarritoCompraPageParis;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CarritoCompraParisSteps {

    CarritoCompraPageParis pageParis = new CarritoCompraPageParis(DriverFactory.getDriver());

    @Given("que estoy en la url {string}")
    public void que_estoy_en_la_url(String string) {
        pageParis.navigateToParis(string);
    }

    @When("agrego al carrito")
    public void agrego_al_carrito() {
        pageParis.clickInBtnProduct();
    }

    @And("click en continuar")
    public void click_en_continuar() {
        pageParis.clickContinuar();
    }

    @And("click en ir al carrito")
    public void click_en_ir_al_carrito() {
        pageParis.clickIrAlCarrito();
    }

    @When("el cliente introduce un número de cupón inválido y hace clic en el botón aplicar")
    public void el_cliente_introduce_un_número_de_cupón_inválido_y_hace_clic_en_el_botón() {
        pageParis.writeCuponInvalid();
    }


    @Then("se muestra un mensaje de error cerca del campo que dice Código de Cupón Inválido")
    public void se_muestra_un_mensaje_de_error_cerca_del_campo_que_dice_código_de_cupón_inválido() {

    }


    @Then("el cliente aumenta la cantidad a pedir del producto haciendo click en el botón mas del producto a un número mayor de limite de stock")
    public void el_cliente_aumenta_la_cantidad_a_pedir_del_producto_haciendo_click_en_el_botón_mas_del_producto_a_un_número_mayor_de_limite_de_stock() throws InterruptedException {
        pageParis.clickAumentarProduct();
    }

}
