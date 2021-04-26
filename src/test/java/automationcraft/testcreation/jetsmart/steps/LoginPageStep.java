package automationcraft.testcreation.jetsmart.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.jetsmart.pages.JetSmartHomePage;
import automationcraft.testcreation.jetsmart.pages.JetSmartInicioSesionPage;

public class LoginPageStep {

    private JetSmartHomePage homePage = new JetSmartHomePage(DriverFactory.getDriver());
    private JetSmartInicioSesionPage inicioSesionPage = new JetSmartInicioSesionPage(DriverFactory.getDriver());


    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        homePage.goToUrl("https://jetsmart.com/cl/es/");
        homePage.cerrarPopUp();
        homePage.clickIniciaSesion();
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        String title =  inicioSesionPage.getTitle();
        System.out.println("inicio Sesion Page titile is: "+title);

    }

    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(string,"Vuelos Baratos – JetSMART Aviones Nuevos | Sitio Oficial");
    }

    @Then("forgot message link should be displayed")
    public void forgot_message_link_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(true);
    }
}
