package org.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.base.BaseClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * 
 * @author MANOJKUMAR
 * @see TestRunnerClass
 * @Date 07-12-2022
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags= ("@StateId"),dryRun=false,plugin= {"json:target\\output.json"},features = "src\\test\\resources", glue = "org.stepdefinition")

public class TestRunnerClass extends BaseClass {
	
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see afterclass
	 */
	@AfterClass
	public static void afterclass() throws FileNotFoundException, IOException {
		
		//generates JVM report----> input pass as json file
		//report-----(reporting---)generate JVm report)
		Reporting.generateJVMReport(getProjectPath() + getPropertyFileValue("jsonpath"));

	}

}
