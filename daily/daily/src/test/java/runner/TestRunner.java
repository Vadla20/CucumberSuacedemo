package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/Features/Test8.feature",
				"src/test/java/Features/Test9.feature",
				"src/test/java/Features/Test10.feature"},
		glue="stepDefi",
		monochrome=false,
		plugin= {"pretty", "html:target/Cucumber-reports.html"}
		)
public class TestRunner {
	
}

