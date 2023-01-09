package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author MANOJKUMAR
 * @see BookHotelPage
 *
 */
public class BookHotelPage extends BaseClass {

	public BookHotelPage() {

		PageFactory.initElements(driver, this);
	}
	// 1.By select all fields

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement bookingconfiramton;

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement bookHotelText;

	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement txtlLastName;

	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement txtAddress;

	@FindBy(xpath = "//input[@id='cc_num']")
	private WebElement txtCardNo;

	@FindBy(xpath = "//select[@id='cc_type']")
	private WebElement dDnCardType;

	@FindBy(xpath = "//select[@id='cc_exp_month']")
	private WebElement dDnMonth;

	@FindBy(xpath = "//select[@id='cc_exp_year']")
	private WebElement dDnYear;

	@FindBy(xpath = "//input[@id='cc_cvv']")
	private WebElement txtCvvNo;

	@FindBy(id = "book_now")
	private WebElement btnClick;

	public WebElement getBookingconfiramton() {
		return bookingconfiramton;
	}

	@FindBy(xpath = "//label[contains(text(),'First Name')]")
	private WebElement errFstname;
	@FindBy(xpath = "//label[text()='Please Enter you Last Name']")
	private WebElement errLstname;
	@FindBy(xpath = "//label[text()='Please Enter your Address']")
	private WebElement errAddress;
	@FindBy(xpath = "//label[text()='Please Enter your 16 Digit Credit Card Number']")
	private WebElement errCardno;
	@FindBy(xpath = "//label[text()='Please Select your Credit Card Type']")
	private WebElement errCardType;
	@FindBy(xpath = "//label[text()='Please Select your Credit Card Expiry Month']")
	private WebElement errExpiry;
	@FindBy(xpath = "//label[text()='Please Enter your Credit Card CVV Number']")
	private WebElement errCvvno;
	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement bookHotelSuccessMsg;

	public WebElement getErrFstname() {
		return errFstname;
	}

	public WebElement getErrLstname() {
		return errLstname;
	}

	public WebElement getErrAddress() {
		return errAddress;
	}

	public WebElement getErrCardno() {
		return errCardno;
	}

	public WebElement getErrCardType() {
		return errCardType;
	}

	public WebElement getErrExpiry() {
		return errExpiry;
	}

	public WebElement getErrCvvno() {
		return errCvvno;
	}

	public WebElement getBookHotelText() {
		return bookHotelText;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtlLastName() {
		return txtlLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCardNo() {
		return txtCardNo;
	}

	public WebElement getdDnCardType() {
		return dDnCardType;
	}

	public WebElement getdDnMonth() {
		return dDnMonth;
	}

	public WebElement getdDnYear() {
		return dDnYear;
	}

	public WebElement getTxtCvvNo() {
		return txtCvvNo;
	}

	public WebElement getBtnClick() {
		return btnClick;
	}

	/**
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param Address
	 * @param creditcardno
	 * @param creditcardtype
	 * @param expmonth
	 * @param expyear
	 * @param cvvno
	 * @see To enter a valid details
	 */
	public void BookHotelPage(String FirstName, String LastName, String Address, String creditcardno, String creditcardtype,
			String expmonth, String expyear, String cvvno) {

		WebElement namefst = getTxtFirstName();
		namefst.sendKeys(FirstName);

		WebElement namelast = getTxtlLastName();
		namelast.sendKeys(LastName);

		WebElement address = getTxtAddress();
		address.sendKeys(Address);

		WebElement cardno = getTxtCardNo();
		cardno.sendKeys(creditcardno);
		//System.out.println(creditcardno);

		WebElement typecard = getdDnCardType();
		typecard.sendKeys(creditcardtype);
		//System.out.println(creditcardtype);

		WebElement monthexp = getdDnMonth();
		monthexp.sendKeys(expmonth);
		//System.out.println(expmonth);

		WebElement yearexp = getdDnYear();
		yearexp.sendKeys(expyear);
		//System.out.println(expyear);

		WebElement nocvv = getTxtCvvNo();
		nocvv.sendKeys(cvvno);

		WebElement booknowbtn = getBtnClick();
		booknowbtn.click();
		implicitwait(50);
	}

	/**
	 * @see bookHotel
	 */
	// 2.without enter any fields click book

	public void bookHotel() {

		elementClick(getBtnClick());

	}
}
