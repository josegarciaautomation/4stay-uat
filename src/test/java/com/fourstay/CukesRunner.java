package com.fourstay;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
//@CucumberOptions(dryRun=true)
@CucumberOptions(plugin={"pretty","html:target/cucumber","json:target/cucumber.json"},
//		tags={"@homepage"}, dryRun=false)
		tags={"@Test"}, dryRun=false)
//		tags={"@dbtest"}, dryRun=false)
//		glue="com/fivestay/step_defs") // shows the location of your step definitions
//		features="location/of/your/feature_files") // shows the location of your features files
//		tags={"@Regression","~@Test"}, dryRun=false)
public class CukesRunner {

}
