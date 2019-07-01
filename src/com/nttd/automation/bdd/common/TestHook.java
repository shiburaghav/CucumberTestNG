package com.nttd.automation.bdd.common;

import com.nttd.automation.common.ARTProperties;
import com.nttd.automation.common.TestArtifacts;
import com.nttd.automation.common.WebBrowser;
import com.nttd.automation.common.WebBrowser.WebBrowserType;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestHook {
	
	ARTProperties properties;
	TestArtifacts testArtifacts;
	static String appURL;

	 public TestHook() {
		 properties = ARTProperties.getInstance();
		testArtifacts = TestArtifacts.getInstance();
	 }
	 
	 @Before
	 public void BeforeSteps(Scenario scenario) {
		 testArtifacts.setScenarioName(scenario.getName());
		 testArtifacts.initializeReporting();
			testArtifacts.setExtentTest(testArtifacts.getExtentReports().startTest(testArtifacts.getScenarioName()));
			testArtifacts.setScreenshotPath(TestArtifacts.createTestCaseFolder(testArtifacts.getTestRunPath()));
			switch (properties.getProperty("browser").toUpperCase()) {
			case "CHROME":
				WebBrowser.getDriver(WebBrowserType.CHROME);
				break;
			case "IE":
				WebBrowser.getDriver(WebBrowserType.IE);
				break;
			}
			appURL = properties.getProperty("url");
			WebBrowser.navigateTo(appURL);
			WebBrowser.setImplicitTime(Integer.parseInt(properties.getProperty("implicitWait")));
		 
	 }
	 
	@After
	public void AfterSteps(Scenario scenario) {
		try {
			TestArtifacts.getInstance().getExtentReports().flush();
			WebBrowser.quitBrowser();
		} catch (Exception ex) {

		}
	}
}
