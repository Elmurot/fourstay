package com.fourstay.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/cucumber", "json:target/report.json"},
		features = "src/test/resources/com/fourstay/features",
		glue = "com/fourstay/step_definitions",
		//tags = "@testitnow",
		dryRun = false
		)

public class CukesRunner {

	
}