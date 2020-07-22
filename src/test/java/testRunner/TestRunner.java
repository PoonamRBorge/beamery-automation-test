package test.java.testRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features="src/test/resources/features",
		glue={"test/java/stepDefinitions"},
		format= {"pretty","html:HTML-Reports"}
		
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
