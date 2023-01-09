package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author MANOJKUMAR
 * @see SearchHotelPage
 * @Date 07-12-2022
 *
 */
public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {

		PageFactory.initElements(driver, this);
	}

	// 1.By select all fields
	// 3.Date Checking (check in date and check out date)

	@FindBy(id = "username_show")
	private WebElement textLoginMsg;

	@FindBy(id = "location")
	private WebElement selectLocation;

	@FindBy(id = "hotels")
	private WebElement selectHotel;

	@FindBy(id = "room_type")
	private WebElement selectRoomtype;

	@FindBy(id = "room_nos")
	private WebElement selectRoom;

	@FindBy(id = "datepick_in")
	private WebElement selectcheckindate;

	@FindBy(id = "datepick_out")
	private WebElement selectcheckoutdate;

	@FindBy(id = "adult_room")
	private WebElement selectAdultroom;

	@FindBy(id = "child_room")
	private WebElement selectChildroom;

	@FindBy(id = "Submit")
	private WebElement selectSearch;

	@FindBy(id = "checkin_span")
	private WebElement errorcheckin;

	@FindBy(id = "checkout_span")
	private WebElement errorcheckout;

	@FindBy(id = "location_span")
	private WebElement errorlocation;

	@FindBy(xpath = "//span[text()='Please Select a Location']")
	private WebElement adactin;

	public WebElement getTextLoginMsg() {
		return textLoginMsg;
	}

	public WebElement getSelectLocation() {
		return selectLocation;
	}

	public WebElement getSelectHotel() {
		return selectHotel;
	}

	public WebElement getSelectRoomtype() {
		return selectRoomtype;
	}

	public WebElement getSelectRoom() {
		return selectRoom;
	}

	public WebElement getSelectcheckindate() {
		return selectcheckindate;
	}

	public WebElement getSelectcheckoutdate() {
		return selectcheckoutdate;
	}

	public WebElement getSelectAdultroom() {
		return selectAdultroom;
	}

	public WebElement getSelectChildroom() {
		return selectChildroom;
	}

	public WebElement getSelectSearch() {
		return selectSearch;
	}

	public WebElement getErrorcheckin() {
		return errorcheckin;
	}

	public WebElement getErrorcheckout() {
		return errorcheckout;
	}

	public WebElement getErrorlocation() {
		return errorlocation;
	}

	public WebElement getAdactin() {
		return adactin;
	}

	/**
	 * 
	 * @param Location
	 * @param Hotels
	 * @param RoomType
	 * @param NoOfRooms
	 * @param CheckInDate
	 * @param CheckOutDate
	 * @param AdultsPerRoom
	 * @param ChildPerRoom
	 * @see To select all fields
	 */
	public void searchHotel(String Location, String Hotels, String RoomType, String NoOfRooms, String CheckInDate,
			String CheckOutDate, String AdultsPerRoom, String ChildPerRoom) {

		WebElement locations = getSelectLocation();
		Select locat = new Select(locations);
		locat.selectByVisibleText(Location);

		WebElement namehotel = getSelectHotel();
		Select hotelsname = new Select(namehotel);
		hotelsname.selectByVisibleText(Hotels);

		WebElement typeroom = getSelectRoomtype();
		Select roomstype = new Select(typeroom);
		roomstype.selectByVisibleText(RoomType);

		WebElement roomno = getSelectRoom();
		Select nonofroom = new Select(roomno);
		nonofroom.selectByVisibleText(NoOfRooms);

		WebElement indate = getSelectcheckindate();
		indate.clear();
		indate.sendKeys(CheckInDate);

		WebElement outdate = getSelectcheckoutdate();
		outdate.clear();
		outdate.sendKeys(CheckOutDate);

		WebElement roomadult = getSelectAdultroom();
		Select adultroom = new Select(roomadult);
		adultroom.selectByVisibleText(AdultsPerRoom);

		WebElement roomchildren = getSelectChildroom();
		Select childperoom = new Select(roomchildren);
		childperoom.selectByVisibleText(ChildPerRoom);

		WebElement btnsearch = getSelectSearch();
		btnsearch.click();

	}

	/**
	 * 
	 * @param Location
	 * @param NoOfRooms
	 * @param checkInDate
	 * @param CheckOutDate
	 * @param AdultsPerRoom
	 * @see to select mandatory fields
	 */
	// 2.verify mandatory fields
	public void searchHotel(String Location, String NoOfRooms, String checkInDate, String CheckOutDate,
			String AdultsPerRoom) {

		WebElement locations = getSelectLocation();
		Select locat = new Select(locations);
		locat.selectByVisibleText(Location);

		WebElement roomno = getSelectRoom();
		Select nonofroom = new Select(roomno);
		nonofroom.selectByVisibleText(NoOfRooms);

		WebElement indate = getSelectcheckindate();
		indate.clear();
		indate.sendKeys(checkInDate);

		WebElement outdate = getSelectcheckoutdate();
		outdate.clear();
		outdate.sendKeys(CheckOutDate);

		WebElement roomadult = getSelectAdultroom();
		Select adultroom = new Select(roomadult);
		adultroom.selectByVisibleText(AdultsPerRoom);

		WebElement btnsearch = getSelectSearch();
		btnsearch.click();
	}

	/**
	 * @see searchHotel
	 */
	// 4.without entry any fields click search
	public void searchHotel() {

		elementClick(getSelectSearch());
	}

}
