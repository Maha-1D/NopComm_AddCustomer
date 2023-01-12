package testRun;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
                features = ".\\Features\\customer.feature",
                glue = "step",
                plugin = {"pretty" ,"html: test-output"},
                monochrome = true
                )

public class TestRunner {}
