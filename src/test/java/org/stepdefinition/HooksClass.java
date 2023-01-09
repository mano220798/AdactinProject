package org.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author Manojkumar
 * @see HooksClass
 * @Date 07-12-2022
 *
 */
public class HooksClass extends BaseClass {

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browser"));
		enterApplnUrl(getPropertyFileValue("Url"));
		maximizewindow();

	}

	@After
	public void afterScenario(Scenario scenario) {
		scenario.attach(screenShot(),"images/png","EveryScenario");
		quitwindow();

	}

}
