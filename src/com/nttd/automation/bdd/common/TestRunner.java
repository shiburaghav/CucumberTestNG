package com.nttd.automation.bdd.common;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
        features = "com/nttd/automation/bdd/features",
        glue = {"com/nttd/automation/bdd/steps"},
        tags = {"@RegressionPack"})

public class TestRunner{
	
	private TestNGCucumberRunner testNGCucumberRunner; 
	
	 @BeforeClass(alwaysRun = true)  
	    public void setUpClass() throws Exception {  
		 if(testNGCucumberRunner != null)
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());  
	  }  

	 @Test(dataProvider = "provider")
	  public void withoutInjection(CucumberFeatureWrapper cucumberFeature) {
		 if(testNGCucumberRunner != null)
		 testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	  }
	 
	  
	  @DataProvider
	  public Object[][] provider() throws Exception {
		  if(testNGCucumberRunner != null) {
			  testNGCucumberRunner.provideFeatures();
		  }
		  return null;
	  }



	    @AfterClass(alwaysRun = true)  
	    public void tearDownClass() throws Exception {  
	    	 if(testNGCucumberRunner != null)
	        testNGCucumberRunner.finish();  
	  }  

}
