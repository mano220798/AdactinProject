package org.stepdefinition;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

/**
 * 
 * @author prakash
 * @Date 07-12-2022
 * @see TC5_CancelBookingStep
 *
 */
public class TC5_CancelBookingStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify success message after cancel generated order id {string}")
	public void user_should_verify_success_message_after_cancel_generated_order_id(String exporderidcanceledmsg) {
		pom.getBookingConfirmationPage().getOrderId();

		WebElement cancelledSuccessMsg = pom.getCancelBookingPage().getCancelledSuccessMsg();
		String actcancelmsg = elementGetText(cancelledSuccessMsg);
		Assert.assertEquals("verify after cancelled orderid success msg", exporderidcanceledmsg, actcancelmsg);

	}

	@Then("User should cancel existing order ID {string}")
	public void user_should_cancel_existing_order_id(String orderno) {
		pom.getCancelBookingPage().cancelBookingPage(orderno);

	}

	@Then("User should verify success message after cancel existing order id {string}")
	public void user_should_verify_success_message_after_cancel_existing_order_id(String expcancelmsg) {
		WebElement cancelledSuccessMsg = pom.getCancelBookingPage().getCancelledSuccessMsg();
		String actcancelmsg = elementGetText(cancelledSuccessMsg);
//		boolean b = actcancelmsg.contains(actcancelmsg);
//		Assert.assertTrue("Verify after Cancel Success message ", b);
		Assert.assertEquals("verify after cancel existing orderid success msg", expcancelmsg, actcancelmsg);

	}

}
