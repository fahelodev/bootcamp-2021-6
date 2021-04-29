package automationcraft.delivery.runners.lineal;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/automationcraft/testcreation/jetsmart/features"},
        glue = {"automationcraft.testcreation.jetsmart.steps","automationcraft.engine.bdd"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                  "timeline:test-output-thread"}
        )
public class reg_001_jetsmartRunner {
}
