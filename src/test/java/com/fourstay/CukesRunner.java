package com.fourstay;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
//@CucumberOptions(dryRun=true)
@CucumberOptions(plugin={"pretty","html:target/cucumber","json:target/cucumber.json"},
				tags={"@Test"})
//				tags={"@Regression","~@Test"})
public class CukesRunner {

}
