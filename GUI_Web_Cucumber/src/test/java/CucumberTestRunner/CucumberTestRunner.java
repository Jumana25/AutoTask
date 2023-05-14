package CucumberTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "CucumberSteps", tags= "@TC2",features="src/test/resources/features/SubscriptionPackages.feature")
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
