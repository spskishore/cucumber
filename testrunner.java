package runner_pkg;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features="FEATURE",glue="STEP_DEF")


public class testrunner extends AbstractTestNGCucumberTests {

}
