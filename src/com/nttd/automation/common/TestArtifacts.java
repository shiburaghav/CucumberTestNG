package com.nttd.automation.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class TestArtifacts {
	
	private static TestArtifacts testArtifacts;
	private ExtentTest extentTest;
	private ExtentReports extentReports;
	static Hashtable<String, String> artProperties;
	static Hashtable<String, String> hParams;
	private String screenshotPath;
	private String testRunPath;
	static String NAME_SEPARATOR = "_";
	private String scenarioName;
	
	private TestArtifacts() {
		
	}
	
	public static TestArtifacts getInstance() {
		if(testArtifacts == null) {
			testArtifacts = new TestArtifacts();
		}
		return testArtifacts;
	}
	
	public void initializeReporting() {
		setTestRunPath(createTestRunFolder());
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		String dateTime = dateFormat.format(date);
		String reportName = testRunPath + File.separator + "TestReport_" +dateTime+".html";
		setExtentReports(new ExtentReports(reportName, NetworkMode.OFFLINE));
	}
	
	
	public static String createTestRunFolder() {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		String dateTime = dateFormat.format(date);
		String path = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(ARTProperties.getInstance().getProperty("reportPath"));
			sb.append(File.separator);
			sb.append("TestRun");
			sb.append(NAME_SEPARATOR);
			sb.append(dateTime);
			path = sb.toString();
			path = Utils.makeDirectories(path);
			
		}catch(Exception ex) {
			Assert.fail(ex.getMessage());
		}
		return path;
	}
	
	public static String createTestCaseFolder(String testRunPath) {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		String dateTime = dateFormat.format(date);
		String path = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(testArtifacts.scenarioName);
			sb.append(NAME_SEPARATOR);
			sb.append(dateTime);
			path = sb.toString();
			path = Utils.makeDirectories(testRunPath + File.separator + path + File.separator + "Screenshots");
			
		}catch(Exception ex) {
			Assert.fail(ex.getMessage());
		}
		return path;
	}
	
	public void writeResults(String outCome, String details) {
		switch(outCome.toUpperCase()) {
		case "PASS":
			getExtentTest().log(LogStatus.PASS, getExtentTest().addScreenCapture(WebBrowser.takeScreenshot(getScreenshotPath()))+details);
			break;
		case "FAIL":
			getExtentTest().log(LogStatus.FAIL, getExtentTest().addScreenCapture(WebBrowser.takeScreenshot(getScreenshotPath()))+details);
			break;
		case "INFO":
			getExtentTest().log(LogStatus.INFO, getExtentTest().addScreenCapture(WebBrowser.takeScreenshot(getScreenshotPath()))+details);
			break;
		}
	}

	public String getTestRunPath() {
		return testRunPath;
	}

	public void setTestRunPath(String testRunPath) {
		this.testRunPath = testRunPath;
	}

	public String getScreenshotPath() {
		return screenshotPath;
	}

	public void setScreenshotPath(String screenshotPath) {
		this.screenshotPath = screenshotPath;
	}

	public ExtentReports getExtentReports() {
		return extentReports;
	}

	public void setExtentReports(ExtentReports extentReports) {
		this.extentReports = extentReports;
	}

	public ExtentTest getExtentTest() {
		return extentTest;
	}

	public void setExtentTest(ExtentTest extentTest) {
		this.extentTest = extentTest;
	}

	public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

}
