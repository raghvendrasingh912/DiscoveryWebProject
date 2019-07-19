package com.discovery.TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features="./Features",
		glue= {"com.discovery.StepDef"}
		)
public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun=true)
	public void setClass() {
		testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(dataProvider="features")
	public void features(CucumberFeatureWrapper cucumberfeaturewrapper) {
		testNGCucumberRunner.runCucumber(cucumberfeaturewrapper.getCucumberFeature());
	}
	
	@DataProvider(name="features")
	public Object[][] features(){
		return testNGCucumberRunner.provideFeatures();
	}
	
	@AfterClass
	public void stopCucumberRunner() {
		testNGCucumberRunner.finish();
	}
	

}
