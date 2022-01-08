package pom.equipo2.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/pom/equipo2/features"}, //Ruta
        glue = {"pom.equipo2.steps", "pom.equipo2.base"}, //package
        plugin = {"pretty"},
        tags ="@ViajesTraslados"
)
public class CucumberRunnerTraslados {

}
