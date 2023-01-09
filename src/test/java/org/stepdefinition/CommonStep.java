package org.stepdefinition;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Manojkumar
 * @see CommonStep
 * @Date 07-12-2022
 *
 */
public class CommonStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify the login success message {string}")
	public void user_should_verify_the_login_success_message(String expLoginsuccessmessage) {

		WebElement textLoginMsg = pom.getSearchHotelPage().getTextLoginMsg();

		String actLoginSuccessMsg = elementGetAttributeValue(textLoginMsg);
		Assert.assertEquals("verify after login success message", expLoginsuccessmessage, actLoginSuccessMsg);

	}

}
