package runnerClass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\LiveProject\\Ebanking\\src\\features\\Role.feature",
				 glue="stepDefination",
				 monochrome=true,
				 plugin={"pretty","json:target/reports/Role.json"},
				 dryRun=false)

public class RoleRunner {

}
