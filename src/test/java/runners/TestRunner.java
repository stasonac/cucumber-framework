package runners;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/",
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true,
        tags = {"@dorina"}
)
public class TestRunner {
}