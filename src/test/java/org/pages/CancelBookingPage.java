package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author MANOJKUMAR
 * @see CancelBookingPage
 * @Date 07-12-2022
 *
 */
public class CancelBookingPage extends BaseClass {

	public CancelBookingPage() {

		PageFactory.initElements(driver, this);
	}

	// 1.booking --->order id --->cancel booking-->the booking has been cancelled
	// 2.existing order id--->cancel booking---->the booking has been cancelled

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement bookedItinerary;

	@FindBy(id = "order_id_text")
	private WebElement searchOrderId;

	@FindBy(id = "search_hotel_id")
	private WebElement goBtn;

	@FindBy(xpath = "//input[@type='button']")
	private WebElement cancelBtnClick;

	@FindBy(id = "search_result_error")
	private WebElement cancelledSuccessMsg;

	public WebElement getCancelledSuccessMsg() {
		return cancelledSuccessMsg;
	}

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getSearchOrderId() {
		return searchOrderId;
	}

	public WebElement getGoBtn() {
		return goBtn;
	}

	public WebElement getCancelBtnClick() {
		return cancelBtnClick;
	}

	/**
	 * 
	 * @param orderno
	 * @see To cancel Existing order id
	 */
	public void cancelBookingPage(String orderno) {
		WebElement bookedItinerary = getBookedItinerary();
		elementClick(bookedItinerary);
		implicitwait(50);

		WebElement searchOrderId = getSearchOrderId();
		elementsendkeys(searchOrderId, orderno);

		WebElement goButton = getGoBtn();
		elementClick(goButton);

		WebElement cancelButtonClick = getCancelBtnClick();
		elementClick(cancelButtonClick);

		alertok();

	}

}
