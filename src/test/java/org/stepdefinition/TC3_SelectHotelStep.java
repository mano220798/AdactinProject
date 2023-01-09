package org.stepdefinition;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Manojkumar
 * @see TC3_SelectHotelStep
 * @Date 07-12-2022
 *
 */
public class TC3_SelectHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should select a hotel")
	public void user_should_select_a_hotel() {

		pom.getSelectHotelPage().selectHotelPage();

	}

	@Then("User should click continue without select any hotel name")
	public void user_should_click_continue_without_select_any_hotel_name() {

		pom.getSelectHotelPage().clickContinue();
	}

	@Then("User shoudld verify without select any hotel name error message {string}")
	public void user_shoudld_verify_without_select_any_hotel_name_error_message(String expectedErrorClick) {
		WebElement errorContinueClick = pom.getSelectHotelPage().getErrorContinueClick();
		String actualErrorClick = elementGetText(errorContinueClick);
		Assert.assertEquals("Verify continue click error message", expectedErrorClick, actualErrorClick);
	}

	@Then("User should verify after select hotel name success message {string}")
	public void user_should_verify_after_select_hotel_name_success_message(String expbookhotelcofirmmsg) {
		WebElement bookHotelText = pom.getBookHotelPage().getBookHotelText();
		String actbookhotelmsg = elementGetText(bookHotelText);
		Assert.assertEquals("verify after select hotel success msg", expbookhotelcofirmmsg, actbookhotelmsg);

	}

}
