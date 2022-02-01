package Steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(plugin = {"json:target/cucumber-report/cucumber.json"},
            snippets = CucumberOptions.SnippetType.CAMELCASE,
            monochrome = true,
            features = {
                    "classpath:features"},
            glue = {"classpath:Steps"},
            tags = "@TodosOsTestes")

    public class RunnersTest {

}

