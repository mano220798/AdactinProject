package org.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Manojkumar
 * @see TC1_LoginStep
 * @Date 07-12-2022
 *
 */
public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the Adactin page")
	public void user_is_on_the_adactin_page() throws FileNotFoundException, IOException {
		
	}

	@When("User should perform login {string}, {string}")
	public void user_should_perform_login(String username, String password) {
		pom.getLoginHotelPage().login(username, password);

	}

	@When("User should perform login {string}, {string} with Enter key")
	public void user_should_perform_login_with_enter_key(String username, String password) throws AWTException {
		pom.getLoginHotelPage().loginWithEnterKey(username, password);
	}

	@Then("User should verify after login with invlaid credentials error message {string}")
	public void user_should_verify_after_login_with_invlaid_credentials_error_message(String expLoginErrorMessage) {
		WebElement errorMsg = pom.getLoginHotelPage().getTextErrorLogin();
		String elementGetText = elementGetText(errorMsg);
		boolean contains = elementGetText.contains(expLoginErrorMessage);
		Assert.assertTrue("verify after login with invalid credential error message contains", contains);
	}

}
