package co.quipux.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/",
        glue = {"co.quipux.stepsDefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@RUN_FEATURE",
        dryRun = false,
        monochrome = true
)
public class RunTest {
}