package automationcraft.testcreation.google.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.google.pages.GooglePages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class GoogleSearchSteps  {

    protected GooglePages google;


    @Given("that I have gone to the Google page")
    public void that_i_have_gone_to_the_google_page() {
        google = new GooglePages(DriverFactory.getDriver());
        google.navigateToGoogle();
    }

    @When("I add {string} to the search box")
    public void i_add_to_the_search_box(String nameAnimal) throws InterruptedException {

        google.enterSearchCriteria(nameAnimal);

    }

    @When("click the Search Button")
    public void click_the_search_button() {

        google.clickGoogleSearch();
    }


    @Then("the {string} should be mentioned in the results")
    public void should_be_mentioned_in_the_results(String nameAnimal) {

        google = new GooglePages(DriverFactory.getDriver());
        String searchResult = google.getTitle();
            Assert.assertTrue(searchResult.contains(nameAnimal));


    }


}
