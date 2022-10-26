package com.relx.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/com/relx/features"},
		glue = {"com/relex/stepDefinitions", "hooks"},
		plugin = {"pretty"}
		)
public class TestRunner {

}
