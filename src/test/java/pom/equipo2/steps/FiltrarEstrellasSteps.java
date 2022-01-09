package pom.equipo2.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.equipo2.base.CucumberTestBase;
import pom.equipo2.pages.HomePageHoteles;

public class FiltrarEstrellasSteps {
    protected HomePageHoteles pageHoteles;

    @Given("i'm on the modules Alojamientos in the page Viajes Falabella")
    public void i_m_on_the_modules_in_the_page() {
        pageHoteles = new HomePageHoteles(CucumberTestBase.getDriver());
        pageHoteles.PaginaHoteles();
    }
    @When("i set a destiny to arrive and i search it")
    public void i_set_a_destiny_to_arrive_and_i_search_it() throws InterruptedException {
        pageHoteles = new HomePageHoteles(CucumberTestBase.getDriver());
        pageHoteles.BusquedaDeHotel();
    }
    @And("i filter the results by stars")
    public void i_filter_the_results_by_stars() throws InterruptedException {
        pageHoteles = new HomePageHoteles(CucumberTestBase.getDriver());
        pageHoteles.FiltrarBusquedaEstrellas();
    }
    @Then("i click on the hotel thar appears on the top of the list")
    public void i_click_on_the_hotel_thar_appears_on_the_top_of_the_list(){
        pageHoteles = new HomePageHoteles(CucumberTestBase.getDriver());
        pageHoteles.ClickEnELPrimerHotel();
    }
}
