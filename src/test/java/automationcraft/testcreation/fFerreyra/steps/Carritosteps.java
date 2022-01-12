package automationcraft.testcreation.fFerreyra.steps;

import automationcraft.testcreation.fFerreyra.pages.CarritoPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Carritosteps {

   CarritoPages carritoPages;

    @Given("que el cliente está el en carrito de compras con {int} producto")
    public void that_i_have_gone_to_the_google_page(String string) {
        carritoPages.CarritoConProducto(string);
        System.out.println("Configurado");
    }

    @When("el cliente aumenta la cantidad a pedir del producto haciendo click en el botón {string} del producto a un número mayor de [limite stock]")
    public void i_add_to_the_search_box(String string) {
        carritoPages.aumentaProducto(string);
        System.out.println("Configurado");
    }


    @Then("el botón {string} se deshabilita.")
    public void should_be_mentioned_in_the_results(String string) {

        carritoPages.desHabilita(string);
        System.out.println("Configurado");
    }

}
