package org.pagemanager;

import org.pages.BookHotelPage;
import org.pages.BookingConfirmationPage;
import org.pages.CancelBookingPage;
import org.pages.SearchHotelPage;
import org.pages.SelectHotelPage;
import org.pages.LoginPage;
/**
 * 
 * @author Manojkumar
 * @Date 07-12-2022
 *
 */
public class PageObjectManager {

	private LoginPage loginHotelPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmationPage bookingConfirmationPage;
	private CancelBookingPage cancelBookingPage;

	public LoginPage getLoginHotelPage() {
		return (loginHotelPage == null) ? loginHotelPage = new LoginPage() : loginHotelPage;
	}

	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage == null) ? searchHotelPage = new SearchHotelPage() : searchHotelPage;
	}

	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage == null) ? selectHotelPage = new SelectHotelPage() : selectHotelPage;
	}

	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage == null) ? bookHotelPage = new BookHotelPage() : bookHotelPage;
	}

	public BookingConfirmationPage getBookingConfirmationPage() {
		return (bookingConfirmationPage == null) ? bookingConfirmationPage = new BookingConfirmationPage()
				: bookingConfirmationPage;
	}

	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage == null) ? cancelBookingPage = new CancelBookingPage() : cancelBookingPage;
	}

}
