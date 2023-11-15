package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\utkar\\eclipse-workspace\\Capstone_Project_Cucumber\\src\\test\\java\\features\\Sportyshoes.feature",
				 glue= {"steps"},
				 plugin= {"html:target/Cucumberreport2.html",
						 "pretty",
						"timeline:test-output-thread/"		
				}
			)

public class TestRunner {

}
