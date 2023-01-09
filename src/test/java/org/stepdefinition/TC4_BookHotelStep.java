package org.stepdefinition;

import java.util.List;
import java.util.Map;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Manojkumar
 * @see TC4_BookHotelStep
 *@Date 07-12-2022
 */
public class TC4_BookHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	

	@Then("User should Book a Hotel {string},{string} ,{string},{string},{string},{string},{string} and {string}")
	public void user_should_book_a_hotel_and(String FirstName, String LastName, String Address, String creditcardno,
			String creditcardtype, String expmonth, String expyear, String cvvno,
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> Maps = dataTable.asMaps();
		Map<String, String> m = Maps.get(1);
		String creditcardno1 = m.get("creditcardno");
		String creditcardtype1 = m.get("creditcardtype");
		String expmonth1 = m.get("expmonth");
		String expyear1 = m.get("expyear");
		String cvvno1 = m.get("cvvno");

		pom.getBookHotelPage().BookHotelPage(FirstName, LastName, Address, creditcardno1, creditcardtype1, expmonth1,
				expyear1, cvvno1);

	 }

	@Then("User should verify after booking success message {string} and save the generated order ID")
	public void user_should_verify_after_booking_success_message_and_save_the_generated_order_id(String string) {

		pom.getBookHotelPage().getBookingconfiramton();

	}

	@Then("User should click book now without entering any fields")
	public void user_should_click_book_now_without_entering_any_fields() {

		pom.getBookHotelPage().bookHotel();
	}

	@Then("User should verify without enter any fields while booking error message {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_should_verify_without_enter_any_fields_while_booking_error_message(String experrfst,
			String experrlst, String experradd, String experrcardno, String experrcardtype, String experrexpiy,
			String experrcvv) {

		WebElement errFstname = pom.getBookHotelPage().getErrFstname();
		String textGet = elementGetText(errFstname);
		boolean b = textGet.contains(experrfst);
		Assert.assertTrue("Verify After Book Now without entring First name", b);

		WebElement errlstname = pom.getBookHotelPage().getErrLstname();
		String lstnmeerr = elementGetText(errlstname);
		boolean b1 = lstnmeerr.contains(experrlst);
		Assert.assertTrue("Verify After Book Now without entring Last name", b1);

		WebElement erradd = pom.getBookHotelPage().getErrAddress();
		String addresserr = elementGetText(erradd);
		boolean b2 = addresserr.contains(experradd);
		Assert.assertTrue("Verify After Book Now without entring Address", b2);

		WebElement errcardno = pom.getBookHotelPage().getErrCardno();
		String crdnoerr = elementGetText(errcardno);
		boolean b3 = crdnoerr.contains(experrcardno);
		Assert.assertTrue("Verify After Book Now without entring Card Number", b3);

		WebElement errcardtype = pom.getBookHotelPage().getErrCardType();
		String crdtypeerr = elementGetText(errcardtype);
		boolean b4 = crdtypeerr.contains(experrcardtype);
		Assert.assertTrue("Verify After Book Now without Select card Type", b4);

		WebElement errcardexp = pom.getBookHotelPage().getErrExpiry();
		String crdexperr = elementGetText(errcardexp);
		boolean b5 = crdexperr.contains(experrexpiy);
		Assert.assertTrue("Verify After Book Now without entring Expiry details", b5);

		WebElement errcardcvv = pom.getBookHotelPage().getErrCvvno();
		String crdcvverr = elementGetText(errcardcvv);
		boolean b6 = crdcvverr.contains(experrcvv);
		Assert.assertTrue("Verify After Book Now without entring CVV Number", b5);

	}

}
