package pom.mentoria.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/pom/mentoria/features"}, //Ruta
        glue = {"pom.mentoria.steps", "pom.mentoria.base"}, //package
        plugin = {"pretty"},
        tags ="@regresion"
)
public class CucumberRunnerGoogle {
}
