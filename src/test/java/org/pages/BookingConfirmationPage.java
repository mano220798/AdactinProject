package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author MANOJKUMAR
 * @see BookingConfirmationPage
 * @Date 07-12-2022
 *
 */
public class BookingConfirmationPage extends BaseClass {

	public BookingConfirmationPage() {

		PageFactory.initElements(driver, this);
	}

	// get generate the order id and return it
	@FindBy(id = "order_no")
	private WebElement getorderid;
	
	@FindBy(id = "my_itinerary")
	private WebElement bookedItinerary;
	
	@FindBy(id = "order_id_text")
	private WebElement searchOrderId;
	
	@FindBy(id = "search_hotel_id")
	private WebElement goButton;
	
	@FindBy(xpath = "//input[@type='button']")
	private WebElement cancelButtonClick;
	
	@FindBy(id="search_result_error")
	private WebElement cancelledSuccessMsg;
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement bookingConfirmSuccessMsg;
	

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getSearchOrderId() {
		return searchOrderId;
	}

	public WebElement getGoButton() {
		return goButton;
	}

	public WebElement getCancelButtonClick() {
		return cancelButtonClick;
	}

	public WebElement getCancelledSuccessMsg() {
		return cancelledSuccessMsg;
	}

	public WebElement getBookingConfirmSuccessMsg() {
		return bookingConfirmSuccessMsg;
	}

	public WebElement getGetorderid() {
		return getorderid;
	}

	/**
	 * @see getOrderId
	 */
	public void getOrderId() {

		WebElement orderId = getGetorderid();
		String text = elementGetAttributeValue(orderId);
		System.out.println(text);
		
		WebElement bookedItinerary = getBookedItinerary();
		elementClick(bookedItinerary);
		implicitwait(50);

		WebElement searchOrderId = getSearchOrderId();
		elementsendkeys(searchOrderId, text);

		WebElement goButton = getGoButton();
		elementClick(goButton);

		WebElement cancelButtonClick = getCancelButtonClick();
		elementClick(cancelButtonClick);

		alertok();

	}

}
