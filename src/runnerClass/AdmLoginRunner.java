package runnerClass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\LiveProject\\Ebanking\\src\\features\\Login.feature",
				 glue="stepDefination",
				 monochrome=true,
				 plugin="pretty",
				 dryRun=false)

public class AdmLoginRunner {

}
