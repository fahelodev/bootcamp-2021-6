package pom.equipo6.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/pom/equipo6/features"}, //Ruta
        glue = {"pom.equipo6.steps", "pom.equipo6.base"}, //package
        plugin = {"pretty"},
        tags ="@regresion"
)
public class CucumberRunnerGoogle {
}
