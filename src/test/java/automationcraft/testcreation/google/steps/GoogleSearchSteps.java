package automationcraft.testcreation.google.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

    @Given("that I have gone to the Google page")
    public void that_i_have_gone_to_the_google_page() {
        System.out.println("Configurado");
    }

    @When("I add {string} to the search box")
    public void i_add_to_the_search_box(String string) {
        System.out.println("Configurado");
    }

    @When("click the Search Button")
    public void click_the_search_button() {
        System.out.println("Configurado");
    }

    @Then("{string} should be mentioned in the results")
    public void should_be_mentioned_in_the_results(String string) {
        System.out.println("Configurado");
    }
}
