package automationcraft.testcreation.google.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.engine.selenium.SeleniumBase;
import automationcraft.testcreation.google.pages.GooglePages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
    GooglePages pageGoogle;

    @Given("that I have gone to the Google page")
    public void that_i_have_gone_to_the_google_page() {
        pageGoogle = new GooglePages(DriverFactory.getDriver());
        pageGoogle.goToGoogle();
    }
    @When("I add {string} to the search box")
    public void i_add_to_the_search_box(String string) throws InterruptedException {
        pageGoogle = new GooglePages(DriverFactory.getDriver());
        pageGoogle.type(string);
    }

    @When("click the Search Button")
    public void click_the_search_button() throws InterruptedException {
        pageGoogle = new GooglePages(DriverFactory.getDriver());
        pageGoogle.ClickButtonSearch();
    }

    @Then("{string} should be mentioned in the results")
    public void should_be_mentioned_in_the_results(String string) {
        pageGoogle = new GooglePages(DriverFactory.getDriver());
        pageGoogle.validate(string);
    }
}