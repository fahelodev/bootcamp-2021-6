package automationcraft.delivery.runners.rsobarzo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

public class PRunner {

    @CucumberOptions(
            features = {"src/test/java/automationcraft/testcreation/rsobarzo/features"},
            glue = {"automationcraft.testcreation.rsobarzo.steps", "automationcraft.engine.bdd"},
            plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                    "timeline:test-output-thread"},
            tags = ""
    )
    public class FRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider
        //@DataProvider (parallel = true) -- For parallel execution support (which is not going to work for our code)
        public Object[][] scenarios() {
            return super.scenarios();
        }

    }
}
