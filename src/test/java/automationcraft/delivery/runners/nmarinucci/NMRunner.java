package automationcraft.delivery.runners.nmarinucci;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;



@CucumberOptions(
        features = {"src/test/java/automationcraft/testcreation/nmarinucci/features"},
        glue = {"automationcraft.testcreation.nmarinucci.steps", "automationcraft.engine.bdd"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                    "timeline:test-output-thread"},
        tags = ""
)
    public class NMRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider
        //@DataProvider (parallel = true) -- For parallel execution support (which is not going to work for our code)
        public Object[][] scenarios() {
            return super.scenarios();
        }


}

