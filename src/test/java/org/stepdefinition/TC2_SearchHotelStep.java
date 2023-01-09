package org.stepdefinition;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

/**
 * 
 * @author Manojkumar
 * @see TC2_SearchHotelStep
 * @Date 07-12-2022
 *
 */
public class TC2_SearchHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should select all the fields {string},{string}, {string},{string},{string},{string},{string} and {string}")
	public void user_should_select_all_the_fields_and(String Location, String Hotels, String RoomType, String NoOfRooms,
			String CheckInDate, String CheckOutDate, String AdultsPerRoom, String ChildPerRoom) {
		pom.getSearchHotelPage().searchHotel(Location, Hotels, RoomType, NoOfRooms, CheckInDate, CheckOutDate,
				AdultsPerRoom, ChildPerRoom);

	}

	@Then("User should verify the success message after search hotel {string}")
	public void user_should_verify_the_success_message_after_search_hotel(String expectedSelectHotelSuccessMsg) {
		WebElement selectHotelTitle = pom.getSelectHotelPage().getSelectHoteltext();
		String actualSelectHotelSuccessMsg = elementGetText(selectHotelTitle);
		Assert.assertEquals("Verify after search hotel success message", expectedSelectHotelSuccessMsg,
				actualSelectHotelSuccessMsg);

	}

	@Then("User should enter only the mandatory fields  {string}, {string}, {string},{string} and {string}")
	public void user_should_enter_only_the_mandatory_fields_and(String Location, String NoOfRooms, String CheckInDate,
			String CheckOutDate, String AdultsPerRoom) {
		pom.getSearchHotelPage().searchHotel(Location, NoOfRooms, CheckInDate, CheckOutDate, AdultsPerRoom);
	}

	@Then("User should verify Check In date and Check Out date error message after search hotel {string} and {string}")
	public void user_should_verify_check_in_date_and_check_out_date_error_message_after_search_hotel_and(
			String expectederrorchkin, String expectederrorchkout) {
		WebElement errorcheckin = pom.getSearchHotelPage().getErrorcheckin();
		String actErrorchkin = elementGetText(errorcheckin);
//		boolean b = actErrorchkin.contains(expectederrorchkin);
//		Assert.assertEquals("verify error message after search hotel", b);
		 Assert.assertEquals("verify error message after search hotel",
		 expectederrorchkin, actErrorchkin);

		WebElement errorcheckout = pom.getSearchHotelPage().getErrorcheckout();
		String actErorchkout = elementGetText(errorcheckout);
//		boolean c = actErorchkout.contains(expectederrorchkout);
//		Assert.assertEquals("verify error message after search hotel", c);
		 Assert.assertEquals("verify error message after search hotel",
		 expectederrorchkout, actErorchkout);

	}

	@Then("User should search hotel without entering the fields")
	public void user_should_search_hotel_without_entering_the_fields() {
		pom.getSearchHotelPage().searchHotel();

	}

	@Then("User should verify error message after search {string}")
	public void user_should_verify_error_message_after_search(String locationerror) {
//		WebElement errorlocation = pom.getSearchHotelPage().getErrorlocation();
//		String actSearchMsg = elementGetText(errorlocation);
//		Assert.assertEquals("verify error message after search hotel", expectedSearchmsg, actSearchMsg);

		WebElement adactin = pom.getSearchHotelPage().getAdactin();
		String textGet = elementGetText(adactin);
	}

}
